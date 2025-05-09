package it.corso.service;

import java.util.List;

import it.corso.model.Evento;

public interface EventoService {

    List<Evento> elencoEventi();
    Evento datiEvento(Integer id);
    
}
