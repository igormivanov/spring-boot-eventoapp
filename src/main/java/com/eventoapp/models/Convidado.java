package com.eventoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity //anotação pra dizer que vai ser uma tabela no banco de dados
public class Convidado {
    
    @Id // o RG vai ser ID e chave primaria da tabela
    @NotEmpty
    private String rg;
    @NotEmpty
    private String nomeConvidado;
    
    
    @ManyToOne  //cada evento vai ter uma lista de convidado, para isso é necessãrio criar uma relação entre as entidades convidados e eventos
                //exemplo: muitos convidados para 1 evento
    private Evento evento;
    
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
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
