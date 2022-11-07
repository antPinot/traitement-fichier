/**
 * 
 */
package entites;

/**
 * @author antPinot
 *
 */

public enum ScoreNutritionnel {
	
	A("A"),
	B("B"),
	C("C"),
	D("D"),
	E("E"),
	F("F");
	
	private String libelle;

	/**Constructeur
	 * @param libelle
	 */
	private ScoreNutritionnel(String libelle) {
		this.libelle = libelle;
	}

	/**Getter pour l'attribut libelle
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**Setter pour l'attribut libelle
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
