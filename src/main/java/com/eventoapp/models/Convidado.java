package com.eventoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Convidado {

	@Id 
	private Long rg;
	
	private String nomeConvidado;
	
	@ManyToOne
	private Evento evento;
	
	public Long getRg() {
		return rg;
	}
	public void setRg(Long rg) {
		this.rg = rg;
	}
	public String getNomeConvidado() {
		return nomeConvidado;
	}
	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}	
	
}
