package pokemon.model;

import java.util.LinkedList;
import java.util.List;

public class Usuario {

	private String usuario;
	private String password;

	private List<PokemonCapturado> pokemonsCapturados = new LinkedList<>();

	public List<PokemonCapturado> getPokemonsCapturados() {
		return pokemonsCapturados;
	}

	public Usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void atrapar(Pokemon pokemon) {
		this.pokemonsCapturados.add(new PokemonCapturado(pokemon.getNombre(), pokemon, Nivel.get()));
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", pokemonsCapturados=" + pokemonsCapturados + "]";
	}

}
