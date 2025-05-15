package it.corso.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Evento;
import it.corso.repository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> elencoEventi() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    public List<Evento> elencoEventiFuturi() {
        LocalDateTime now = LocalDateTime.now();
        return (List<Evento>) eventoRepository.findByRicezioneAfter(now);
    }

    @Override
    public Evento datiEvento(Integer id) {
        Optional<Evento> libroOptional = eventoRepository.findById(id);
        if (libroOptional.isPresent()) {
            return libroOptional.get();
        }
        return null;
    }

    @Override
    public void salvaEvento(Evento evento, MultipartFile foto) {

        if (foto != null && !foto.isEmpty()) {
            
            try {
                String formato = foto.getContentType();
                String copertinaCodificata = "data:" + formato + ";base64,"
                        + Base64.getEncoder().encodeToString(foto.getBytes());
                evento.setFoto(copertinaCodificata);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        eventoRepository.save(evento);
    }

    @Override
    public void eliminaEvento(Integer id) {
        eventoRepository.deleteById(id);
    }

    @Override
    public Map<String, String> validazioneCampi(String nome, String descrizione, Double costo, String campo, Integer nPartecipanti) {
        Map<String, String> errori = new HashMap<>();
        if(!nome.matches("[a-zA-Z0-9\\s-]{1,50}")) {
            errori.put("nome", "Caratteri non ammessi in nome");
        }
        if(!descrizione.matches("[a-zA-Z0-9'\",.;:\\ssàèìòùáéíóú!?-]{1,255}")) {
            errori.put("descrizione", "Caratteri non ammessi in descrizione");
        }
        if(!campo.matches("[a-zA-Z0-9\\s-]{1,10}")) {
            errori.put("campo", "Caratteri non ammessi in campo");
        }
        if(costo <= 0) {
            errori.put("costo", "Il costo deve essere positivo");
        }
        if(nPartecipanti <= 0) {
            errori.put("partecipanti", "I partecipanti devono essere almeno uno");
        }

        if(!errori.isEmpty()) {
            return errori;
        }
        
        return null;
    }

}
