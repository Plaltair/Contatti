package com.corsojava.progetto.trasporti.servicies;

import java.util.List;

import com.corsojava.progetto.trasporti.entities.Destinazione;

public interface DestinazioneService {
	
	public List<Destinazione> findAll();
	public Destinazione findById(int id);
	public boolean exists (int id);
	public Destinazione save(Destinazione destinazione);
	public void delete(Destinazione destinazione);

}
