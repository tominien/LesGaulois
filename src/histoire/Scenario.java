package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {

	public static void main(String[] args) {
		// Création d'Astérix et du romain Minus
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain romain_minus = new Romain("Minus", 6);

		// Script
		asterix.parler("Bonjour à tous !");
		romain_minus.parler("UN GAU... UN GAUGAU...");
		for (int i = 0; i < 3; i++) {
			asterix.frapper(romain_minus);
		}

		// Druide
		Druide druide = new Druide("druide", 0, 100);
		druide.preparerPotion();

		// TODO Finir la TP1 (à partir de la page 19)

	}

}
