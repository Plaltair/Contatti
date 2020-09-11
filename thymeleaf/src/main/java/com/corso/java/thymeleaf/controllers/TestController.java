package com.corso.java.thymeleaf.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.corso.java.thymeleaf.entities.Persona;
import com.corso.java.thymeleaf.service.PersonaService;

@Controller
public class TestController {
	
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping("/start")
	public String start() {
		return "start";
	}
	
	@RequestMapping("/contatti")
	public String conferma(Model model) {
		List<Persona> persone = personaService.findAllByOrderByCognomeAsc();
		model.addAttribute("persone", persone);
		return "contatti";
	}
	
	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@RequestMapping(value = "/conferma", method = RequestMethod.POST)
	public String conferma(@Valid @ModelAttribute Persona persona, BindingResult br) {
		if (br.hasErrors()) {
			return "form";
		}
		else {
			personaService.save(persona);
			return "redirect:/contatti";
		}
	}
	
	@RequestMapping("/form_change")
	public String formChange(@ModelAttribute Persona p, Model model) {
		model.addAttribute("persona", p);
		return "form_change";
	}
	
	@RequestMapping(value = "/conferma_change", method = RequestMethod.POST)
	public String confermaChange(@Valid @ModelAttribute Persona persona, BindingResult br) {
		if (br.hasErrors()) {
			return "form_change";
		}
		else {
			personaService.save(persona);
			return "redirect:/contatti";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute Persona p, Model model) {
		personaService.delete(p);
		return "redirect:/contatti";
	}
	
	@InitBinder
    public void initBinder (WebDataBinder binder) {
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }
}
