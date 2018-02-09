package Fabrica;

import clases.clientes.tarifa.Tarifa;
import menus.MenuTipoTarifa1;
import menus.MenuTipoTarifa2;

public interface FabricaTarifa1 {
	
	public Tarifa getTipoTarifa( MenuTipoTarifa1 tipo, Tarifa tarifaBase, double oferta);

}
