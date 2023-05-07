package ar.edu.unlam.tallerweb1.delivery;

public class DatosRegistro {
	
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	
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
	
	public DatosRegistro() {
		
	}
	
	public DatosRegistro(String email, String password, String nombre, String apellido) {
		setEmail(email);
		setPassword(password);
		setNombre(nombre);
		setApellido(apellido);
	}

}
