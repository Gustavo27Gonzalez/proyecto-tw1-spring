package ar.edu.unlam.tallerweb1.domain.excursiones;

import java.util.List;

public interface RepositorioExcursion {

	List<Excursiones> listarExcursiones();

	void guardar(Excursiones excursion);

	Boolean tieneCupo(Long idExcursion);

}
