package cl.andres.java.biblioteca.model;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Libro {

	private int id;
	@Size(min=1,max=50)
	private String nombre;
	@Size(max=250)
	private String descripcion;
	private Autor autor;
}
