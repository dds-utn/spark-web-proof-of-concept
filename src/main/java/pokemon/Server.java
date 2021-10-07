package pokemon;

import com.google.gson.Gson;
import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.Spark;

public class Server {
	public static void main(String[] args) {
		Bootstrap.init();
		Spark.port(9000);
		Router.INSTANCE.init();
		Spark.init();
	}
}
