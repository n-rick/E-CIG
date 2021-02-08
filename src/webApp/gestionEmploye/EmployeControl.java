package webApp.gestionEmploye;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

/**
 * Servlet implementation class EmployeControl
 */
@WebServlet(
		name = "EmployeControl", 
		description = "Controleur Employe", 
		urlPatterns = {"/admin/*"}
		)

public class EmployeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	private RequestDispatcher 	disp;
 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Dans controleur employe acces via /admin/ en doGet");
		
		if 		(request.getPathInfo() == null || request.getPathInfo().equals("/")) 		goAccueil(request, response);
		else if (request.getPathInfo().equals("/list")) 									goListEmploye(request, response);
		else {
			request.setAttribute("message", "Une erreur c'est produite! Veuillez retourner � l'accueil");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError")); 
			disp.forward(request,response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans controleur employe acces via /admin/ en dopost");
		
		if 		(request.getPathInfo() == null || request.getPathInfo().equals("/")) 	goAccueil(request, response);
		else if (request.getPathInfo().equals("/modif")) 								goModif(request, response);
		else if (request.getPathInfo().equals("/supp")) 								goSupp(request, response);
		else {
			request.setAttribute("message", "Une erreur c'est produite! Veuillez retourner � l'accueil");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError")); 
			disp.forward(request,response);
		}
	}
	
	
	private void goSupp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans Go supp");
		request.setAttribute("message", "");
		// r�cup�ration des donnees
		String idEmploye		= request.getParameter("selectEmploye").strip();
		System.out.println("les donn�es de l'employ� sont : "+ idEmploye);

		// suppression de l'employ� dans la liste
		boolean ok = Dao.supressEmploye(idEmploye);
		System.out.println("l'employ� (N� "+idEmploye+") a bien �t� supprim� ");
		

		//rediriger vers la liste des employ�s
		if (ok) request.setAttribute("message", "L'employe " + idEmploye + " a �t� supprim&eacute;");
		else	request.setAttribute("message", "L'employe "+ idEmploye + " n'existe pas");

		goListEmploye(request, response);
		
	}

	private void goModif(HttpServletRequest request, HttpServletResponse response) {
// TODO A coder m�thode modifier avec l'ID.
		
	}

	private void goListEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dans EmployeControle - M�thode goListEmploye");
		String cheminASuivre = null;
		// si la liste est vide
		if (Dao.employes.size() == 0) {
			request.setAttribute("message", "La liste des employ�s est vide.");
			cheminASuivre = this.getServletContext().getInitParameter("pageError");
		}
		else {
			// on affiche la liste
			request.setAttribute("employes", Dao.employes);
			cheminASuivre = "/WEB-INF/vue/employe/listeEmploye.jsp";
		}
		disp = request.getRequestDispatcher(cheminASuivre);
		disp.forward(request, response);
		
	}
	
	private void goAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans EmployeControl - Go accueil");
		disp = request.getRequestDispatcher("/index.jsp");
		disp.forward(request,response);	
		
	}
}
