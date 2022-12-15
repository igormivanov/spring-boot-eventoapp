package com.eventoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventoController {

	@RequestMapping("/cadastrarEvento") // Indica o endpoint(URL) que deverá ser acessado na requisição 
	public String form() {
		return "evento/formEvento"; // Indica o local que está o seu html, geralmente ele está nos templates
	}
}
