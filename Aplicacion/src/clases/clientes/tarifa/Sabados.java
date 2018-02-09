package clases.clientes.tarifa;

import java.io.Serializable;

import clases.Llamada;	

public class Sabados extends TarifaOferta implements Serializable{	//Hija de TarifaOferta
	
	private static final long serialVersionUID = -6385657894457878642L;

	public Sabados(Tarifa original, double oferta) {
		super(original, oferta);
	}
	
	@Override
	public double calcularPrecioLlamada(Llamada llam) {	//Completar
		
		double duracion = llam.getDuracion();
		double tarifaNueva = super.getTarifa()*duracion;
		System.out.println("eeeo" + tarifaNueva);
		double tarifaOriginal = super.original.calcularPrecioLlamada(llam);	//TODO COMPROBAR
		
		if ((llam.getFecha().getDayOfWeek().name() == "SATURDAY") && tarifaNueva < tarifaOriginal) {
			System.out.println(tarifaNueva);
			return tarifaNueva;
		}
		System.out.println("eeeo" + tarifaOriginal);
		return tarifaOriginal;
		
	}
	
//	@Override
//	public double calcularTipoOferta(Llamada llam) {	//Completar
//		System.out.println(llam.getFecha().getDayOfWeek().name());
//		if ((llam.getFecha().getDayOfWeek().name() == "SATURDAY")) {
//			if(super.getTarifa() < super.original.calcularTipoOferta(llam))	//comparar oferta y oferta original
//				return super.getTarifa();									//de manera recurrente
//		}
//		
//		return super.original.calcularTipoOferta(llam);
//	}

}
