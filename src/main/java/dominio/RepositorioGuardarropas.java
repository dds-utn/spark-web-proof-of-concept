package dominio;

public class RepositorioGuardarropas {

	private static final RepositorioGuardarropas INSTANCE = new RepositorioGuardarropas();

	public static RepositorioGuardarropas instance() {
		return INSTANCE;
	}

	public Guardarropa findByUsuario(Usuario usuario) {
		Guardarropa guardarropas = new Guardarropa("ropa sport");
		guardarropas.getPrendas().add(new Prenda("remera", Color.VERDE));
		guardarropas.getPrendas().add(new Prenda("jean", Color.AZUL));
		return guardarropas;
	}

}
