package com.sip.ams.controllers;
import java.time.LocalDate;
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
import com.sip.ams.entities.Book;

import com.sip.ams.entities.Commande;
import com.sip.ams.repository.Commanderepository;

import com.sip.ams.repository.BookRepository;

public class CommandeController {


	private Commanderepository commandeRepository;

	private BookRepository bookrepository;

	
	@Autowired
	public CommandeController(Commanderepository commandeRepository,BookRepository bookrepository) {
		this.commandeRepository = commandeRepository;
		
		this.bookrepository = bookrepository;
	}
	
	
	@GetMapping("list")
	@ResponseBody
	public String listorders(Model model) 
	{
		List<Commande> com = (List<Commande>) commandeRepository.findAll();
		if (com.size() == 0)
			com = null;
		model.addAttribute("commande", com);
		return "aka";
		
		
	}
	
	

	

}
