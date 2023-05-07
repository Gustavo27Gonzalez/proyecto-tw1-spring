package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class RepositorioUsuarioTest extends SpringTest {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Test
	@Transactional
	@Rollback
	public void quePuedoGuardarUnUsuarioTest() {
		
		Usuario nuevoUsuario = dadoQueExisteUnUsuario();
		
		Long idUsuario = cuandoGuardoUnUsuario(nuevoUsuario);
		
		entoncesLoPuedoBuscarPorSuId(idUsuario);
	}

	private void entoncesLoPuedoBuscarPorSuId(Long id) {
		Usuario usuarioBuscado = repositorioUsuario.buscarPorId(id);
		assertThat(usuarioBuscado).isNotNull();
		
	}

	private Long cuandoGuardoUnUsuario(Usuario usuario) {
		repositorioUsuario.guardar(usuario);
		return usuario.getId();
	}

	private Usuario dadoQueExisteUnUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("usuarioNuevo@guardar.com");
		usuario.setPassword("!Guardar1234");
		usuario.setNombre("Nuevo");
		usuario.setApellido("Usuario");
		return usuario;
	}
	
	
	@Test
	@Transactional
	@Rollback
	public void queHayUnUsuarioRegistradoYAlBuscarloPorMailMeDevuelveAlUsuario() {
		
		Usuario usuario1 = dadoQueGuardoUnUsuario();
		Usuario usuario2 = dadoQueGuardoOtroUsuario();
		
		Usuario usuarioObtenido = cuandoBuscoUnUsuarioPorSuMail(usuario2.getEmail());
		String emailUsuarioBuscado = usuario2.getEmail();
		
		entoncesLoPuedoBuscarPorSuEmail(usuarioObtenido, emailUsuarioBuscado);
	}

	private void entoncesLoPuedoBuscarPorSuEmail(Usuario usuarioObtenido, String emailUsuarioBuscado) {
		assertThat(usuarioObtenido).isNotNull();
		assertThat(usuarioObtenido.getEmail()).isEqualTo(emailUsuarioBuscado);
	}

	private Usuario cuandoBuscoUnUsuarioPorSuMail(String email) {
		return repositorioUsuario.buscar(email);
	}
	
	private Usuario dadoQueGuardoOtroUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("otroUsuario@test.com");
		usuario.setPassword("!OtroTest1");
		usuario.setNombre("Otro");
		usuario.setApellido("Usuario");
		repositorioUsuario.guardar(usuario);
		return usuario;
	}

	private Usuario dadoQueGuardoUnUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("unUsuario@test.com");
		usuario.setPassword("!Test1111");
		usuario.setNombre("Un Nuevo");
		usuario.setApellido("Usuario");
		repositorioUsuario.guardar(usuario);
		return usuario;
	}
	
	@Test
	@Transactional
	@Rollback
	public void queAlBuscarPorEmailUnUsuarioNoGuardadoDevuelveNull() {
		
		Usuario usuario = dadoQueGuardoUnUsuario(new Usuario("user@user.com", "!User1234", "User", "Generic", true));
		
		Usuario usuarioObtenido = cuandoBuscoUnUsuarioPorEmail("MiEmail@gmail.com");
		
		entoncesLoBuscoPorEmailYNoLoEncuentro(usuarioObtenido);
	}

	private void entoncesLoBuscoPorEmailYNoLoEncuentro(Usuario usuarioObtenido) {
		assertThat(usuarioObtenido).isNull();
		
	}
	
	private Usuario cuandoBuscoUnUsuarioPorEmail(String email) {
		return repositorioUsuario.buscar(email);
	}

	private Usuario dadoQueGuardoUnUsuario(Usuario usuario) {
		repositorioUsuario.guardar(usuario);
		return usuario;
	}
	

}
