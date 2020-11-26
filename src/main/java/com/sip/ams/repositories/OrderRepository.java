package com.sip.ams.repositories;


import org.springframework.data.repository.CrudRepository;

import com.sip.ams.entities.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {

}

