package ar.edu.unlam.tallerweb1.domain;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursionImpl;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;


public class ServicioExcursionTest {

	private ServicioExcursion servicioExcursion;
	private RepositorioExcursion repositorioExcursion = mock(RepositorioExcursion.class); 
	public static final int CANTIDAD_EXCURSIONES = 3;	
	
	
	@Before
	public void init() {
		this.servicioExcursion = new ServicioExcursionImpl(this.repositorioExcursion);
	}
	
	
	@Test
	public void alBuscarExcursionesDevuelveListaDeExcursiones() {

			dadoQueExistenExcursiones (CANTIDAD_EXCURSIONES);

			List <Excursiones> listaExcursiones = cuandoListoExcursiones();

			entoncesTraeListadoExcursiones (listaExcursiones , CANTIDAD_EXCURSIONES);
	}
	
	
	private List<Excursiones> cuandoListoExcursiones() {
		return servicioExcursion.listarExcursiones();
	}


	private void dadoQueExistenExcursiones(int cantidadExcursiones) {
		
		List <Excursiones> excursiones = new ArrayList<>();
		
		for(int i = 0; i < cantidadExcursiones; i++)
			excursiones.add(new Excursiones());
		
		when(this.servicioExcursion.listarExcursiones()).thenReturn(excursiones);
	}

	private void entoncesTraeListadoExcursiones (List<Excursiones> listaExcursiones, int cantidadExcursionesEsperada) {
		assertThat(listaExcursiones).isNotNull();
		//mirar clase de German
	}


	
}
