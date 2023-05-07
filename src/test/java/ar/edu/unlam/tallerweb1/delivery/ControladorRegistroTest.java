package ar.edu.unlam.tallerweb1.delivery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistroImpl;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class ControladorRegistroTest {
	
	private ServicioRegistro servicioRegistro;
	private ControladorRegistro controladorRegistro;
	
	private DatosRegistro datosRegistro;
	private DatosRegistro datosRegistroEmailInvalido;
	private DatosRegistro datosRegistroPasswordInvalida;
	
	public static final String EMAIL = "registroTest@test.com"; 
	public static final String PASSWORD = "!Registro1234";
	public static final String NOMBRE = "juan";
	public static final String APELLIDO = "registro";
	
	public static final String EMAIL_INVALIDO = "registro..@test";
	public static final String PASSWORD_INVALIDA = "pass1";
	
	@Before
	public void init() {
		this.datosRegistro = new DatosRegistro(EMAIL, PASSWORD, NOMBRE, APELLIDO);
		this.datosRegistroEmailInvalido = new DatosRegistro(EMAIL_INVALIDO, PASSWORD, NOMBRE, APELLIDO);
		this.datosRegistroPasswordInvalida = new DatosRegistro(EMAIL, PASSWORD_INVALIDA, NOMBRE, APELLIDO);
		this.servicioRegistro = mock(ServicioRegistroImpl.class);
		this.controladorRegistro = new ControladorRegistro(this.servicioRegistro);
	}
	
	@Test
	public void alIngresarCredencialesCorrectasDeUnNuevoUsuarioMeRegistraYLlevaAlLogin() {
		
		// Preparación
		
		dadoQueNoExisteElUsuario(datosRegistro);
		
		// Ejecución
		
		ModelAndView mav = cuandoMeRegistro(datosRegistro);
		
		// Verificación
		
		entoncesElRegistroEsExitoso(mav);		
		
	}
	
	private void dadoQueNoExisteElUsuario(DatosRegistro datosRegistro) {
		when(servicioRegistro.emailValido(datosRegistro)).thenReturn(true);
	}
	
	private ModelAndView cuandoMeRegistro(DatosRegistro datosRegistro) {
		return controladorRegistro.registrarUsuario(datosRegistro);
	}
	
	private void entoncesElRegistroEsExitoso(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("login");
		assertThat(mav.getModel().get("msg")).isEqualTo("Registro Exitoso");
	}
	
	@Test
	public void alIngresarEmailInvalidoNoMeDejaRegistrar() {
		
		dadoQueElEmailEsInvalido(datosRegistroEmailInvalido);
		
		ModelAndView mav = cuandoMeRegistro(datosRegistroEmailInvalido);
		
		entoncesElRegistroFalla(mav);
		
	}

	private void dadoQueElEmailEsInvalido(DatosRegistro datosRegistroEmailInvalido) {
		when(servicioRegistro.emailValido(datosRegistroEmailInvalido)).thenReturn(false);
	}

	private void entoncesElRegistroFalla(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("registro-usuario");
		assertThat(mav.getModel().get("msg")).isEqualTo("Registro Fallido");
	}
	
	@Test
	public void alIngresarPasswordInvalidaNoMeDejaRegistrar() {
		
		dadoQueLaPasswordEsInvalida(datosRegistroPasswordInvalida);
		
		ModelAndView mav = cuandoMeRegistro(datosRegistroPasswordInvalida);
		
		entoncesElRegistroFalla(mav);
		
	}//2:09hs
	
	private void dadoQueLaPasswordEsInvalida(DatosRegistro datosRegistroPasswordInvalida) {
		when(servicioRegistro.passwordValida(datosRegistroPasswordInvalida)).thenReturn(false);
	}
	
	@Test
	public void alIngresarUnEmailQueYaEsUsuarioNoMeDejaRegistrar() {
		
		dadoQueExisteElUsuario(datosRegistro);
		
		ModelAndView mav = cuandoMeRegistro(datosRegistro);
		
		entoncesElRegistroFalla(mav);
	}

	private void dadoQueExisteElUsuario(DatosRegistro datosRegistro2) {
		when(servicioRegistro.emailValido(datosRegistro)).thenReturn(true);
		when(servicioRegistro.buscarEmailRegistrado(datosRegistro)).thenReturn(true);
	}

	@Test
	public void alIngresarARegistrarmeMeMuestraLaPantallaDeRegistro() {
		
		ModelAndView mav = cuandoMeQuieroRegistrar();
		
		entoncesMeLlevaALaPantallaDeRegistro(mav);
	}

	private ModelAndView cuandoMeQuieroRegistrar() {
		return controladorRegistro.registrarme();
	}
	
	private void entoncesMeLlevaALaPantallaDeRegistro(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("registro-usuario");
	}

}
