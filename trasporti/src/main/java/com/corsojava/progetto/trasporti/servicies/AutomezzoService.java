package com.corsojava.progetto.trasporti.servicies;

import java.util.List;

import com.corsojava.progetto.trasporti.entities.Automezzo;

public interface AutomezzoService {
	
	public List<Automezzo> findAll();
	public Automezzo findById(String id);
	public boolean exists(String id);
	public Automezzo save(Automezzo automezzo);
	public void delete(Automezzo automezzo);

}
