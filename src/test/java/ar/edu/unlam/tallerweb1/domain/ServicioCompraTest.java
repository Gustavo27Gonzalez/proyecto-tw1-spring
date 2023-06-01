package ar.edu.unlam.tallerweb1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.delivery.DatosCompra;
import ar.edu.unlam.tallerweb1.domain.compra.Compra;
import ar.edu.unlam.tallerweb1.domain.compra.RepositorioCompra;
import ar.edu.unlam.tallerweb1.domain.compra.ServicioCompra;
import ar.edu.unlam.tallerweb1.domain.compra.ServicioCompraImpl;
import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursionImpl;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class ServicioCompraTest {

	private ServicioExcursion servicioExcursion;
	private RepositorioExcursion repositorioExcursion;
	
	@Before
	public void init() {
		this.repositorioExcursion = mock(RepositorioExcursion.class);
		this.servicioExcursion = new ServicioExcursionImpl(this.repositorioExcursion);
	}
	
	@Test
	public void existeUnaExcursionYPuedoComprarla() {
		Excursiones e = new Excursiones("mi excursion", new Date(2023-07-29), 24999.99, 3, "primer excursion");
		Usuario u = new Usuario();
		u.setNombre("Juan");
		Compra compra = new Compra(e, u);
		
		dadoQueExisteUnaExcursionYLaQuieroComprar(compra);
		
		Compra compraExitosa = cuandoQuieroComprarUnaExcursion(compra);

		entoncesLaCompraEsExitosa(compraExitosa);
	}

	
	private Compra cuandoQuieroComprarUnaExcursion(Compra compra) {
		return this.servicioExcursion.comprar(compra);
	}

	private void dadoQueExisteUnaExcursionYLaQuieroComprar(Compra compra) {
		when(this.repositorioExcursion.comprar(compra)).thenReturn(compra);
	}
	
	private void entoncesLaCompraEsExitosa(Compra compraExitosa) {
		assertThat(compraExitosa).isNotNull();
	}

	

}
