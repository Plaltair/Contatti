package com.corso.java.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.corso.java.thymeleaf.dao.PersonaDao;
import com.corso.java.thymeleaf.entities.Persona;

@Service
public class PersonaServiceImplement implements PersonaService {
	
	@Autowired
	private PersonaDao personaDao;

	@Override
	@Transactional
	public List<Persona> findAll() {
		return personaDao.findAll();
	}
	
	@Override
	public List<Persona> findAllByOrderByCognomeAsc() {
		return personaDao.findAllByOrderByCognomeAsc();
	}
	
	@Override
	@Transactional
	public void save(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	@Transactional
	public void delete(Persona persona) {
		personaDao.delete(persona);
	}

}
