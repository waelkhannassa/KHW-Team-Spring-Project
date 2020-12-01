package com.sip.ams.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.sip.ams.entities.Book; 
import com.sip.ams.repository.BookRepository;

@Controller
@RequestMapping("/book/")
public class BookController {
	private BookRepository bookrepository;
	public static String uploadDirectory =
			System.getProperty("user.dir")+"/src/main/resources/static/uploads";
	
	@Autowired
	public BookController(BookRepository bookrepository) {
		this.bookrepository = bookrepository;
	}
	
	
	@GetMapping("list")
	@ResponseBody
	public String listbooks(Model model) {
		List<Book> liste = (List<Book>) bookrepository.findAll();
		if (liste.size() == 0)
			liste = null;
		model.addAttribute("books", liste);
		return "koussaywaelhamza";
	}
	
	
	@GetMapping("add")
	@ResponseBody
	public String showaddform(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "kzehfbvzejhf";
	}
	
	
	@PostMapping("add")
	@ResponseBody
	public String addBook(@Valid Book book,BindingResult result) {
		if (result.hasErrors()) {
			return "provider/addProvider";
			}
	bookrepository.save(book);
	
	return "POST";}
	
	
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") int id, Model model) {

		Book book = bookrepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		bookrepository.delete(book);

		return "redirect:../list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showBookFormToUpdate(@PathVariable("id") int id, Model model) {
		Book book = bookrepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		model.addAttribute("book", book);
		return "book/updateBook";
	}
	
	
	
	@PostMapping("update")
	public String updateBook(@Valid Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "book/updateBook";
		}
		

	
		bookrepository.save(book);
		return "redirect:list";
	}
	
}