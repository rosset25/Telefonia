package clientes;	//TODO Casi hecho, repasar m·s tarde

//import java.time.LocalDateTime;  *No me deja importar esta clase
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TreeMap;
import java.io.Serializable;
import java.time.LocalDateTime;

import aplicacion.Fechador;
import factura_llamada.Factura;
import factura_llamada.Llamada;

public abstract class Cliente implements Fechador, Serializable{	//Clase Padre, Abstract (sÛlo podemos crear Particulares o Empresas)
	
	//Atributos
	
	private String DNI;
	private String nombre;
	private Direccion direccion;
	private Tarifa tarifa;
	private String e_mail;
	private LocalDateTime fechaDeAlta; 
	//TreeMap<Long,Factura> listaFacturas = new TreeMap<Long,Factura>();
	/*ArrayList<Llamada> listaLlamadas = new ArrayList<Llamada>();    /* de momento no ser√° un treeMap, ya que para la factura
																	*necesitaremos consul
																	*
																	*
																	*
																	*
																	*/
	//Constructor
	
	public Cliente(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tarifa = tarifa;
		this.e_mail = e_mail;
		this.fechaDeAlta = LocalDateTime.now(); //Asignar la fecha del sistema automaticamente
		
	}
	
	//Interface Fechador---> getFecha()
	@Override
	public LocalDateTime getFecha() {
		return fechaDeAlta;
	}
	//////////////////
	
	//gets y sets
	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;  
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	/*public ArrayList<Llamada> getListaLlamadas() {
		return this.listaLlamadas;
	}
	
	public TreeMap<Long,Factura> getListaFacturas() {
		return this.listaFacturas;
	}
	
	public void addLlamada(Llamada llamada){
		listaLlamadas.add(llamada);
	}
	
	public void addFactura(Factura factura) {	/*no olvidar que, cada vez que se haga una factura, 
		 											se le a√±ada al cliente correspondiente 
		
		listaFacturas.put(factura.getID(), factura);
	}*/
	
	//////////////////////////////////////////
	
	//toString()
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("-- CLIENTE --\n");
		sb.append("_____________\n\n");
		sb.append("	Nombre: " + this.nombre + "\n");
		sb.append("	DNI: " + this.DNI + "\n");
		sb.append("	DirecciÛn: \n" + this.direccion.toString() + "\n");
		sb.append("	Tarifa: " + this.tarifa.toString() + "\n");
		sb.append("	e-mail: " + this.e_mail + "\n");
		return sb.toString();
	}
	////////////////////////////////////
	
	
	
	
	//CAMBIAR A BaseDeDatos
//	public double emitirTarifa(LocalDateTime inicio, LocalDateTime fin) {
//		if (listaLlamadas.isEmpty()) {
//			return 0;
//		}
//		int i= 0;
//		Llamada llam = listaLlamadas.get(i);  //Habr√° que lanzar excepci√≥n si no hay llamadas
//		LocalDateTime fechaLlam = llam.getFecha(); 
//		double sumaMin = 0;
//	
//		while (i < listaLlamadas.size() && inicio.compareTo(fechaLlam) <= 0 && fin.compareTo(fechaLlam) >= 0) {
//			llam = listaLlamadas.get(i); /*cambiar en alg√∫n momento, cutrecillo, 
//										*pero no da error (fuera de rango)*/
//			fechaLlam = llam.getFecha(); 
//			sumaMin += Math.ceil(llam.getDuracion());
//			i++;//llamada siguiente de la lista
//		}
//		
//		return sumaMin*this.tarifa.getTarifa();
//	}
	
	
	//BORRAR. Hacer lista de llamadas en BaseDeDatos
	/*public String toStringListaLlamadas() {
		String cadena = "";
		Llamada llamada;
		for (int i=0; i < listaLlamadas.size(); i++) {
			llamada = this.listaLlamadas.get(i);
			cadena += llamada.toStringLlamada() + "\n";
		}
		
		return cadena;
	}*/
	
	
	//M¡S DE LO MISMO: Esto debe estar en BaseDeDatos:
//	public ArrayList<Factura> crearFacturas() {
//		ArrayList<Factura> lista = new ArrayList<Factura>();
//		lista.addAll(listaFacturas.values());	
//		return lista; 		
//	}
//	
//	public String toStringFacturas() {  //no nos sale por pantalla, no sabemos por qu√©
//		
//		ArrayList<Factura> listaFacturasMostrar = crearFacturas();		
//		String cadena = "";
//		Factura f;
//		for (int i=0; i < listaFacturasMostrar.size(); i++) {
//			f = listaFacturasMostrar.get(i);
//			System.out.println(cadena + f.toString());
//			cadena = cadena + f.toStringFactura() + "\n\n";			
//		}	
//		return cadena;
//	}
//	
	/*public String toStringListaClientes() {	//Mostrar todos los clientes  guardados
		ArrayList<Cliente> lista = recuperarListaClientes();
		String cadena = "";
		Cliente cliente; 
		for (int i=0; i < lista.size(); i++) {
			cliente = lista.get(i);
			cadena = cadena  + cliente.toStringCliente() + "\n\n";
		}	
		return cadena;
	}*/
	
	
	
	
	//hasta aqu√≠


	
	

}
