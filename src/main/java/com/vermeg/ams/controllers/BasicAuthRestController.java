package com.vermeg.ams.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.ams.entities.AuthenticationBean;

@CrossOrigin(origins = "*")
@RestController
public class BasicAuthRestController {
	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}
}