package com.sip.ams.repositories;

import org.springframework.data.repository.CrudRepository; 

import com.sip.ams.entities.Commande;

public interface CommandeRepository extends CrudRepository<Commande,Integer> {

}
