package MVC.controlador;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Fabrica.FabricaTarifa1;
import Fabrica.FabricaTarifa2;
import Fabrica.FabricaTarifaParametizada1;
import Fabrica.FabricaTarifaParametizada2;
import Fabrica.FabricaCliente;
import Fabrica.FabricaClienteEstandar;

import MVC.modelo.Modelo;
import MVC.vista.panelClientes.VistaDNI;
import MVC.vista.panelClientes.VistaDatosCliente;
import MVC.vista.panelClientes.VistaTarifa;
import clases.Factura;
import clases.Llamada;
import clases.clientes.Cliente;
import clases.clientes.Direccion;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import excepciones.ClienteExcepcion;
import menus.MenuTipoTarifa1;
import menus.MenuTipoTarifa2;

public class ControladorLlamadas implements Controlador2 {
	
	private Modelo modelo;

	public ControladorLlamadas() {
		//constructor por defecto
	}
	
	
	@Override
	public void setModelo(Modelo m) {
		modelo = m;
	}
	
	//TODO implementar los métodos de Llamadas

	
}
