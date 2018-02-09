package Fabrica;

import java.io.Serializable;

import clases.clientes.tarifa.Dia;
import clases.clientes.tarifa.Domingos;
import clases.clientes.tarifa.Sabados;
import clases.clientes.tarifa.Tarde;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import menus.MenuTipoTarifa1;
import menus.MenuTipoTarifa2;

public class FabricaTarifaParametizada1 implements FabricaTarifa1, Serializable{

	private static final long serialVersionUID = 4414988954308858413L;
	
	public FabricaTarifaParametizada1() {	//Constructor por defecto
		super();
	}

	@Override
	public Tarifa getTipoTarifa(MenuTipoTarifa1 tipoTarifa, Tarifa tarifa, double oferta) {	
		//la tarifa basica tambien tendria que estar en la fabrica
		switch(tipoTarifa) {
		
			case DIA:
				tarifa = new Dia(tarifa, oferta);
				break;
				
			case TARDE:
				tarifa = new Tarde(tarifa, oferta);
				break;
				
			case NOCHE:
				tarifa = new Sabados(tarifa, oferta);
				break;
		}
		
		return tarifa;
	}
}
