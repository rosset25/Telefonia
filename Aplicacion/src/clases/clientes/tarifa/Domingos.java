package clases.clientes.tarifa;

import java.io.Serializable;
import aplicacion.Fechador;
import clases.Llamada;		//Hija de TarifaOferta

public class Domingos extends TarifaOferta implements Serializable{	//Esta oferta es igual que la de los Domingos, 
											//pero podría no serlo, por ello está separada

	private static final long serialVersionUID = -6022032736447775267L;

	public Domingos(Tarifa original, double oferta) {
		super(original, oferta);
	}
	
	@Override
	public double calcularPrecioLlamada(Llamada llam) {	//Completar
		
		double duracion = llam.getDuracion();
		double tarifaNueva = super.getTarifa()*duracion;
		double tarifaOriginal = super.original.calcularPrecioLlamada(llam);	//TODO COMPROBAR
		
		if ((llam.getFecha().getDayOfWeek().name() == "SUNDAY") && tarifaNueva < tarifaOriginal) {
			return tarifaNueva;
		}
		
		return tarifaOriginal;
		
	}
	
//	@Override
//	public double calcularTipoOferta(Llamada llam) {	
//		
//		if ((llam.getFecha().getDayOfWeek().name() == "SUNDAY")) {
//			if(super.getTarifa() < super.original.calcularTipoOferta(llam))	//comparar oferta y oferta original
//				return super.getTarifa();									//de manera recurrente
//		}
//		
//		return super.original.calcularTipoOferta(llam);
//	}

}
