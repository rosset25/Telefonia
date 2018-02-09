package clases.clientes.tarifa; //TODO done

import java.io.Serializable;

import clases.Llamada;

public abstract class Tarifa implements Serializable{	//Atributo de Cliente y de Factura
														//Tarifa Original
	private static final long serialVersionUID = -8746672059710964569L;
		
	
	//Atributos
	private double eurMin;

	//Constructor
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
	
	//Cálculo del precio (Decorador)
	public double calcularPrecioLlamada(Llamada llam) {
		return eurMin*llam.getDuracion(); 
	}
	
//	public double calcularTipoOferta(Llamada llam) {
//		return eurMin;
//	}
	
	/////////////////////////////////
	
	//toString()
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.eurMin);
		return sb.toString();
	}
	////////////////////////////////

}


