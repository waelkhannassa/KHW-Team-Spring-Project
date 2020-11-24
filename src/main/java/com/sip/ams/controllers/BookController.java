package com.sip.ams.controllers;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;


import com.sip.ams.entities.Book;

import com.sip.ams.repositories.BookRepository;


@Controller
@RequestMapping("/book/")
public class BookController {
	public static String uploadDirectory =
			System.getProperty("user.dir")+"/src/main/resources/static/uploads";
	
	private final BookRepository BookRepository;
	 @Autowired
	 public BookController(BookRepository BookRepository) {
	 this.BookRepository = BookRepository;

	 }

	 @GetMapping("list")
	 public String listBooks(Model model) {
	 model.addAttribute("books", BookRepository.findAll());
	 return "Book/listBooks";
	 }
	 
	 @GetMapping("add")
	 public String showAddBooksForm(Book book) {
	 return "Book/addBook";
	 }

	 @PostMapping("add")
	 public String addBook(@Valid Book book, BindingResult result, Model
	model, @RequestParam("files") MultipartFile[] files) {
	 if (result.hasErrors()) {
	 return "Book/addBook";
	 }
	 StringBuilder fileName = new StringBuilder();
	 MultipartFile file = files[0];
	 Path fileNameAndPath = Paths.get(uploadDirectory,
	file.getOriginalFilename());

	 fileName.append(file.getOriginalFilename());
	 try {
	Files.write(fileNameAndPath, file.getBytes());
	} catch (IOException e) {
	e.printStackTrace();
	}

	book.setPicture(fileName.toString());
	 BookRepository.save(book);
	 return "redirect:list";
	 }
	 
	 
	 
	 @GetMapping("delete/{id}")
	 public String deleteBook(@PathVariable("id") long id, Model model) {
	 Book book = BookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid book Id:" +
	id));
	 BookRepository.delete(book);
	 model.addAttribute("Books", BookRepository.findAll());
	 return "redirect:../list";
	 }
	 
	 @GetMapping("edit/{id}")
	 public String showBookFormToUpdate(@PathVariable("id") long id, Model
	model) {
	 Book book = BookRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid book Id:" + id));
	 model.addAttribute("book", book);
	 return "Book/updateBook";
	 }
	 
	 @PostMapping("update")
	 public String updateBook(@Valid Book book, BindingResult result, Model
	 model) {
	 if (result.hasErrors()) {
	 return "book/updateBook";
	 }
	 BookRepository.save(book);
	 return "redirect:list";
	 }

	 @GetMapping("show/{id}")
	 public String showBookDetails(@PathVariable("id") long id, Model model)
	{
	 Book book = BookRepository.findById(id)
	 .orElseThrow(()->new IllegalArgumentException("Invalid book Id:" + id));

	 model.addAttribute("book", book);

	 return "book/showBook";
	 }
	
}