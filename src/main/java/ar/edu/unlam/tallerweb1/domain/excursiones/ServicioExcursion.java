package ar.edu.unlam.tallerweb1.domain.excursiones;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.compra.Compra;


public interface ServicioExcursion {

	List <Excursiones> listarExcursiones();
	void guardar(Excursiones excursion);
	Boolean tieneCupo (Long idExcursion);
	// Interface que define los metodos del Servicio de Usuarios.
	Compra comprar(Compra compra);
	
	//tipo dato -- nombre funcion y que reciben  (Inteligencia capa de negocio, declaramos las funciones)
	
	
}








	

