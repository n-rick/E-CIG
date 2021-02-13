package metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author Enrick
 * <p><b>Description : </b>Class metier Employe </p>
 *
 */

public class Employe {
	
	// d�claration des variables utiles � la la class m�re Employe	
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
	 * <b>Constructeur de la class Employe par d�faut :</b>
	 * @param idEmploye : 
	 * 					Identifiant de l'employ�.
	 * @param nomEmploye : 
	 * 					Nom de famille de l'employ�.
	 * @param coordonnee  :
	 * 					Coordonn�e de l'employ� sous forme (libell� de la rue, cdp, nom de la ville).
	 */
	// Constructeur avec Id, pour modification et suppression par ID:
	public Employe (String idEmploye) {
		this.idEmploye = idEmploye;
		this.nomEmploye = "inconnu";
		this.coordonnee = new EmployeCoordonnees("inconnue", 12345, "inconnue"); // coordonn�es avec des valeurs! 
	}


	/**
	 * <b>Constructeur de la class Employe avec param�tre sauf refEmploye :</b>
	 * <p><b>NOTA : </b>RefEmploye correspond � la r�f�rence de l'employ� en fonction de statut.</p>
	 * @param idEmploye : identifiant de l'empoy�.
	 * @param civEmploye : civilit� de l'employ�.
	 * @param nomEmploye : nom de l'employ�.
	 * @param prenomEmploye : pr�nom de l'employ�.
	 * @param dateNaissEmploye : date de naissance de l'employ� (format : jj-mm-aaaa).
	 * @param emailEmploye : �mail de l'employ�.
	 * @param mdpEmploye : mot de passe de l'employ�
	 * @param numTelEmploye : num�ro de t�l�phone de l'employ�
	 * @param coordonnee : coordonn�e de l'employ� sous forme (libell� de la rue, cdp, nom de la ville).
	 */
	// Constructeur standard avec initialisation des champs
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
	 * <b>Contructeur de la Class Employ� :</b>
	 * <p>Ajout du param�tre refEmploye.</p>
	 * @param idEmploye  		: identifiant de l'employ�.
	 * @param refEmploye 		: r�f�rence de l'employ� dans la soci�t�.
	 * @param civEmploye 		: civilit� de l'employ�.
	 * @param nomEmploye 		: nom de l'employ�.
	 * @param prenomEmploye 	: pr�nom de l'employ�.
	 * @param dateNaissEmploye 	: date de naissance de l'employ� (format : jj-mm-aaaa).
	 * @param emailEmploye 		: adresse mail de l'employ�.
	 * @param mdpEmploye 		: mot de passe de l'employ�
	 * @param numTelEmploye 	: num�ro de t�l�phone de l'employ�.
	 * @param coordonnee 		: coordonn�e de l'employ� sous forme (libell� de la rue, cdp, nom de la ville).
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
	
	/**
	 * <b>Description de la m�thode creerRef()</b>
	 * <p>Cette m�thode permet de cr�er la r�f�rence d'un employ� en fonction de son statut.</p>
	 * <p>Elle ne prend aucun param�tre en entr�e et retourn le statut de l'employ�. Si celui-ci
	 * n'est n'y un Responsable, ni un Salari�, le statut de l'employ� commencera par la cha�ne de caract�re
	 * 'EM'.</p>
	 * <p>Cette m�thode ne prend aucun param�tre en entr�e. Et affiche en sortie le statut de l'employ�.</p>
	 * <p>Condition : le nom de l'employ� ne doit pas �tre null, et sa taille doit �tre sup�rieur � 1.</p>
	 * <p> @return :  statut (une cha�ne de carat�re concat�n�e avec la chaine de caract�re 'EM' 
	 * 	+ Les 2 premi�res initiales du nom de famille de l'empoy�
	 * 	+ le chiffre 0
	 * 	+ le mois de naissance de l'employ�).</p>
	 **/
	// M�thode cr�ant la r�f�rence de l'employ� en fonction de son statut
	public String creerRef() {
		String statut = null;
		if (getNomEmploye() != null && getNomEmploye().length() > 1) 
			statut = "EM" + getNomEmploye().toUpperCase().trim().substring(0,2) + 0 + getDateNaissEmploye().getMonthValue();
		
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
	// objets de type Employ� par leur identifiants:
	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj != null && obj instanceof Employe) {
			Employe employe = (Employe)obj;
			retour = employe.getIdEmploye().equals(this.idEmploye) ;
		}
		return retour;
	} 
	
	// M�thode toString surcharg�e pour affichage (uniquement pour des tests, ou autre )
	@Override
	public String toString() {
		return "Employ� N� : " + idEmploye + "\n r�f.: "+refEmploye+ "\n civilit� : " + civEmploye +
				"\n nom de l'Employe : " + nomEmploye
				+ ", prenom de l'employe : " + prenomEmploye + 
				"\n date de Naissance : " + dateNaissEmploye.format(DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.FRENCH))
				+ "\n emailEmploye : " + emailEmploye + ", mdpEmploye : " + mdpEmploye + "\n numTelEmploye : "
				+ numTelEmploye + "\n coordonnee : " + coordonnee+"\n";
	}
}