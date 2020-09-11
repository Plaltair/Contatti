package com.corso.java.thymeleaf.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 3, message = "Minimo 3 caratteri")
	@NotNull(message = "Obbligatorio")
	private String nome;
	@Size(min = 3, message = "Minimo 3 caratteri")
	@NotNull(message = "Obbligatorio")
	private String cognome;
	@Size(min = 3, message = "Minimo 3 caratteri")
	@NotNull(message = "Obbligatorio")
	private String telefono;
	@Size(min = 3, message = "Minimo 3 caratteri")
	@NotNull(message = "Obbligatorio")
	private String email;
	@Size(min = 3, message = "Minimo 3 caratteri")
	@NotNull(message = "Obbligatorio")
	private String indirizzo;
	
	public Persona() {
		
	}
	
	public Persona(String nome, String cognome, String telefono, String email, String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.indirizzo = indirizzo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}
