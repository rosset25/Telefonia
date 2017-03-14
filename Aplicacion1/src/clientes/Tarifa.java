package clientes; //TODO Tarifa done

import java.io.Serializable;
import java.util.Date;

public class Tarifa implements Serializable{	//tributo de la clase Cliente
	
	//Atributos
	private double eurMin;
	
	//Constructor por defecto
	public Tarifa(double eurMin) {
		this.eurMin = eurMin;
	}
	//////////////////////////////
	
	//gets y sets
	public double getTarifa() {
		return this.eurMin;
	}
	
	public void setTarifa(double eurMin) {
		this.eurMin = eurMin;
	}
	//////////////////////////////////
	
	//toString()
	public String toStringTarifa() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.eurMin);
		return sb.toString();
	}
	////////////////////////////////

}


