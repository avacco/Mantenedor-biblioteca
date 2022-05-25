package cl.andres.java.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SitioController {

	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
}
