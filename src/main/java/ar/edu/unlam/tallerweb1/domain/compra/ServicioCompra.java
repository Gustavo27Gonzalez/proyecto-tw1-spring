package ar.edu.unlam.tallerweb1.domain.compra;

import ar.edu.unlam.tallerweb1.delivery.DatosCompra;

public interface ServicioCompra {

	Boolean tieneCupo(Long idExcursion);

	void comprar(DatosCompra datosCompra);

}
