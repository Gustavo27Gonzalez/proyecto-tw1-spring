package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;

public class RepositorioExcursionTest extends SpringTest {
	
	@Autowired
	private RepositorioExcursion repositorioExcursion;
	
	public static final int CANTIDAD_EXCURSIONES = 4;
	
	@Before
    public void init() {
        this.repositorioExcursion = mock(RepositorioExcursion.class);
    }

	@Test
	@Transactional
	@Rollback
	public void siExistenExcursionesYPidoTodasLasExcursionesDevuelveUnaListaDeExcursiones() {
		
		dadoQueExistenExcursiones(CANTIDAD_EXCURSIONES);
	
		List<Excursiones> listaExcursiones = cuandoBuscoExcursiones();
		
		entoncesObtengoElListadoDeExcursiones(listaExcursiones, CANTIDAD_EXCURSIONES);
	}

	private void entoncesObtengoElListadoDeExcursiones(List<Excursiones> listaExcursiones,
			int cantidadExcursiones) {
		assertThat(listaExcursiones).isNotNull();
		assertThat(listaExcursiones).hasSize(cantidadExcursiones);
	}

	private List<Excursiones> cuandoBuscoExcursiones() {
		return repositorioExcursion.listarExcursiones();
	}

	private void dadoQueExistenExcursiones(int cantidadExcursiones) {
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
			repositorioExcursion.guardar(excursion);
		}
		when(this.repositorioExcursion.listarExcursiones()).thenReturn(excursiones);
	}

}
