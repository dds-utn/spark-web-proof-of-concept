package pokemon.repositories;

import java.util.LinkedList;
import java.util.List;

import pokemon.model.Usuario;

public class UsuarioRepositorio {

	private List<Usuario> usuarios = new LinkedList<>();
	private static UsuarioRepositorio instance;
	
	public static UsuarioRepositorio get() {
		if (instance == null) {
			instance = new UsuarioRepositorio();
		}
		return instance;
	}
	
	public Usuario findAny() {
		return usuarios.stream().findAny().orElse(null);
	}
	
	public Usuario findByUsername(int username) {
		throw new RuntimeException("findByUsername aun no esta implementado");
	}

	public void registrar(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	
}
