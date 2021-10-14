package pokemon.model;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Captura {

	private String apodo;
	private Pokemon pokemon;
	private int nivel;
	private LocalDateTime fechaCaptura;

	public Captura(String apodo, Pokemon pokemon, int nivel) {
		super();
		this.apodo = apodo;
		this.pokemon = pokemon;
		this.nivel = nivel;
		this.fechaCaptura = LocalDateTime.now();
	}

	public String getApodo() {
		return apodo;
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

	public boolean getNuevo(){ return Period.between(fechaCaptura.toLocalDate(), LocalDate.now()).getDays() <= 1;  }

	@Override
	public String toString() {
		return "PokemonCapturado [nombre=" + apodo + ", pokemon=" + pokemon + ", nivel=" + nivel + ", fechaCaptura="
				+ fechaCaptura + "]";
	}

	public void setFechaDeCaptura(LocalDateTime date) {
		this.fechaCaptura = date;
	}

    public boolean sePareceNombreA(String nombre) {
		return StringUtils.startsWithIgnoreCase(this.apodo, nombre);
    }
}
