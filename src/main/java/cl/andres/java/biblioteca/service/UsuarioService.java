package cl.andres.java.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.andres.java.biblioteca.model.Usuario;
import cl.andres.java.biblioteca.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// Utiliza el findAll para sacar una lista de usuarios. Si alguno de estos usuarios es ADMIN, lo retorna.
	// El metodo que llama a este necesita que el retorno sea nulo para crear un admin generico.
	public Usuario checkForAdmin() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		for(Usuario usuario : usuarios) {
			if (usuario.getRoles() == "ADMIN") {
				return usuario;
			}
		}
		return null;
	}
	
	public Usuario buscarPorEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
	
	public Usuario crearUsuario(Usuario usuario){
		String passwordCodificado = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(passwordCodificado);
		usuarioRepository.create(usuario);
		return usuario;
	}
}
