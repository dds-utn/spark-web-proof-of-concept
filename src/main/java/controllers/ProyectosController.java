package controllers;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ProyectosController {
	
	public static ModelAndView index(Request req, Response res){
		Map<String, Double> model = new HashMap<>();
		
		return new ModelAndView(model, "proyectos/index.hbs");
	}
	
	public static ModelAndView show(Request req, Response res){
		Map<String, String> model = new HashMap<>();
		String id = req.params("id");
		
		model.put("id", id);
		return new ModelAndView(model, "proyectos/show.hbs");
	}
}
