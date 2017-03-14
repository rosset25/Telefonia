package gestion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;

import aplicacion.Fechador;
import clientes.Cliente;
import clientes.Tarifa;
import factura_llamada.Factura;
import factura_llamada.Llamada;

public interface OperacionesBDyP extends Generica {
	
	/*Para los clientes*/
	
	public void removeCliente(String DNI);
	public void setTarifaCliente(Cliente cliente, Tarifa tarifa);
	public Cliente getCliente(String DNI);
	public String toStringListaClientes(LinkedList<Cliente> lista);
	public void addCliente(Cliente cliente, String DNI);
	public TreeMap<String, Cliente> getListaClientes();
	
	///////////////////////////////
	
	/*Para las llamadas*/
	
	public void addLlamada(Llamada llamada);
	public TreeMap getListaLlamadas();
	public String toStringListaLlamadas(LinkedList llamadas);
	public void setListaLlamadas(String DNI, LinkedList lista);
	///////////////////////////////////
	
	/*Para las facturas*/
	public TreeMap getListaFacturas(String DNI);
	public Factura getFactura(long ID);
	public void addFactura(Factura f);
	public void setListaFacturas(String DNI, LinkedList lista);

	

	


	

		


	
}
