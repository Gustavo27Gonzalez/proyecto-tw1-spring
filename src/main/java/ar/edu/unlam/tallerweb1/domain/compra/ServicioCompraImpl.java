package ar.edu.unlam.tallerweb1.domain.compra;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.delivery.DatosCompra;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;

@Service("servicioCompra")
@Transactional
public class ServicioCompraImpl implements ServicioCompra {

	private RepositorioCompra repositorioCompra;
	
	private RepositorioExcursion repositorioExcursion;
	
	@Autowired
	public ServicioCompraImpl(RepositorioCompra repositorioCompra, RepositorioExcursion repositorioExcursion) {
		this.repositorioCompra = repositorioCompra;
		this.repositorioExcursion = repositorioExcursion;
	}

	@Override
	public Boolean tieneCupo(Long idExcursion) {
		return true;
		//return (repositorioExcursion.tieneCupo(idExcursion) != null) ? true : false;
	}

	@Override
	public Compra comprar(DatosCompra datosCompra) {
		Compra nuevaCompra = new Compra(datosCompra);
		repositorioCompra.guardar(nuevaCompra);
		return nuevaCompra;		
	}

}
