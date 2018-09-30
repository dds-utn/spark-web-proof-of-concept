package server;

import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Server {
	public static void main(String[] args) {
		Spark.port(9000);
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		
		Spark.get("/saludar", (request, response) -> {
			String persona = request.queryParams("persona");
			return "<html><body><h1>HOLA "+ persona + "!!</h1></body></html>";
		} );
		
		Spark.get("/convertir", Controller::convertir, engine);
		
		Spark.init();
		DebugScreen.enableDebugScreen();
	}

}
