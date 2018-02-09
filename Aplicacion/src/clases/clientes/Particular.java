package clases.clientes;

import clases.clientes.tarifa.Tarifa;

public class Particular extends Cliente{	//Clase Hijo
	
	private static final long serialVersionUID = 6170137852616540159L;
	
	//Atributos
	
	private String apellidos;	//s�lo un atributo m�s que Cliente
	
	//Constructor	 
	
	public Particular(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail, String apellidos) {
		super(DNI, nombre, direccion, tarifa, e_mail);
		this.apellidos = apellidos;
	}
	//////////////////////////////////
	
	//gets y sets
	public String getApellidos() {
		return this.apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	////////////////////////////////

	
	//toString()
	@Override
	public String toString() {					//cambiamos toString() porque lo l�gico es que 
		StringBuilder sb = new StringBuilder();	//los apellidos est�n despu�s del nombre
		sb.append("-- CLIENTE --\n");
		sb.append("_____________\n\n");
		sb.append("	Nombre: " + this.getNombre() + "\n");
		sb.append("	Apellidos: " + this.apellidos + "\n");
		sb.append("	DNI: " + this.getDNI() + "\n");
		sb.append("	Direcci�n: \n" + this.getDireccion().toString() + "\n");
		sb.append("	Tarifa: " + this.getTarifa().toString() + "\n");
		sb.append("	e-mail: " + this.getE_mail() + "\n");
		sb.append("	Fecha de alta: " + getFecha().toString() + "\n");
		return sb.toString();
	}
	//////////////////////////////////
}
