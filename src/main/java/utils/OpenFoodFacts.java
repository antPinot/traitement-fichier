/**
 * 
 */
package utils;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import entites.Produit;


/**
 * @author antPinot
 *
 */
public class OpenFoodFacts {

	private List<Produit> produits = new ArrayList<Produit>();

	/**
	 * Constructeur
	 * 
	 * @param produits
	 * @throws IOException
	 */
	public OpenFoodFacts() throws IOException {
		this.produits = FileGenerate.createOpenFoodFacts();
	}

	/**
	 * Getter pour l'attribut produits
	 * 
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/**
	 * Setter pour l'attribut produits
	 * 
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
