package pokemon;

import java.util.HashMap;

import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControllerUsuario {
	
	public static ModelAndView show(Request request, Response response) {
		HashMap<String, Object> viewModel = new HashMap<>();
		Usuario usuario = UsuarioRepositorio.get().findAny();
		viewModel.put("usuario", usuario.getUsuario());
		
		return new ModelAndView(viewModel, "usuario.hbs");
	}
}
