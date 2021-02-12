package metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employe {
	
	private 	String				idEmploye;
	private		String				refEmploye;
	private		String				civEmploye;
	private 	String				nomEmploye;
	private 	String				prenomEmploye;
	private 	LocalDate			dateNaissEmploye;
	private 	String				emailEmploye;
	private 	String				mdpEmploye;
	private 	String 				numTelEmploye;
	private 	EmployeCoordonnees 	coordonnee;
	

	// Constructeur par d�faut, utilisation exclusif dans le useBean:
	public Employe() {
	}
	
	/**
	 * <b>Constructeur par d�faut</b>
	 * @param idEmploye
	 * @param nomEmploye
	 */
	// Constructeur avec Id, pour modification et suppression par ID:
	public Employe (String idEmploye) {
		this.idEmploye = idEmploye;
		this.nomEmploye = "inconnu";
		this.coordonnee = new EmployeCoordonnees("inconnue", 12345, "inconnue"); // coordonn�es avec des valeurs! 
	}// Constructeur standard avec initialisation des champs



	/**
	 * @param idEmploye
	 * @param civEmploye
	 * @param nomEmploye
	 * @param prenomEmploye
	 * @param dateNaissEmploye
	 * @param emailEmploye
	 * @param mdpEmploye
	 * @param numTelEmploye
	 * @param coordonnee
	 */
	
	public Employe(String idEmploye, String civEmploye, String nomEmploye, String prenomEmploye,
			LocalDate dateNaissEmploye, String emailEmploye, String mdpEmploye, String numTelEmploye,
			EmployeCoordonnees coordonnee) {
		this.idEmploye = idEmploye;
		setRefEmploye(creerRef());
		this.civEmploye = civEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		setDateNaissEmploye(dateNaissEmploye);
		this.emailEmploye = emailEmploye;
		this.mdpEmploye = mdpEmploye;
		this.numTelEmploye = numTelEmploye;
		this.coordonnee = coordonnee;
	}
	
	/**
	 * @param idEmploye
	 * @param refEmploye
	 * @param civEmploye
	 * @param nomEmploye
	 * @param prenomEmploye
	 * @param dateNaissEmploye
	 * @param emailEmploye
	 * @param numTelEmploye
	 * @param coordonnee
	 */
	public Employe(String idEmploye, String refEmploye, String civEmploye, String nomEmploye,
			String prenomEmploye, LocalDate dateNaissEmploye, String emailEmploye,
			String numTelEmploye, EmployeCoordonnees coordonnee) {
		this.idEmploye = idEmploye;
		this.refEmploye = refEmploye;
		this.civEmploye = civEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.dateNaissEmploye = dateNaissEmploye;
		this.emailEmploye = emailEmploye;
		this.numTelEmploye = numTelEmploye;
		this.coordonnee = coordonnee;
	}

	// M�thode cr�ant la r�f�rence de l'employ� en fonction de son statut
	public String creerRef() {
		String statut = null;
		if (getNomEmploye() != null && getNomEmploye().length() > 1) 
			statut = "00" + getNomEmploye().toUpperCase().trim().substring(0,2) + getDateNaissEmploye().getMonthValue();
		
		return statut;
	}
	
	// GETTERS
	public String getIdEmploye() {
		return idEmploye;
	}
	
	public String getRefEmploye() {
		return refEmploye;
	}

	public String getCivEmploye() {
		return civEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public LocalDate getDateNaissEmploye() {
		return dateNaissEmploye;
	}

	public String getEmailEmploye() {
		return emailEmploye;
	}

	public String getMdpEmploye() {
		return mdpEmploye;
	}

	public String getNumTelEmploye() {
		return numTelEmploye;
	}

	public EmployeCoordonnees getCoordonnee() {
		return coordonnee;
	}
	
	// SETTERS
	
	public void setIdEmploye(String idEmploye) {
		this.idEmploye = idEmploye;
	}

	protected void setRefEmploye(String refEmploye) {
		this.refEmploye = refEmploye;
	}

	public void setCivEmploye(String civEmploye) {
		// contr�le
		if(civEmploye.equals("Mr") || civEmploye.equals("Mme"))		this.civEmploye = civEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}
	
	public void setDateNaissEmploye(LocalDate dateNaissEmploye) {
		this.dateNaissEmploye = dateNaissEmploye;
	}

	public void setEmailEmploye(String emailEmploye) {
		this.emailEmploye = emailEmploye;
	}
	
	public void setMdpEmploye(String mdpEmploye) {
		this.mdpEmploye = mdpEmploye;
	}
	
	// contr�le et param�trage du num�ros de t�l�phone au format FR de type ##.##.##.##.##
	public void setNumTelEmploye(String numTelEmploye) {
	    String regex = ("^([0-9]{2}.[0-9]{2}.[0-9]{2}.[0-9]{2}.[0-9]{2})$");
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(numTelEmploye);
	    if (matcher.matches()) {
	    	this.numTelEmploye = numTelEmploye;
	    } else {
	    	this.numTelEmploye = ("06.11.11.11.11");
	    }
	}

	public void setCoordonnee(EmployeCoordonnees coordonnee) {
		this.coordonnee = coordonnee;
	}

	// Red�finition de la m�thode EQUALS, pour v�rification entre deux
	// objets de type Employ�:
	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj != null && obj instanceof Employe) {
			Employe employe = (Employe)obj;
			retour = employe.getIdEmploye().equals(this.idEmploye) ;
		}
		return retour;
	} 
	
	// Affichage (uniquement pour des tests, ou autre )
	@Override
	public String toString() {
		return "Employ� N� : " + idEmploye + "\n r�f.: "+refEmploye+ "\n civilit� : " + civEmploye +
				"\n nom de l'Employe : " + nomEmploye
				+ ", prenom de l'employe : " + prenomEmploye + 
				"\n date de Naissance : " + dateNaissEmploye.format(DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.FRENCH))
				+ "\n emailEmploye : " + emailEmploye + ", mdpEmploye : " + mdpEmploye + "\n numTelEmploye : "
				+ numTelEmploye + "\n coordonnee : " + coordonnee+"\n";
	}
	
//	// test
//	@Override
//	public String toString() {
//		return "Employ� N� : " + idEmploye + "\n r�f.: "+refEmploye+ "\n civilit� : " + civEmploye +
//				"\n nom de l'Employe : " + nomEmploye
//				+ ", prenom de l'employe : " + prenomEmploye
//				+ "\n emailEmploye : " + emailEmploye + ", mdpEmploye : " + mdpEmploye + "\n numTelEmploye : "
//				+ numTelEmploye;
//	}
}