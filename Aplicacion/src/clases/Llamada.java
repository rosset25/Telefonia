package clases;	// TODO done

import java.io.Serializable;
import java.time.LocalDateTime;

import aplicacion.Fechador;
import clases.clientes.Cliente;

public class Llamada implements Fechador,Serializable{	
	
	private static final long serialVersionUID = 8405567765807015478L;
	
	//Atributos
	private String telefono;
	private double duracion; 
	private LocalDateTime fechaLlamada; 
	private String DNI;
	
	//Constructor
	public Llamada(String DNI, String telefono, double duracion, LocalDateTime fechaLlamada) {
		this.telefono = telefono;
		this.duracion = duracion;
		this.fechaLlamada = fechaLlamada;
		this.DNI = DNI;
	}
	///////////////////////////////
	
	//Interface Fechador ---> getFecha()
	@Override
	public LocalDateTime getFecha() {
		return fechaLlamada;
	}
	////////////////////////////
		
	
	//gets y sets
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDNI() {
		return this.DNI;
	}

	public double getDuracion() {	//no se puede modificar la duración
		return duracion;
	}
	//////////////////////////////////////////
	
	//toString()
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-- LLAMADA --\n");
		sb.append("_____________\n\n");
		sb.append("	DNI del cliente: " + this.DNI + "\n");
		sb.append("	Tel�fono que realiz� la llamada: " + this.telefono + "\n");
		sb.append("	Fecha y hora de la llamada: " + this.fechaLlamada.toString() + "\n");
		sb.append("	Duraci�n: " + this.duracion + " minutos" + "\n");		
		return sb.toString();
	}
	//////////////////////////////////

}
