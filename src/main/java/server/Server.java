package server;

import spark.Spark;
import spark.debug.DebugScreen;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Server {
	public static void main(String[] args) {
		new Bootstrap().init();
		Spark.port(9000);
		DebugScreen.enableDebugScreen();
		Router.configure();
	}

}
