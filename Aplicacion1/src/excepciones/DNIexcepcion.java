package excepciones;

public class DNIexcepcion extends Exception {
	
	public DNIexcepcion() {
		super("Se ha introducido un DNI erróneo, Introduce 8 dígitos y una letra");
	}

}
