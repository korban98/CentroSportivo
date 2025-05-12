package it.corso.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, Integer> {

    List<Evento> findByRicezioneAfter(LocalDateTime now);

}
