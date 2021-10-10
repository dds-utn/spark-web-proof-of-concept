package pokemon;

import com.github.jknack.handlebars.cache.NullTemplateCache;
import com.github.jknack.handlebars.cache.TemplateCache;
import controllers.ControllerHome;
import spark.ResponseTransformer;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {

	public static void configure() {
		HandlebarsTemplateEngine engineTemplate = new HandlebarsTemplateEngine();

		Spark.staticFiles.location("public");
		Spark.get("/me",
				(request, response) -> ControllerHome.index(request, response),
				engineTemplate);
	}

}
