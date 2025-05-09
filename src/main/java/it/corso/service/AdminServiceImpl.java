package it.corso.service;

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

}
