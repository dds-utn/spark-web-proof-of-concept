package server;

import java.util.HashMap;
import java.util.Map;

import model.ConversorKelvin;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ConversorController {

	public static ModelAndView showResultado(Request req, Response res) {
		double celsius = Double.parseDouble(req.queryParams("celsius"));
		
		double kelvin = new ConversorKelvin().convertir(celsius);
		
		Map<String, Double> model = new HashMap<>();
		model.put("celsius", celsius);
		model.put("kelvin", kelvin);
		
		return new ModelAndView(model, "showResultado.hbs");
	}
}
