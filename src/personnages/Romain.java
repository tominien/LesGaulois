package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
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
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		// Création du romain
		Romain romain = new Romain("Romain", 10);

		// Affichage du nom
		System.out.println(romain.getNom());
		System.out.println(romain);

		// Test des diférentes fonctions de la classe
		System.out.println(romain.prendreParole());
		romain.parler("Je suis " + romain.getNom() + " !");
		romain.recevoirCoup(5); // Affiche "Aïe"
		romain.recevoirCoup(10); // Affiche "J'abandonne..."
	}
}
