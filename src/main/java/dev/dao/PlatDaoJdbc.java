package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;


public class PlatDaoJdbc implements IPlatDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public PlatDaoJdbc(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public List<Plat> listerPlats() {
		String sql ="SELECT * FROM PLAT";
		return this.jdbcTemplate.query(sql, new PlatMapper());
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		String sql = "INSERT INTO PLAT(NOM, PRIX) VALUES(?,?)";
		this.jdbcTemplate.update(sql, nomPlat, prixPlat);
		
	}

}
