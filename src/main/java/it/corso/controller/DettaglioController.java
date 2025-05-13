package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.model.Evento;
import it.corso.service.EventoService;


@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public String renderPage(@RequestParam(defaultValue = "0") Integer id, Model model) {
        Evento evento = eventoService.datiEvento(id);

        if(evento == null) return "redirect:/home";

        model.addAttribute("evento", evento);
        
        return "dettaglio";
    }

}
