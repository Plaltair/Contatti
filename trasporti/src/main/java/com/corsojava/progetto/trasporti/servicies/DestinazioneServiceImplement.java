package com.corsojava.progetto.trasporti.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.corsojava.progetto.trasporti.dao.AutomezzoDao;
import com.corsojava.progetto.trasporti.dao.DestinazioneDao;
import com.corsojava.progetto.trasporti.entities.Automezzo;
import com.corsojava.progetto.trasporti.entities.Destinazione;

@Service
public class DestinazioneServiceImplement implements DestinazioneService {
	
	@Autowired
	private DestinazioneDao destinazioneDao;
	
	@Autowired
	private AutomezzoDao automezzoDao;

	@Override
	@Transactional
	public List<Destinazione> findAll() {
		return destinazioneDao.findAll();
	}
	
	@Override
	@Transactional
	public Destinazione findById(int id) {
		return destinazioneDao.findById(id).get();
	}
	
	@Override
	@Transactional
	public boolean exists(int id) {
		return destinazioneDao.existsById(id);
	}

	@Override
	@Transactional
	public Destinazione save(Destinazione destinazione) {
		return destinazioneDao.save(destinazione);
	}
	
	@Override
	@Transactional
	public void delete(Destinazione destinazione) {
		Destinazione dest = destinazioneDao.findById(destinazione.getId()).get();
		Automezzo automezzo = automezzoDao.findById(dest.getAutomezzo().getTarga()).get();
		automezzo.setDestinazione(null);
		automezzoDao.save(automezzo);
		destinazioneDao.delete(destinazione);
	}
}
