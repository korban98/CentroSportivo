package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String renderPagina(HttpSession session){
        
        if(session.getAttribute("admin") == null) return "loginadmin";
        
        return "redirect:/riservata";
    }
    
    @PostMapping
    public String postMethodName(@RequestParam String username, @RequestParam String password, HttpSession session) {
        String esitoControllo = adminService.controlloLogin(username, password, session);
        if(esitoControllo.equals("Credenziali Errate")) {
            return "redirect:/loginadmin?errore=" + esitoControllo;
        }
        session.setAttribute("admin", adminService.datiAdmin(username));
        return "redirect:/riservata";
    }

}
