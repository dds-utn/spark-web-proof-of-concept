package server;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
//TODO: ESTO ESTA TODO REPETIDO, ES SOLO UN EJEMPLO DE MUESTRA!!!!! ABSTRAER Y DELEGAR!
public class ConversorController {
	public String otra(Request req, Response res) {
		
		HashMap<String, Object> viewModel = new HashMap();
		viewModel.put("otroDato", "eeeeeeeee");
		ModelAndView modelAndView = new ModelAndView(viewModel, "otra.hbs");
		return new HandlebarsTemplateEngine().render(modelAndView);
		
	}
	
	public String otraConOtroLayout(Request req, Response res) {
		
		HashMap<String, Object> viewModel = new HashMap();
		viewModel.put("otroDato", "eeeeeeeee");
		ModelAndView modelAndView = new ModelAndView(viewModel, "otraConOtroLayout.hbs");
		return new HandlebarsTemplateEngine().render(modelAndView);
		
	}
	
	public String convertirAMillas(Request req, Response res) {
		String km = req.queryParams("km");
		HashMap<String, Object> viewModel = new HashMap();
	
		Boolean hayKilometros = km !=null;
		Double millas = hayKilometros? calcularMillas(km) : 0;
		
		viewModel.put("km", km);
		viewModel.put("hayKilometros", hayKilometros);
		viewModel.put("millas", millas);
		ModelAndView modelAndView = new ModelAndView(viewModel, "conversor.hbs");
		return new HandlebarsTemplateEngine().render(modelAndView);
		
	/*	
		
		if(km == null) {
			return "<html>"+
					"<form method='get' action='/conversor/millas'>"+
						"<input name='km'/>"+
						"<button type='submit'>Convertir!</button>"+
					"</form>"+
				"<html>";
			
		}
		Double kmNumero = Double.parseDouble(km);
		Double millas = new Conversor().convertirAMillas(kmNumero);
		return "<html>"+
		"<form method='get' action='/conversor/millas'>"+
			"<input name='km' value='"+km+"'/>"+
			"<button type='submit'>Convertir!</button>"+
			"millas: "+ millas+
		"</form>"+
		"<html>";
*/
		
		
	}

	private Double calcularMillas(String km) {
		Double kmNumero = Double.parseDouble(km);			
		return new Conversor().convertirAMillas(kmNumero);
	}
}
