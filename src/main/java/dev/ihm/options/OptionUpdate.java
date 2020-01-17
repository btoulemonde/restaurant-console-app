package dev.ihm.options;

import java.util.Scanner;

import dev.service.IPlatService;

public class OptionUpdate implements IOptionMenu {

	private Scanner scanner;

	private IPlatService service;

	
	
	/**
	 * @param scanner
	 * @param service
	 */
	public OptionUpdate(Scanner scanner, IPlatService service) {
		super();
		this.scanner = scanner;
		this.service = service;
	}

	@Override
	public String getTitre() {
		return "Changer le nom d'un plat";
	}

	@Override
	public void executer() {
		System.out.println("Saisissez un id : ");
		String choix = this.scanner.next();
		int id = Integer.parseInt(choix);
		
		System.out.println("Saisissez le nom du nouveau plat");
		String nom = this.scanner.next();
		
		this.service
		.mettreAjour(nom, id);

	}

}
