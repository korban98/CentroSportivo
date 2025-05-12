package it.corso.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.model.Admin;
import it.corso.repository.AdminRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService{


    @Autowired
    private AdminRepository adminRepository;


    @Override
    public String controlloLogin(String username, String password, HttpSession session) {
        Admin admin = adminRepository.findByUsername(username);

        if(admin == null || !admin.getPsw().equals(password)){
            return "Credenziali Errate";
        }
        session.setAttribute("admin", admin);
        return "Login Autorizzato";

    }

    @Override
    public Admin datiAdmin(Integer id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public Admin datiAdmin(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public String validazioneCampi(String username) {
        if(!username.matches("[a-zA-Z0-9._-]{1,50}")) {
            return "Caratteri non ammessi in Username";
        }
        
        return null;
    }

}
