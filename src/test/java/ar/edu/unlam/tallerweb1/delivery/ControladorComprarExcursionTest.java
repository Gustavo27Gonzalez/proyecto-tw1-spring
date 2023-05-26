package ar.edu.unlam.tallerweb1.delivery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.compra.ServicioCompra;
import ar.edu.unlam.tallerweb1.domain.compra.ServicioCompraImpl;

public class ControladorComprarExcursionTest {
	
	private ServicioCompra servicioCompra;
	private ControladorCompra controladorCompra;
	
	private DatosCompra datosCompra;
	
	//public static final Date FECHA_EXCURSION = "2023-06-29";
	public static final Double PRECIO = 24999.99;
	public static final Long ID_EXCURSION = 2L;
	public static final long ID_USUARIO = 3L;
	
	
	@Before
	public void init() {
		this.datosCompra = new DatosCompra(ID_EXCURSION, PRECIO, ID_USUARIO);
		this.servicioCompra = mock(ServicioCompraImpl.class);
		this.controladorCompra = new ControladorCompra(servicioCompra);
	}
	
	@Test
	public void alClickearBotonComprarMeRedirigeALaPantallaDeComprar() {
		
		ModelAndView mav = cuandoQuieroComprar();
		
		entoncesMeLlevaALaPantallaComprar(mav);
	}

	private void entoncesMeLlevaALaPantallaComprar(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("compra-excursion");		
	}

	private ModelAndView cuandoQuieroComprar() {
		return controladorCompra.comprar();
	}
	
	@Test
	public void alConfirmarLaCompraSeRealizaYMeRedirigeAlInicio() {
		dadoQueLaExcursionTieneCupo(datosCompra);
		
		ModelAndView mav = cuandoComproUnaExcursion(datosCompra);
		
		entoncesLaCompraEsExitosa(mav);
	}

	private void entoncesLaCompraEsExitosa(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("usuarioInicio");
		assertThat(mav.getModel().get("msg")).isEqualTo("Compra Exitosa");
	}

	private ModelAndView cuandoComproUnaExcursion(DatosCompra datosCompra2) {
		return controladorCompra.comprarExcursion(datosCompra);
	}

	private void dadoQueLaExcursionTieneCupo(DatosCompra datosCompra2) {
		when(servicioCompra.tieneCupo(datosCompra.getIdExcursion())).thenReturn(true);
	}

}
