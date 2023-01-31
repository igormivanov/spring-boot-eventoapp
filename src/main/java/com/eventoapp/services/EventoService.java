package com.eventoapp.services;

import com.eventoapp.models.Evento;

import jakarta.validation.Valid;

public interface EventoService {

	Iterable<Evento> findAll();

	void save(@Valid Evento evento);

	Evento findByCodigo(long codigo);

	void delete(Evento evento);

}
