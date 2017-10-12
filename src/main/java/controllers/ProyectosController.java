package controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import db.RepositorioProyectos;
import model.Proyecto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ProyectosController implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView listar(Request req, Response res){
		Map<String, List<Proyecto>> model = new HashMap<>();
		List<Proyecto> proyectos = RepositorioProyectos.instancia.listar();
		
		model.put("proyectos", proyectos);
		return new ModelAndView(model, "proyectos/index.hbs");
	}
	
	public ModelAndView mostrar(Request req, Response res){
		Map<String, Proyecto> model = new HashMap<>();
		String id = req.params("id");
		
		Proyecto proyecto = RepositorioProyectos.instancia.buscar(Long.parseLong(id));
		model.put("proyecto", proyecto);
		return new ModelAndView(model, "proyectos/show.hbs");
	}
	
	public ModelAndView nuevo(Request req, Response res){
		return new ModelAndView(null, "proyectos/new.hbs");
	}
	
	public Void crear(Request req, Response res){
		Proyecto proyectoNuevo = new Proyecto(req.queryParams("nombre"), new BigDecimal(req.queryParams("costoEstimado")));
		withTransaction(() ->{
			RepositorioProyectos.instancia.agregar(proyectoNuevo);
		});
		res.redirect("/proyectos");
		return null;
	}
}
