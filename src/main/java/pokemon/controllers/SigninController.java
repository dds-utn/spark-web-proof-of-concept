package pokemon.controllers;

import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class SigninController {
    public ModelAndView index(Request request, Response response) {
        return new ModelAndView(null, "signin.hbs");
    }

    public ModelAndView post(Request request, Response response) {
        String usuario = request.queryParams("nombre");
        String password = request.queryParams("password");
        Usuario usuarioEncontrado = UsuarioRepositorio.get().findByUsername(usuario);

        if (usuarioEncontrado == null ||
                !usuarioEncontrado.getPassword().equals(password)) {
            return new ModelAndView(null, "signin.hbs");
        }

        response.cookie("usuario_logueado", usuario);
        response.redirect("/capturas");
        return null;
    }
}
