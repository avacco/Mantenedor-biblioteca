package cl.andres.java.biblioteca.repository;

import java.util.List;

import cl.andres.java.biblioteca.model.Usuario;

public interface UsuarioRepository {

	public List<Usuario> findAll();
	
	public int count();
	
	public Usuario findById(int id);
	
	public void create(Usuario usuario);
	
	public void edit(Usuario usuario);
	
	public void delete(int id);
	
	public Usuario findByEmail(String email);
}
