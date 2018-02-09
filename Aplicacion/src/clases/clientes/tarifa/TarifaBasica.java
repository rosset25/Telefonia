package clases.clientes.tarifa;

import java.io.Serializable;

import clases.Llamada;

public class TarifaBasica extends Tarifa implements Serializable{	//Hija de Tarifa
											//Tarifa estándar del cliente, la cual se decorará
	
	private static final long serialVersionUID = 6178062352976637373L;
	
	
	public TarifaBasica(double eurMin) {
		super(eurMin);
	}
	
	/////////////////////////////////
		
	//toString()
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getTarifa());
		return sb.toString();
	}
	////////////////////////////////

	
}
