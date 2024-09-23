package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;

	public static void main(String[] args) {
		// Création de Panoramix
		Druide panoramix = new Druide("Panoramix", 5, 10);

		// Tester la méthode "preparerPotion()" :
		for (int i = 0; i < 10; i++) {
			panoramix.preparerPotion();
		}
	}

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

	public int preparerPotion() {
		// Génération de l'entier aléatoire
		Random random = new Random();
		int randomInt = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;

		// Annonce de la force de la potion
		if (randomInt >= 7) {
			parler("J'ai préparé une super potion de force!");
			parler("La force de ma potion est " + randomInt + ".");
		} else {
			parler("Je n'ai pas trouvé tous les ingédients, ma potion est seulement de force " + randomInt + ".");
		}

		return randomInt;
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(preparerPotion());
		}
	}
}
