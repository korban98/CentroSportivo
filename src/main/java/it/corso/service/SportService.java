package it.corso.service;

import java.util.List;

import it.corso.model.Sport;

public interface SportService {
    Sport trovaSport(String nome);
    List<Sport> elencoSport();
    Sport trovaSportById(Integer id);
}
