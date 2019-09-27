package server;

import dominio.RepositorioGuardarropas;
import dominio.Usuario;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		//RepositorioGuardarropas.instance().findByUsuario(new Usuario());
		Spark.port(9000);
		Spark.init();
		DebugScreen.enableDebugScreen();
	}

}
