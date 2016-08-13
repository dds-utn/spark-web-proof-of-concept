package pokemon;

import static spark.Spark.*;

import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;

public class Server {
	public static void main(String[] args) {
		Bootstrap.init();

		Usuario usuario = UsuarioRepositorio.get().findAny();

		get("/usuario", (req, res) -> usuario.getUsuario());

	}
}
