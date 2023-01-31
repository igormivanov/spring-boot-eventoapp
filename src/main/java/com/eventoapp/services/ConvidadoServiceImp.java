package com.eventoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;
import com.eventoapp.repository.ConvidadoRepository;

import jakarta.validation.Valid;

@Service
public class ConvidadoServiceImp implements ConvidadoService{
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	@Override
	public Iterable<Convidado> findByEvento(Evento evento) {
		return convidadoRepository.findByEvento(evento);
	}

	@Override
	public void save(@Valid Convidado convidado) {
		convidadoRepository.save(convidado);
	}

	@Override
	public Convidado findByRg(String rg) {
		return convidadoRepository.findByRg(rg);
	}

	@Override
	public void delete(Convidado convidado) {
		convidadoRepository.delete(convidado);
	}

}
