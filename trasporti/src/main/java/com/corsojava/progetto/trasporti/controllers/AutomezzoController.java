package com.corsojava.progetto.trasporti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.corsojava.progetto.trasporti.entities.Automezzo;
import com.corsojava.progetto.trasporti.entities.Destinazione;
import com.corsojava.progetto.trasporti.servicies.AutomezzoService;
import com.corsojava.progetto.trasporti.servicies.DestinazioneService;

@Controller
public class AutomezzoController {
	
	@Autowired
	private AutomezzoService automezzoService;
	
	@Autowired 
	private DestinazioneService destinazioneService;
	
	@RequestMapping("/automezzi")
	public String automezzi(Model model) {
		model.addAttribute("automezzi", automezzoService.findAll());
		return "automezzi";
	}
	
	@RequestMapping("/aggiungi_automezzo")
	public String aggiungiAutomezzo(Model model) {
		model.addAttribute("destinazioni", destinazioneService.findAll());
		return "aggiungi_automezzo";
	}
	
	@RequestMapping("/aggiungi_automezzo_check")
	public String aggiungiAutomezzoCheck(@RequestParam("targa") String targa, RedirectAttributes redirectAttributes) {
		if (!automezzoService.exists(targa)) {
			redirectAttributes.addFlashAttribute("alreadyExists", false);
			Automezzo automezzo = new Automezzo();
			automezzo.setTarga(targa);
			automezzoService.save(automezzo);
		}
		else {
			redirectAttributes.addFlashAttribute("alreadyExists", true);
		}
		return "redirect:/automezzi";
	}
	
	@RequestMapping("/elimina_automezzo")
	public String eliminaAutomezzo(@RequestParam("targa") String targa) {
		Automezzo automezzo = automezzoService.findById(targa);
		if (automezzo.getDestinazione() != null) {
			automezzo.getDestinazione().setAutomezzo(null);
		}
		automezzoService.delete(automezzo);
		return "redirect:/automezzi";
	}
	
	@RequestMapping("/modifica")
	public String modifica(@RequestParam("targa") String targa, Model model) {
		Automezzo automezzo = automezzoService.findById(targa);
		
		model.addAttribute("automezzo", automezzo);
		model.addAttribute("destinazioni", destinazioneService.findAll());
		
		return "modifica";
	}
	
	@RequestMapping("/modifica_check")
	public String modifica(@RequestParam("targa") String targa, @RequestParam("destinazione") int destinazione, Model model) {
		Automezzo automezzo = automezzoService.findById(targa);
		Destinazione dest = destinazioneService.findById(destinazione);
		automezzo.setDestinazione(dest);
		automezzoService.save(automezzo);
		
		return "redirect:/";
	}

}
