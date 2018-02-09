package clientes; //TODO Tarifa done

import java.io.Serializable;
import java.util.Date;

public class Tarifa implements Serializable{	//Atributo de Cliente
	
	private static final long serialVersionUID = -8746672059710964569L;
		
	
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
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.eurMin);
		return sb.toString();
	}
	////////////////////////////////

}


