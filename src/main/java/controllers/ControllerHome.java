package controllers;

import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerHome {
	public static ModelAndView index(Request req, Response res) {
		Usuario model = UsuarioRepositorio.get().findAny();
		return new ModelAndView(model, "home.hbs");
		//return "<html> <body> Hola" + UsuarioRepositorio.get().findAny() + " </body></html>";
	}
}
