package pokemon;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
		gaston.getCapturas().get(0).setFechaDeCaptura(LocalDateTime.now().minus(10, ChronoUnit.DAYS));

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
					.agregarFoto("https://www.pikpng.com/pngl/b/125-1255087_png-library-stock-retro-rewind-pinterest-cultura-pop.png"),
				new Pokemon(TipoPokemon.AGUA, "Psyduck", golduck)
					.agregarFoto("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/c7bca634-434f-4d30-8394-513ca6421852/ddtd2kg-8796ad91-e7c4-49b4-8225-08d1197d47c6.png/v1/fill/w_800,h_800,strp/chibidex___054_psyduck_by_seviyummy_ddtd2kg-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9ODAwIiwicGF0aCI6IlwvZlwvYzdiY2E2MzQtNDM0Zi00ZDMwLTgzOTQtNTEzY2E2NDIxODUyXC9kZHRkMmtnLTg3OTZhZDkxLWU3YzQtNDliNC04MjI1LTA4ZDExOTdkNDdjNi5wbmciLCJ3aWR0aCI6Ijw9ODAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.zV-KzO0r7YOoa8wWjXWp8XOtLvxUW0pF5bOSsmPHjhI"),
				new Pokemon(TipoPokemon.NORMAL, "Snorlax", null)
					.agregarFoto("https://i.pinimg.com/originals/fd/f5/62/fdf562aa3afef2367940aaaf4224220d.jpg"),
				new Pokemon(TipoPokemon.HADA, "Dedenne", null)
					.agregarFoto("https://d.furaffinity.net/art/huiro/1421855255/1421855255.huiro_%E7%94%B5%E5%A5%B6%E5%A5%B6.png"),
				new Pokemon(TipoPokemon.PSIQUICO, "Mew", null));
		
		pokemons.stream().collect(Collectors.toList()).addAll(Arrays.asList(golduck, charizard, charmeleon));
		
		return pokemons;
	}

	private static List<Usuario> usuarios() {
		return Arrays.asList(new Usuario("gaston", "gaston"),
		new Usuario("lucas", "lucas"));
	}
}
