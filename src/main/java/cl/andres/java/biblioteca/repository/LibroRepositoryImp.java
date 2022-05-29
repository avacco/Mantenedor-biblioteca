package cl.andres.java.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.andres.java.biblioteca.model.Libro;
@Repository
public class LibroRepositoryImp implements LibroRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Libro libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Libro libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
