package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/loginadmin")
public class LoginAdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String renderPagina(){
        return "loginadmin";
    }

    @PostMapping
    public String postMethodName(@RequestParam String username, @RequestParam String password, HttpSession session) {
        String esitoControllo = adminService.controlloLogin(username, password, session);
        if(esitoControllo.equals("Credenziali Errate")) {
            return "redirect:/loginadmin?errore=" + esitoControllo;
        }
        return "redirect:/riservata";
    }

}
