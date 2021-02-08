package webApp.gestionEmploye;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import metier.Employe;

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
		else if (request.getPathInfo().equals("/affich"))									goAffichEmploye(request, response);
		else {
			request.setAttribute("message", "Une erreur c'est produite! Veuillez retourner à l'accueil");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError")); 
			disp.forward(request,response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans controleur employe acces via /admin/ en dopost");
		
		if 		(request.getPathInfo() == null || request.getPathInfo().equals("/")) 	goAccueil(request, response);
		else if (request.getPathInfo().equals("/modif")) 								doModif(request, response);
		else if (request.getPathInfo().equals("/supp")) 								doSupp(request, response);
		else {
			request.setAttribute("message", "Une erreur c'est produite! Veuillez retourner à l'accueil");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError")); 
			disp.forward(request,response);
		}
	}
	
	private void goAffichEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans Go AfficheEmploye");
		request.setAttribute("message", "");
		// Récupération de la session de l'employé
		HttpSession sessionEmploye = request.getSession(true);
		Employe employeEnSession = (Employe) sessionEmploye.getAttribute("employe");
		// Récupération de l'employe sélectionné dans la liste
		Employe employe = Dao.getEmploye(employeEnSession.getIdEmploye());
		
		request.setAttribute("employeSelec", employe);
		doModif(request, response);
		
	}	
	
	private void doSupp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans Go supp");
		request.setAttribute("message", "");
		// récupération des donnees
		String idEmploye = request.getParameter("selectEmploye").strip();

		// suppression de l'employé dans la liste
		boolean ok = Dao.supressEmploye(idEmploye);
		System.out.println("l'employé (N° "+idEmploye+") a bien été supprimé ");
		

		//rediriger vers la liste des employés
		if (ok) request.setAttribute("message", "L'employe " + idEmploye + " a été supprim&eacute;");
		else	request.setAttribute("message", "L'employe "+ idEmploye + " n'existe pas");

		goListEmploye(request, response);
		
	}

	private void doModif(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO A refaire!!
		
//		System.out.println("Dans Go Modif");
//		request.setAttribute("message", "");
//		// Récupération de la session de l'employé
//		HttpSession sessionEmploye = request.getSession(true);
//		Employe employeEnSession = (Employe) sessionEmploye.getAttribute("employe");
//		// Récupération de l'employe sélectionné dans la liste
//		Employe employe = Dao.getEmploye(employeEnSession.getIdEmploye());
//		
//		request.setAttribute("employeSelec", employe);
		//RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/vue/");
//		// méthode modifier avec l'ID.
//		// récupération des données grâce à l'ID de l'employé
//		String idE			=	request.getParameter("selectEmploye").strip();
//		String refE			= 	request.getParameter("refEmploye").strip();
//		String civE			= 	request.getParameter("radioBtnEmploye").strip();
//		String nomE			= 	request.getParameter("nomEmploye").strip();
//		String prenomE		= 	request.getParameter("prenomEmploye").strip();
//		String dateNaissE 	= 	request.getParameter("ageEmploye").strip();
//		String emailE 		= 	request.getParameter("mailEmploye").strip();
//		String mdpE			= 	request.getParameter("mailEmploye").strip();
//		String telE			=	request.getParameter("portableEmploye").strip();
//		String rueE			= 	request.getParameter("adrEmploye").strip();
//		String cdpE 		= 	request.getParameter("cdpEmploye").strip();
//		String villeE 		= 	request.getParameter("villeEmploye").strip();
//		
//		Employe employe = new Employe(idE,  refE,  civE,  nomE,  prenomE,
//				dateNaissE,  emailE,  mdpE,  telE,  rueE,  cdpE,  villeE);
//		
//		// Modification de données
//		boolean modifOk = Dao.modifEmploye(employe);
//		
//		//rediriger vers la liste des employés
//		if (modifOk) request.setAttribute("message", "L'employe N°: " + idE +" avec la réf.: "+refE+" a été modifié avec succès!");
//		else	request.setAttribute("message", "L'employe "+ idE + " n'existe pas!");
//
//		goListEmploye(request, response);
		
	}

	private void goListEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dans EmployeControle - Méthode goListEmploye");
		String cheminASuivre = null;
		// si la liste est vide
		if (Dao.employes.size() == 0) {
			request.setAttribute("message", "La liste des employés est vide.");
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
