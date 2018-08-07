package mavha.examen.seba.service;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ejb.ApplicationException;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import mavha.examen.seba.data.PersonaRepository;
import mavha.examen.seba.model.Persona;

@Stateless
public class PersonaService {

	@Inject
	private PersonaRepository personaRepository;
	@Inject
	private Event<Persona> personaEventSrc;
	@Inject
	private Validator validator;

	@Transactional(value = TxType.REQUIRED)
	public void agregar(PersonaCompletaDto personaDto) throws ErrorValidacion, UnicidadDniViolada {
		final Persona persona = new Persona(personaDto.dni, personaDto.nombre, personaDto.apellido, personaDto.edad);

		try {
			// Validar usando bean validation
			validarPersona(persona);
			// agregar la persona al contexto de persistencia
			personaRepository.persistir(persona);
			// Notificar que la persona fue agregada (anque aún pude ser desecho si la transacción no es exitosa. Es el consumidor del evento el responsable de filtrar los casos exitosos indicandolo con {@code @Observes(during=AFTER_SUCCESS)}. 
			personaEventSrc.fire(persona); // TODO agregar qualifier o wrapper para distinguir qué sucedió con la
											// persona (alta, baja, o modificacion).
		} catch (ConstraintViolationException cve) {
			throw new ErrorValidacion(cve.getConstraintViolations().stream().collect(
					Collectors.toMap(v -> v.getPropertyPath().toString(), v -> v.getMessage(), (a, b) -> a + " " + b)), cve);
		} catch (EntityExistsException eee) {
			throw new UnicidadDniViolada(eee);
		} catch (PersistenceException pe) {
			if (pe.getCause().getClass().getName() == org.hibernate.exception.ConstraintViolationException.class
					.getName())
				throw new UnicidadDniViolada(pe); // Dado que DNI es el único campo con constraints
			else
				throw pe;
		}
	}

	public List<PersonaCompletaDto> todasOrdenadasPorApellidoYNombre() {
		return personaRepository.todasOrdenadasPorApellidoYNombre().stream()
				.map(p -> new PersonaCompletaDto(p.getDni(), p.getNombre(), p.getApellido(), p.getEdad()))
				.collect(Collectors.toList());
	}

	/**
	 * <p>
	 * Validates the given Persona variable and throws validation exceptions based
	 * on the type of error. If the error is standard bean validation errors then it
	 * will throw a ConstraintValidationException with the set of the constraints
	 * violated.
	 * </p>
	 * 
	 * @param persona
	 *            Persona a validar
	 * @throws ConstraintViolationException
	 *             If Bean Validation errors exist
	 */
	private void validarPersona(Persona persona) throws ConstraintViolationException {
		// Create a bean validator and check for issues.
		final Set<ConstraintViolation<Persona>> violations = validator.validate(persona);

		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
	}

	public static class PersonaCompletaDto implements Serializable {
		private static final long serialVersionUID = 1L;

		public final long dni;
		public final String nombre;
		public final String apellido;
		public final int edad;

		@JsonCreator
		public PersonaCompletaDto(@JsonProperty("dni") long dni, @JsonProperty("nombre") String nombre,
				@JsonProperty("apellido") String apellido, @JsonProperty("edad") int edad) {
			this.dni = dni;
			this.nombre = nombre;
			this.apellido = apellido;
			this.edad = edad;
		}
	}

	@ApplicationException(rollback = true)
	public static class ErrorValidacion extends Exception {
		private static final long serialVersionUID = 1L;
		public final Map<String, String> detalle;

		public ErrorValidacion(Map<String, String> detalle, Throwable cause) {
			super("detalle=" + detalle, cause);
			this.detalle = detalle;
		}
	}
	
	@ApplicationException(rollback = true)
	public static class UnicidadDniViolada extends Exception {
		private static final long serialVersionUID = 1L;

		public UnicidadDniViolada(Throwable cause) {
			super("Dni Duplicado", cause);
		}
	}
}
