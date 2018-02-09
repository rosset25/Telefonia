package excepciones;

public class ClienteExcepcion extends Exception{
	
	public ClienteExcepcion(){
		super("El cliente no existe");
	}
	
	public ClienteExcepcion(String mensaje) {
		super(mensaje);
	}

}
