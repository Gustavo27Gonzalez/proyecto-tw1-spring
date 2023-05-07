package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class PersistenciaUsuarioTest extends SpringTest {

	@Test
	@Transactional
	@Rollback
	public void quePuedoGuardarUnUsuarioTest() {
		
		Usuario nuevoUsuario = dadoQueExisteUnUsuario();
		
		Long idUsuario = cuandoGuardoUnUsuario(nuevoUsuario);
		
		entoncesLoPuedoBuscarPorSuId(idUsuario);
	}

	private void entoncesLoPuedoBuscarPorSuId(Long id) {
		Usuario usuarioBuscado = session().get(Usuario.class, id);
		assertThat(usuarioBuscado).isNotNull();
		
	}

	private Long cuandoGuardoUnUsuario(Usuario usuario) {
		session().save(usuario);
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

}
