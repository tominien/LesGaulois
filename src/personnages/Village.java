package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillagois = 0;
	private int nbVillagoisMaximum;
	private Gaulois[] villagois;

	public Village(String nom, int nbVillagoisMaximum) {
		this.nom = nom;
		this.nbVillagoisMaximum = nbVillagoisMaximum;
		this.villagois = new Gaulois[nbVillagoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois villagois) {
		if (nbVillagois < nbVillagoisMaximum) {
			this.villagois[nbVillagois] = villagois;
			nbVillagois++;
		}
	}

	public Gaulois trouverHabitant(int indice) {
		if (indice >= nbVillagois) {
			throw new IllegalArgumentException("Unexpected value: L'indice du villagois dans le village " + getNom()
					+ " est supérieur au nombre d'habitants.");
		}

		return villagois[indice];
	}

	public void afficherVillagois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillagois; i++) {
			System.out.println("- " + villagois[i].getNom());
		}
	}

	public static void main(String[] args) {
		// Main permettant de tester la classe "Village".
		// Il correspond à la partie 2 de l'exercice 1 du TP n°2.

		Village village = new Village("Village des Irréductibles", 30);

//		Gaulois gaulois = village.trouverHabitant(30);
		// Génère une erreur car on essaye d'accéder à un gaulois pas encore ajouté.

		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8, 0);

		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);

//		Gaulois gaulois = village.trouverHabitant(0);
//		System.out.println(gaulois);
		// On obtient Astérix si on met indice à 0 et une erreur si on met indice à 1.

		Gaulois obelix = new Gaulois("Obélix", 25, 0);
		village.ajouterHabitant(obelix);

		village.afficherVillagois();
	}
}
