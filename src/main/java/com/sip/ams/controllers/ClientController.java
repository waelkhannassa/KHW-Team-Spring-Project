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

import com.sip.ams.entities.client;
import com.sip.ams.repositories.ClientRepository;

@Controller
@RequestMapping("/client/")
public class ClientController {
	private ClientRepository clientrepository;
	public static String uploadDirectory =
			System.getProperty("user.dir")+"/src/main/resources/static/uploads";
	@Autowired
	public ClientController(ClientRepository clientrepository) {
		this.clientrepository = clientrepository;
	}

	@GetMapping("list")
	public String listclients(Model model) {
		List<client> liste = (List<client>) clientrepository.findAll();
		if (liste.size() == 0)
			liste = null;
		model.addAttribute("clients", liste);
		return "client/listClient";
	}

	@GetMapping("add")
	public String showaddform(Model model) {
		client client = new client();
		model.addAttribute("client", client);
		return "client/addclient";
	}
	@GetMapping("show/{id}")
	public String ShowclientDetails(@PathVariable("id")int id,Model m) {
		client b = clientrepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("invalid client id"+id));
		m.addAttribute("client", b);
		return"client/showclient";
	}

	@PostMapping("add")
	public String addclient(@Valid client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client/addclient";
		}
		
		clientrepository.save(client);
		return "redirect:list";

	

	}

	@GetMapping("delete/{id}")
	public String deleteclient(@PathVariable("id") int id, Model model) {

		client client = clientrepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
		clientrepository.delete(client);

		return "redirect:../list";
	}

	@GetMapping("edit/{id}")
	public String showclientFormToUpdate(@PathVariable("id") int id, Model model) {
		client client = clientrepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
		model.addAttribute("client", client);
		return "client/updateclient";
	}

	@PostMapping("update")
	public String updateclient(@Valid client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "client/updateclient";
		}
			
		clientrepository.save(client);
		return "redirect:list";
	}
}
