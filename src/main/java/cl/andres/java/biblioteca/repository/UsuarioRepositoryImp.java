package cl.andres.java.biblioteca.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.andres.java.biblioteca.model.Usuario;
@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Usuario makeObject(ResultSet rs, int numFila) throws SQLException{
		Long id				= rs.getLong("id");
		String email		= rs.getString("email");
		String password		= rs.getString("password");
		String roles		= rs.getString("roles");
		return new Usuario(id,email,password,roles);
	}
	
	@Override
	public List<Usuario> findAll() {
		return jdbcTemplate.query("SELECT * FROM usuarios", this::makeObject);
	}

	@Override
	public Usuario findById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM usuarios WHERE id = ?", this::makeObject);
	}
	
	// queryForObject(sql-string, metodo-makeObject, dato-a-reemplazar-el-?);
	@Override
	public Usuario findByEmail(String email) {
		return jdbcTemplate.queryForObject("SELECT * FROM usuarios WHERE email = ?", this::makeObject, email);
	}

	@Override
	public void create(Usuario usuario) {
		String sql = "INSERT INTO usuarios(email,password,roles) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql
							,usuario.getEmail()
							,usuario.getPassword()
							,usuario.getRoles()
						)
		;
	}

	@Override
	public void edit(Usuario usuario) {
		String sql = "UPDATE usuarios SET email = ?, password = ?, roles = ? WHERE id = ?";
		jdbcTemplate.update(sql
							,usuario.getEmail()
							,usuario.getPassword()
							,usuario.getRoles()
						)
		;
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";
		jdbcTemplate.update(sql,id);
	}
	

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM usuarios", Integer.class);
		
	}
}
