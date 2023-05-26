package ar.edu.unlam.tallerweb1.domain.excursiones;

import java.util.List;


public interface ServicioExcursion {

	List <Excursiones> listarExcursiones();
	void guardar(Excursiones excursion);
	Boolean tieneCupo (Long idExcursion);
	// Interface que define los metodos del Servicio de Usuarios.
	
	//tipo dato -- nombre funcion y que reciben  (Inteligencia capa de negocio, declaramos las funciones)
	
	
}








	

