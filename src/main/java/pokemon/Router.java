package pokemon;

import controllers.ControllerHome;
import spark.Spark;

public class Router {

	public static void configure() {
		Spark.get("/", ControllerHome::index);		
	}

}
