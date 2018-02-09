package clases.clientes;	//TODO done

import java.io.Serializable;
import java.time.LocalDateTime;

import aplicacion.Fechador;
import clases.Factura;
import clases.Llamada;
import clases.clientes.tarifa.Tarifa;

public abstract class Cliente implements Fechador, Serializable{	//Clase Padre, Abstract (s�lo podemos crear Particulares o Empresas)
	
	private static final long serialVersionUID = 121967387945066632L;
	
	//Atributos
	
	private String DNI;
	private String nombre;
	private Direccion direccion;
	private Tarifa tarifa;
	private String e_mail;
	private LocalDateTime fechaDeAlta; 
	
	//Constructor
	
	public Cliente(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tarifa = tarifa;
		this.e_mail = e_mail;
		this.fechaDeAlta = LocalDateTime.now(); //Asignar la fecha del sistema automaticamente
		
	}
	
	//Interface Fechador---> getFecha()
	
	
	@Override
	public LocalDateTime getFecha() {
		return fechaDeAlta;
	}
	//////////////////
	
	//gets y sets
	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;  
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	//////////////////////////////////////////
	
	//toString()
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("-- CLIENTE --\n");
		sb.append("_____________\n\n");
		sb.append("	Nombre: " + this.nombre + "\n");
		sb.append("	DNI: " + this.DNI + "\n");
		sb.append("	Direcci�n: \n" + this.direccion.toString() + "\n");
		sb.append("	Tarifa: " + this.tarifa.toString() + "\n");
		sb.append("	e-mail: " + this.e_mail + "\n");
		sb.append("	Fecha de alta: " + this.fechaDeAlta.toString() + "\n");
		return sb.toString();
	}
	////////////////////////////////////
	
}
