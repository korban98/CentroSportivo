package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//localhost:8080/
@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public String renderPagina(){
        return "home";
    }
}
