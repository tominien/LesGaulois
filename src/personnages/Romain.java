package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert(this.force > 0);
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
		int forceDebut = this.force;
		assert(this.force > 0);
		this.force -= forceCoup;	
		if (this.force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert(forceDebut > this.force);
	}
	
	private void equiper_equipement(Equipement equipement) {
		this.equipements[this.nbEquipement] = equipement;
		this.nbEquipement++;
		System.out.println("Le soldat " + getNom() + "s'équipe avec un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch(this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
			break;
		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + getNom() + "possède déjà un " + equipement + " !");
			} else {
				equiper_equipement(equipement);
			}
			break;
		default: // this.nbEquipement = 0
			equiper_equipement(equipement);
			break;
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
		
		// Test du l'énumération EQUIPEMENT :
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		
		// Test de la méthode sEquiper :
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.BOUCLIER);
	}
}
