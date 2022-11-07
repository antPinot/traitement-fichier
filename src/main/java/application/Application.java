/**
 * 
 */
package application;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entites.Additif;
import entites.Allergene;
import entites.Categorie;
import entites.Ingredient;
import entites.Marque;
import entites.OpenFoodFacts;
import entites.Produit;

/**
 * @author antPinot
 *
 */
public class Application {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		OpenFoodFacts openFoodFacts = new OpenFoodFacts();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		/*
		 * em.persist(openFoodFacts.getProduits().get(0).getCategorie());
		 * em.persist(openFoodFacts.getProduits().get(0).getMarque());
		 * em.persist(openFoodFacts.getProduits().get(0).getIngredients().get(0));
		 * em.persist(openFoodFacts.getProduits().get(0).getAdditifs().get(0));
		 * em.persist(openFoodFacts.getProduits().get(0).getAllergenes().get(0));
		 * em.persist(openFoodFacts.getProduits().get(0));
		 */

		for (Produit contenu : openFoodFacts.getProduits()) {

			transaction.begin();

			TypedQuery<Categorie> queryCategorie = em.createQuery("SELECT c FROM Categorie c WHERE c.libelle = :param1",
					Categorie.class);
			queryCategorie.setParameter("param1", contenu.getCategorie().getLibelle());
			List<Categorie> categoriesResult = queryCategorie.getResultList();
			
			if (categoriesResult.size() == 0) {
				em.persist(contenu.getCategorie());
			} else {
				contenu.setCategorie(categoriesResult.get(0));
			}

			TypedQuery<Marque> queryMarque = em.createQuery("SELECT m FROM Marque m WHERE m.libelle = :param2",
					Marque.class);
			queryMarque.setParameter("param2", contenu.getMarque().getLibelle());
			List<Marque> marquesResult = queryMarque.getResultList();

			if (marquesResult.size() == 0) {
				em.persist(contenu.getMarque());
			} else {
				contenu.setMarque(marquesResult.get(0));
			}

			/*
			 * for (Categorie ctQuery : categoriesResult) { if
			 * (!contenu.getCategorie().getLibelle().equals(ctQuery.getLibelle())) {
			 * 
			 * } else {
			 * 
			 * }
			 */

			/*
			 * for (Marque mqQuery : marquesResult) { if
			 * (!contenu.getMarque().getLibelle().equals(mqQuery.getLibelle())) {
			 * em.persist(contenu.getMarque()); } else { contenu.setMarque(mqQuery); } }
			 */
			
			Set<Ingredient> ingredientsUpdate = new HashSet<Ingredient>();

			for (Ingredient ingredients : contenu.getIngredients()) {
				TypedQuery<Ingredient> queryIngredient = em
						.createQuery("SELECT i FROM Ingredient i WHERE i.libelle = :param3", Ingredient.class);
				queryIngredient.setParameter("param3", ingredients.getLibelle());
				List<Ingredient> ingredientsResult = queryIngredient.getResultList();

				if (ingredientsResult.size() == 0) {
					em.persist(ingredients);
				} else {
					ingredientsUpdate.add(ingredientsResult.get(0));
				}
			}
			
			contenu.setIngredients(ingredientsUpdate);

			/*
			 * for (Ingredient igQuery : ingredientsResult) { if
			 * (!ingredients.getLibelle().equals(igQuery.getLibelle())) {
			 * em.persist(ingredients); } else {
			 * ingredients.setLibelle(igQuery.getLibelle()); } } }
			 */
			
			Set<Additif> additfsUpdate = new HashSet<Additif>();
			
			for (Additif additifs : contenu.getAdditifs()) {
				TypedQuery<Additif> queryAdditif = em
						.createQuery("SELECT ad FROM Additif ad WHERE ad.libelle = :param4", Additif.class);
				queryAdditif.setParameter("param4", additifs.getLibelle());
				List<Additif> additifsResult = queryAdditif.getResultList();
				if (additifsResult.size() == 0) {
					em.persist(additifs);
				} else {
					additfsUpdate.add(additifsResult.get(0));
				}
			}
			
			contenu.setAdditifs(additfsUpdate);
			/*
			 * for (Additif adQuery : additifsResult) { if
			 * (!additifs.getLibelle().equals(adQuery.getLibelle())) { em.persist(additifs);
			 * } else { additifs.setLibelle(adQuery.getLibelle()); } } }
			 */

			Set<Allergene> allergenesUpdate = new HashSet<Allergene>();
			
			for (Allergene allergenes : contenu.getAllergenes()) {
				TypedQuery<Allergene> queryAllergene = em
						.createQuery("SELECT al FROM Allergene al WHERE al.libelle = :param5", Allergene.class);
				queryAllergene.setParameter("param5", allergenes.getLibelle());
				List<Allergene> allergenesResult = queryAllergene.getResultList();
				if (allergenesResult.size() == 0) {
					em.persist(allergenes);
				} else {
					allergenesUpdate.add(allergenesResult.get(0));
				}
			}
			
			contenu.setAllergenes(allergenesUpdate);

			/*
			 * for (Allergene alQuery : allergenesResult) { if
			 * (!allergenes.getLibelle().equals(alQuery.getLibelle())) {
			 * em.persist(allergenes); } else { allergenes.setLibelle(alQuery.getLibelle());
			 * } }
			 */
			
			em.persist(contenu);
			
			transaction.commit();
		}

		Produit queryProduit = em.find(Produit.class, 1);
		System.out.println(queryProduit);

	}

}
