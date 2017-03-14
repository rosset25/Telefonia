package factura_llamada;	//TODO en principio hecho, repasar.... 

import java.io.Serializable;
import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.Date;

import aplicacion.Fechador;
import clientes.Cliente;
import clientes.Tarifa;

public class Factura implements Fechador,Serializable{
	
	//Atributos
	
	private static long codigo_siguiente = 33L; //ID del pr�ximo cliente
	private String DNI;
	private long ID;
	private Tarifa tarifa;
	private double importeTarifa;	// TODO REPASAR importe Tarifa
	private LocalDateTime fechaEmision;
	private LocalDateTime inicio;	//Per�odo	
	private LocalDateTime fin; 		//Per�odo
	
	

	//Constructor
	
	public Factura(Cliente cliente, LocalDateTime inicio, LocalDateTime fin, double importeTarifa) {
		this.ID = codigo_siguiente; //no se repetir� nunca, 
		codigo_siguiente++; //se a�adir� +1, as� la siguiente factura tendr� siempre un ID distinto
		this.DNI = cliente.getDNI();
		this.fechaEmision = LocalDateTime.now();
		this.importeTarifa = importeTarifa;  //Se realizar� la operaci�n para obtenerla de antemano
		//Per�odo
		this.inicio = inicio;
		this.fin=fin;
	}
	////////////////////////////

	//Interface Fechador---> getFecha()
	@Override
	public LocalDateTime getFecha() {	//Mostrar fecha de emisión		
		return fechaEmision;
	}
	/////////////////////////

	//gets (en principio ning�n atributo podr� cambiarse)
	public Long getID() {	
		return this.ID;
	}

	public String getDNI() {	
		return this.DNI;
	}
	
	public Tarifa getTarifa() {	
		return tarifa;
	}

	public double getImporteTarifa() {	
		return importeTarifa;
	}

	public LocalDateTime getFechaEmision() {	
		return fechaEmision;
	}

	public LocalDateTime getInicio() {	
		return inicio;
	}

	public LocalDateTime getFin() {		
		return fin;
	}
	//////////////////////////////////////////////
	
	//toString()
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-- FACTURA --\n");
		sb.append("_____________\n\n");
		sb.append("	ID: " + this.ID + "\n");
		sb.append("	DNI del Cliente: " + this.DNI + "\n");
		sb.append("	Tarifa: " + this.tarifa.toString() + "\n");
		sb.append("	Importe de la tarifa: " + this.importeTarifa + "\n");
		sb.append("	Fecha de emisi�n: " + this.fechaEmision.toString() + "\n");
		sb.append("	Per�odo: " + this.fin.toString() + " - " + this.inicio.toString() + "\n");		
		return sb.toString();
	}
	///////////////////////////////////////

}
