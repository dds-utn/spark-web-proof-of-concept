package pokemon;

import controllers.ControllerHome;
import spark.ResponseTransformer;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {

	public static void configure() {
		//Spark.get("/me", ControllerHome::index);
		HandlebarsTemplateEngine engineTemplate = new HandlebarsTemplateEngine();
		Spark.staticFiles.location("public");
		Spark.get("/me",
				(request, response) -> ControllerHome.index(request, response),
				engineTemplate);
	}

}
