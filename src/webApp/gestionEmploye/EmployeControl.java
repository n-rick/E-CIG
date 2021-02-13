package webApp.gestionEmploye;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import metier.Employe;
import metier.EmployeCoordonnees;
import metier.Salarie;

/**
 * Servlet implementation class EmployeControl
 */
@WebServlet(name = "EmployeControl",
			description = "Controleur Employe",
			urlPatterns = { "/admin/*" })

public class EmployeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Dans EmployeControl acces via /admin/ en doGet");

		if (request.getPathInfo() == null || request.getPathInfo().equals("/"))			goAccueil(request, response);
		else if (request.getPathInfo().equals("/list"))									goListEmploye(request, response);
		else if (request.getPathInfo().equals("/creaEmp"))								goCreaEmploye(request,response);
		else {
			request.setAttribute("message", "Une erreur c'est produite! Veuillez retourner à l'accueil");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError"));
			disp.forward(request, response);
		}
	}

	/**<b>Méthode goCreamEmploye()</b>
	 * <p>Méthode permettant d'accéder à la jsp de création d'un nouvelle employé</p>
	 * @see /WEB-INF/vue/employe/creationEmploye.jsp
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goCreaEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.println("Dans EmployeControl.java - goCreaEmployé ");
		disp = request.getRequestDispatcher("/WEB-INF/vue/employe/creationEmploye.jsp");
		disp.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		System.out.println("Dans controleur employe acces via /admin/ en doPost");

		if (request.getPathInfo() == null || request.getPathInfo().equals("/"))			goAccueil(request, response);
		else if (request.getPathInfo().equals("/affich"))								goAffichEmploye(request, response);
		else if (request.getPathInfo().equals("/modif"))								doModif(request, response);
		else if (request.getPathInfo().equals("/supp"))									doSupp(request, response);
		else if (request.getPathInfo().equals("/crea"))									doCrea(request, response);
		else {
			request.setAttribute("message", "Une erreur c'est produite! Veuillez retourner à l'accueil");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError"));
			disp.forward(request, response);
		}
	}
	
	private void goAccueil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Dans EmployeControl - Go accueil");
		disp = request.getRequestDispatcher("/index.jsp");
		disp.forward(request, response);

	}

	/**<b>Méthode doCrea</b>
	 * <p>Méthode permettant de créer un nouvel employé
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doCrea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EmployControl.java - dans doCrea");
		
		// Récupération de la session de l'employé
//		HttpSession sessionEmploye = request.getSession(true);
//		Employe employeEnSession = (Employe) sessionEmploye.getAttribute("employe");
		
		String idE = request.getParameter("idEmploye").strip();
		String sexE = request.getParameter("radioBtnEmploye");	
		String nomE = request.getParameter("nomEmploye").strip();
		String prenomE = request.getParameter("prenomEmploye").strip();
		String dNaissE = request.getParameter("ageEmploye").strip();
		String mailE = request.getParameter("mailEmploye").strip();
		String mdpE = request.getParameter("mdpEmploye").strip();
		String telE = request.getParameter("portableEmploye").strip();
		String rueE = request.getParameter("adrEmploye").strip();
		int cdpE = Integer.parseInt(request.getParameter("cdpEmploye"));
		String villeE = request.getParameter("villeEmploye").strip();
		
		System.err.println(sexE);
		System.err.println(mailE);
		LocalDate dateNaiss = LocalDate.parse(dNaissE, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Employe newSalarie = new Salarie(idE, sexE, nomE, prenomE, dateNaiss, mailE, mdpE, telE, new EmployeCoordonnees(rueE, cdpE, villeE));
		//System.out.println(newSalarie.getPrenomEmploye());
		System.err.println(newSalarie.getRefEmploye());
		if(!idE.isBlank() && !nomE.isBlank() && !prenomE.isBlank() && !dNaissE.isBlank() 
				&& !mdpE.isBlank() && !telE.isBlank() && !rueE.isBlank() && !villeE.isBlank()) {
		Dao.employes.add(newSalarie);
		disp = request.getRequestDispatcher("/admin/affich");
		disp.forward(request, response);
		} else {
			request.setAttribute("message", "Une erreur c'est produite! Tous les champs sont vides");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError"));
			disp.forward(request, response);
		}
	}
		

	/**
	 * <b>Méthode goAfficheEmploye()</b>
	 * <p>Cette méthode permet d'accéder à la jsp qui affiche la liste des employés</p>
	 * @see /WEB-INF/vue/employe/listeEmploye.jsp
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAffichEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EmployeControl.java - Dans goAfficheEmploye");
		request.setAttribute("message", "");
		
		// Récupération de la session de l'employé
		HttpSession sessionEmploye = request.getSession(true);
		Employe employeEnSession = (Employe) sessionEmploye.getAttribute("employe");
		
		// Récupération de l'employe sélectionné dans la liste
// !!!!!!!!!!!!!!!!!!!!!!!! DM
		//Employe employe = Dao.getEmploye(employeEnSession.getIdEmploye());
		String idEmployeSelectionne = request.getParameter("selectEmploye");
		System.out.println("Dans EmployeControl.java - Méthode: goAffichEmploye - id Employé : "+idEmployeSelectionne);
		
		Employe employe = Dao.getEmploye(idEmployeSelectionne);
		System.out.println("EmployeControl.java - goAffichEmploye - employe selectionne recupere depuis DAO : " + employe);
		
		request.setAttribute("employeSelec", employe);

		// On remet la liste des employés dans request pour affichage
		ArrayList<Employe> ListDesEmployes = Dao.employes;
		request.setAttribute("employes", ListDesEmployes);
// !!!!!!!!!!!!!!!!!!!!!!!! DM
		disp = request.getRequestDispatcher("/WEB-INF/vue/employe/listeEmploye.jsp");
		disp.forward(request, response);

	}

	/**
	 * <b>Methode doSupp()</b>
	 * <p>Méthode permettant de supprimer un employé de la liste</p>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doSupp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans Go supp");
		request.setAttribute("message", "");
		// récupération des donnees
		String idEmploye = request.getParameter("selectEmploye").strip();

		// suppression de l'employé dans la liste
		boolean ok = Dao.supressEmploye(idEmploye);
		System.out.println("l'employé (N° " + idEmploye + ") a bien été supprimé ");

		// rediriger vers la liste des employés
		if (ok)
			request.setAttribute("message", "L'employe " + idEmploye + " a été supprim&eacute;");
		else
			request.setAttribute("message", "Vous n'avez sélectionné aucun employé!");

		goListEmploye(request, response);

	}

	/**<b>Méthode doModif()</b>
	 * <p>Méthode permettant la modification d'un employé dans la liste des employés</p>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doModif(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dans do Modif");
		request.setAttribute("message", "");
		
		String idE = request.getParameter("idEmploye");
		//System.out.println(idE);
		String mailE = request.getParameter("mailEmploye").strip();
		//System.out.println(mailE);
		String telE = request.getParameter("portableEmploye").strip();
		//System.out.println(telE);
		String rueE = request.getParameter("rueEmploye").strip();
		//System.out.println(rueE);
		int cdpE = Integer.parseInt(request.getParameter("cdpEmploye"));
		//System.out.println(cdpE);
		String villeE = request.getParameter("villeEmploye").strip();
		//System.out.println(villeE);
		
		for (Employe emp : Dao.employes ) {
			if (idE.equals(emp.getIdEmploye())) {
				emp.setEmailEmploye(mailE);
				emp.setNumTelEmploye(telE);
				emp.getCoordonnee().setAdressRueEmploye(rueE);
				emp.getCoordonnee().setCdpEmploye(cdpE);
				emp.getCoordonnee().setNomVille(villeE);
			}
		}
		request.setAttribute("message", "Les modifications ont bien été prise en compte");
		disp = request.getRequestDispatcher("/admin/list");
		disp.forward(request, response);
	}

	/**<b>Méthode goListEmploye</b>
	 * <p>Méthode permettant l'affichage de la liste des employés</p>
	 * @see /WEB-INF/vue/employe/listeEmploye.jsp
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goListEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dans EmployeControle - Méthode goListEmploye");
		String cheminASuivre = null;
		// si la liste est vide
		if (Dao.employes.size() == 0) {
			request.setAttribute("message", "La liste des employés est vide.");
			cheminASuivre = this.getServletContext().getInitParameter("pageError");
		} else {
			// on affiche la liste
			request.setAttribute("employes", Dao.employes);
			//request.setAttribute("employeSelec", Dao.employes);
			request.setAttribute("message", " ");
//			System.out.println("Employe controle" + Dao.employes.get(0));
			cheminASuivre = "/WEB-INF/vue/employe/listeEmploye.jsp";
		}
		disp = request.getRequestDispatcher(cheminASuivre);
		disp.forward(request, response);

	}
}