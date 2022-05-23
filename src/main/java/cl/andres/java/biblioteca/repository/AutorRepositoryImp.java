package cl.andres.java.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import cl.andres.java.biblioteca.model.Autor;

public class AutorRepositoryImp implements AutorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Autor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
