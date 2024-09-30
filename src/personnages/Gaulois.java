package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		// Création du gaulois, du druide et du romain
		Gaulois asterix = new Gaulois("Astérix", 8);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain minus = new Romain("Minus", 6);

		// Affichage du nom
		System.out.println(asterix.getNom());
		System.out.println(asterix);

		// Test des diférentes fonctions de la classe
		System.out.println(asterix.prendreParole());
		asterix.parler("Je suis " + asterix.getNom() + " !");
		asterix.frapper(minus);
		panoramix.preparerPotion();
		panoramix.booster(asterix);
		asterix.frapper(minus);

	}
}
