package ar.edu.unlam.tallerweb1.domain.excursiones;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.compra.Compra;

public interface RepositorioExcursion {

	List<Excursiones> listarExcursiones();

	void guardar(Excursiones excursion);

	Excursiones tieneCupo(Long idExcursion);

	Compra comprar(Compra compra);

	void comprar(Excursiones excursion);

	Excursiones buscarPorId(long id);


}
