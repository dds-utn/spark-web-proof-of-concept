package server;

import static spark.Spark.get;
import static spark.Spark.init;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import controller.ControllerGuardarropas;
import controller.ControllerPerfil;
import controller.ControllerSesion;
import dominio.Guardarropa;
import dominio.RepositorioGuardarropas;
import spark.ModelAndView;
import spark.Spark;
import spark.TemplateEngine;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Server {
	public static void main(String[] args) {
		//RepositorioGuardarropas.instance().findByUsuario(new Usuario());
		port(9000);
		staticFileLocation("/public");
		init();
		TemplateEngine engine = new HandlebarsTemplateEngine();

		ControllerGuardarropas controllerGuardarropas = new ControllerGuardarropas();
		ControllerSesion controllerSesion = new ControllerSesion();
		ControllerPerfil controllerPerfil = new ControllerPerfil();

		get("/guardarropa/prendas", controllerGuardarropas::prendas, engine);
		get("/login", controllerSesion::mostrarLogin, engine);
		post("/login", controllerSesion::crear, engine);
		get("/perfil", controllerPerfil::mostrar, engine);
		DebugScreen.enableDebugScreen();
	}

}