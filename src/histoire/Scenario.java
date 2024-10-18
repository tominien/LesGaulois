package histoire;

//Changements de code notables :
// (1) La variable "texte" de "Romain" n'était utilisées que dans une fonction. Je l'ai supprimée (est-ce grave ?).
// (2) La méthode "faireUneDonnation" de "Musee" était mal orthographiée, je l'ai corrigée par "faireUneDonation" (est-ce grave ?).

import personnages.Druide;
import personnages.Gaulois;
import personnages.Equipement;
import personnages.Romain;
import villagegaulois.Musee;

public class Scenario {
	public static void main(String[] args) {
		// Scénario fixé par les énoncés de TP :
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25, 0);
		Gaulois asterix = new Gaulois("Astérix", 8, 0);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");

		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);

		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0 && Boolean.FALSE.equals(minus.isVainqueur()));

		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0 && Boolean.FALSE.equals(milexcus.isVainqueur()));

		Musee musee = new Musee();
		asterix.faireUneDonation(musee);

		// Afficher le contenu du musée sous forme d'une liste OCaml :
		System.out.println(musee.extraireInstructionsOCaml());
	}
}