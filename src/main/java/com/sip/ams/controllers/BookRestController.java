package com.sip.ams.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.sip.ams.entities.Book;
import com.sip.ams.repositories.BookRepository;
import com.sip.ams.exception.ResourceNotFoundException;
@RestController
@RequestMapping({"/books"})
public class BookRestController {

	
	@Autowired
	private BookRepository BookRepository;
	
	@GetMapping("/list")
	 public List<Book> getAllBook() {
	 return (List<Book>) BookRepository.findAll();
}
	
	@PostMapping("/add")
	 public Book createProvider(@Valid @RequestBody Book book) {
	 return BookRepository.save(book);
	 }
	
	@PutMapping("/{bookId}")
	 public Book updateProvider(@PathVariable Long bookId, @Valid
	@RequestBody Book bookRequest) {
	 return BookRepository.findById(bookId).map(book -> {
	 book.setTitle(bookRequest.getTitle());
	 book.setPrice(bookRequest.getPrice());
	 book.setAuthor(bookRequest.getAuthor());
	 book.setReleaseDate(bookRequest.getReleaseDate());
	 return BookRepository.save(book);
	 }).orElseThrow(() -> new ResourceNotFoundException("BookId " + bookId + " not found"));
	 }
	
	@DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable Long bookId) {
		Book book = BookRepository.findById(bookId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + bookId));
		BookRepository.delete(book);
		return book;
       
    }
	
}

	