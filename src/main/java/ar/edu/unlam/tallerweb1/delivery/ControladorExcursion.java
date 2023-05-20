package ar.edu.unlam.tallerweb1.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursion;

public class ControladorExcursion {
	
	@Autowired
	ServicioExcursion servicioExcursion;
	
	@Autowired
	RepositorioExcursion repositorioExcursion;

	public ControladorExcursion(ServicioExcursion servicioExcursion, RepositorioExcursion repositorioExcursion) {
		this.servicioExcursion = servicioExcursion;
		this.repositorioExcursion = repositorioExcursion;
	}

	@RequestMapping(path="/listado-excursiones", method = RequestMethod.GET)
	public ModelAndView listarExcursiones() {
		ModelMap model = new ModelMap();
		List<Excursiones> excursiones = this.servicioExcursion.listarExcursiones();
		model.put("excursiones", excursiones);
		ModelAndView mav = new ModelAndView("listar-excursiones", model);
		return mav;
	}

}
