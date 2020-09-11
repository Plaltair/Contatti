package com.corso.java.thymeleaf.service;

import java.util.List;
import com.corso.java.thymeleaf.entities.Persona;

public interface PersonaService {
	
	public List<Persona> findAll();
	
	public List<Persona> findAllByOrderByCognomeAsc();
	
	public void save(Persona persona);
	
	public void delete(Persona persona);
}
