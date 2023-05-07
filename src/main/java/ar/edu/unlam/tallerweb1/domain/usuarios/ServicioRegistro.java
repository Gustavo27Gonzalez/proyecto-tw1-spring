package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;

public interface ServicioRegistro {
	
	Boolean emailValido(DatosRegistro datosRegistro);
	Usuario registrarUsuario(DatosRegistro datosRegistro);
	Boolean passwordValida(DatosRegistro datosRegistro);
	Boolean buscarEmailRegistrado(DatosRegistro datosRegistro);
	Usuario buscarUsuario(DatosRegistro datosRegistro);

}
