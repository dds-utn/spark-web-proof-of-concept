package server;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class Controller {

	public static ModelAndView convertir(Request req, Response res) {
		int celsius = Integer.parseInt(req.queryParams("celsius"));
		
		int kelvin = new Conversor().convertir(celsius);
		
		Map<String, Object> viewModel = new HashMap<>();
		viewModel.put("celsius", celsius);
		viewModel.put("kelvin", kelvin);
		
		return new ModelAndView(viewModel, "kelvin.hbs");
	}
	
}
