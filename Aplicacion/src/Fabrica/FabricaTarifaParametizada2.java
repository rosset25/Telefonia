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

public class FabricaTarifaParametizada2 implements FabricaTarifa2, Serializable{

	private static final long serialVersionUID = 4414988954308858413L;
	
	public FabricaTarifaParametizada2() {	//Constructor por defecto
		super();
	}

	@Override
	public Tarifa getTipoTarifa(MenuTipoTarifa2 tipoTarifa, Tarifa tarifa, double oferta) {	
		//la tarifa basica tambien tendria que estar en la fabrica
		switch(tipoTarifa) {
				
			case DOMINGOS:
				tarifa = new Domingos(tarifa, oferta);
				break;
			
			case SABADOS:
				tarifa = new TarifaBasica(0);
				break;
		}
		
		return tarifa;
	}

}
