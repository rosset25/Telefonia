package MVC.modelo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import aplicacion.Fechador;
import clases.Factura;
import clases.Llamada;
import clases.clientes.Cliente;
import clases.clientes.tarifa.Tarifa;
import excepciones.ClienteExcepcion;

public interface Modelo {	//Para relacionar Principal con la BaseDeDatos
	
	/*Para los clientes*/
	
	public void removeCliente(String DNI) throws ClienteExcepcion;
	public void setTarifaCliente(Cliente cliente, Tarifa tarifa);
	public Cliente getCliente(String DNI) throws ClienteExcepcion ;
	public String toStringListaClientes(LinkedList<Cliente> lista);
	public void addCliente(Cliente cliente, String DNI) throws ClienteExcepcion ;
	public HashMap<String, Cliente> getListaClientes();
	
	///////////////////////////////
	
	/*Para las llamadas*/
	
	public void addLlamada(Llamada llamada);
	public HashMap getListaLlamadas();
	public String toStringListaLlamadas(LinkedList llamadas);
	
	///////////////////////////////////
	
	/*Para las facturas*/
	public HashMap getListaFacturasDeClientes();
	public Factura getFactura(long ID);
	public void addFactura(String DNI, LocalDateTime inicio, LocalDateTime fin, Tarifa tarifa);
	public String toStringListaFacturasDeCliente(LinkedList<Factura> facturas);
	public HashMap getListaFacturas();	
	
	///////////////////////////////////
	
	/*Salir*/
	public void salir();
	
}
