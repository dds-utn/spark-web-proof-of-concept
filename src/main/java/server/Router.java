package server;

import spark.Spark;

public class Router {
	static Router _instance;
	private Router() {
		
	}
	
	public static Router instance() {
		if(_instance == null) {
			_instance = new Router();
		}
		return _instance;
	}
	
	
	public void configurar() {
		Spark.staticFileLocation("/public");

		ConversorController controller = new ConversorController();
		Spark.get("/conversor/millas", controller::convertirAMillas);
		Spark.get("/otra", controller::otra);
		Spark.get("/otraConOtroLayout", controller::otraConOtroLayout);

		
	}

}








