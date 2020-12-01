package com.sip.ams.repository;

import org.springframework.data.repository.CrudRepository;

import com.sip.ams.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {

}