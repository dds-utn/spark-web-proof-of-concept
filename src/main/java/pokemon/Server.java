package pokemon;

import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Server {
	public static void main(String[] args) {
		Bootstrap.init();

		
	    HandlebarsTemplateEngine engine = 
	    		new HandlebarsTemplateEngine();

		Spark.get("/usuario", (request, response) -> ControllerUsuario.show(request, response), engine);

		Spark.get("/pokemon/:nombre", (request, response) -> 
				"Aca deberia ir un pokemon: " + request.params(":nombre"));
	}
}
