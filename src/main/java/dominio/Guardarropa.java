package dominio;

import java.util.ArrayList;
import java.util.List;

public class Guardarropa {

	private List<Prenda> prendas = new ArrayList<Prenda>();
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Guardarropa(String nombre) {
		this.nombre = nombre;
	}

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}
	
	
}
