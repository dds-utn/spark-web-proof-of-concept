package controllers;

import pokemon.repositories.UsuarioRepositorio;
import spark.Request;
import spark.Response;

public class ControllerHome {
	public static String index(Request req, Response res) {
		return "<html> <body> Hola" + UsuarioRepositorio.get().findAny() + " </body></html>";
	}
}
