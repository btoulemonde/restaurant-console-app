package dev.ihm;

import dev.exception.PlatException;
import dev.ihm.options.IOptionMenu;
import dev.ihm.options.OptionAjouterPlat;
import dev.ihm.options.OptionListerPlats;
import dev.ihm.options.OptionSupprimer;
import dev.ihm.options.OptionChercherParId;
import dev.ihm.options.OptionChercherParNom;
import dev.ihm.options.OptionTerminer;
import dev.ihm.options.OptionUpdate;
import dev.service.IPlatService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class Menu {

    private Map<Integer, IOptionMenu> actions = new HashMap<>();
    
    private String menu;
    private Scanner scanner;

    public Menu(Scanner scanner, @Qualifier("platServiceVersion1")IPlatService service) {
        actions.put(1, new OptionListerPlats(service));
        actions.put(2, new OptionAjouterPlat(scanner, service));
        actions.put(3, new OptionChercherParId(scanner, service));
        actions.put(4, new OptionChercherParNom(scanner, service));
        actions.put(5, new OptionUpdate(scanner, service));
        actions.put(6, new OptionSupprimer(scanner, service));
        actions.put(99, new OptionTerminer());
        this.scanner = scanner;
    }

    public void afficher() {

        boolean continuer = true;

        while (continuer) {

            System.out.println(getMenuTexte());

            int choix = this.scanner.nextInt();

            try {
                this.actions.get(choix).executer();
            } catch (PlatException e) {
                continuer = false;
                System.out.println(e.getMessage());
            }
        }
    }

    private String getMenuTexte() {
        if (menu == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("** Restaurant Console App **");
            sb.append("\n");
            this.actions.forEach((index, option) -> {
                sb.append(index + ". " + option.getTitre());
                sb.append("\n");
            });
            this.menu = sb.toString();
        }
        return this.menu;
    }
}
