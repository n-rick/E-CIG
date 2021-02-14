package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import metier.Abonne;
import metier.Employe;
import metier.EmployeCoordonnees;
import metier.Responsable;
import metier.Salarie;

public class Dao {

	public static ArrayList<Abonne> abonnes = initA();

	// Enrick cr�ation d'une arrayListe employ�

	public static ArrayList<Employe> employes = initEmployes();

	// SOFIEN
	public static Abonne getAbonne(String mail, String pw) {

		Abonne a = null;
		for (Abonne abonne : Dao.abonnes) {
			if (abonne != null && abonne.getMail() != null && abonne.getPw() != null && abonne.getMail().equals(mail)
					&& abonne.getPw().equals(pw))
				a = abonne;

		}

		return a;
	}

	public static Abonne getAbonne(String email) {

		Abonne abonne = null;
		Abonne abo = new Abonne(email);
		if (Dao.abonnes.indexOf(abo) >= 0)
			abonne = Dao.abonnes.get(Dao.abonnes.indexOf(abo));

		return abonne;
	}

	public static void setAbonne(Abonne abonne) {
		Abonne abo = getAbonne(abonne.getMail());
		if (abo != null) {
			Dao.abonnes.get(Dao.abonnes.indexOf(abo)).setNom(abonne.getNom());
			Dao.abonnes.get(Dao.abonnes.indexOf(abo)).setPrenom(abonne.getPrenom());
			Dao.abonnes.get(Dao.abonnes.indexOf(abo)).setPw(abonne.getPw());
			Dao.abonnes.get(Dao.abonnes.indexOf(abo)).setMail(abonne.getMail());
		}
	}

	public static void addAbonne(Abonne abonne) {
		if (abonne != null && abonne.getIdAbonne() != null)
			Dao.abonnes.add(abonne);
	}

	public static ArrayList<Abonne> initA() {
		ArrayList<Abonne> abonnes = new ArrayList<Abonne>();
		Abonne a1 = new Abonne("001", "Dupond", "Jean", "aa", "dupond@mail.fr");
		abonnes.add(a1);
		return abonnes;

	}

	public static String printListeAbo() {

		String msg = "<select name=\"idAbonne\" id=\"idAbonne\"> <option value=\"\">-- Choisir un abonn� --</option>";
		if (!Dao.abonnes.isEmpty()) {
			for (Abonne abo : Dao.abonnes) {

				msg += "<option value=\"" + abo.getIdAbonne() + "\">" + abo.getNom() + " " + abo.getPrenom()
						+ "</option>";

			}
		}
		msg += "</select>";
		return msg;

	}
	// FIN CODAGE SOFIEN

	// DEBUT CODE ENRICK

	// ENRICK - Get employ� avec ID en param�tre de type chaine de caract�re
	/**
	 * @param idEmploye
	 * @return
	 */
	public static Employe getEmploye(String idEmploye) {
		Employe employe = new Employe(idEmploye);
		return getEmploye(employe);
	}
	
	// ENRICK - Get Employ� avec en param�tre un objet de type employ�
	public static Employe getEmploye(Employe employe) {
		Employe trouve = null;
		if (employes.contains(employe))
			trouve = employes.get(employes.indexOf(employe));
		return trouve;
	}


	/**
	 * <b>GetEmploye</b>
	 * <p>Get employ� avec email et mot de passe pour v�rification lors de la connexion.</p> 
	 * @param email
	 * @param mdp
	 * @return
	 */
	// ENRICK - Get employ� avec email et mot de passe avec v�rification des informations.
	public static Employe getEmploye(String email, String mdp) {

		Employe trouve = null;

		if (email != null && mdp != null) {
			for (Employe emplo : Dao.employes) {
				if (emplo != null && email.equals(emplo.getEmailEmploye()) && mdp.equals(emplo.getMdpEmploye()))
					trouve = emplo;
			}
		}
		return trouve;
	}


	/**
	 * <b>SuppressEmploye()</b>
	 * <p>Permet la suppression de l'employ� s�lectionn� dans la liste</p>
	 * @param idEmploye
	 * @return
	 */
	// ENRICK - Suppression d'un employ� dans la liste
	public static boolean supressEmploye(String idEmploye) {
		boolean ok = false;
		Employe employe = new Employe(idEmploye);
		int index = employes.indexOf(employe);
		if (index != -1) {
			employes.remove(index);
			ok = true;
		}
		return ok;
	}

	// ENRICK - Modification d'employ�
	public static boolean modifEmploye(Employe employe) {
		boolean modifOk = false;
		int index = employes.indexOf(employe);
		if (index != -1) {
			employes.set(index, employe);
			modifOk = true;
		}

		return modifOk;
	}

	// ENRICK - Array list des employ�s
	private static ArrayList<Employe> initEmployes() {

		// Instatiation des employ�s: Soit de type Responsable, soit de type Salari�
		Employe res01 = new Responsable("01", "Mr", "Dupont", "Joe", LocalDate.parse("1976-04-21"),
				"dupont.joe@mail.com", "dupjo12", "06.12.23.34.45",
				new EmployeCoordonnees("23 rue jolit", 13006, "Marseille"));
		Employe sal01 = new Salarie("001", "Mme", "Durant", "Josie", LocalDate.parse("1986-06-11"),
				"durant.josie@mail.fr", "durjo20", "06.15.23.34.45",
				new EmployeCoordonnees("23 avenue Grande", 06006, "Nice"));
		Employe sal02 = new Salarie("002", "Mr", "Machin", "Jacques", LocalDate.parse("2000-02-07"),
				"machin_j@mail.com", "macj98", "06.23.78.36.45",
				new EmployeCoordonnees("23 cours de Napol�on rouge", 69000, "Lyon"));
		Employe sal03 = new Salarie("003", "Mme", "Macpol", "Michelle", LocalDate.parse("1989-12-25"),
				"macMic@email.fr", "macpo76", "06.63.83.34.45",
				new EmployeCoordonnees("23 boulevard du cheval rouge", 93200, "Saint-Denis"));
		Employe sal04 = new Salarie("004", "Mme", "Tatata", "Agathe", LocalDate.parse("2009-08-08"),
				"tatata_agathe@mail.com", "tataA08", "07.19.90.34.45",
				new EmployeCoordonnees("23 rue de la cours des grands", 95400, "Villier-le-Bel"));
		Employe sal05 = new Salarie("005", "Mr", "Totoo", "Jean-Charles", LocalDate.parse("2001-01-01"),
				"ttjc@email.com", "ttjch01", "06.23.34.11.99",
				new EmployeCoordonnees("23 boulevard du cheval rouge", 15004, "Aurillac"));
		Employe sal06 = new Salarie("006", "Mr", "Truc", "Gil", LocalDate.parse("1977-05-16"), "truc_gil@mail.com",
				"trgi12", "07.12.12.34.67", new EmployeCoordonnees("32 cours bellevue", 14098, "Pertuis"));

		// Cr�ation de la liste des employ�s
		ArrayList<Employe> employes = new ArrayList<Employe>();
		employes.add(res01);
		
		// System.out.println("Dans DAO : "+list.get(0));
		employes.add(sal01);
		employes.add(sal04);
		employes.add(sal05);
		employes.add(sal03);
		employes.add(sal02);
		employes.add(sal06);

		return employes;
	}
// FIN DE CODE ENRICK	

}