package dominio;

public class Prenda {
	private String nombre;
	private Color color;

	public Prenda(String nombre, Color color) {
		super();
		this.nombre = nombre;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
