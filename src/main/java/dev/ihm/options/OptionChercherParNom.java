package dev.ihm.options;

import java.util.Scanner;

import dev.entite.Plat;
import dev.service.IPlatService;

public class OptionChercherParNom implements IOptionMenu {

	private Scanner scanner;

	private IPlatService service;

	/**
	 * @param scanner
	 * @param service
	 */
	public OptionChercherParNom(Scanner scanner, IPlatService service) {
		super();
		this.scanner = scanner;
		this.service = service;
	}

	@Override
	public String getTitre() {
		return "chercher un plat par son nom";
	}

	@Override
	public void executer() {
		System.out.println("Saisissez un nom : ");
		String nom = this.scanner.next();

		Plat plat = this.service.afficherPlatNom(nom); 
		
		System.out.println(plat.getNom() + " (" + (plat.getPrixEnCentimesEuros() / 100) + " €)");

	}


}
