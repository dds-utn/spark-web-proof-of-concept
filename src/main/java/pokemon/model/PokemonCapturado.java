package pokemon.model;

import java.time.LocalDateTime;

public class PokemonCapturado {

	private String nombre;
	private Pokemon pokemon;
	private int nivel;
	private LocalDateTime fechaCaptura;

	public PokemonCapturado(String nombre, Pokemon pokemon, int nivel) {
		super();
		this.nombre = nombre;
		this.pokemon = pokemon;
		this.nivel = nivel;
		this.fechaCaptura = LocalDateTime.now();
	}

	public String getNombre() {
		return nombre;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public int getNivel() {
		return nivel;
	}

	public LocalDateTime getFechaCaptura() {
		return fechaCaptura;
	}

	@Override
	public String toString() {
		return "PokemonCapturado [nombre=" + nombre + ", pokemon=" + pokemon + ", nivel=" + nivel + ", fechaCaptura="
				+ fechaCaptura + "]";
	}

}
