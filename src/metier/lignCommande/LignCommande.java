package metier.lignCommande;

import java.util.Objects;

import produit.metier.Produit;

public class LignCommande {
	public int quantite;
	public Produit produit;
	
	public LignCommande (int quantite, Produit produit) {
		this.quantite = quantite;
		this.produit = produit;
	}
	
	
	//Quand le produit est ajout� depuis la ListProduit la quantite est de 1 
	
	public LignCommande(Produit produit) {
		this.quantite = 1;
		this.produit = produit;
	}
	
	//methode
	/*	public double calculMontant() {
		Objects.requireNonNull(produit);
		try {
			double montant = getProduit().getPrix()*quantite;
			return montant;
		}catch 
		
	}*/
	
	
	//getters et setters
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	//toString
	
	
	@Override
	public String toString() {
		return "LignCommande [quantite=" + quantite + ", produit=" + produit + "]";
	}
	


	
}
