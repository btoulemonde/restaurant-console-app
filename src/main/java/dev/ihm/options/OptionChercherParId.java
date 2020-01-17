package dev.ihm.options;

import java.util.Scanner;

import dev.entite.Plat;
import dev.service.IPlatService;

public class OptionChercherParId implements IOptionMenu {
	private Scanner scanner;

	private IPlatService service;

	/**
	 * @param scanner
	 * @param service
	 */
	public OptionChercherParId(Scanner scanner, IPlatService service) {
		super();
		this.scanner = scanner;
		this.service = service;
	}

	@Override
	public String getTitre() {
		return "chercher un plat par son id";
	}

	@Override
	public void executer() {
		System.out.println("Saisissez un id : ");
		String choix = this.scanner.next();
		int id = Integer.parseInt(choix);

		Plat plat = this.service.afficherPlatId(id);

		System.out.println(plat.getNom() + " (" + (plat.getPrixEnCentimesEuros() / 100) + " €)");

	}

}
