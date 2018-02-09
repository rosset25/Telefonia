package clases.clientes.tarifa;

import java.io.Serializable;
import java.time.LocalTime;

import clases.Llamada;

public class Tarde extends TarifaOferta implements Serializable{	//Hija de TarifaOferta

	private static final long serialVersionUID = -580658514196115906L;

	private LocalTime horaInicio = LocalTime.of(15, 0);
	private LocalTime horaFinal = LocalTime.of(20, 0);
	
	public Tarde(Tarifa original, double oferta) {
		super(original, oferta);
	}
	
	@Override
	public double calcularPrecioLlamada(Llamada llam) {	//Completar
		
		double duracion = llam.getDuracion();
		double tarifaNueva = super.getTarifa()* duracion;
		double tarifaOriginal = super.original.calcularPrecioLlamada(llam);
		LocalTime horaLlam = llam.getFecha().toLocalTime();
		
		if (tarifaNueva < tarifaOriginal && (horaLlam.isAfter(horaInicio) && horaLlam.isBefore(horaFinal))) {
			return tarifaNueva;
		}
		
		return tarifaOriginal;
		
	}
	
//	@Override
//	public double calcularTipoOferta(Llamada llam) {	//Completar
//		
//		LocalTime horaLlam = llam.getFecha().toLocalTime();
//		
//		if ((horaLlam.isAfter(horaInicio) && horaLlam.isBefore(horaFinal))) {
//			if(super.getTarifa() < super.original.calcularTipoOferta(llam))	//comparar oferta y oferta original
//				return super.getTarifa();									//de manera recurrente
//		}
//		
//		return super.original.calcularTipoOferta(llam);
//	}

	
}
