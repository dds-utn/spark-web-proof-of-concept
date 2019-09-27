package dominio;

import java.util.List;

public class Guardarropa {

	private List<Prenda> prendas;
	private String nombre;

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
