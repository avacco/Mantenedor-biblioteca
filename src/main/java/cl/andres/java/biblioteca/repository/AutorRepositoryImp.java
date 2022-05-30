package cl.andres.java.biblioteca.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.andres.java.biblioteca.model.Autor;

@Repository
public class AutorRepositoryImp implements AutorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Autor makeObject(ResultSet rs, int numFila) throws SQLException{
		Long id				= rs.getLong("id");
		String nombre		= rs.getString("nombre");
		return new Autor(id,nombre);
	}
	
	@Override
	public List<Autor> findAll() {
		return jdbcTemplate.query("SELECT * FROM autor", this::makeObject);
	}

	@Override
	public Autor findById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM autor WHERE id = ?", this::makeObject, id);	
	}

	@Override
	public void create(Autor autor) {
		String sql = "INSERT INTO autor(nombre) VALUES(?)";
		jdbcTemplate.update(sql,autor.getNombre());
	}

	@Override
	public void edit(Autor autor) {
		String sql = "UPDATE autor SET nombre = ?";
		jdbcTemplate.update(sql,autor.getNombre());		
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM autor WHERE id = ?";
		jdbcTemplate.update(sql,id);	
	}

}
