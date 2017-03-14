package factura_llamada;	// TODO done

import java.util.Date;

import aplicacion.Fechador;
import clientes.Cliente;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Llamada implements Fechador,Serializable{	
	
	private static final long serialVersionUID = 8405567765807015478L;
	
	//Atributos
	private String telefono;
	private double duracion; 
	private LocalDateTime fechaLlamada; 
	private String DNI;
	
	//Constructor
	public Llamada(String DNI, String telefono, double duracion) {
		this.telefono = telefono;
		this.duracion = duracion;
		this.fechaLlamada = LocalDateTime.now();
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

	public double getDuracion() {	//no se puede modificar la duraciÃ³n
		return duracion;
	}
	//////////////////////////////////////////
	
	//toString()
	public String toStringLlamada() {
		StringBuilder sb = new StringBuilder();
		sb.append("-- LLAMADA --\n");
		sb.append("_____________\n\n");
		sb.append("	DNI del cliente: " + this.DNI + "\n");
		sb.append("	Teléfono que realizó la llamada: " + this.telefono + "\n");
		sb.append("	Fecha y hora de la llamada: " + this.fechaLlamada.toString() + "\n");
		sb.append("	Duración: " + this.duracion + "\n");		
		return sb.toString();
	}
	//////////////////////////////////

}
