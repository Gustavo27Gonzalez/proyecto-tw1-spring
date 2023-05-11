package ar.edu.unlam.tallerweb1.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursionImpl;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursion;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class ServicioExcursionTest {

	private ServicioExcursion servicioExcursion;
	private RepositorioExcursion repositorioExcursion = mock(RepositorioExcursion.class); 
		
	
	@Before
	public void init() {
		this.servicioExcursion = new ServicioExcursionImpl(this.repositorioExcursion);
	}
	
	@Test
	public void alBuscarExcursionesDevuelveListaDeExcursiones() {

			dadoQueExistenExcursiones ( CANTIDAD_EXCURSIONES);

			list <Excursion> listaExcursiones = cuandoListoLasExcursiones;

			entoncesTraeListadoExcursiones (listaExcursiones , CANTIDAD_EXCURSIONES);
	}
	
	
}
