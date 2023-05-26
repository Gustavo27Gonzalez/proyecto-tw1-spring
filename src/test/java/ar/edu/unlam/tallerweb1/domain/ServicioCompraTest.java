package ar.edu.unlam.tallerweb1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.delivery.DatosCompra;
import ar.edu.unlam.tallerweb1.domain.compra.Compra;
import ar.edu.unlam.tallerweb1.domain.compra.RepositorioCompra;
import ar.edu.unlam.tallerweb1.domain.compra.ServicioCompra;
import ar.edu.unlam.tallerweb1.domain.compra.ServicioCompraImpl;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;

public class ServicioCompraTest {

	private ServicioCompra servicioCompra;
	private RepositorioCompra repositorioCompra;
	private RepositorioExcursion repositorioExcursion;
	
	private DatosCompra datosCompra;
	
	//public static final Date FECHA_EXCURSION = "2023-06-29";
	public static final Double PRECIO = 24999.99;
	public static final Long ID_EXCURSION = 2L;
	public static final long ID_USUARIO = 3L;
	
	@Before
	public void init() {
		this.datosCompra = new DatosCompra(ID_EXCURSION, PRECIO, ID_USUARIO);
		this.servicioCompra = new ServicioCompraImpl(this.repositorioCompra, this.repositorioExcursion);
	}
	
	@Test
	public void alComprarUnaExcursionConCupoDisponibleSeRealizaLaCompraExitosa() {
		dadoQueLaExcursionTieneCupo(datosCompra);
		
		Compra nuevaCompra = cuandoComproUnaExcursion(datosCompra);
	
		entoncesLaCompraEsExitosa(nuevaCompra, datosCompra);
	}

	private void entoncesLaCompraEsExitosa(Compra nuevaCompra, DatosCompra datosCompra) {
		verify(repositorioCompra, times(1)).guardar(nuevaCompra);
		assertThat(nuevaCompra).isNotNull();
		assertThat(nuevaCompra.getPrecio()).isEqualTo(PRECIO);
	}

	private Compra cuandoComproUnaExcursion(DatosCompra datosCompra) {
		return servicioCompra.comprar(datosCompra);
	}

	private void dadoQueLaExcursionTieneCupo(DatosCompra datosCompra) {
		//assertThat(servicioCompra.tieneCupo(datosCompra.getIdExcursion())).isTrue();
		//when(this.servicioCompra.tieneCupo(datosCompra.getIdExcursion())).thenReturn(true);
	
	}

}
