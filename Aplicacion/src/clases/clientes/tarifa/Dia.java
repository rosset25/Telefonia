package clases.clientes.tarifa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import clases.Llamada;

public class Dia extends TarifaOferta implements Serializable{
	
private static final long serialVersionUID = -2748293361638606881L;
	
	private LocalTime horaInicio = LocalTime.of(9, 0);
	private LocalTime horaFinal = LocalTime.of(13, 0);
	
	public Dia(Tarifa original, double oferta) {
		super(original, oferta);
	}
	
	
	@Override
	public double calcularPrecioLlamada(Llamada llam) {	//Completar
		
		double duracion = llam.getDuracion();
		double tarifaNueva = super.getTarifa()*duracion;
		System.out.println("eeeo" + tarifaNueva);
		double tarifaOriginal = super.original.calcularPrecioLlamada(llam);
		LocalTime horaLlam = llam.getFecha().toLocalTime();
		
		if (tarifaNueva < tarifaOriginal && (horaLlam.isAfter(horaInicio) && horaLlam.isBefore(horaFinal))) {
			System.out.println("return" + tarifaNueva);
			return tarifaNueva;
		}
		System.out.println("eeeeooo" + tarifaOriginal);
		return tarifaOriginal;
		
	}
	
	
//	@Override
//	public double calcularTipoOferta(Llamada llam) {
//		
//		LocalTime horaLlam = llam.getFecha().toLocalTime();
//		
//		if (horaLlam.isAfter(horaInicio) && horaLlam.isBefore(horaFinal)) { //Periodo
//			if(super.getTarifa() < super.original.calcularTipoOferta(llam))	//comparar oferta y oferta original
//				return super.getTarifa();									//de manera recurrente
//		}
//		
//		return super.original.calcularTipoOferta(llam);
		
	

}
