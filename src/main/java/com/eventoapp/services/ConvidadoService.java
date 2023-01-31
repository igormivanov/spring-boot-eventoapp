package com.eventoapp.services;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;

import jakarta.validation.Valid;

public interface ConvidadoService {

	Iterable<Convidado> findByEvento(Evento evento);

	void save(@Valid Convidado convidado);

	Convidado findByRg(String rg);

	void delete(Convidado convidado);

}
