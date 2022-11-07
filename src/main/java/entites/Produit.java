/**
 * 
 */
package entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author antPinot
 *
 */

@Entity
@Table
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "LIBELLE", length = 255, nullable = false, unique = false)
	private String nom;

	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIE")
	private Categorie categorie;

	@ManyToOne
	@JoinColumn(name = "ID_MARQUE")
	private Marque marque;

	@Column(name = "SCORE_NUTRITIONNEL", length = 2, nullable = false, unique = false)
	private String scoreNutritionnel;
	
	@Column(name = "ENERGIE", length = 25, nullable = true, unique = false)
	private String energie;
	
	@Column(name = "GRAISSE", length = 25, nullable = true, unique = false)
	private String graisse;

	@ManyToMany
	@JoinTable(name = "PRODUIT_INGREDIENT", joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_INGREDIENT", referencedColumnName = "ID"))
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	@ManyToMany
	@JoinTable(name = "PRODUIT_ADDITIF", joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ADDITIF", referencedColumnName = "ID"))
	private Set<Additif> additifs = new HashSet<Additif>();
	
	@ManyToMany
	@JoinTable(name = "PRODUIT_ALLERGENE", joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ALLERGENE", referencedColumnName = "ID"))
	private Set<Allergene> allergenes = new HashSet<Allergene>();

	/**Constructeur
	 * @param nom
	 * @param categorie
	 * @param marque
	 * @param scoreNutritionnel
	 * @param energie
	 * @param graisse
	 * @param ingredients
	 * @param additifs
	 * @param allergenes
	 */

	

	/**Constructeur
	 * 
	 */
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	/**Constructeur
	 * @param nom
	 * @param categorie
	 * @param marque
	 * @param scoreNutritionnel
	 * @param energie
	 * @param graisse
	 * @param ingredients
	 * @param additifs
	 * @param allergenes
	 */
	public Produit(String nom, Categorie categorie, Marque marque, String scoreNutritionnel, String energie,
			String graisse, Set<Ingredient> ingredients, Set<Additif> additifs, Set<Allergene> allergenes) {
		this.nom = nom;
		this.categorie = categorie;
		this.marque = marque;
		this.scoreNutritionnel = scoreNutritionnel;
		this.energie = energie;
		this.graisse = graisse;
		this.ingredients = ingredients;
		this.additifs = additifs;
		this.allergenes = allergenes;
	}

	/**Getter pour l'attribut nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**Setter pour l'attribut nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter pour l'attribut categorie
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**Setter pour l'attribut categorie
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**Getter pour l'attribut marque
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**Setter pour l'attribut marque
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/**Getter pour l'attribut scoreNutritionnel
	 * @return the scoreNutritionnel
	 */
	public String getScoreNutritionnel() {
		return scoreNutritionnel;
	}

	/**Setter pour l'attribut scoreNutritionnel
	 * @param scoreNutritionnel the scoreNutritionnel to set
	 */
	public void setScoreNutritionnel(String scoreNutritionnel) {
		this.scoreNutritionnel = scoreNutritionnel;
	}

	/**Getter pour l'attribut energie
	 * @return the energie
	 */
	public String getEnergie() {
		return energie;
	}

	/**Setter pour l'attribut energie
	 * @param energie the energie to set
	 */
	public void setEnergie(String energie) {
		this.energie = energie;
	}

	/**Getter pour l'attribut graisse
	 * @return the graisse
	 */
	public String getGraisse() {
		return graisse;
	}

	/**Setter pour l'attribut graisse
	 * @param graisse the graisse to set
	 */
	public void setGraisse(String graisse) {
		this.graisse = graisse;
	}

	/**Getter pour l'attribut id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter pour l'attribut ingredients
	 * @return the ingredients
	 */
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	/**Setter pour l'attribut ingredients
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**Getter pour l'attribut additifs
	 * @return the additifs
	 */
	public Set<Additif> getAdditifs() {
		return additifs;
	}

	/**Setter pour l'attribut additifs
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(Set<Additif> additifs) {
		this.additifs = additifs;
	}

	/**Getter pour l'attribut allergenes
	 * @return the allergenes
	 */
	public Set<Allergene> getAllergenes() {
		return allergenes;
	}

	/**Setter pour l'attribut allergenes
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(Set<Allergene> allergenes) {
		this.allergenes = allergenes;
	}


}
