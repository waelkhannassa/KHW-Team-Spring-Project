package com.sip.ams.controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sip.ams.entities.Book;
import com.sip.ams.exception.ResourceNotFoundException;
import com.sip.ams.repository.BookRepository;

@RestController
@RequestMapping({"/books"})
public class BookRestController {
	@Autowired
	private BookRepository bookRepository;
	@GetMapping("/list")
	 public List<Book> getAllBook() {
	 return (List<Book>) bookRepository.findAll();
	 }
	@PostMapping("/add")
	 public Book createBook(@Valid @RequestBody Book book) {
	 return bookRepository.save(book);
	 }
	@PutMapping("/{bookId}")
	 public Book updateBook(@PathVariable Long bookId, @Valid
	@RequestBody Book bookRequest) {
	 return bookRepository.findById(bookId).map(book -> {
	 book.setTitle(bookrRequest.getTitle());
	 book.setPrice(bookRequest.getPrice());
	 book.setAddress(providerRequest.getAddress());
	 return providerRepository.save(provider);
	 }).orElseThrow(() -> new ResourceNotFoundException("ProviderId " +
	providerId + " not found"));
	 }
	 @DeleteMapping("/{providerId}")
	 public ResponseEntity<?> deleteProvider(@PathVariable Long providerId) {
	 return providerRepository.findById(providerId).map(provider -> {
	 providerRepository.delete(provider);
	 return ResponseEntity.ok().build();
	 }).orElseThrow(() -> new ResourceNotFoundException("ProviderId " +
	providerId + " not found"));
	 }
	}

}
