package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.ControladorRegistro;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistroImpl;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class ServicioRegistroTest {
	
	private ServicioRegistro servicioRegistro;
	private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
	
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
		this.servicioRegistro = new ServicioRegistroImpl(this.repositorioUsuario);
	}

	@Test
	public void alIngresarUnCorreoValidoMeDevuelveVerdadero() {
		Boolean esValido = servicioRegistro.emailValido(datosRegistro);
		entoncesMiCorreo(esValido);
	}

	private void entoncesMiCorreo(Boolean esValido) {
		assertTrue(esValido);		
	}
	
	@Test
	public void alIngresarCredencialesValidasMeRegistroCorrectamente() {
		
		dadoQueTengoCredencialesValidas(datosRegistro);
		
		Usuario nuevoUsuarioRegistrado = cuandoMeRegistro(datosRegistro);
		
		entoncesElRegistroEsExitoso(nuevoUsuarioRegistrado, datosRegistro);
		
	}//2:41 hs
	
	private void entoncesElRegistroEsExitoso(Usuario usuarioNuevo, DatosRegistro datosRegistro) {
		verify(repositorioUsuario, times(1)).guardar(usuarioNuevo);
		assertThat(usuarioNuevo).isNotNull();	
		assertThat(datosRegistro.getEmail()).isEqualTo(usuarioNuevo.getEmail());
		assertThat(datosRegistro.getPassword()).isNotEqualTo("1234");
	}
	
	private Usuario cuandoMeRegistro(DatosRegistro datosRegistro) {
		return servicioRegistro.registrarUsuario(datosRegistro);
	}
	
	private void dadoQueTengoCredencialesValidas(DatosRegistro datosRegistro) {
		assertThat(servicioRegistro.emailValido(datosRegistro)).isTrue();
		assertThat(servicioRegistro.passwordValida(datosRegistro)).isTrue();
		//assertThat(servicioRegistro.buscarEmailRegistrado(datosRegistro)).isFalse();
	}

}
