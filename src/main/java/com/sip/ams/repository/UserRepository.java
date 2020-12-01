package com.sip.ams.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;

import com.sip.ams.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
User findByEmail(String email);
}
