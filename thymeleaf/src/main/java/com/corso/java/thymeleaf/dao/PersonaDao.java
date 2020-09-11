package com.corso.java.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.corso.java.thymeleaf.entities.Persona;

@RepositoryRestResource(path = "persone")
public interface PersonaDao extends JpaRepository<Persona, Integer> {
	public List<Persona> findAllByOrderByCognomeAsc();
}
