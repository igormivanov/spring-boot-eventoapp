package com.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.models.Evento;

//interface vai ser precisa apenas instanciar e utilizar metodos ja prontos(salvar,deletar, update no banco-CRUD)
public interface EventoRepository extends CrudRepository<Evento, String> {
    
    //metodo para fazer a busca no banco de dados através do codigo do evento(esse método será usadp no EventoController)
    Evento findByCodigo(Long codigo);

}
