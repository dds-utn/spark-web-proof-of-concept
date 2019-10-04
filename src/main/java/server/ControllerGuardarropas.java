package server;

import dominio.Guardarropa;
import dominio.RepositorioGuardarropas;
import dominio.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerGuardarropas {

	public ModelAndView prendas(Request req, Response res) {
		Guardarropa guardarropas = 
				RepositorioGuardarropas.instance()
				.findByUsuario(new Usuario());
		
		return new ModelAndView(guardarropas, "guardarropas.hbs");
	}

}
