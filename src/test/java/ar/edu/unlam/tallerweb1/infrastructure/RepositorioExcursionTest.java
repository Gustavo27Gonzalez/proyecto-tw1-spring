package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;

public class RepositorioExcursionTest {
	
	@Autowired
	private RepositorioExcursion repositorioExcursion;
	
	public static final int CANTIDAD_EXCURSIONES = 4;

	@Test
	@Transactional
	@Rollback
	public void queSiExistenExcursionesDevuelveUnaListaDeExcursiones() {
		
		List<Excursiones> excursiones = dadoQueExistenExcursiones(CANTIDAD_EXCURSIONES);
	
		List<Excursiones> listaExcursionesObtenida = cuandoBuscoExcursiones();
		
		entoncesObtengoElListadoDeExcursiones(listaExcursionesObtenida, excursiones);
	}

	private void entoncesObtengoElListadoDeExcursiones(List<Excursiones> listaExcursionesObtenida,
			List<Excursiones> excursiones) {
		assertThat(listaExcursionesObtenida).isNotNull();
		assertThat(listaExcursionesObtenida.size()).isEqualTo(excursiones.size());
	}

	private List<Excursiones> cuandoBuscoExcursiones() {
		return repositorioExcursion.listarExcursiones();
	}

	private List<Excursiones> dadoQueExistenExcursiones(int cantidadExcursiones) {
		Excursiones excursion = new Excursiones();
		Double precio = 550.5;
		List<Excursiones> excursiones = new ArrayList<>();
		for(int i = 1; i <= cantidadExcursiones; i++) {
			excursion.setNombre(String.valueOf(i));
			excursion.setFecha(new Date(2023-05-11));
			excursion.setPrecio(precio * i);
			excursion.setCupo(i);
			excursion.setDescripcion(String.valueOf(i));
			excursiones.add(excursion);
		}
		return excursiones;
	}

}
