/**
 * 
 */
package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entites.Categorie;
import entites.Marque;
import entites.Produit;

/**
 * @author antPinot
 *
 */
public class FileGenerate {

	public static List<Produit> createOpenFoodFacts() throws IOException {

		List<Produit> openFoodFacts = new ArrayList<Produit>();

		List<String> file = read();

		Map<String, Integer> clesMap = cles(file);

		for (String lignes : file) {
			if (lignes != file.get(0)) {
				String[] lignesDecoupees = lignes.split("\\|", -1);
				openFoodFacts.add(new Produit(lignesDecoupees[clesMap.get("nom")],
						new Categorie(lignesDecoupees[clesMap.get("categorie")]),
						new Marque(lignesDecoupees[clesMap.get("marque")]),
						lignesDecoupees[clesMap.get("nutritionGradeFr")], lignesDecoupees[clesMap.get("energie100g")],
						lignesDecoupees[clesMap.get("graisse100g")],
						GenerateUtils.generateIngredientsList(lignesDecoupees[clesMap.get("ingredients")]),
						GenerateUtils.generateAdditifsList(lignesDecoupees[clesMap.get("additifs")]),
						GenerateUtils.generateAllergenesList(lignesDecoupees[clesMap.get("allergenes")])));
			}
		}

		return openFoodFacts;

	}

	public static Map<String, Integer> cles(List<String> contenu) throws IOException {

		Map<String, Integer> clesMap = new HashMap<String, Integer>();

		String[] tableauCles = contenu.get(0).split("\\|", -1);

		Integer valeur = 0;

		for (String cles : tableauCles) {
			clesMap.put(cles, valeur);
			valeur++;
		}

		return clesMap;

	}

	public static List<String> read() throws IOException {

		Path path = Paths.get(
				"C:/Users/Saranthony/Documents/Reconversion Professionnelle/Apprentissage Programmation/Diginamic/JPA/TP/open-food-facts.csv");

		List<String> contenu = Files.readAllLines(path, StandardCharsets.UTF_8);

		return contenu;

	}

}
