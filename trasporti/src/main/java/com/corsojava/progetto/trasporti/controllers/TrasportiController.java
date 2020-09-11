package com.corsojava.progetto.trasporti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corsojava.progetto.trasporti.entities.Automezzo;
import com.corsojava.progetto.trasporti.servicies.AutomezzoService;

import java.util.List;

@Controller
public class TrasportiController {
	
	@Autowired
	private AutomezzoService automezzoService;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Automezzo> automezzi = automezzoService.findAll();
		
		model.addAttribute("automezzi", automezzi);
		
		return "index";
	}
	
	@RequestMapping("/termina")
	public String termina(@RequestParam("targa") String targa) {
		Automezzo automezzo = automezzoService.findById(targa);
		
		automezzo.setDestinazione(null);
		
		automezzoService.save(automezzo);
		
		return "redirect:/";
	}

}
