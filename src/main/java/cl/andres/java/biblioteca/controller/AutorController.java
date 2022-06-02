package cl.andres.java.biblioteca.controller;

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

import cl.andres.java.biblioteca.model.Autor;
import cl.andres.java.biblioteca.repository.AutorRepository;
@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;
	
	@GetMapping("/nuevoautor")
	public String nuevolibro(Autor autor, Model modelo) {
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autores",autores);
		return "admin/nuevoautor";
	}
	
	@PostMapping("/procesarautor")
	public String procesarAutor(@Valid Autor autor, BindingResult validacion, Model modelo) {
		if(validacion.hasErrors()) { 
			List<Autor> autores = autorRepository.findAll();
			modelo.addAttribute("autores",autores);
			return "admin/nuevoautor";
		}
		autorRepository.create(autor);
		return "redirect:/autor/nuevoautor";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable (name="id") Long id) {
		autorRepository.delete(id);
		return "redirect:/autor/nuevoautor";
	}
	
}
