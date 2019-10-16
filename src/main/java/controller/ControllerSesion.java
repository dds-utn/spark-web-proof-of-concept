package controller;

import dominio.Usuarie;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerSesion {
	public ModelAndView mostrarLogin(Request req, Response res) {
		return new ModelAndView(null, "login.hbs");
	}
	
	public ModelAndView crear(Request req, Response res) {
		//Usuarie usuarie = RepositorioUsuaries.buscarPorNombre(req.params("user"))
		//si no existe, lanzar excepción
		Usuarie usuarie = new Usuarie("foo", "foo");
		usuarie.validarContrasenia(req.queryParams("pass"));
		
		
		res.cookie("uid", usuarie.getId().toString());
		
		// redirijan al perfil
		res.redirect("/perfil");
		return null;
	}

}
