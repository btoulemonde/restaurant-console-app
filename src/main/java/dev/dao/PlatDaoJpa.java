package dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dev.entite.Plat;

//@Repository
public class PlatDaoJpa implements IPlatDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Plat> listerPlats() {
		TypedQuery<Plat> query= em.createQuery("SELECT p From Plat p ", Plat.class);
		List<Plat> listePlats = query.getResultList();
		return listePlats;
	}

	@Override
	@Transactional
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		Plat plat = new Plat(nomPlat, prixPlat);
		em.persist(plat);

	}

}
