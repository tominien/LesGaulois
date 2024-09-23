package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {

	public static void main(String[] args) {
		// Création d'Astérix et du romain Minus
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain romain_minus = new Romain("Minus", 6);

		// Script
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour !");
		romain_minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(romain_minus);
	}
}
