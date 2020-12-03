package com.sip.ams.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Commande;

@Repository



public interface CommandeRepository  extends CrudRepository<Commande,Integer> {

}
