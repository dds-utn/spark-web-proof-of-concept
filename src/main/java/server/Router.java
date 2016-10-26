package server;

import controllers.HomeController;
import controllers.ProyectosController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {

	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.build();

		Spark.staticFiles.location("/public");
		
		
		Spark.get("/", HomeController::home, engine);
		Spark.get("/proyectos", ProyectosController::index, engine);
		Spark.get("/proyectos/:id", ProyectosController::show, engine);
	}

}