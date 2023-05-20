package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLoginImpl;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistroImpl;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class ControladorLoginTest {
	
	private ServicioLogin servicioLogin;
	private ControladorLogin controladorLogin;
	
	private DatosLogin datosLogin;
	private DatosLogin datosLoginEmailInvalido;
	private DatosLogin datosLoginPasswordInvalida;
	private DatosLogin datosLoginPasswordIncorrecta;
	
	public static final String EMAIL = "registroTest@test.com"; 
	public static final String PASSWORD = "!Registro1234";
	
	public static final String EMAIL_INVALIDO = "registro..@test";
	public static final String PASSWORD_INVALIDA = "pass1";
	public static final String PASSWORD_INCORRECTA = "!Registro1";

	@Before
	public void init() {
		this.datosLogin = new DatosLogin(EMAIL, PASSWORD);
		this.datosLoginEmailInvalido = new DatosLogin(EMAIL_INVALIDO, PASSWORD);
		this.datosLoginPasswordInvalida = new DatosLogin(EMAIL, PASSWORD_INVALIDA);
		this.datosLoginPasswordIncorrecta = new DatosLogin(EMAIL, PASSWORD_INCORRECTA);
		this.servicioLogin = mock(ServicioLoginImpl.class);
		this.controladorLogin = new ControladorLogin(this.servicioLogin);
	}
	
	@Test
	public void alIngresarCredencialesCorrectasMeLogueaYLlevaAlInicio() {
		dadoQueIngresaEmailYPasswordValidas(datosLogin);
		dadoQueExisteElUsuario(datosLogin);
		ModelAndView mav = cuandoMeLogueo(datosLogin);
		entoncesElLoginEsExitoso(mav);
	}

	private void entoncesElLoginEsExitoso(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("redirect:/inicio");
	}

	private ModelAndView cuandoMeLogueo(DatosLogin datosLogin) {
		return controladorLogin.validarLogin(datosLogin, null);
	}

	private void dadoQueExisteElUsuario(DatosLogin datosLogin) {
		when(servicioLogin.consultarUsuario(datosLogin)).thenReturn(true);		
	}
	
	private void dadoQueIngresaEmailYPasswordValidas(DatosLogin datosLogin) {
		when(servicioLogin.emailValido(datosLogin)).thenReturn(true);
		when(servicioLogin.passwordValida(datosLogin)).thenReturn(true);
	}
	
	@Test
	public void alIngresarCredencialesIncorrectasNoMeLoguea() {
		dadoQueExisteElUsuario(datosLogin);
		dadoQueAlLoguearmeIngresoMalLaPassword(datosLoginPasswordIncorrecta);
		ModelAndView mav = cuandoMeLogueoIngresandoMalLaPassword(datosLoginPasswordIncorrecta);
		entoncesElLoginNoEsExitoso(mav);
	}

	private void entoncesElLoginNoEsExitoso(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("login");
	}

	private ModelAndView cuandoMeLogueoIngresandoMalLaPassword(DatosLogin datosLoginPasswordIncorrecta) {
		return controladorLogin.validarLogin(datosLoginPasswordIncorrecta, null);
	}
	
	private void dadoQueAlLoguearmeIngresoMalLaPassword(DatosLogin datosLoginPasswordIncorrecta) {
		when(servicioLogin.consultarUsuario(datosLoginPasswordIncorrecta)).thenReturn(false);
	}
    
}
