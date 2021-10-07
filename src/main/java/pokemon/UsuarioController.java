package pokemon;

import com.google.gson.Gson;
import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.Request;
import spark.Response;

public class UsuarioController {

    public String me(Request request, Response response) {
        Usuario usuario = UsuarioRepositorio.get().findAny();
        response.header("content-type", "application/json");
        return new Gson().toJson(usuario);
    }

}
