package dev.dao;

import dev.entite.Plat;
import dev.exception.PlatException;

import java.util.List;

public interface IPlatDao {
    List<Plat> listerPlats();
    void ajouterPlat(String nomPlat, Integer prixPlat);
    default Plat rechercherParId(int id){
    	throw new PlatException("Fonction non implémentée");
    }
    default Plat rechercherParNom(String nom){
    	throw new PlatException("Fonction non implémentée");
    }
}
