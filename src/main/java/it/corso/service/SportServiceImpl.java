package it.corso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.model.Sport;
import it.corso.repository.SportRepository;

@Service
public class SportServiceImpl implements SportService{

    @Autowired
    private SportRepository sportRepository;



    @Override
    public Sport trovaSport(String nome) {
        return sportRepository.findByNome(nome);
    }

}
