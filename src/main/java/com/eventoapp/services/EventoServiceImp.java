package com.eventoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

import jakarta.validation.Valid;

@Service
public class EventoServiceImp implements EventoService{

	@Autowired
	private EventoRepository eventoRepository;
	
	@Override
	public Iterable<Evento> findAll() {
		return eventoRepository.findAll();
	}

	@Override
	public void save(@Valid Evento evento) {
		eventoRepository.save(evento);
	}

	@Override
	public Evento findByCodigo(long codigo) {
		return eventoRepository.findByCodigo(codigo);
	}

	@Override
	public void delete(Evento evento) {
		eventoRepository.delete(evento);
	}
	
}
