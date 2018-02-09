package MVC.controlador;

import java.time.LocalDateTime;
import java.util.Collection;
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
import serializable.CrearSerializable;

public class ControladorClientes implements Controlador1 {
	
	private VistaDatosCliente vcc1;	//vista CrearCliente 1 (datos)
	private VistaDNI vcc2; //vista CrearCliente 2 (DNI)
	private VistaTarifa vt; //vista de PanelTarifa
	private VistaDNI vb; //vista de PanelBorrarCliente
	private VistaDNI vct; //vista de PanelCambiarTarifa 
	
	private Modelo modelo;

	public ControladorClientes() {
		//constructor por defecto
	}
	
	@Override
	public void setVistaPanelCrearCliente(VistaDatosCliente v1, VistaDNI v2) {
		this.vcc1 = v1;
		this.vcc2 = v2;
	}
	
	@Override
	public void setVistaPanelTarifa(VistaTarifa v) {
		this.vt = v;
	}
	
	@Override
	public void setVistaPanelBorrarCliente(VistaDNI v) {
		this.vb = v;
	}
	
	@Override
	public void setVistaCambiarTarifa(VistaDNI v) {
		this.vct = v;
	}
	
	@Override
	public void setModelo(Modelo m) {
		modelo = m;
	}
	
	@Override
	public void removeCliente(String DNI) throws ClienteExcepcion {
		String d = vb.getDNI();
		modelo.removeCliente(DNI);
		System.out.println(d);
	}
	
	@Override
	public Cliente getCliente(String DNI) throws ClienteExcepcion {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cliente> getListaClientes() {
		return modelo.getListaClientes().values();
	}

	@Override
	public void addCliente(int opcionTarifa1, int opcionTarifa2, int tipoCliente) throws ClienteExcepcion {
		Cliente cliente = null;
		String DNI = vcc2.getDNI();
		String nombre = vcc1.getNombre();
		String e_mail = vcc1.getE_mail();
		
		System.out.println(DNI);
		
		String CP = vcc1.getCP();
		String poblacion = vcc1.getPoblacion();
		String provincia = vcc1.getProvincia();
		Direccion direccion = new Direccion(CP, poblacion, provincia);
		
		Tarifa tarifa = crearTarifa(opcionTarifa1,opcionTarifa2);
		
		FabricaClienteEstandar c = new FabricaClienteEstandar();
		FabricaCliente fabrica = c;
	
		switch (tipoCliente) {
		case 0:
			String apellidos = vcc1.getApellidos();
			cliente = fabrica.getParticular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
			break;
		case 1:
			cliente = fabrica.getEmpresa(DNI, nombre, direccion, tarifa, e_mail);
			break;
		}
		
		modelo.addCliente(cliente, DNI);
		
		System.out.println("añadido");
				
	}
	
	@Override
	public void cambiarTarifaCliente(int op1, int op2) throws ClienteExcepcion {
		Tarifa tarifa = crearTarifa(op1,op2);
		modelo.setTarifaCliente(modelo.getCliente(vct.getDNI()), tarifa);
	}
	
	
	public Tarifa crearTarifa(int opcion1, int opcion2) {
		
		Tarifa tarifa = new TarifaBasica(vt.getTarifaBasica());
		FabricaTarifa1 fabrica1 = new FabricaTarifaParametizada1();
		FabricaTarifa2 fabrica2 = new FabricaTarifaParametizada2();
		MenuTipoTarifa1 oferta1 = null;
		MenuTipoTarifa2 oferta2 = null;
		
		//Se podrían llamar a métodos distintos pero meh
		switch (opcion1) {
			case 0:
				tarifa = fabrica1.getTipoTarifa(oferta1.DIA, tarifa, vt.getTarifaOferta1());
				break;
			case 1:
				tarifa = fabrica1.getTipoTarifa(oferta1.TARDE, tarifa, vt.getTarifaOferta1());
				break;
			case 2:
				tarifa = fabrica1.getTipoTarifa(oferta1.NOCHE, tarifa, vt.getTarifaOferta1());
				break;
		}
		
		switch (opcion2) {
			case 0:
				tarifa = fabrica2.getTipoTarifa(oferta2.SABADOS, tarifa, vt.getTarifaOferta2());
				break;
			case 1:
				tarifa = fabrica2.getTipoTarifa(oferta2.DOMINGOS, tarifa, vt.getTarifaOferta2());
		}
		
		return tarifa;
	}

	@Override
	public void salir() {
		modelo.salir();
	}
	
	
//	//TODO COMPLETAR ---> pasar a los respectivos controladores 
//
//	
//
//	@Override
//	public void addLlamada(String DNI) throws ClienteExcepcion {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Llamada> getLlamadas(String DNI) throws ClienteExcepcion {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Factura> getFacturasCliente(String DNI) throws ClienteExcepcion {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Factura getFactura(long ID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void addFactura(String DNI, LocalDateTime inicio, LocalDateTime fin, Tarifa tarifa) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String toStringListaFacturasDeCliente(LinkedList<Factura> facturas) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public HashMap getListaFacturas() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
