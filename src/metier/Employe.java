package metier;

public class Employe {
	
	private String	idEmploye;
	private String	refEmploye;
	private String	civEmploye;
	private String	nomEmploye;
	private String	prenomEmploye;
	private String	dateNaissEmploye;
	private String	emailEmploye;
	private String	mdpEmploye;
	private String 	numTelEmploye;
	private String	adressRueEmploye;
	private String	cdpEmploye;
	private String	nomVille;
	

	// Constructeur par défaut, utilisation exclusif dans le useBean
	public Employe() {
	}
	
	// Constructeur avec Id, pour recherche et suppression par ID.
	public Employe (String idEmploye) {
		this.idEmploye = idEmploye;
		this.nomEmploye = "inconnu";		
	}
	

	// Constructeur standard.

	public Employe(String idEmploye, String refEmploye, String civEmploye, String nomEmploye, String prenomEmploye,
			String dateNaissEmploye, String emailEmploye, String mdpEmploye, String numTelEmploye,
			String adressRueEmploye, String cdpEmploye, String nomVille) {
		this.idEmploye = idEmploye;
		this.refEmploye = refEmploye;
		this.civEmploye = civEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.dateNaissEmploye = dateNaissEmploye;
		this.emailEmploye = emailEmploye;
		this.mdpEmploye = mdpEmploye;
		this.numTelEmploye = numTelEmploye;
		this.adressRueEmploye = adressRueEmploye;
		this.cdpEmploye = cdpEmploye;
		this.nomVille = nomVille;
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

	public String getDateNaissEmploye() {
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

	public String getAdressRueEmploye() {
		return adressRueEmploye;
	}

	public String getCdpEmploye() {
		return cdpEmploye;
	}

	public String getNomVille() {
		return nomVille;
	}
	
	// SETTERS
	public void setIdEmploye(String idEmploye) {
		this.idEmploye = idEmploye;
	}

	public void setRefEmploye(String refEmploye) {
		this.refEmploye = refEmploye;
	}

	public void setCivEmploye(String civEmploye) {
		this.civEmploye = civEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public void setDateNaissEmploye(String dateNaissEmploye) {
		this.dateNaissEmploye = dateNaissEmploye;
	}

	public void setEmailEmploye(String emailEmploye) {
		this.emailEmploye = emailEmploye;
	}

	public void setMdpEmploye(String mdpEmploye) {
		this.mdpEmploye = mdpEmploye;
	}

	public void setNumTelEmploye(String numTelEmploye) {
		this.numTelEmploye = numTelEmploye;
	}

	public void setAdressRueEmploye(String adressRueEmploye) {
		this.adressRueEmploye = adressRueEmploye;
	}

	public void setCdpEmploye(String cdpEmploye) {
		this.cdpEmploye = cdpEmploye;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	// Fonction EQUALS redéfini, pour vérification entre deux
	// objet de type Employé; pour la suppression d'objet.
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
		return "Employe [idEmploye : " + idEmploye + ", refEmploye : " + refEmploye + ", civEmploye : " + civEmploye
				+ ", nomEmploye : " + nomEmploye + ", prenomEmploye : " + prenomEmploye + ", dateNaissEmploye : "
				+ dateNaissEmploye + ", emailEmploye : " + emailEmploye + ", mdpEmploye : " + mdpEmploye
				+ ", adressRueEmploye : " + adressRueEmploye + ", cdpEmploye : "
				+ cdpEmploye + ", nomVille : " + nomVille + "]";
	}
	

}