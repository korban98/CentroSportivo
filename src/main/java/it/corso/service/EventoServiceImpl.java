package it.corso.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
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

}
