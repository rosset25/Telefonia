package Fabrica;

import clases.clientes.tarifa.Tarifa;
import menus.MenuTipoTarifa1;
import menus.MenuTipoTarifa2;

public interface FabricaTarifa2 {

	public Tarifa getTipoTarifa(MenuTipoTarifa2 tipoTarifa, Tarifa tarifa, double oferta);

}
