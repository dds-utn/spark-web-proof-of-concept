package pokemon.model;

import java.util.Random;

public class Nivel {
	private static Random rand = new Random();
	
	public static int get() {
		return rand.nextInt(1000);
	}
}
