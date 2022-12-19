//ESSAS CLASSE TEM COMO OBJETIVO SALVAR/PEGAR DADOS/FORMULARIO NO BANCO DE DADOS
package com.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;
import com.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.repository.EventoRepository;

import jakarta.validation.Valid;

@Controller
public class EventoController {
    
    //criar um aotwired pro evento repository
    @Autowired
    private EventoRepository er;
    
    @Autowired
    private ConvidadoRepository cr;
    
    @RequestMapping(value="/cadastrarEvento",method=RequestMethod.GET)//metodo para retornar o formulario
    public String form() {
        return "evento/formEvento";
    }
    
    @RequestMapping(value="/cadastrarEvento",method=RequestMethod.POST)//metodo para salvar o formulario -- vai mandar a requisição pro banco de dados
    public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
    	if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarEvento";
        }
        er.save(evento);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso");
        return "redirect:/cadastrarEvento";
    }
    
    //metodo para retornar a lista de evento através da busca do banco de dados
    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {
        ModelAndView mv = new ModelAndView("index");//mostra a pagina que será renderizada
        Iterable<Evento> eventos = er.findAll();//fazer busca no banco de dados
        mv.addObject("eventos", eventos);//colocar o evento que foi buscado na view que sera renderizada
        return mv;
    }
    
    //metodo para quando clicar no nome do evento, ser redirecionado para outra pagina onde mostrará detalhes do evento
    @RequestMapping(value="/{codigo}",method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo")long codigo) {
        Evento evento = er.findByCodigo(codigo);//metodo que foi feito na classe EventoRepository para encontrar o codigo no banco de dados e guardar na variavel "evento"
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");//criação de uma nova pagina para ser redirecionado
        mv.addObject("evento", evento);
        
        Iterable<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);
        return mv;
        
    }
    
    //metodo para quando clicar em adicionar convidado, receber a requisição via post e depois salvar no banco de dados.
    @RequestMapping(value="/{codigo}",method=RequestMethod.POST)
    public String detalhesEventoPost(@PathVariable("codigo")long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
        //antes de salvar no banco o @validated vai fazer a verificação pra ver se tem algum erro
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/{codigo}";
        }
        //o convidado deve estar relacionado com o codigo do evento
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento);
        cr.save(convidado);
        attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
        return "redirect:/{codigo}";
    }

}
