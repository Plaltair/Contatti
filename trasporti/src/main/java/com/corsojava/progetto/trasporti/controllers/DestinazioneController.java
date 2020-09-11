package com.corsojava.progetto.trasporti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corsojava.progetto.trasporti.entities.Destinazione;
import com.corsojava.progetto.trasporti.servicies.DestinazioneService;

@Controller
public class DestinazioneController {
	
	@Autowired
	private DestinazioneService destinazioneService;
	
	@RequestMapping("/destinazioni")
	public String destinazioni(Model model) {
		model.addAttribute("destinazioni", destinazioneService.findAll());
		return "destinazioni";
	}
	
	@RequestMapping("/aggiungi_destinazione")
	public String aggiungiDestinazione() {
		return "aggiungi_destinazione";
	}
	
	@RequestMapping("/aggiungi_destinazione_check")
	public String aggiungiDestinazioneCheck(@RequestParam("citta") String citta, @RequestParam("distanza") int distanza) {
		Destinazione destinazione = new Destinazione();
		destinazione.setCitta(citta);
		destinazione.setDistanza(distanza);
		destinazioneService.save(destinazione);
		return "redirect:/destinazioni";
	}
	
	@RequestMapping("/elimina_destinazione")
	public String eliminaDestinazione(@RequestParam("id") int id, @RequestParam("citta") String citta, @RequestParam("distanza") int distanza) {
		Destinazione destinazione = destinazioneService.findById(id);
		destinazioneService.delete(destinazione);
		return "redirect:/destinazioni";
	}

}
