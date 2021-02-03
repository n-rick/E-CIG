package webApp.identification;

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
 * Servlet implementation class Ident
 */
@WebServlet("/ident")
public class Ident extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Je suis dans creer Get");
		request.setAttribute("message", "Url invalide !!");
		RequestDispatcher disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError"));
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recuperation des donnees
		String email = request.getParameter("email-modal");
		String pwd = request.getParameter("password-modal");

		System.out.println("Identification - post - l'email : " + email);

		// verification de l'existence dans la liste des employes
		Employe employe = Dao.getEmploye(email, pwd);
		// System.out.println("Identification : " + employe);

		// Mise en session du nom et prenom
		HttpSession session = request.getSession(true);
		if (employe != null) {

			Employe employeSession = new Employe(employe.getIdEmploye());
			employeSession.setNomEmploye(employe.getNomEmploye());
			employeSession.setPrenomEmploye(employe.getPrenomEmploye());
			employeSession.setDateNaissEmploye(employe.getDateNaissEmploye());

			session.setAttribute("employe", employeSession);
			response.sendRedirect(request.getContextPath());

		} else {
			session.setAttribute("employe", null);

			request.setAttribute("message", "Mauvaise identification !!!");
			String chemin = this.getServletContext().getInitParameter("pageError");

			RequestDispatcher disp = request.getRequestDispatcher(chemin);
			disp.forward(request, response);
		}
	}
}
