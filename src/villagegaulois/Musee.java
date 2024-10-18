package villagegaulois;

import personnages.Gaulois;
import personnages.Trophee;
import personnages.Equipement;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;

	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		// Vérifier que le musée n'est pas plein :
		if (nbTrophees >= 200) {
			throw new IllegalArgumentException("Unexpected value: Le musée est plein.");
		}

		// Création du trophée
		Trophee tropheeDonne = new Trophee(gaulois, equipement);

		// Ajouter le trophée au musée
		trophees[nbTrophees] = tropheeDonne;
		nbTrophees++;
	}

	public String extraireInstructionsOCaml() {
		String instructionsOCaml = "let musee = [\n";

		for (int index = 0; index < nbTrophees - 1; index++) {
			Trophee tropheeActuel = trophees[index];
			instructionsOCaml += "\t\"" + tropheeActuel.donnerNom() + "\", \"" + tropheeActuel.getEquipement()
					+ "\";\n";
		}
		instructionsOCaml += "\t\"" + trophees[nbTrophees - 1].donnerNom() + "\", \""
				+ trophees[nbTrophees - 1].getEquipement() + "\"\n]";

		return instructionsOCaml;
	}
}
