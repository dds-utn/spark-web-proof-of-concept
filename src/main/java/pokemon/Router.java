package pokemon;

import controllers.ControllerHome;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {

	public static void configure() {
		HandlebarsTemplateEngine transformer = 
				new HandlebarsTemplateEngine();
		
		Spark.get("/", ControllerHome::index, transformer);		
	}

}
