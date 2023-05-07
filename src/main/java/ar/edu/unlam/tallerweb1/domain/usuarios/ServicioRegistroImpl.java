package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

import java.util.regex.*;
import java.util.*;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro {
	
	private RepositorioUsuario servicioRegistrarDao;
	
	@Autowired
	public ServicioRegistroImpl(RepositorioUsuario servicioRegistrarDao){
		this.servicioRegistrarDao = servicioRegistrarDao;
	}
	
	@Override
	public Boolean emailValido(DatosRegistro datosRegistro) {
		String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regexEmail);
		Matcher matcher= pattern.matcher(datosRegistro.getEmail());
		return matcher.matches();
	}

	@Override
	public Usuario registrarUsuario(DatosRegistro datosRegistro) {
		Usuario nuevoUsuario = new Usuario(datosRegistro);
		servicioRegistrarDao.guardar(nuevoUsuario);
		return nuevoUsuario;
	}

	@Override
	public Boolean passwordValida(DatosRegistro datosRegistro) {
		String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile(regexPassword);
		Matcher matcher= pattern.matcher(datosRegistro.getPassword());
		return matcher.matches();
	}

	@Override
	public Boolean buscarEmailRegistrado(DatosRegistro datosRegistro) {
		return null;
	}

	@Override
	public Usuario buscarUsuario(DatosRegistro datosRegistro) {
		return servicioRegistrarDao.buscar(datosRegistro.getEmail());
	}

}
