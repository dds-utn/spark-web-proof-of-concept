package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.RepositorioProyectos;
import model.Proyecto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ProyectosController{
	
	public static ModelAndView index(Request req, Response res){
		Map<String, List<Proyecto>> model = new HashMap<>();
		List<Proyecto> proyectos = RepositorioProyectos.instancia.listar();
		
		model.put("proyectos", proyectos);
		return new ModelAndView(model, "proyectos/index.hbs");
	}
	
	public static ModelAndView show(Request req, Response res){
		Map<String, String> model = new HashMap<>();
		String id = req.params("id");
		
		model.put("nombre", "Nombre");
		model.put("costo_estimado", "1000");
		model.put("esta_asignado", "No");
		return new ModelAndView(model, "proyectos/show.hbs");
	}
}
