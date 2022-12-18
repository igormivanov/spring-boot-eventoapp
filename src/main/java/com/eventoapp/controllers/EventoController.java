package com.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired // Essa anotação significa que toda vez que precisarmos utilizar essa interface, será criado uma nova instancia automaticamente
	private EventoRepository eventoRepository;
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET) // Indica o endpoint(URL) que deverá ser acessado na requisição 
	public String form() {
		return "evento/formEvento"; // Indica o local que está o seu html, geralmente ele está nos templates
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST) 
	public String form(Evento evento) {
		
		eventoRepository.save(evento); 
		
		return "redirect:/cadastrarEvento"; 
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index"); // Dentro do () Colocar a url a ser exibida
		Iterable<Evento> eventos = eventoRepository.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
		Evento evento = eventoRepository.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		return mv;
	}
}
