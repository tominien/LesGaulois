package personnages;

import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force, int nbTrophees) {
		this.nom = nom;
		this.force = force;
		this.nbTrophees = nbTrophees;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom() + ".");

		// Récupérer tous les équipements jetés par le romain frappé :
		Equipement[] tropheesRecuperes = romain.recevoirCoup((force / 3) * effetPotion);

		// Les ajouter à notre liste de trophées :
		// Condition ajoutée : si le gaulois ne peux plus transporter de trophées, il
		// les laisse par terre.
		for (int index = 0; tropheesRecuperes != null && index < tropheesRecuperes.length
				&& nbTrophees < 100; index++, nbTrophees++) {
			trophees[nbTrophees] = tropheesRecuperes[index];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}

	public void faireUneDonation(Musee musee) {
		// Donner tous les trophées aux musée :
		String listeTrophees = "";
		for (int index = 0; index < nbTrophees; index++) {
			Equipement equipementActuel = trophees[index];
			musee.donnerTrophee(this, equipementActuel);
			listeTrophees += "\t- " + equipementActuel.toString() + "\n";
		}

		// Annoncer les trophées donnés (si on en a donné) :
		if (nbTrophees > 0) {
			parler("\nJ'ai récupéré " + nbTrophees + " trophée(s) ! Je les ai tous donnés au musée :\n"
					+ listeTrophees);
		}

	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + ", nbTrophees= " + nbTrophees + "]";
	}

	public static void main(String[] args) {
		// Main permettant de tester la classe Gaulois.
		// Il correspond à l'exercice 1 du TP n°1.

		// Création du gaulois, du druide et du romain.
		Gaulois asterix = new Gaulois("Astérix", 8, 0);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain minus = new Romain("Minus", 6);

		// Affichage du nom du gaulois.
		System.out.println(asterix.getNom()); // Affiche "Astérix"
		System.out.println(asterix); // Affiche "Gaulois [nom=Astérix, force=8, effetPotion=1, nbTrophees=0]"

		// Test des diférentes fonctions de la classe .
		System.out.println(asterix.prendreParole()); // Affiche "Le gaulois Astérix : "
		asterix.parler("Je suis " + asterix.getNom() + " !"); // Affiche "Le gaulois Astérix : « Je suis Astérix ! »"
		asterix.frapper(minus);
		panoramix.booster(asterix);
		asterix.frapper(minus);
	}
}
