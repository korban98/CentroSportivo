package it.corso.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Evento;

public interface EventoService {

    List<Evento> elencoEventi();
    Evento datiEvento(Integer id);
    void salvaEvento(Evento evento, MultipartFile foto);
    void eliminaEvento(Integer id);
    
}
