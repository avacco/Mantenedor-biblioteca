package cl.andres.java.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.andres.java.biblioteca.model.Usuario;
import cl.andres.java.biblioteca.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/generaradmin")
	// genera una cuenta de administrador generico
	public String generarAdmin() {
		if(usuarioService.checkForAdmin() == null) {
			
			Usuario usuario = Usuario.builder()
										.email("admin@admin.cl")
										.password("123")
										.roles("ADMIN")
										.build();
			usuarioService.crearUsuario(usuario);
		}
		return "redirect:/";
	}
	
	@GetMapping("/index")
	public String index() {
		return "admin/index";
	}
}
