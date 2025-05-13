package it.corso.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.corso.model.Admin;
import it.corso.model.Evento;
import it.corso.model.Sport;
import it.corso.service.AdminService;
import it.corso.service.EventoService;
import it.corso.service.IndirizzoService;
import it.corso.service.SportService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/riservata")
public class RiservataController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private IndirizzoService indirizzoService;

    @Autowired
    private SportService sportService;

    @GetMapping
    public String renderPage(HttpSession session, Model model, @RequestParam(required = false) Integer id) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/loginadmin";
        }
        Admin adminSession = (Admin) session.getAttribute("admin");
        Admin admin = adminService.datiAdmin(adminSession.getId());
        if (!model.containsAttribute("evento")) {
            Evento evento = (id == null) ? new Evento() : eventoService.datiEvento(id);
            model.addAttribute("evento", evento);
        }
        model.addAttribute("admin", admin);
        model.addAttribute("eventi", eventoService.elencoEventi());
        model.addAttribute("sportList", sportService.elencoSport());
        return "riservata";
    }

    @GetMapping("/logout")
    public String logoutCliente(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/";
    }

    @PostMapping
    public String salvaEvento(@ModelAttribute Evento evento,@RequestParam(required=false, name="fotoEvento") MultipartFile foto, @RequestParam(required=false) String ricezione, @RequestParam String nome, @RequestParam String descrizione, @RequestParam Double costo, @RequestParam String campo, @RequestParam Integer partecipanti, RedirectAttributes redirectAttributes) {
        evento.setIndirizzo(indirizzoService.getIndirizzo(1));
        Sport sport = sportService.trovaSportById(evento.getSport().getId());
        evento.setSport(sport);

        if(evento.getRicezione() == null){
            LocalDateTime data = LocalDateTime.parse(ricezione);
            evento.setRicezione(data);
        }

        Map<String, String> esitoValidazione = eventoService.validazioneCampi(nome, descrizione, costo, campo, partecipanti);
        if (esitoValidazione != null) {
            redirectAttributes.addFlashAttribute("evento", evento);
            redirectAttributes.addFlashAttribute("errori", esitoValidazione);
            return "redirect:/riservata";
        }

        eventoService.salvaEvento(evento, foto);
        return "redirect:/riservata";
    }

    @GetMapping("/rimuovi")
    public String rimuoviEvento(Integer id) {
        eventoService.eliminaEvento(id);
        return "redirect:/riservata";
    }

}
