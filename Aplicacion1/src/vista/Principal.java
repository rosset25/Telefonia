package vista;		//TODO Repasar la clase, tratar excepciones, creo que no hace falta Serializable

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.TreeMap;
import clientes.Cliente;
import clientes.Direccion;
import clientes.Empresa;
import clientes.Particular;
import clientes.Tarifa;
import factura_llamada.Factura;
import factura_llamada.Llamada;
import menus.Menu0;
import menus.Menu1;
import menus.Menu2;
import menus.Menu3;

public class Principal implements Serializable{

	//Atributos
	
	private Input entrada; //entrada de datos
	private Output salida; //salida de datos
	private OperacionesBDyP operaciones;   /* Interfaz que relaciona Principal con la BaseDeDatos */
	private int opcion;
	private boolean salir = false;
	
	//Constructor por defecto
	public Principal() {	
		super();
	}
	/////////////////////
	
	//inicializar la entrada y salida de datos
	public void setInput(Input in) {
		this.entrada = in;
	}
	
	public void setOutput(Output out) {
		this.salida = out;
	}
	
	public void setOperaciones(OperacionesBDyP operaciones) {
		this.operaciones = operaciones;
	}
	////////////////////////////
	
	public void salir() {	//Finalizar el programa
		salir = true; 
		salida.mostrarString("Gracias por su visita.");
	}
	//////////////////////
	
	public LocalDateTime crearFecha(String fecha) {	//TODO Crear EXCEPCIÓN
		String[] f = fecha.split("/");	
		LocalDateTime ff = LocalDateTime.of(Integer.parseInt(f[0]),Integer.parseInt(f[1]),Integer.parseInt(f[2]),0,0,0);
		return ff;
	}
	
	public String pedirDatos(String cadena) {
		salida.mostrarString(cadena);
		String leer = entrada.leerString();
		return leer;
	}
	
	public double pedirDatosDouble(String cadena) {
		salida.mostrarString(cadena);
		double leer = entrada.leerDouble();
		return leer;
	}
	
	/////////////////////////////////////////
	
	//Creación CLIENTES
	public void crearCliente() {
		String apellidos = null; //hay que inicializar la variable obligatoriamente
		Cliente cliente;
		String DNI = pedirDatos("DNI: ");//Hacer excepción si DNI erróneo o está creado
		
		if (operaciones.existe(DNI,operaciones.getListaClientes())) {	//Comprobar que el cliente no está dado de alta todavía
			salida.mostrarString("Este cliente ya se ha dado de alta");
			salida.mostrarString("No se pudo realizar la operación");	
		}else{
			String tipo = tipoCliente();	//Preguntamos qué tipo de cliente es
			String nombre = pedirDatos("Nombre: ");
			
			if (tipo == "p") {							//Se hace aquí la comprobación del tipo, aunque se haga 
				apellidos = pedirDatos("Apellidos: ");	//dos veces, para dar los apellidos después del nombre,
			}											//que queda mejor
			
			salida.mostrarString("Datos de su domicilio:");
			String CP = pedirDatos("     CP:");
			String poblacion = pedirDatos("     Población:");
			String provincia = pedirDatos("     Província:");
			Direccion direccion = new Direccion(CP, poblacion, provincia);
			Double eurosMin = pedirDatosDouble("Añada una tarifa inicial (€/min): "); //TODO tratar EXCEPCIÓN (debe ser con una ,)
			Tarifa tarifa = new Tarifa(eurosMin);		
			String e_mail = pedirDatos("Correo electrónico (e_mail): ");	
			
			if (tipo == "p") { //Si es un particular
				cliente = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
			}else {	//Si es una empresa
				cliente = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
			}	
		
			operaciones.addCliente(cliente, DNI); //Añadiendo el DNI se pierde menos tiempo
			salida.mostrarString("Cliente añadido \n");	//Se le pasa por valor una única vez
		}
	}
	
	public String tipoCliente() {	//TODO Puede que se transforme en un menú
		
		String tipo = pedirDatos("Empresa o  Particular?");
		boolean correcto = false;
		while (! correcto) {		
			switch(tipo) {
				case "P":
				case "p": //NOTA: se puede poner también método para poner Mayúscula
					return "p";
				case "E":
				case "e":
					return "e";
				default:
					tipo = pedirDatos("Opción no válida");
			}
		}
		return null;
	}
	//////////////////////////////////////////////
	
	//Creación LLAMADAS
	public void crearLlamada() {
		String DNI = pedirDatos("DNI del cliente: ");
		if (operaciones.existe(DNI, operaciones.getListaLlamadas())) {
			String telef = pedirDatos("Teléfono: ");	
			double duracion = pedirDatosDouble("Duración (en minutos): ");  //TODO excepción
			Llamada llamada = new Llamada(DNI, telef, duracion);
			operaciones.addLlamada(llamada);
		}else{
			salida.mostrarString("No se pudo realizar la operación");
		}
	}
	
	
	
	public void iniciar() {	//Iniciamos el menú principal con las tres opciones	
			//TODO HACER EXCEPCIÓN: tanto en este menú como en los demás si no has inicializado la entrada, 
			//la salida y la Base de Datos, tiene que lanzar una excepción
			
		
		while (this.salir == false) {
				
				salida.mostrarString("Bienvenido");
				salida.mostrarString("Elija una opción:");
				salida.mostrarString(Menu0.getMenu0());
				opcion = entrada.leerInt();	//TODO Tratar EXCEPCIÓN
				Menu0 opcionMenu = Menu0.getOpcion(opcion);	
				
				switch(opcionMenu) {	//En Try habrá que obligarle a que vuelva a elegir
					case CLIENTES:
						opcion1();
						break; 
						
					case LLAMADAS:
						opcion2();
						break;
						
					case FACTURAS:
						opcion3();
						break;
						
					case SALIR:
						salir();
						break;
						
					default:
						salida.mostrarString("Opción no válida");
				}
			}
		
	}
	/////////////////////////////////////
	
	//CLIENTES
	public void opcion1() {
		
		while (salir == false) {
					
			salida.mostrarString(Menu1.getMenu1());
			opcion = entrada.leerInt();	//TODO Tratar excepción
			Menu1 opcionMenu = Menu1.getOpcion(opcion);	

			String DNI;
			Tarifa tarifa;
			TreeMap listaClientes = operaciones.getListaClientes();
			
			switch(opcionMenu) {	
				case NUEVO_CLIENTE:
					crearCliente();
					break;
							
				case BORRAR_CLIENTE:
					DNI = pedirDatos("DNI del cliente que se desea borrar: ");
					operaciones.removeCliente(DNI);
					break;
				
				case CAMBIAR_TARIFA:
					DNI = pedirDatos("Introduce DNI del cliente: ");	
					if (operaciones.existe(DNI,listaClientes)) {
						Double EurMin = pedirDatosDouble("Nueva tarifa deseada (€/min): ");
						tarifa = new Tarifa(EurMin);	//TODO tratar EXCEPCIÓN (double con ,)
						operaciones.setTarifaCliente(operaciones.getCliente(DNI), tarifa);
					}else {
						salida.mostrarString("No es posible realizar esta operación");
					}
					break;
							
				case RECUPERAR_DATOS:	
					DNI = pedirDatos("Introduce DNI del cliente: ");
					if (operaciones.existe(DNI,listaClientes)) {
						salida.mostrarString(operaciones.getCliente(DNI).toString());
					}else{
						salida.mostrarString("El cliente buscado no existe o no se ha dado de alta");
					}
					break;
								
				case RECUPERAR_CLIENTES: //TODO Hacer excepción si no hay clientes en la lista
					LinkedList lista = operaciones.recuperarLista(operaciones.getListaClientes());
					salida.mostrarString(operaciones.toStringListaClientes(lista));
					break;
				
				case LISTADO_CLIENTES_FECHAS:
					//TODO COMPLETAR, nueva opción, clase genérica
					
					break;
					
				case ANTERIOR:
					iniciar();
					break;
							
				case SALIR:
					salir();
					break; 
					
				default:
					salida.mostrarString("Opción no válida");
			}
		}
				
	}
	//////////////////////////////
	
	//LLAMADAS	
	public void opcion2() {
		
		while (salir == false) {
			
			salida.mostrarString(Menu2.getMenu2());
			opcion = entrada.leerInt();	//TODO Tratar excepción
			Menu2 opcionMenu = Menu2.getOpcion(opcion);
			
			String DNI;
			Cliente cliente;
			TreeMap listaLlamadas = operaciones.getListaLlamadas(); 
			
			switch(opcionMenu) {
				case NUEVA_LLAMADA: 
					crearLlamada();
					break;
			
				case LLAMADAS:
					DNI = pedirDatos("Introduce DNI del cliente: ");	//Se pueden imprimir las llamadas 
					if (operaciones.existe(DNI, listaLlamadas)) {				//de clientes ya dados de baja
						LinkedList lista = operaciones.recuperarLista(operaciones.getListaLlamadas());
						salida.mostrarString(operaciones.toStringListaLlamadas(lista));
					}
						break;
					
				case LISTADO_LLAMADAS_FECHAS:
					//TODO crear EXCEPCIÓN
					salida.mostrarString("Período: "); 
					String fecha = pedirDatos("Fecha inicio (AAAA/MM/DD): ");
					LocalDateTime fechaInicio = crearFecha(fecha); 
					fecha = pedirDatos("Fecha fin (AAAA/MM/DD): ");
					LocalDateTime fechaFin = crearFecha(fecha); 
					LinkedList lista = operaciones.recuperarEntreFechas(listaLlamadas, fechaInicio, fechaFin);
					salida.mostrarString(operaciones.toStringListaLlamadas(lista));
					break;
					
				case ANTERIOR:
					iniciar();
					
				case SALIR:
					salir();
					break;
					
				default:
					salida.mostrarString("OpciÃ³n no vÃ¡lida");
			}
			
		}
		
		
	}
	
	public void opcion3() {
		
//		while (salir == false) {
//			
//			salida.mostrarString(Menu3.getMenu3());
//			opcion = entrada.leerInt();	//TODO Tratar excepción
//			Menu3 opcionMenu = Menu3.getOpcion(opcion);
//			
//			String DNI;
//			Cliente cliente;
//			long ID;
//			Factura factura;	
//			
//			switch(opcion) {
//			
//				case NUEVA_FACTURA:
//					DNI = pedirDatos("DNI del cliente: ");
//					cliente = operaciones.getCliente(DNI);
//					salida.mostrarString("PerÃ­odo: "); 
//					salida.mostrarString("Fecha inicio (AAAA/MM/DD): ");
//					String fecha = entrada.leerString();
//					LocalDateTime fechaInicio = crearFecha(fecha); 
//					salida.mostrarString("Fecha fin (AAAA/MM/DD): ");
//					fecha = entrada.leerString();
//					LocalDateTime fechaFin = crearFecha(fecha); 
//					factura = new Factura(cliente, fechaInicio, fechaFin);
//					operaciones.addFactura(factura);
//					cliente.addFactura(factura);
//					break;
//					
//				case CODIGO:
//					salida.mostrarString("ID de la factura: ");
//					ID = entrada.leerLong();
//					factura = operaciones.getFactura(ID);
//					if (factura != null) {
//						salida.mostrarString(factura.toStringFactura());						
//					}
//					break;
//					
//				case FACTURA_CLIENTE:
//					DNI = pedirDNI();
//					cliente = operaciones.getCliente(DNI);
//					cliente.toStringFacturas();  //AQUIII
//					break;
//					
//				case LISTADO_FACTURA_FECHAS:
//					
//				case ANTERIOR:
//					iniciar();
//					break;
//					
//				case SALIR:
//					salir();
//					
//				default:
//					salida.mostrarString("OpciÃ³n no vÃ¡lida");
//						
//			}
//	
//		}
	
	}
	
	
	
}
