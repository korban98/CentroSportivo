package it.corso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.model.Indirizzo;
import it.corso.repository.IndirizzoRepository;

@Service
public class IndirizzoServiceImpl implements IndirizzoService{


    @Autowired
    private IndirizzoRepository indirizzoRepository;


    @Override
    public Indirizzo getIndirizzo(Integer id) {
        return indirizzoRepository.findById(id).get();
    }

}
