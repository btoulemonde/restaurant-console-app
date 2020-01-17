package dev.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;
import dev.repository.PlatRepository;

@Repository
public class PlatDaoDataJpa implements IPlatDao {
	
	@Autowired 
	PlatRepository pRepo;
	

	@Override
	public List<Plat> listerPlats() {
		return pRepo.findAll();
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		pRepo.save(new Plat(nomPlat, prixPlat));

	}

	@Override
	public Plat rechercherParId(int id) {
		return pRepo.findById(id);
	}

	@Override
	public Plat rechercherParNom(String nom) {
		return pRepo.findByNom(nom);
	}
	
	

	
	
	

}
