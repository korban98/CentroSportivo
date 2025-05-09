package it.corso.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.model.Evento;
import it.corso.repository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> elencoEventi() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    public Evento datiEvento(Integer id) {
        Optional<Evento> libroOptional = eventoRepository.findById(id);
        if(libroOptional.isPresent()) {
            return libroOptional.get();
        }
        return null;
    }

}
