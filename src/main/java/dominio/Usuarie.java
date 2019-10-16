package dominio;

public class Usuarie {

	//NUNCA HAGAN ESTO, ES SOLO A FINES DIDACTICOS
	//NO SE PUEDE GUARDAR UNA PASS DESENCRIPTADA
	//NO SE PUEDE TAMPOCO GUARDARLA ENCRIPTADA
	//HAY QUE GUARDAR UN HASH
	private String password;
	private String nombre; 

	public Usuarie(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public void validarContrasenia(String pass) {
		if(!this.password.equals(pass)) {
			throw new ContraseniaInvalidaException();
		}
	}

	public Long getId() {
		return 1L;
	}
	
	

}
