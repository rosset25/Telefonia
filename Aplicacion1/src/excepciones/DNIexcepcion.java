package excepciones;

public class DNIexcepcion extends Exception {
	
	public DNIexcepcion() {
		super("Se ha introducido un DNI err�neo, Introduce 8 d�gitos y una letra");
	}

}
