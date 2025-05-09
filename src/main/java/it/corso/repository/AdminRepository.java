package it.corso.repository;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
