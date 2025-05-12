package it.corso.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.AdminService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/loginadmin")
public class LoginAdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String renderPagina(@RequestParam(required = false) String esito, Model model, HttpSession session){
        
        if(session.getAttribute("admin") != null) return "redirect:/riservata";

        model.addAttribute("esito", esito);
        
        return "loginadmin";
    }

    @PostMapping
    public String postMethodName(@RequestParam String username, @RequestParam String password, HttpSession session) {
        String esitoValidazione = adminService.validazioneCampi(username);
        if(esitoValidazione != null) {
            return "redirect:/loginadmin";
        }
        String esitoControllo = adminService.controlloLogin(username, password, session);
        if(esitoControllo.equals("Credenziali Errate")) {
            return "redirect:/loginadmin?esito=" + esitoControllo;
        }
        session.setAttribute("admin", adminService.datiAdmin(username));
        return "redirect:/riservata";
    }

}
