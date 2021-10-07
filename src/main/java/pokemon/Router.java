package pokemon;

import com.google.gson.Gson;
import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.Spark;

public class Router {

    public static Router INSTANCE = new Router();


    public void init() {

        UsuarioController controller = new UsuarioController();

        Spark.get("/me", (request, response) -> {
            return controller.me(request, response);
        });

    }
}
