package ar.edu.unlam.tallerweb1.domain.excursiones;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;


public class ServicioExcursionImpl implements ServicioExcursion {

	private RepositorioExcursion repositorioExcursion;

	@Autowired
	public ServicioExcursionImpl(RepositorioExcursion repositorioExcursion){
		this.repositorioExcursion = repositorioExcursion;
	}

}
