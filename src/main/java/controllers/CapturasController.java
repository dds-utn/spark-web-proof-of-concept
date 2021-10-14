package controllers;

import pokemon.model.Captura;
import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CapturasController {
	public ModelAndView index(Request req, Response res) {
		String filtroParametro = req.queryParams("likeNombre");

		Usuario usuario = UsuarioRepositorio.get().findAny();
		Map<String, Object> model = new HashMap<>();
		//List<Captura> capturas = filtro == null ? usuario.getCapturas() : usuario.filtrarPorNombre(filtro);
		List<Captura> capturas = Optional.ofNullable(filtroParametro)
				.map(filtro -> usuario.filtrarPorNombre(filtro))
				.orElseGet(() -> usuario.getCapturas());

		model.put("likeNombre", filtroParametro);
		model.put("usuario", usuario);
		model.put("capturas", capturas);

		return new ModelAndView(model, "home.hbs");
		//return "<html> <body> Hola" + UsuarioRepositorio.get().findAny() + " </body></html>";
	}
}
