package gestion.inicio;

import java.io.Serializable;
import java.time.LocalDateTime;

import aplicacion.BaseDeDatos;
import excepciones.ClienteExcepcion;

public class main implements Serializable{

	public static void main(String[] args) throws ClienteExcepcion {
		//main
		
		LocalDateTime pepe = LocalDateTime.now();
		//System.out.println(pepe.getDayOfWeek().getValue());
		
		Inicio inicio = new Inicio();
		inicio.iniciarPrograma();
		
		
	}
	
	
}
