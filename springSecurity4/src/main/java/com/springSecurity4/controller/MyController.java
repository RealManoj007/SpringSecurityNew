package com.springSecurity4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/home")
	public String home() {
		return "Spring security 1";
	}
	
	@GetMapping("/bye")
	public String bye() {
		return "Bye Spring security 1";
	}
}
