package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistroImpl;

@Controller
public class ControladorRegistro {
	
	private static ServicioRegistro servicioRegistro;
	
	
	@Autowired
	public ControladorRegistro(ServicioRegistro servicioRegistro) {
		
		this.servicioRegistro = servicioRegistro;
	}
	
	@RequestMapping(path = "/registrarme", method = RequestMethod.GET)
	public ModelAndView registrarme() {
		ModelMap model = new ModelMap();
		model.put("datosRegistro", new DatosRegistro());
		return new ModelAndView("registro-usuario", model);
	}

	@RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST)
	public static ModelAndView registrarUsuario(@ModelAttribute DatosRegistro datosRegistro) {
		ModelMap model = new ModelMap();
		String viewName = "";
		
		if(servicioRegistro.emailValido(datosRegistro) && servicioRegistro.passwordValida(datosRegistro)) {
			servicioRegistro.registrarUsuario(datosRegistro);
			model.put("msg","Registro Exitoso");
			model.put("datosLogin", new DatosLogin(datosRegistro.getEmail()));
			viewName = "login";
		}else {
			model.put("msg","Registro Fallido");
			viewName = "registro-usuario";
		}
		
		return new ModelAndView(viewName, model);
	}

	

}
