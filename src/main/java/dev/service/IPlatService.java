package dev.service;

import dev.entite.Plat;
import dev.exception.PlatException;

import java.util.List;

public interface IPlatService {

    List<Plat> listerPlats();

    void ajouterPlat(String nomPlat, Integer prixPlat);
    
    default Plat afficherPlatId (int id){
    	throw new PlatException("Fonction non implémentée");
    }
    
    default Plat afficherPlatNom (String nom){
    	throw new PlatException("Fonction non implémentée");
    }
}
