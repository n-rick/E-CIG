package dao;

import java.util.ArrayList;
import metier.Abonne;
import metier.Employe;

public class Dao {

	public static ArrayList<Abonne> abonnes = initA();
	
	// Enrick création d'une arrêt liste employé
	public static ArrayList<Employe>  employes  = initEmployes();
	
	// SOFIEN
	public static Abonne getAbonne(String mail, String pw) {
		
		Abonne a = null;
		for (Abonne abonne : Dao.abonnes) {
			if (abonne != null && abonne.getMail() != null && abonne.getPw() != null && abonne.getMail().equals(mail) && abonne.getPw().equals(pw))
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
		if(abonne != null && abonne.getIdAbonne() != null)
		Dao.abonnes.add(abonne);
	}


	public static ArrayList<Abonne> initA() {
		ArrayList<Abonne> abonnes = new ArrayList<Abonne>();
		Abonne a1 = new Abonne("001", "Dupond", "Jean", "aa","dupond@mail.fr");
		abonnes.add(a1);
		return abonnes;

	}

	public static String printListeAbo() {

		String msg = "<select name=\"idAbonne\" id=\"idAbonne\"> <option value=\"\">-- Choisir un abonné --</option>";
		if (!Dao.abonnes.isEmpty()) {
			for (Abonne abo : Dao.abonnes) {

				msg += "<option value=\""+abo.getIdAbonne()+"\">"+abo.getNom() + " " + abo.getPrenom()+"</option>";

			}
		}
		msg+="</select>";
		return msg;

	}
	// FIN CODAGE SOFIEN
	
	// DEBUT CODE ENRICK
	
	//ENRICK -  Get employé avec ID en paramètre de type chaine de caractère
	public static Employe getEmploye(String idEmploye) {
		Employe employe = new Employe(idEmploye);
		return getEmploye(employe);
	}
	// ENRICK - Get Employé avec en paramètre un objet de type employé
	public static Employe getEmploye(Employe employe) {
		Employe trouve = null;
		if (employes.contains(employe)) trouve = employes.get(employes.indexOf(employe));
		return trouve;
	}
	// Enrick - Get employé avec email et mot de passe avec vérification des informations.
	public static Employe getEmploye(String email, String mdp) {

		Employe trouve = null;

		if (email != null && mdp != null) {
			for (Employe emplo : Dao.employes) {
				if (emplo != null && email.equals(emplo.getEmailEmploye()) && mdp.equals(emplo.getMdpEmploye())) trouve = emplo;
			}
		}
		return trouve;
	}
	
	// ENRICK - Suppression d'un employé dans la liste
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
	
	// ENRICK  - Modification d'employé
	public static boolean modifEmploye (Employe employe) {
		boolean modifOk = false;
		int index = employes.indexOf(employe);
		if(index != -1)	{
			employes.set(index, employe);
			modifOk = true;
		}
		
		return modifOk;		
	}

	// ENRICK - Array list des employés 
	private static ArrayList<Employe> initEmployes() {
		
	ArrayList<Employe> list 	= new ArrayList<Employe>();
	list.add(new Employe("1","RE12", "Monsieur", "Dupont", "Joe", "12/03/1999", "dupont.joe@mail.com","dupjore12", "06.12.23.34.45", "24 rue St-Sébastien", "13006", "Marseille"));
	list.add(new Employe("2","SA01", "Madame", "Dupont", "Jeanne", "21/06/2008","dupont.j@mail.com","dupjesa01","07.12.12.12.12", "123 avenue de la Coupe", "13100", "Aix-en-Provence"));
	list.add(new Employe("3","SA17", "Monsieur", "Machin", "Charles", "10/08/1977","machin_Charles@email.com","machasa17","06.10.20.30.40", "98 boulevard J. reno", "84120", "Pertuis"));
	list.add(new Employe("4","SA12", "Monsieur", "Durrant", "John", "30/03/1989","durj@mail.com","durjosa12","07.01.02.03.04", "2 cours St-Nicolas", "06006", "Nice"));
	list.add(new Employe("5","SA45", "Madame", "Truc", "Gin", "10/08/1977","trgin77@email.com","trugisa45","06.11.22.33.44", "98 boulevard J. reno", "13028", "La ciotat"));
	list.add(new Employe("6","RE05", "Madame", "Hello", "Sarrah", "16/10/1997","helloS@mailme.com","helsare05","06.11.22.33.44", "123 avenue de la gd Motte", "83170" , "Brignole"));
	return list;
}
// FIN DE CODE ENRICK	

}