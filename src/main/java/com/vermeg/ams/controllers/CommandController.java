package com.vermeg.ams.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.vermeg.ams.entities.Book;
import com.vermeg.ams.entities.Command;
import com.vermeg.ams.entities.LigneCommand;
import com.vermeg.ams.entities.User;
import com.vermeg.ams.repositories.BookRepository;
import com.vermeg.ams.repositories.CommandRepository;
import com.vermeg.ams.repositories.LigneCommandRepository;
import com.vermeg.ams.repositories.UserRepository;
import com.vermeg.ams.controllers.CommandController;

@Controller
@RequestMapping("/command/")
public class CommandController {

	private final CommandRepository commandRepository;
	private static BookRepository bookRepository;
	private final LigneCommandRepository lignecommandRepository;
	private final UserRepository userRepository;
	public static long id_user ;

	
	
	@Autowired
	public CommandController(CommandRepository commandRepository, BookRepository bookRepository,
			LigneCommandRepository lignecommandRepository,UserRepository userRepository) {
		this.commandRepository = commandRepository;
		this.bookRepository = bookRepository;
		this.lignecommandRepository = lignecommandRepository;
		this.userRepository = userRepository;
	}
/*
	public static double calculateTotalPrice() {
		Double totalPrice = 0.0;
		List<Book> lb = (List<Book>) bookRepository.findAll();
		for (Book b : lb) {
			if (b.getCart() == true) {
				totalPrice += b.getPrice();
			}
		}

		return totalPrice;
	}
*/
	
	
	/*@GetMapping("addToCart/{id}")
	public String addToCart(@PathVariable("id") long id, Model model) {

		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid command Id:" + id));
	
		bookRepository.save(book);
		//model.addAttribute("Totalprice", calculateTotalPrice());

		return "redirect:../add";
	}*/

	@GetMapping("list")
	// @ResponseBody
	public String listCommand(Model model,@RequestParam("email") String em) {
	
			LigneCommandController.email = em ;
		User user = userRepository.findByEmail(em);
		id_user = user.getId();
		System.out.println(id_user);
		List<Command> lp = (List<Command>) commandRepository.findAll();
		List<Command> lp2 = (List<Command>) commandRepository.findCommandByIdUser(id_user);

		if (lp.size() == 0)
			lp = null;

		model.addAttribute("commands", lp);
		model.addAttribute("commandsUser", lp2);
		return "Command/listCommands";
	}

	@GetMapping("listBooks")
	//@ResponseBody
	public String listBookForCommand(Model model) {
		
		List<Book> lp = (List<Book>) bookRepository.findAll();

		if (lp.size() == 0)
			lp = null;

		model.addAttribute("books", lp);
		return "Command/showBooks";
	}

/*	
	@GetMapping("listByUser")
	// @ResponseBody
	public String listCommandById(Model model) {
		List<Command> lp = (List<Command>) commandRepository.findCommandByIdUser(id_user);

		if (lp.size() == 0)
			lp = null;

		model.addAttribute("commandsUser", lp);
		return "Command/listCommands";
	}*/
	
	@GetMapping("show/{id}")
	public String showDetailsCommand(@PathVariable("id") long id, Model model) {
		List<Book> b = new ArrayList<>();
		Map<Book, Integer> p = new HashMap<Book, Integer>();
		
		List<LigneCommand> lc = lignecommandRepository.findLigneCommandByCommand(id);
		
		for(LigneCommand l : lc) {
			p.put(l.getBook(),l.getQuantity());
		}

		
		model.addAttribute("books", p);
		
		return "Command/showDetails";
	}

	@PostMapping("add")
	public String addCommand(BindingResult result, Model model) {
		/*if (result.hasErrors()) {
			return "Command/addCommand";
		}

		Command command = new Command(LocalDate.now(), CommandController.calculateTotalPrice());
		List<Book> lb = (List<Book>) bookRepository.findAll();
		List<Book> lbCart = new ArrayList<>();
		commandRepository.save(command);
		for (Book b : lb) {
			if (b.getCart()) {
				lbCart.add(b);
				b.setCart(false);
				b.setQuantity(b.getQuantity() - 1);
			}
			lignecommand.setBook(b);
			lignecommand.setCommand(command);
			lignecommandRepository.save(lignecommand);
		}*/
		
	//	Command command =new Command(LocalDate.now(), CommandController.calculateTotalPrice());
		return "redirect:../command/list";
	}

	@GetMapping("delete/{id}")
	public String deleteCommand(@PathVariable("id") long id, Model model) {
		Command command = commandRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid command Id:" + id));
		commandRepository.delete(command);
		return "redirect:../list";
	}

	
}
