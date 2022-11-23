/**
 * 
 */
package utils;

import java.util.HashSet;
import java.util.Set;

import entites.Additif;
import entites.Allergene;
import entites.Ingredient;

/**
 * @author antPinot
 *
 */
public class GenerateUtils {
	
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
	
	public static <T> Set<T> generateList(String string, Class<T> classe){
		Set<T> set = new HashSet<T>();
		String[] stringTraitee = string.split(",");
		
		for (String objects : stringTraitee) {
			try {
				set.add(classe.getConstructor(String.class).newInstance(objects));
			} catch (ReflectiveOperationException e) {
				throw new RuntimeException(e);
			}
		}
		return set;
	}

}
