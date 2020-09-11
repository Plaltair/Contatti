package com.corsojava.progetto.trasporti.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.corsojava.progetto.trasporti.dao.AutomezzoDao;
import com.corsojava.progetto.trasporti.entities.Automezzo;

@Service
public class AutomezzoServiceImplement implements AutomezzoService {
	
	@Autowired
	private AutomezzoDao automezzoDao;

	@Override
	@Transactional
	public List<Automezzo> findAll() {
		return automezzoDao.findAll();
	}
	
	@Override
	@Transactional
	public Automezzo findById(String id) {
		return automezzoDao.findById(id).get();
	}
	
	@Override
	@Transactional
	public boolean exists(String id) {
		return automezzoDao.existsById(id);
	}

	@Override
	@Transactional
	public Automezzo save(Automezzo automezzo) {
		return automezzoDao.save(automezzo);
	}

	@Override
	@Transactional
	public void delete(Automezzo automezzo) {
		automezzoDao.delete(automezzo);
	}
}
