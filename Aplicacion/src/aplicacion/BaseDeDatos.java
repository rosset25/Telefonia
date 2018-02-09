package aplicacion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

//import MVC.modelo.Generica;
import MVC.modelo.Modelo;
import clases.Factura;
import clases.Llamada;
import clases.clientes.Cliente;
import clases.clientes.tarifa.Tarifa;
import excepciones.ClienteExcepcion;
import excepciones.FechaExcepcion;
import serializable.CrearSerializable;

public class BaseDeDatos implements Modelo, Serializable {
	
	private static final long serialVersionUID = -3974046000202607815L; 
	
	//TODO Tal vez cambiar en un futuro de LinkedList a HashSet
	
	//Atributos
	private HashMap<String,Cliente> listaClientes =  new HashMap<String,Cliente>();  
	private HashMap<Long,Factura> listaFacturas = new HashMap<Long,Factura>();
	private HashMap<String, LinkedList<Factura>> listaFacturasDeClientes = new HashMap<String,LinkedList<Factura>>(); 
	private HashMap<String,LinkedList<Llamada>> listaLlamadasDeClientes = new HashMap<String,LinkedList<Llamada>>();
	
	//Constructor
	public BaseDeDatos() {
//		this.listaClientes = 
//		this.listaFacturas = 
//		this.listaFacturasDeClientes = ;
//		this.listaLlamadasDeClientes =;
	}
	
	//m�todos GEN�RICOS
	
//	__________________________________________________________________
//	No hace falta pero se deja por si acaso....
//	@Override
//	public <T> boolean existe(T dato, TreeMap lista) {	
//		return lista.containsKey(dato); //Saber si un cliente/Llamada/Factura est� o no en la lista
//	}	
//	______________________________________________________________________
	
	//Estos m�todos servir�n para pasar par�metros y hacer una lista que se vaya a imprimir 
	//ESTA LISTA si que se va a usar para transformar Map en List
//	@Override
//	public <U extends Fechador> LinkedList<U> recuperarLista(Map lista) { //Para ListaClientes y ListaFacturas
//		LinkedList<U> listaADevolver = new LinkedList<U>();
//		listaADevolver.addAll(lista.values());	
//		return listaADevolver; 		
//	}
//	
//	@Override
//	public <V extends Fechador,T,U> LinkedList<V> recuperarListaDeLista(T dato,HashMap<T,U> lista) {	//Para el resto
//		LinkedList<V> listaDeLista = (LinkedList<V>) lista.get(dato);
//		return listaDeLista;
//	}
	
	//Para toString() de las listas
	private <T extends Fechador> String toStringLista(Collection<T> lista) {
		StringBuilder sb = new StringBuilder();		//S�lo para uso privado de la clase,
		for (int i=0; i < lista.size(); i++) {		//Construcci�n de cadena para pasarla al toString 
			T tipo = ((LinkedList<T>) lista).get(i);
			sb.append("\n" + tipo.toString());
		}	
		sb.append("\n\n______________________\n\n\n");
		return sb.toString();
	}	
///////////////////////////////////////////////////////
	
	//Operaciones CLIENTES	
	
	//Comprobaciones para la inicializaci�n de las listas donde estar�n los datos de Llamadas y Facturas
	private void comprobacionesCreacionCliente(String DNI) {
		if (! listaLlamadasDeClientes.containsKey(DNI)) {	// Ver si ese cliente estuvo anteriormente dado de alta
			LinkedList llamadas = new LinkedList();		//Se inicializa lista de llamadas (estar� vac�a)
			listaLlamadasDeClientes.put(DNI,llamadas); 
		}	
		if (! listaFacturasDeClientes.containsKey(DNI)) {	//Ver si ten�a facturas anteriormente
			LinkedList facturas = new LinkedList();			//Si no las tiene se inicializa una
			listaFacturasDeClientes.put(DNI, facturas);	//lista de facturas (estar� vac�a) 
		}
	}
	
	@Override
	public void addCliente(Cliente cliente, String DNI) throws ClienteExcepcion {
		listaClientes.hashCode();
		if( listaClientes.containsKey(DNI)) {
			throw new ClienteExcepcion("El cliente con DNI " + DNI + " ya esta registrado"); // cliente ya existente
		}
		
		listaClientes.put(DNI, cliente); //Se comprueba de antes si el cliente 
		comprobacionesCreacionCliente(DNI);		
	}											

	@Override
	public void removeCliente(String DNI) {
		if (listaClientes.containsKey(DNI)) {
			listaClientes.remove(DNI);
			/*listaLlamadasDeClientes.remove(DNI);	
			 *Hemos optado por no borrar el registro de llamadas de un cliente, 
			 *pero no podr� a�adir nuevas
			 *Tampoco a�adir� nuevas Facturas, se podr�n buscar por el DNI o ID	*/
		}		
	}
	
	@Override
	public void setTarifaCliente(Cliente cliente, Tarifa tarifa)  {  
		cliente.setTarifa(tarifa);		//No hace falta especificar que est� en la 
	}									//lista porque ya se le pasa como par�metro
	
	@Override
	public Cliente getCliente(String DNI) throws ClienteExcepcion {	
		Cliente cliente = listaClientes.get(DNI);
		if(cliente == null) {
			throw new ClienteExcepcion("El cliente con DNI " + DNI + " no existe"); // cliente ya existente
		}
		return cliente;
	}
	
	@Override
	public HashMap<String,Cliente> getListaClientes() {
		return this.listaClientes;
	}

	@Override
	public String toStringListaClientes(LinkedList<Cliente> lista) {
			
		/*Se pide LinkedList como par�metro, ya que as� podremos imprimir cualquier lista de
		 *clientes con la condici�n que queramos*/
		if (! lista.isEmpty()) {	
			StringBuilder sb = new StringBuilder();
			sb.append("   LISTA CLIENTES:   \n");
			sb.append("______________________\n\n\n");
			Cliente cliente = null;
			sb.append(toStringLista(lista)); 
			sb.append("\n\n"); 
			return sb.toString();
		}
		return "No hay clientes que mostrar \n\n";
	}
	//fin de las acciones para clientes
	///////////////////////////////////////////////
	
	//Operaciones LLAMADAS
	@Override	
	public void addLlamada(Llamada llamada){  //REVISAR:se puede añadir directamente addLlamada de Cliente
		String DNI = llamada.getDNI();
		LinkedList lista = listaLlamadasDeClientes.get(DNI);
		lista.add(llamada);
		listaLlamadasDeClientes.put(DNI,lista);
	}

	@Override 
	public HashMap getListaLlamadas() {
		return this.listaLlamadasDeClientes;
	}
	
	@Override
	public String toStringListaLlamadas(LinkedList lista) {	
		if (! lista.isEmpty()) {	
			StringBuilder sb = new StringBuilder();
			sb.append("   LISTA LLAMADAS:   \n");
			sb.append("_____________________\n\n\n");
			sb.append(toStringLista(lista)); 
			sb.append("\n\n"); 
			return sb.toString();
		}
		return "El cliente no tiene llamadas \n\n";
	}
	
	private void setListaLlamadas(String DNI, LinkedList lista) {
		this.listaLlamadasDeClientes.put(DNI, lista);
	}
	/*fin de las acciones para llamadas*/
	////////////////////////////////////////
	
	
	/*Operaciones FACTURAS*/
	@Override
	public Factura getFactura(long ID) {
		return listaFacturas.get(ID);	
	}

	@Override
	public HashMap getListaFacturasDeClientes() {
		return listaFacturasDeClientes;
	}

	@Override
	public HashMap getListaFacturas() {
		return this.listaFacturas;
	}
	
	@Override
	public void addFactura(String DNI, LocalDateTime inicio, LocalDateTime fin, Tarifa tarifa) {		
		LinkedList<Llamada> llamadas = listaLlamadasDeClientes.get(DNI);
		Factura factura = new Factura(DNI, llamadas, inicio, fin,tarifa);
		this.listaFacturas.put(factura.getID(),factura); 
		LinkedList<Factura> lista = this.listaFacturasDeClientes.get(DNI);	
		lista.add(factura); 
		this.listaFacturasDeClientes.put(DNI, lista);
		
	}

	private void setListaFacturas(String DNI, LinkedList lista) {
		this.listaFacturasDeClientes.put(DNI, lista);	//TODO excepcion cliente
		
	}
	
	@Override
	public String toStringListaFacturasDeCliente(LinkedList<Factura> lista) {
		if (! lista.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("   LISTA FACTURAS:   \n");
			sb.append("_____________________\n\n\n");
			sb.append(toStringLista(lista)); 
			sb.append("\n\n"); 
			return sb.toString();
		}
		return "No hay facturas que mostrar \n\n";
	}
	//fin de acciones para facturas
	///////////////////////////////////////////	

	// Guarda todos los datos en memoria
	@Override
	public void salir() {
		CrearSerializable.guardarBaseDeDatos(this);
	}
	
}



