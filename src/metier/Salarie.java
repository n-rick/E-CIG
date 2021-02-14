package metier;

import java.time.LocalDate;

public class Salarie extends Employe {
	

	public Salarie() {
		
	}
	
	// M�thode cr�ant la r�f�rence de l'employ� en fonction de son statut
	public String creerRef() {
		String statut = null;
		if (getNomEmploye() != null && getNomEmploye().length() > 1) 
			statut = "SA" + getNomEmploye().toLowerCase().trim().substring(0,2) + 0 + getDateNaissEmploye().getMonthValue();
		
		return statut;
	}

	/**
	 * @param idEmploye
	 */
	public Salarie(String idEmploye) {
		super(idEmploye);
	}

	/**
	 * @param refEmploye
	 * @param civEmploye
	 * @param nomEmploye
	 * @param prenomEmploye
	 * @param dateNaissEmploye
	 * @param emailEmploye
	 * @param numTelEmploye
	 * @param coordonnee
	 */
	public Salarie(String idEmploye, String refEmploye, String civEmploye, String nomEmploye, String prenomEmploye,
			LocalDate dateNaissEmploye, String emailEmploye, String numTelEmploye, EmployeCoordonnees coordonnee) {
		super(idEmploye, refEmploye, civEmploye, nomEmploye, prenomEmploye, dateNaissEmploye, emailEmploye, numTelEmploye,
				coordonnee);
	}

	/**
	 * @param civEmploye
	 * @param nomEmploye
	 * @param prenomEmploye
	 * @param dateNaissEmploye
	 * @param emailEmploye
	 * @param mdpEmploye
	 * @param numTelEmploye
	 * @param coordonnee
	 */
	public Salarie(String idEmploye, String civEmploye, String nomEmploye, String prenomEmploye,
			LocalDate dateNaissEmploye, String emailEmploye, String mdpEmploye, String numTelEmploye,
			EmployeCoordonnees coordonnee) {
		super(idEmploye, civEmploye, nomEmploye, prenomEmploye, dateNaissEmploye, emailEmploye, mdpEmploye, numTelEmploye,
				coordonnee);
		setRefEmploye(creerRef());
	}


	@Override
	public String toString() {
		return "Salarie :"+super.toString();
	}
	
	

}
