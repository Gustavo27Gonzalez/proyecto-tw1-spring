package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.delivery.DatosLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Boolean consultarUsuario(DatosLogin datosLogin);
	Boolean emailValido(DatosLogin datosLogin);
	Boolean passwordValida(DatosLogin datosLogin);
}
