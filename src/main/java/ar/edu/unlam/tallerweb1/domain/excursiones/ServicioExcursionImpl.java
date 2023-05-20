package ar.edu.unlam.tallerweb1.domain.excursiones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;

@Service("servicioExcursion")
@Transactional
public class ServicioExcursionImpl implements ServicioExcursion {

	private RepositorioExcursion repositorioExcursion;

	@Autowired
	public ServicioExcursionImpl(RepositorioExcursion repositorioExcursion){
		this.repositorioExcursion = repositorioExcursion;
	}

	@Override
	public List<Excursiones> listarExcursiones() {
		return this.repositorioExcursion.listarExcursiones();
	}

	@Override
	public void guardar(Excursiones excursion) {
		this.repositorioExcursion.guardar(excursion);		
	}

}
