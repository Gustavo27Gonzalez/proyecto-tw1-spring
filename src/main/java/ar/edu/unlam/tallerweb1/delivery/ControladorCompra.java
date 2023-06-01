package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.compra.ServicioCompra;

@Controller
public class ControladorCompra {
	
	
	private ServicioCompra servicioCompra;

	@Autowired
	public ControladorCompra(ServicioCompra servicioCompra) {
		this.servicioCompra = servicioCompra;
	}

	@RequestMapping(path = "/comprar"/*, method = RequestMethod.GET*/)
	public ModelAndView comprar() {
		ModelMap model = new ModelMap();
		model.put("datosCompra", new DatosCompra());
		return new ModelAndView("compra-excursion", model);
	}

	@RequestMapping(path = "/comprar-excursion", method = RequestMethod.POST)
	public ModelAndView comprarExcursion(@ModelAttribute DatosCompra datosCompra) {
		ModelMap model = new ModelMap();
		String viewName = "";
		
		if(servicioCompra.tieneCupo(datosCompra.getIdExcursion())) {
			servicioCompra.comprar(datosCompra);
			model.put("msg", "Compra Exitosa");
			viewName = "usuarioInicio";
		}else {
			model.put("msg", "Ha ocurrido un error inesperado");
			viewName = "compra-excursion";
		}
		
		return new ModelAndView(viewName, model);
	}

}
