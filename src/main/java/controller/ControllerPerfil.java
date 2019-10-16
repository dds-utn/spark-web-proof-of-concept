package controller;

import java.util.HashMap;
import java.util.Map;

import dominio.Usuarie;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerPerfil {

	
	public ModelAndView mostrar(Request req, Response res) {
		Map<String, String> model = new HashMap<>();
		String id = req.cookie("uid");
		model.put("id", id);
		return new ModelAndView(model, "perfil.hbs");
	}

}
