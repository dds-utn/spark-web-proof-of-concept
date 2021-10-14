package pokemon.controllers;

import pokemon.repositories.UsuarioRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class PerfilController {
    public ModelAndView index(Request request, Response response) {
        return new ModelAndView(UsuarioRepositorio.get().findByUsername(request.cookie("usuario_logueado")), "perfil.hbs");
    }
}
