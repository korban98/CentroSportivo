package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.model.Evento;
import it.corso.repository.EventoRepository;

public class HomeServiceImpl implements HomeService{

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> elencoEventi() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    public Evento datiEvento(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'datiEvento'");
    }

}
