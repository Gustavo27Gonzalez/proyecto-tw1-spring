package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.delivery.DatosLogin;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	private RepositorioUsuario repositorioLogin;

	@Autowired
	public ServicioLoginImpl(RepositorioUsuario servicioLoginDao){
		this.repositorioLogin = servicioLoginDao;
	}

	@Override
	public Boolean consultarUsuario (DatosLogin datosLogin) {
		Usuario usuario = repositorioLogin.buscarUsuario(datosLogin);
		Boolean result = false;
		if(usuario != null) {
			result = true;
		}
		return result;
	}

	@Override
	public Boolean emailValido(DatosLogin datosLogin) {
		String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regexEmail);
		Matcher matcher= pattern.matcher(datosLogin.getEmail());
		return matcher.matches();
	}

	@Override
	public Boolean passwordValida(DatosLogin datosLogin) {
		String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile(regexPassword);
		Matcher matcher= pattern.matcher(datosLogin.getPassword());
		return matcher.matches();
	}

}
