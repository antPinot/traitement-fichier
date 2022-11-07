/**
 * 
 */
package entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author antPinot
 *
 */
@Entity
@Table
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "LIBELLE", length = 255, nullable = true, unique = false)
	private String libelle;
	
	@ManyToMany(mappedBy = "ingredients")
	private List<Produit> produits;

	/**Constructeur
	 * 
	 */
	public Ingredient() {
	}

	/**Constructeur
	 * @param libelle
	 */
	public Ingredient(String libelle) {
		this.libelle = libelle;
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

	/**Getter pour l'attribut produits
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/**Setter pour l'attribut produits
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
