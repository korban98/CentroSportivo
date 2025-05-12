package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Admin;
import it.corso.service.AdminService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/riservata")
public class RiservataController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String renderPage(HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return "redirect:/loginadmin";
        }
        Admin adminSession = (Admin) session.getAttribute("admin");
        Admin admin = adminService.datiAdmin(adminSession.getId());
        model.addAttribute("admin", admin);
        return "riservata";
    }

    @GetMapping("/logout")
    public String logoutCliente(HttpSession session) {
        session.removeAttribute("cliente");
        return "redirect:/";
    }
    
}
