package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.model.Evento;
import it.corso.repository.EventoRepository;

public class HomeSericeImpl implements HomeService{

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> elencoEventi() {
        return (List<Evento>) eventoRepository.findAll();
    }

}
