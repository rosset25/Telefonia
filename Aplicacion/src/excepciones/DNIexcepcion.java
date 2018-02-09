package excepciones;

public class DNIexcepcion extends Exception {	
	
	public DNIexcepcion() {
		super("Se ha introducido un DNI err�neo, Introduce dni de longitud 9");
	}

}
