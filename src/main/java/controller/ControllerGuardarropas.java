package controller;

import dominio.Guardarropa;
import dominio.RepositorioGuardarropas;
import dominio.Usuarie;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerGuardarropas {

	public ModelAndView prendas(Request req, Response res) {
		Guardarropa guardarropas = 
				RepositorioGuardarropas.instance()
				.findByUsuario(new Usuarie("foo", "foo"));
		
		return new ModelAndView(guardarropas, "guardarropas.hbs");
	}

}
