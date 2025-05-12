package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Evento;
import it.corso.service.EventoService;


//localhost:8080/
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private EventoService eventoService;
    
    @GetMapping
    public String renderPagina(Model model){
        List<Evento> eventi = eventoService.elencoEventiFuturi();
        model.addAttribute("eventi", eventi);
        return "home";
    }
    
}