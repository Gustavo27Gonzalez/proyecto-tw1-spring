package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.DatosCompra;
import ar.edu.unlam.tallerweb1.domain.compra.Compra;
import ar.edu.unlam.tallerweb1.domain.compra.RepositorioCompra;
import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class RepositorioCompraTest extends SpringTest{

	@Autowired
	private RepositorioCompra repositorioCompra;
	
	@Autowired
	private RepositorioExcursion repositorioExcursion;
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	private Compra compra;
	
	public static final Double PRECIO = 29999.99;
	public static final Long ID_EXCURSION = 1L;
	public static final long ID_USUARIO = 1L;
	
	@Test
	@Transactional
	@Rollback
	public void queSeGuardaUnaCompraTest() {
		Usuario nuevoUsuario = dadoQueExisteUnUsuario();
		Excursiones nuevaExcursion = dadoQueExisteUnaExcursion();
		
		Long idCompra = cuandoComproUnaExcursion(compra);
		
		entoncesLaPuedoBuscarPorSuId(idCompra);
	}

	private void entoncesLaPuedoBuscarPorSuId(Long idCompra) {
		Compra compraBuscada = repositorioCompra.buscarPorId(idCompra);
		assertThat(compraBuscada).isNotNull();
		
	}

	private Long cuandoComproUnaExcursion(Compra compra) {
		compra.setIdExcursion(ID_EXCURSION);
		compra.setPrecio(PRECIO);
		compra.setIdUsuario(ID_USUARIO);
		repositorioCompra.guardar(compra);
		return compra.getId();
	}

	private Excursiones dadoQueExisteUnaExcursion() {
		Excursiones excursion = new Excursiones();
		excursion.setNombre("Termas del litoral");
		excursion.setFecha(new Date(2023-07-12));
		excursion.setPrecio(29999.99);
		excursion.setCupo(8);
		excursion.setDescripcion("Recorrido por las termas del litoral");
		repositorioExcursion.guardar(excursion);
		return excursion;
	}

	private Usuario dadoQueExisteUnUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("usuarioNuevo@guardar.com");
		usuario.setPassword("!Guardar1234");
		usuario.setNombre("Nuevo");
		usuario.setApellido("Usuario");
		repositorioUsuario.guardar(usuario);
		return usuario;
	}

}
