package mavha.examen.seba.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String NOMBRES_REGEXP = "[A-Za-záéíúó]?[a-záéíúó]*(\\s[A-Za-záéíúó]?[a-záéíúó]*)*";
	private static final String NOMBRES_PATTERN_VIOLACION = "La primer letra debe ser mayúscula.";

	@Id
	@NotNull(message = "No te Olvides el DNI!")
	@Min(value = 1000000, message = "Opps! DNI debe tener 7 u 8 dígitos!")
	@Max(value = 99999999, message = "Opps!El DNI debe tener 7 u 8 dígitos.")
	private long dni;

	@NotNull(message = "El nombre es Fundamental!!")
	@Size(min = 1, max = 50, message = "Crack! Necesito el nombre! (50 caracteres maximo)") 
	@Pattern(regexp = NOMBRES_REGEXP, message = NOMBRES_PATTERN_VIOLACION)
	private String nombre;

	@NotNull(message = "Sin Apellido, sólo eres un N.")
	@Size(min = 1, max = 40, message = "Pon el Apellido! 40 caracteres máximo")
	@Pattern(regexp = NOMBRES_REGEXP, message = NOMBRES_PATTERN_VIOLACION)
	private String apellido;

	@NotNull(message = "No le diré a nadie tu edad, pero la necesito.. cuac!")
	@Min(value = 0, message = "La edad no es por debajo de cero.")
	@Max(value = 110, message = "Imposible!! Son muchos años para un Desarrollador!")
	private int edad;

	public Persona() {
		super();
	}

	public Persona(long dni, String nombre, String apellido, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public long getDni() {
		return this.dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dni ^ (dni >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (dni != other.dni)
			return false;
		return true;
	}

}
