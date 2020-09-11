package com.corsojava.progetto.trasporti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.corsojava.progetto.trasporti.entities.Automezzo;

@RepositoryRestResource(path = "automezzo")
public interface AutomezzoDao extends JpaRepository<Automezzo, String> {

}
