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
import com.sip.ams.entities.User;
import com.sip.ams.entities.Commande;
import com.sip.ams.repository.BookRepository;
import com.sip.ams.repository.UserRepository;
import com.sip.ams.repository.CommandeRepository;

@Controller
@RequestMapping("/commande/")
public class CommandeController {

	private CommandeRepository CommandeRepository;
	private UserRepository Userrepository;
	private BookRepository bookrepository;

	@Autowired
	public CommandeController(CommandeRepository CommandeRepository, UserRepository Userrepository,
			BookRepository bookrepository) {
		this.CommandeRepository = CommandeRepository;
		this.Userrepository = Userrepository;
		this.bookrepository = bookrepository;
	}

	@GetMapping("list")
	//@ResponseBody
	public String listCommandes(Model model) {
		List<Commande> com = (List<Commande>) CommandeRepository.findAll();
		if (com.size() == 0)
			com = null;
		model.addAttribute("Commandes", com);
		return "commande/listCommande";
		// System.out.println(com);
		 //return "Nombre de fournisseur = " + com.size();
	}

	@GetMapping("add")
	//@ResponseBody
	public String showAddCommandeForm(Model model) {
		Commande Commande = new Commande();// object dont la valeur des attributs par defaut
		LocalDate lt = LocalDate.now();
		Commande.setCommandeDate(lt);
		model.addAttribute("Commande", Commande);
		List<User> cl = (List<User>) Userrepository.findAll();
		model.addAttribute("clients", cl);
		List<Book> lb = (List<Book>) bookrepository.findAll();
		model.addAttribute("books", lb);
		//return "waa";
		return "commande/addCommande";
		
		
		 
	}

	@PostMapping("add")
	// @ResponseBody
	public String addCommande(@Valid Commande Commande, @RequestParam("checkid") List<Integer> listids,
			@RequestParam("idUser") int idUser) {
		double prices =0.0;
		User User = Userrepository.findById(idUser)
				.orElseThrow(() -> new IllegalArgumentException("invalid User"));
		Commande.setUser(User);

		for (int i = 0; i < listids.size(); i++) {

			Book b = bookrepository.findById(listids.get(i))
					.orElseThrow(() -> new IllegalArgumentException("invalid id "));
			prices+=b.getPrice();

			Commande.addmybooks(b);
		}
		Commande.setPrice(prices);
		CommandeRepository.save(Commande);
		return "redirect:list";
	}
	
	@GetMapping("showdetails/{id}")
	public String showdetails(@PathVariable("id")int id,Model m) {
		
		Commande o = CommandeRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid ID"+id));
		List<Book> mybooks = o.getmybooks();
		System.out.println("------------------------------------------------------------------------");
		System.out.println(mybooks.size()+mybooks.toString());
		System.out.println("**************************************************************************");
		m.addAttribute("mybooks", mybooks);
		return"Commande/details";
	}
	
	
	@GetMapping("delete/{id}")
	public String deleteCommande(@PathVariable("id") int id, Model model) {
		
		Commande Commande = CommandeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Commande Id:" + id));
		
		CommandeRepository.delete(Commande);
		
		return "redirect:../list";
	}

	@GetMapping("edit/{id}")
	public String showCommandeFormToUpdate(@PathVariable("id") int id, Model model) {
		Commande Commande = CommandeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Commande Id:" + id));

		model.addAttribute("Commande", Commande);
		return "Commande/updateCommande";
	}

	@PostMapping("update")
	public String updateCommande(@Valid Commande Commande, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Commande/updateCommande";
		}
		CommandeRepository.save(Commande);
		return "redirect:list";
	}
}
