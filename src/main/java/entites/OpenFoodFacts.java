/**
 * 
 */
package entites;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author antPinot
 *
 */
public class OpenFoodFacts {

	private List<Produit> produits = new ArrayList<Produit>();

	/**Constructeur
	 * @param produits
	 * @throws IOException 
	 */
	public OpenFoodFacts() throws IOException {
		this.produits = creerOpenFoodFacts();
	}

	public static List<Produit> creerOpenFoodFacts() throws IOException {

		List<Produit> openFoodFacts = new ArrayList<Produit>();

		Path path = Paths.get(
				"C:/Users/Saranthony/Documents/Reconversion Professionnelle/Apprentissage Programmation/Diginamic/JPA/TP/open-food-facts.csv");

		List<String> contenu = Files.readAllLines(path, StandardCharsets.UTF_8);

		String[] tableauCles = contenu.get(0).split("\\|",-1);

		Map<String, Integer> clesMap = new HashMap<String, Integer>();

		Integer valeur = 0;

		for (String cles : tableauCles) {
			clesMap.put(cles, valeur);
			valeur++;
		}

		for (String lignes : contenu) {
			if (lignes != contenu.get(0)) {
				String[] lignesDecoupees = lignes.split("\\|", -1);
				openFoodFacts.add(new Produit(lignesDecoupees[clesMap.get("nom")], 
						new Categorie(lignesDecoupees[clesMap.get("categorie")]),
						new Marque(lignesDecoupees[clesMap.get("marque")]),
						lignesDecoupees[clesMap.get("nutritionGradeFr")], lignesDecoupees[clesMap.get("energie100g")],
						lignesDecoupees[clesMap.get("graisse100g")],
						generateIngredientsList(lignesDecoupees[clesMap.get("ingredients")]),
						generateAdditifsList(lignesDecoupees[clesMap.get("additifs")]),
						generateAllergenesList(lignesDecoupees[clesMap.get("allergenes")])));
			}
		}
		
		return openFoodFacts;

	}

	public static Set<Ingredient> generateIngredientsList(String ingredientString) {
		Set<Ingredient> ingredientsList = new HashSet<Ingredient>();
		String[] ingredientStringTraitee = ingredientString.split(",");

		for (String ingredients : ingredientStringTraitee) {
			ingredientsList.add(new Ingredient(ingredients));
		}

		return ingredientsList;
	}

	public static Set<Allergene> generateAllergenesList(String allergeneString) {
		Set<Allergene> allergenesList = new HashSet<Allergene>();
		String[] allergeneStringTraitee = allergeneString.split(",");

		for (String allergenes : allergeneStringTraitee) {
			allergenesList.add(new Allergene(allergenes));
		}

		return allergenesList;
	}

	public static Set<Additif> generateAdditifsList(String additifString) {
		Set<Additif> additifsList = new HashSet<Additif>();
		String[] additifStringTraitee = additifString.split(",");

		for (String additifs : additifStringTraitee) {
			additifsList.add(new Additif(additifs));
		}

		return additifsList;
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
