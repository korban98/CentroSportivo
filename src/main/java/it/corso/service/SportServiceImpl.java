package it.corso.service;

import java.util.List;

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



    @Override
    public List<Sport> elencoSport() {
        return (List<Sport>) sportRepository.findAll();
    }



    @Override
    public Sport trovaSportById(Integer id) {
        return sportRepository.findById(id).get();
    }

}
