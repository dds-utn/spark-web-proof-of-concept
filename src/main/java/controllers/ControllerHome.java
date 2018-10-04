package controllers;

import java.util.HashMap;
import java.util.List;

import com.google.common.base.Optional;

import pokemon.model.Captura;
import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerHome {
	public static ModelAndView index(Request req, Response res) {
		Usuario user = UsuarioRepositorio.get().findAny();

		String apodo = req.queryParams("apodo");
		List<Captura> capturas = 
				Optional.fromNullable(apodo)
				.transform(it -> user.findByApodo(it))
				.or(user.getCapturas());
		
		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("apodo", apodo);
		viewModel.put("capturas", capturas);
		
		return new ModelAndView(
				viewModel, 
				"index.hbs");
	}
}
