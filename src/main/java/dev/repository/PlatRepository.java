package dev.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Plat;

public interface PlatRepository extends JpaRepository<Plat, Integer> {
	
	Plat findById (int ID);
	
	Plat findByNom (String NomPlat);
	
	
	
	

}
