package com.sip.ams.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sip.ams.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
