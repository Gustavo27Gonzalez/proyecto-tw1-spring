package ar.edu.unlam.tallerweb1.domain.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.delivery.DatosLogin;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en el
@Entity (name="usuarios")
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	// para el resto de los atributo no se usan anotaciones entonces se usa el default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de dato de java.
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private Boolean activo = true;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public boolean activo() {
		return activo;
    }

    public void activar() {
		activo = true;
    }
    
    public Usuario() {
    }
    
    public Usuario (DatosRegistro datosRegistro) {
    	setEmail(datosRegistro.getEmail());
		setPassword(datosRegistro.getPassword());
		setNombre(datosRegistro.getNombre());
		setApellido(datosRegistro.getApellido());
		setActivo(true);
    }
    
    public Usuario(DatosLogin datosLogin) {
		setEmail(datosLogin.getEmail());
		setPassword(datosLogin.getPassword());
	}
    
    public Usuario(Long id, String email) {
		setId(id);
		setEmail(email);
	}
    
	public Usuario(String email, String password, String nombre, String apellido, boolean activo) {
		setEmail(email);
		setPassword(password);
		setNombre(nombre);
		setApellido(apellido);
		setActivo(activo);
	}
}
