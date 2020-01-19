package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dev.entite.Plat;

public interface PlatRepository extends JpaRepository<Plat, Integer> {


	public Plat findByNom(String NomPlat);

	@Query("update Plat p set p.nom = :nom where p.id = :id")
	@Modifying
	@Transactional
	public void metAJourNom(@Param("nom") String nom, @Param("id") Integer id);

}
