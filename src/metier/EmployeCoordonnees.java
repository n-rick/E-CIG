package metier;

public class EmployeCoordonnees {
	
	private String	adressRueEmploye;
	private int		cdpEmploye;
	private String	nomVille;

	public EmployeCoordonnees() {
	}

	/**
	 * @param adressRueEmploye
	 * @param cdpEmploye
	 * @param nomVille
	 */
	public EmployeCoordonnees(String adressRueEmploye, int cdpEmploye, String nomVille) {
		this.adressRueEmploye = adressRueEmploye;
		this.cdpEmploye = cdpEmploye;
		this.nomVille = nomVille;
	}

	/**
	 * @return le nom de la rue de l'employ�
	 */
	public String getAdressRueEmploye() {
		return adressRueEmploye;
	}

	/**
	 * @return le code postal de l'employ�
	 */
	public int getCdpEmploye() {
		return cdpEmploye;
	}

	/**
	 * @return le libell� de la ville de l'employ�
	 */
	public String getNomVille() {
		return nomVille;
	}

	/**
	 * @param adressRueEmploye the adressRueEmploye to set
	 */
	public void setAdressRueEmploye(String adressRueEmploye) {
		this.adressRueEmploye = adressRueEmploye;
	}

	/**
	 * @param cdpEmploye the cdpEmploye to set
	 */
	public void setCdpEmploye(int cdpEmploye) {
		this.cdpEmploye = cdpEmploye;
	}

	/**
	 * @param nomVille the nomVille to set
	 */
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	@Override
	public String toString() {
		return "adresse : " + adressRueEmploye + "\n code postal : " + cdpEmploye
				+ "\n ville : " + nomVille;
	}

}
