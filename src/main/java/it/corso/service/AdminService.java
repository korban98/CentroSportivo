package it.corso.service;

import it.corso.model.Admin;
import jakarta.servlet.http.HttpSession;

public interface AdminService {

    Admin datiAdmin(Integer id);
    String controlloLogin(String username, String password, HttpSession session);
    Admin datiAdmin(String username);
    String validazioneCampi(String username);

}
