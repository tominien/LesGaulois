package personnages;

public class Village {
	public String nom;
	private Chef chef;
	private int nbVillagois = 0;
	private int nbVillagoisMaximum;
	private Gaulois[] villagois;

	public Village(String nom, int nbVillagoisMaximum) {
		this.nom = nom;
		this.nbVillagoisMaximum = nbVillagoisMaximum;
		this.villagois = new Gaulois[nbVillagoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois villagois) {
		if (nbVillagois < nbVillagoisMaximum) {
			this.villagois[nbVillagois] = villagois;
			nbVillagois++;
		}
	}

	public Gaulois trouverHabitant(int indice) {
		// On suppose que l'indce donné est strictement inférieur à la variable
		// nbVillagois. Sinon, nous obtiendrons une erreur.
		return this.villagois[indice];
	}

	public void afficherVillagois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i<nbVillagois; i++) {
			System.out.println("- " + this.villagois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
		// Nous obtenons une erreur cas nous essayons d'accéder à un gaulois qui n'a pas
		// encore été créé.
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);

//		Gaulois gaulois = village.trouverHabitant(0);
//		System.out.println(gaulois);
		// Nous Obtenons le gaulois AStérix (si on met l'indice 0) et une erreur si on
		// met l'indice 1.
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		
		village.afficherVillagois();
	}
}
