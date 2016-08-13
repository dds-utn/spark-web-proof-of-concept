package pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pokemon.model.Pokemon;
import pokemon.model.TipoPokemon;
import pokemon.model.Usuario;
import pokemon.repositories.UsuarioRepositorio;

public class Bootstrap {
	public static void init() {
		List<Usuario> usuarios = usuarios();
		usuarios.forEach((usuario) -> UsuarioRepositorio.get().registrar(usuario));
		
		List<Pokemon> pokemons = pokemons();
		
		Usuario gaston = usuarios.get(0);
		pokemons.stream().limit(4).forEach((pokemon) -> gaston.capturar(pokemon));
		
	}

	private static List<Pokemon> pokemons() {
		Pokemon golduck = new Pokemon(TipoPokemon.AGUA, "Golduck", null)
				.agregarFoto("http://vignette4.wikia.nocookie.net/pokemon/images/0/04/055Golduck_Dream.png/revision/latest?cb=20140828004434")
				.agregarFoto("http://vignette1.wikia.nocookie.net/pokemon/images/a/a1/Trinity_Golduck.png/revision/latest?cb=20151007060107");
		Pokemon charizard = new Pokemon(TipoPokemon.FUEGO, "Charizard", null)
				.agregarFoto("http://www.buldumbuldum.com/kisiye_ozel_resimleri/1717cf48ce924b4280e04e2d21b0ccdb.png")
				.agregarFoto("http://pre13.deviantart.net/4d21/th/pre/i/2015/084/3/4/006_charizard_by_sarahrichford-d8jh1hy.png")
				.agregarFoto("http://static.srcdn.com/wp-content/uploads/Charizard-flying.jpg");
		Pokemon charmeleon = new Pokemon(TipoPokemon.FUEGO, "Charmeleon", charizard)
				.agregarFoto("http://cdn.bulbagarden.net/upload/thumb/4/4a/005Charmeleon.png/250px-005Charmeleon.png");
		
		List<Pokemon> pokemons = Arrays.asList(
				new Pokemon(TipoPokemon.FUEGO, "Charmander", charmeleon)
					.agregarFoto("http://cdn.bulbagarden.net/upload/thumb/7/73/004Charmander.png/250px-004Charmander.png"), 
				new Pokemon(TipoPokemon.AGUA, "Psyduck", golduck)
					.agregarFoto("http://vignette1.wikia.nocookie.net/pokemon/images/e/e2/054Psyduck_Pokemon_Mystery_Dungeon_Red_and_Blue_Rescue_Teams.png/revision/latest?cb=20150106002458"), 
				new Pokemon(TipoPokemon.NORMAL, "Snorlax", null)
					.agregarFoto("http://cdn.bulbagarden.net/upload/thumb/f/fb/143Snorlax.png/250px-143Snorlax.png"),
				new Pokemon(TipoPokemon.HADA, "Dedenne", null)
					.agregarFoto("http://vignette2.wikia.nocookie.net/pokemon/images/a/ad/Dedenne_702_XY_AnimeArt.png/revision/latest?cb=20140830063922"),
				new Pokemon(TipoPokemon.PSIQUICO, "Mew", null));
		
		pokemons.stream().collect(Collectors.toList()).addAll(Arrays.asList(golduck, charizard, charmeleon));
		
		return pokemons;
	}

	private static List<Usuario> usuarios() {
		return Arrays.asList(new Usuario("gaston", "gaston"),
		new Usuario("lucas", "lucas"));
	}
}
