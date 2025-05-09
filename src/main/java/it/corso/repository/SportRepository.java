package it.corso.repository;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Sport;

public interface SportRepository extends CrudRepository<Sport, Integer>{

}
