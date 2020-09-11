package com.corsojava.progetto.trasporti.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "automezzo")
public class Automezzo {
	
	@Id
	private String targa;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "arrivo", referencedColumnName = "id")
	private Destinazione arrivo;

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	public void setDestinazione(Destinazione destinazione) {
		this.arrivo = destinazione;
	}

	public Destinazione getDestinazione() {
		return arrivo;
	}
}
