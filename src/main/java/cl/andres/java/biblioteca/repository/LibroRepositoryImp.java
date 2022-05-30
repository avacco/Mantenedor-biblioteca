package cl.andres.java.biblioteca.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.andres.java.biblioteca.model.Autor;
import cl.andres.java.biblioteca.model.Libro;

@Repository
public class LibroRepositoryImp implements LibroRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	AutorRepository autorRepository;
	
	private Libro makeObject(ResultSet rs, int numFila) throws SQLException{
		Long id				= rs.getLong("id");
		String nombre		= rs.getString("nombre");
		String descripcion	= rs.getString("descripcion");
		Long autorId 		= rs.getLong("autor_id");
				
		Autor autor			= autorRepository.findById(autorId);
		return new Libro(id,nombre,descripcion,autorId,autor);
	}
	
	@Override
	public List<Libro> findAll() {
		return jdbcTemplate.query("SELECT * FROM libro", this::makeObject);
	}

	@Override
	public Libro findById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM libro WHERE id = ?", this::makeObject, id);
	}

	@Override
	public void create(Libro libro) {
		String sql = "INSERT INTO libro(nombre,descripcion,autor_id) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql
							,libro.getNombre()
							,libro.getDescripcion()
							,libro.getAutor_id()
						)
		;

	}

	@Override
	public void edit(Libro libro) {
		String sql = "UPDATE libro SET nombre = ?, descripcion= ?, autor_id= ? WHERE id = ?";
	
		jdbcTemplate.update(sql
							,libro.getNombre()
							,libro.getDescripcion()
							,libro.getAutor_id()
						)
		;
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM libro WHERE id = ?";
		jdbcTemplate.update(sql,id);
	}

}
