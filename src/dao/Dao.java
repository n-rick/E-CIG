package dao;

import java.util.ArrayList;

import metier.Employe;

public class Dao {
	public static ArrayList<Employe>  employes  = initEmployes();
	
	public static boolean supressEmploye(String idEmploye) {
		boolean ok = false;
		Employe employe = new Employe(idEmploye);
		int index = employes.indexOf(employe);
		if (index != -1) {
			employes.remove(index);
			ok = true;
			// TODO : si employe est celui de la session, remettre à jour la session
		}
		return ok;
	}
	
	public static Employe getEmploye(String idEmploye) {
		Employe employe = new Employe(idEmploye);
		return getEmploye(employe);
	}
	public static Employe getEmploye(Employe employe) {
		Employe trouve = null;
		if (employes.contains(employe)) trouve = employes.get(employes.indexOf(employe));
		return trouve;
	}
	
	public static Employe getEmploye(String email, String mdp) {

		Employe trouve = null;

		if (email != null && mdp != null) {
			for (Employe emplo : Dao.employes) {
				if (emplo != null && email.equals(emplo.getEmailEmploye()) && mdp.equals(emplo.getMdpEmploye())) trouve = emplo;
			}
		}
		return trouve;
	}
	
	private static ArrayList<Employe> initEmployes() {
		
	ArrayList<Employe> list 	= new ArrayList<Employe>();
	list.add(new Employe("RE12", "Monsieur", "Dupont", "Joe", "12/03/1999", "dupont.joe@mail.com","dupjore12", 2, "24 rue St-Sébastien", 13006, "Marseille"));
	list.add(new Employe("SA01", "Madame", "Dupont", "Jeanne", "21/06/2008","dupont.j@mail.com","dupjesa01", 3, "123 avenue de la Coupe", 13100, "Aix-en-Provence"));
	list.add(new Employe("SA17", "Monsieur", "Machin", "Charles", "10/08/1977","Charles","machasa17", 7, "98 boulevard J. reno", 84120, "Pertuis"));
	list.add(new Employe("SA12", "Monsieur", "Durrant", "John", "30/03/1989","durj@mail.com","durjosa12", 6, "2 cours St-Nicolas", 06006, "Nice"));
	list.add(new Employe("SA45", "Madame", "Truc", "Gin", "10/08/1977","trgin77@email.com","trugisa45", 7, "98 boulevard J. reno", 13028, "La ciotat"));
	list.add(new Employe("RE05", "Madame", "Hello", "Sarrah", "16/10/1997","helloS@mailme.com","helsare05", 1, "123 avenue de la gd Motte", 83170 , "Brignole"));
	return list;
}

}
