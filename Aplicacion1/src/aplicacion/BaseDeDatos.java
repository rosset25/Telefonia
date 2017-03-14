package aplicacion;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import clientes.Cliente;
import clientes.Tarifa;
import factura_llamada.Factura;
import factura_llamada.Llamada;
import gestion.Generica;
import gestion.OperacionesBDyP;

public class BaseDeDatos implements Generica, OperacionesBDyP, Serializable{
	
	//AÑADIR LISTAS, HACER CLASES GENÉRICAS (aparte de la obligatoria la de add cualquier cosa) 
	
	//AÑADIR a los métodos las comprobaciones necesarias
	
	//FALTAN AÃ‘ADIR NUEVOS MÃ‰TODOS
	
	private static final long serialVersionUID = -3974046000202607815L; 
	
	//variables estáticas mejor?
	private TreeMap<String,Cliente> listaClientes;  
	private TreeMap<Long,Factura> listaFacturas;
	private TreeMap<String,LinkedList<Factura>> listaFacturasDeClientes; 
	private TreeMap<String,LinkedList<Llamada>> listaLlamadasDeClientes;
	
	public BaseDeDatos() {
		this.listaClientes = new TreeMap<String,Cliente>(); 
		this.listaFacturas = new TreeMap<Long,Factura>();
		this.listaFacturasDeClientes = new TreeMap<String,LinkedList<Factura>>();
		this.listaLlamadasDeClientes = new TreeMap<String,LinkedList<Llamada>>();
	}
	
	//métodos GENÉRICOS
	
	@Override	//Sacar el período de fechas TODO Hacer excepción, se usará también para saber el período de la factura
	public <U extends Fechador,T> LinkedList recuperarEntreFechas( TreeMap<T,U> lista, LocalDateTime inicio, LocalDateTime fin) {
		LinkedList<U> fechasValidas = new LinkedList<U>();
		LinkedList<U> listaFechasActuales = recuperarLista(lista);
		for(U dato : listaFechasActuales) {
			LocalDateTime fecha = dato.getFecha();
			if( fecha.compareTo(inicio) >= 0 && fecha.compareTo(fin) <= 0) {
				fechasValidas.add(dato);
			}
		}
		
		return fechasValidas;
	}
	
	
	@Override
	public <T> boolean existe(T dato, TreeMap lista) {	
		return lista.containsKey(dato); //Saber si un cliente/Llamada/Factura está o no en la lista
	}	
	
	//Ésta clase servirá para pasar parámetros para hacer una lista que se vaya a imprimir
	//Tal vez cambiar en un futuro a HashSet
	@Override
	public <U extends Fechador,T> LinkedList<U> recuperarLista(TreeMap<T,U> lista) {
		LinkedList<U> listaADevolver = new LinkedList<U>();
		listaADevolver.addAll(lista.values());	
		return listaADevolver; 		
	}
	
	private <T extends Fechador> String toStringLista(T tipo, LinkedList<T> lista) {	 
		StringBuilder sb = new StringBuilder();		//Sólo para uso privado de la clase,
		for (int i=0; i < lista.size(); i++) {		//Construcción de cadena para pasarla al toString 
			tipo = lista.get(i);
			sb.append("\n" + tipo.toString());
		}	
		sb.append("\n\n______________________\n\n\n");
		return sb.toString();
	}	

	
	/*Operaciones CLIENTES*/
	
	
	//Comprobaciones para la inicialización de las listas donde estarán los datos de Llamadas y Facturas
	private void comprobacionesCreacionCliente(String DNI) {
		if (existe(DNI,listaLlamadasDeClientes)) {	// Ver si ese cliente estuvo anteriormente dado de alta
			LinkedList llamadas = new LinkedList();		//Se inicializa lista de llamadas (estará vacía)
			listaLlamadasDeClientes.put(DNI,llamadas); 
		}	
		if ( existe(DNI,listaFacturasDeClientes)) {	//Ver si tenía facturas anteriormente
			LinkedList facturas = new LinkedList();			//Si no las tiene se inicializa una
			listaFacturasDeClientes.put(DNI, facturas);	//lista de facturas (estará vacía) 
		}
	}
	@Override
	public void addCliente(Cliente cliente, String DNI) {
		listaClientes.put(DNI, cliente); //Se comprueba de antes si el cliente 
		comprobacionesCreacionCliente(DNI);
		
	}											

	@Override
	public void removeCliente(String DNI) {
		if (existe(DNI,listaClientes)) {
			listaClientes.remove(DNI);
			/*listaLlamadasDeClientes.remove(DNI);	
			*Hemos optado por no borrar el registro de llamadas de un cliente 
			*(pero no podrá añadir nuevas) 
			*Tampoco sus Facturas, se podrán buscar por el DNI o ID			*/
		}		
	}
	
	@Override
	public void setTarifaCliente(Cliente cliente, Tarifa tarifa) {  
		cliente.setTarifa(tarifa);		//No hace falta especificar que esté en la 
	}									//lista porque ya se le pasa como parámetro
	
	@Override
	public Cliente getCliente(String DNI) {	
		return listaClientes.get(DNI);
	}
	
	@Override
	public TreeMap<String,Cliente> getListaClientes() {
		return this.listaClientes;
	}

	@Override
	public String toStringListaClientes(LinkedList<Cliente> lista) {	//TODO Sustituir por una EXCEPCIÓN seguramente
			
		/*Se pide LinkedList como parámetro, ya que así podremos imprimir cualquier lista de
		 *clientes con la condición que queramos*/
		if (! lista.isEmpty()) {	// <-----TODO EXCEPCIÓN!
			StringBuilder sb = new StringBuilder();
			sb.append("   LISTA CLIENTES:   \n");
			sb.append("______________________\n\n\n");
			Cliente cliente = null;
			sb.append(toStringLista(cliente, lista)); 
			sb.append("\n\n"); 
			return sb.toString();
		}
		return "No hay clientes que mostrar \n\n";
	}
	/*fin de las acciones para clientes*/
	///////////////////////////////////////////////
	
	//Operaciones LLAMADAS
	@Override	
	public void addLlamada(Llamada llamada){  //REVISAR:se puede aÃ±adir directamente addLlamada de Cliente
		String DNI = llamada.getDNI();
		LinkedList lista = listaLlamadasDeClientes.get(DNI);
		lista.add(llamada);
		listaLlamadasDeClientes.put(DNI,lista);
	}
	
	@Override 
	public TreeMap getListaLlamadas() {
		return this.listaLlamadasDeClientes;
	}
	
	@Override
	public String toStringListaLlamadas(LinkedList lista) {	//TODO hacer EXCEPCIÓN si está vacía la lista	
		if (! lista.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("   LISTA LLAMADAS:   \n");
			sb.append("_____________________\n\n\n");
			Llamada llamada = null;
			sb.append(toStringLista(llamada, lista)); 
			sb.append("\n\n"); 
			return sb.toString();
		}
		return "El cliente no tiene llamadas \n\n";
	}
	
	@Override
	public void setListaLlamadas(String DNI, LinkedList lista) {
		this.listaLlamadasDeClientes.put(DNI, lista);
	}
	/*fin de las acciones para llamadas*/
	////////////////////////////////////////
	
	
	/*Operaciones FACTURAS*/
	@Override
	public Factura getFactura(long ID) {
		return listaFacturas.get(ID);	//TODO poner la ID en el validador genérico existe()
	}

	@Override
	public TreeMap getListaFacturas(String DNI) {
		return listaFacturas;
	}
	
	@Override
	public void addFactura(Factura factura) {
		listaFacturas.put(factura.getID(), factura);
		
//		ListaFacuturasDeClientes.put(factura.getDNI(),)
	}

	@Override
	public void setListaFacturas(String DNI, LinkedList lista) {
		
	}

	

	


	
	
}



