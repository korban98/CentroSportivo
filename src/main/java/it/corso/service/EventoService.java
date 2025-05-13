package it.corso.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Evento;

public interface EventoService {

    List<Evento> elencoEventi();
    Evento datiEvento(Integer id);
    List<Evento> elencoEventiFuturi();
    void salvaEvento(Evento evento, MultipartFile foto);
    void eliminaEvento(Integer id);
    Map<String, String> validazioneCampi(String nome, String descrizione, Double costo, String campo, Integer nPartecipanti);
    
}
