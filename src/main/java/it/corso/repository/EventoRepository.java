package it.corso.repository;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, Integer> {

}
