package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Before;
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
	
	private Usuario u = new Usuario();
	
	@Before
	public void init() {
		this.repositorioUsuario = new RepositorioUsuarioImpl(this.sessionFactory);
		this.repositorioExcursion = new RepositorioExcursionImpl(this.sessionFactory);
		this.repositorioCompra = new RepositorioCompraImpl(this.sessionFactory);
	}
	
	@Test
	@Transactional
	@Rollback
	public void alRealizarUnaCompraSeGuardaLaCompraTest() {
		Compra nuevaCompra = dadoQueTengoUnaCompraListaParaPersistir();
		cuandoLaCompraEsFinalizadaEntoncesSePersiste(nuevaCompra);
		entoncesPuedoBuscarLaCompraGuardadaYValidarQueFueExitosa(nuevaCompra);
	}

	private void entoncesPuedoBuscarLaCompraGuardadaYValidarQueFueExitosa(Compra nuevaCompra) {
		Compra compra = this.repositorioCompra.buscarPorId(nuevaCompra.getId());
		assertThat(compra.getId()).isEqualTo(nuevaCompra.getId());
	}

	private void cuandoLaCompraEsFinalizadaEntoncesSePersiste(Compra nuevaCompra) {
		repositorioCompra.guardar(nuevaCompra);
		
	}

	private Compra dadoQueTengoUnaCompraListaParaPersistir() {
		Excursiones e = new Excursiones("mi excursion", new Date(2023-07-29), 24999.99, 3, "primer excursion");
		this.repositorioExcursion.comprar(e);
		Usuario u = new Usuario();
		u.setNombre("Juan");
		this.repositorioUsuario.guardar(u);
		DatosCompra datosCompra = new DatosCompra(e, u);
		return new Compra(datosCompra);
	}

	

}
