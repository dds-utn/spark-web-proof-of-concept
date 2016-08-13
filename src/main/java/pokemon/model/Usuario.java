package pokemon.model;

import java.util.LinkedList;
import java.util.List;

public class Usuario {

	private String nombre;
	private String password;

	private List<Captura> capturas = new LinkedList<>();

	public List<Captura> getCapturas() {
		return capturas;
	}

	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void capturar(Pokemon pokemon) {
		this.capturas.add(new Captura(pokemon.getNombre(), pokemon, 10));
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + nombre + ", capturas=" + capturas + "]";
	}

}
