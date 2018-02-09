package clases.clientes.tarifa;

import java.io.Serializable;

import clases.Llamada;

public abstract class TarifaOferta extends Tarifa implements Serializable{

	private static final long serialVersionUID = -4872059303329082765L;

	protected Tarifa original;
	
	public TarifaOferta(Tarifa original, double oferta) {
		super(oferta);
		this.original = original;
	}

	@Override
	public abstract double calcularPrecioLlamada(Llamada llam);
	
//	@Override
//	public abstract double calcularTipoOferta(Llamada llam);
//	
	@Override
	public String toString(){
		return super.toString();
	}
}
