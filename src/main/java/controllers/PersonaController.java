package controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import model.Persona;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class PersonaController {

	public static ModelAndView get(Request req, Response res) {
		Map<String, Object> viewModel = new HashMap<String, Object>();

		viewModel.put("fecha", LocalDate.now());
		viewModel.put("persona", new Persona("Aldi"));
		return new ModelAndView(viewModel, "persona.hbs");
	}
}
