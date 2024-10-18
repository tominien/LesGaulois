package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = false;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert this.force >= 0;
	}

	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}

	public boolean isVainqueur() {
		return vainqueur;
	}

	private boolean isInvariantVerified() {
		return force > 0;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;

		// Précondition : force strictement positive.
		assert isInvariantVerified();

		// Calcul de la force du coup et modification de la force du romain :
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;

		// Réaction du romain en fonction du coup :
		if (force == oldForce) {
			// Le coup ne lui a rien fait.
			parler("Tu ne me fais rien haha !");
			vainqueur = true;
		} else if (force > 0) {
			// Le coup lui a fait des dégats mais il lui reste de la force.
			parler("Aïe");
		} else {
			// Le coup lui a fait des dégats et il n'a plus de force.
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}

		// Postcondition : La force a diminuée ou le romain est vainqueur.
		assert force < oldForce ^ isVainqueur(); // "^" opération xor, une seule des deux conditions est vérifiée.

		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		parler("Ma force est de " + force + ", et la force du coup est de " + forceCoup + ".");

		// Calcul de la résistance de(s) équipement(s) :
		int resistanceEquipement = 0;
		if (nbEquipement > 0) {
			for (int index = 0; index < nbEquipement; index++) {
				if (equipements[index] != null && equipements[index].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					resistanceEquipement += 5;
				}
			}
		}

		// Calcul de la résistance de(s) équipement(s) par rapport à la force du coup :
		parler("Mais heureusement, grace à mon équipement sa force est diminuée de " + resistanceEquipement + " !");
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0;
		}
		// Les trois lignes ci dessus peuvent être synthétisées en :
		// "forceCoup = max(0, forceCoup - resistanceEquipement);".
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		// Ejecter tous les équipements du romain :
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}

		// Renvoyer la liste des équipements éjectés :
		return equipementEjecte;
	}

	private void equiper(Equipement equipement) {
		// Ajouter l'équipement "equipement" à la liste des équipements du romain :
		equipements[nbEquipement] = equipement;
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement.toString() + ".");
		nbEquipement++;
	}

	public void sEquiper(Equipement equipement) {
		// Ajouter l'équipement "equipement" au romain,
		// s'il lui reste de la place et qu'il ne le possède pas déjà :
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipements[0].toString() + " !");
			} else {
				equiper(equipement);
			}
			break;
		case 0:
			equiper(equipement);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
		}
	}

	public static void main(String[] args) {
		// Main permettant de tester la classe "Romain".
		// Il correspond à la question 2 de l'exercice 2 du TP n°2.

		Romain minus = new Romain("Minus", 8);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
