package dev.ihm.options;

import java.util.Scanner;

import dev.service.IPlatService;

public class OptionSupprimer implements IOptionMenu {

	private Scanner scanner;

	private IPlatService service;
	
	
	/**
	 * @param scanner
	 * @param service
	 */
	public OptionSupprimer(Scanner scanner, IPlatService service) {
		super();
		this.scanner = scanner;
		this.service = service;
	}

	@Override
	public String getTitre() {
		return "Supprimer un plat :";
	}

	@Override
	public void executer() {
		System.out.println("Saisissez un id : ");
		String choix = this.scanner.next();
		int id = Integer.parseInt(choix);
		
		this.service.delet(id);

	}

}
