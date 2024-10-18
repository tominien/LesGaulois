package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		// Génération de l'entier aléatoire :
		Random random = new Random();
		int randomInt = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;

		// Annonce de la force de la potion :
		if (randomInt >= 7) {
			parler("J'ai préparé une super potion de force!");
			parler("La force de ma potion est " + randomInt + ".");
		} else {
			parler("Je n'ai pas trouvé tous les ingédients, ma potion est seulement de force " + randomInt + ".");
		}

		forcePotion = randomInt;
	}

	public void booster(Gaulois gaulois) {
		if ("Obélix".equals(gaulois.getNom())) {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		} else {
			preparerPotion();
			gaulois.boirePotion(forcePotion);
		}
	}

	public static void main(String[] args) {
		// Main permettant de tester la classe "Druide".
		// Il correspond à la partie b de la question 3 de l'exercice 4 du TP n°1.

		// Création de Panoramix
		Druide panoramix = new Druide("Panoramix", 5, 10);

		// Tester la méthode "preparerPotion()" :
		for (int index = 0; index < 10; index++) {
			panoramix.preparerPotion();
		}
	}
}
