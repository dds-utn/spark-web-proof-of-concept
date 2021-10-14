package pokemon;

import pokemon.controllers.CapturasController;
import pokemon.controllers.PerfilController;
import pokemon.controllers.SigninController;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {

	public static void configure() {
		HandlebarsTemplateEngine engineTemplate = new HandlebarsTemplateEngine();
		CapturasController capturasController = new CapturasController();
		PerfilController perfilController = new PerfilController();
		SigninController signinController = new SigninController();

		DebugScreen.enableDebugScreen();

		Spark.staticFiles.location("public");
		Spark.get("/capturas",
				(request, response) -> capturasController.index(request, response),
				engineTemplate);
		Spark.get("/perfil", perfilController::index, engineTemplate);


		Spark.get("/signin", signinController::index, engineTemplate);
		Spark.post("/signin", signinController::post, engineTemplate);
	}

}
