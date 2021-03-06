package dev.service;

import dev.dao.IPlatDao;
import dev.entite.Plat;
import dev.exception.PlatException;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PlatServiceVersion1 implements IPlatService {

    private IPlatDao dao;

    
    public PlatServiceVersion1(IPlatDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Plat> listerPlats() {
        return dao.listerPlats();
    }
    
    @Override
    public Plat afficherPlatId(int id){
    	return dao.rechercherParId(id);
    }
    

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {

        // règle métier

        if (nomPlat.length() <= 3) {
            throw new PlatException("un plat doit avoir un nom de plus de 3 caractères");
        }

        if (prixPlat <= 500) {
            throw new PlatException("le prix d'un plat doit être supérieur à 5 €");
        }

        // persistance uniquement si les règles métiers sont respectées
        dao.ajouterPlat(nomPlat, prixPlat);
    }

	@Override
	public Plat afficherPlatNom(String nom) {
		
		return dao.rechercherParNom(nom);
	}

	@Override
	public void mettreAjour(String nom, int id) {
		dao.update(nom, id);
	}

	@Override
	public void delet(int id) {
		dao.delete(id);
	}
	
	
	
	
}
