package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.sip.ams.entities.client ;
public interface ClientRepository extends JpaRepository<client , Integer> {

}
