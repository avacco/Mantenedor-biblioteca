package cl.andres.java.biblioteca.repository;

import java.util.List;

import cl.andres.java.biblioteca.model.Libro;

public interface LibroRepository {
	
	public List<Libro> findAll();
	
	public Libro findById(int id);
	
	public void create(Libro libro);
	
	public void edit(Libro libro);
	
	public void delete(int id);

}
