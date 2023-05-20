package ar.edu.unlam.tallerweb1.delivery;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursionImpl;


public class ControladorExcursionesTest {
	
	private ServicioExcursion servicioExcursion;
	private RepositorioExcursion repositorioExcursion;
	private ControladorExcursion controladorExcursion;
	
	public static final int CANTIDAD_EXCURSIONES = 3;

	@Before
	public void init() {
		this.servicioExcursion = mock(ServicioExcursionImpl.class);
		this.repositorioExcursion = mock(RepositorioExcursion.class);
		this.controladorExcursion = new ControladorExcursion(this.servicioExcursion, this.repositorioExcursion);
	}
	
	@Test
	public void alPedirTodasLasExcursionesObtengoLaListaCompleta() {
		dadoQueExistenExcursiones(CANTIDAD_EXCURSIONES);

		ModelAndView mav = cuandoListoExcursiones();

		entoncesEncuentro(mav, CANTIDAD_EXCURSIONES);

		entoncesMeLLevaALaVista(mav, "listar-excursiones");
	}

	private void entoncesMeLLevaALaVista(ModelAndView mav, String vistaEsperada) {
		assertThat(mav.getViewName()).isEqualTo(vistaEsperada);		
	}

	private void entoncesEncuentro(ModelAndView mav, int cantidadExcursiones) {
		assertThat((ArrayList<Excursiones>)mav.getModel().get("excursiones")).hasSize(cantidadExcursiones);		
	}

	private ModelAndView cuandoListoExcursiones() {
		return controladorExcursion.listarExcursiones();
	}

	private void dadoQueExistenExcursiones(int cantidadExcursiones) {
		List<Excursiones> excursiones = new ArrayList<>();
		for (int i=0; i<cantidadExcursiones; i++) 
			excursiones.add(new Excursiones());
		when(this.servicioExcursion.listarExcursiones()).thenReturn(excursiones);
	}

	

}
