package pokemon;

import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;

public class Server {
	public static void main(String[] args) {
		Bootstrap.init();
		
		Usuario usuario = UsuarioRepositorio.get().findAny();
		System.out.println(usuario.toString());
	}
}
