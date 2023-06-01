package ar.edu.unlam.tallerweb1.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.SessionService;
import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.excursiones.ServicioExcursion;

@Controller
public class ControladorExcursion {
	
	ServicioExcursion servicioExcursion;
	
	RepositorioExcursion repositorioExcursion;

	SessionService sessionService;

	@Autowired
	public ControladorExcursion(ServicioExcursion servicioExcursion, RepositorioExcursion repositorioExcursion) {
		this.servicioExcursion = servicioExcursion;
		this.repositorioExcursion = repositorioExcursion;
	}

	@RequestMapping(path="/listar-excursiones", method = RequestMethod.GET)
	public ModelAndView listarExcursiones() {
		ModelMap model = new ModelMap();
		List<Excursiones> excursiones = this.servicioExcursion.listarExcursiones();
		model.put("excursiones", excursiones);
		ModelAndView mav = new ModelAndView("listar-excursiones", model);
		return mav;
	}
	
	@RequestMapping(path="/seleccionar-excursion", method = RequestMethod.GET)
	public ModelAndView seleccionarExcursion(@RequestParam("id") long id) {
		this.sessionService.setExcursionActual(this.servicioExcursion.getExcursion(id));
		ModelMap model = new ModelMap();
		model.put("excursion", this.servicioExcursion.getExcursion(id));
		ModelAndView mav = new ModelAndView("comprar", model);
		return mav;
	}

}
