package vista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import clientes.Cliente;
import clientes.Direccion;
import clientes.Empresa;
import clientes.Particular;
import clientes.Tarifa;
import factura_llamada.Factura;
import factura_llamada.Llamada;

public class PrincipalCopia {

	//Atributos
	
	private Input entrada; //entrada de datos
	private Output salida; //salida de datos
	private OperacionesBDyP operaciones;   /* Interfaz que relaciona el menú con la clase Principal.
											Menú lo usa como objeto para poder llamar a los métodos de Principal */
	private String opcion;
	private boolean salir = false;
	
	
	public PrincipalCopia() {	//contructor por defecto
		
	}
	
	public void setInput(Input in) {
		this.entrada = in;
	}
	
	public void setOutput(Output out) {
		this.salida = out;
	}
	
	public void setOperaciones(OperacionesBDyP operaciones) {
		this.operaciones = operaciones;
	}
	
	public void salir() {	//Para finalizar el programa
		salir = true;  //Supongo que no es necesario pero...meh
		salida.mostrarString("Gracias por su visita.");
		System.exit(0);
	}
	
	public LocalDateTime crearFecha(String fecha) {
		String[] f = fecha.split("/");	
		LocalDateTime ff = LocalDateTime.of(Integer.parseInt(f[0]),Integer.parseInt(f[1]),Integer.parseInt(f[2]),0,0,0);
		return ff;
	}
	
	public String pedirDNI() {
		salida.mostrarString("DNI del cliente: ");
		String DNI = entrada.leerString();
		return DNI;
	}
	
	public void iniciar() {	//Iniciamos el menú con las tres opciones principales
			
		LocalDateTime fecha = LocalDateTime.now();		
			while (this.salir == false) {
				
				salida.mostrarString("Bienvenido");
				salida.mostrarString("Elija una opción:");
				salida.mostrarString(
						"	1)Clientes\n" 
						+ "	2)Llamadas\n" 
						+ "	3)Facturas\n"
						+ "	4)Salir\n");
				salida.mostrarString("Opción: ");
				
				opcion = entrada.leerString();
				
				switch(opcion) {
					case "1":
						opcion1();
						break; 
						
					case "2":
						opcion2();
						break;
						
					case "3":
						opcion3();
						
					case "4":
						salir();
						
					default:
						salida.mostrarString("Opción no válida");
				}
			}
		
	}
	
	
	public void opcion1() {
		
		while (salir == false) {
					
			salida.mostrarString("Elija una opción:");
			salida.mostrarString(
							"	1) Dar de alta a un nuevo cliente\n"
							+ "	2) Borrar un cliente\n"
							+ "	3) Cambiar la tarifa de un cliente\n"
							+ "	4) Recuperar los datos de un cliente\n"
							+ "	5) Recuperar listado de todos los clientes\n"
							+ "	6) Volver al menú anterior\n"
							+ "	7) Salir\n");
			salida.mostrarString("Opción: ");
					
			opcion = entrada.leerString();
			String DNI;
			Tarifa tarifa;
			Cliente cliente;
					
			switch(opcion) {
					
				case "1":
					
					DNI = pedirDNI(); //de momento suponemos que pondrán bien el DNI?
					salida.mostrarString("Nombre: ");
					String nombre = entrada.leerString();
					salida.mostrarString("Datos de su domicilio:");
					salida.mostrarString("     CP:");
					String CP = entrada.leerString(); 
					salida.mostrarString("     Población:");
					String poblacion = entrada.leerString();
					salida.mostrarString("     Província:");
					String provincia = entrada.leerString();
					Direccion direccion = new Direccion(CP, poblacion, provincia);
					salida.mostrarString("Añada una tarifa inicial (€/min): ");
					Double eurosMin = entrada.leerDouble();
					tarifa = new Tarifa(eurosMin);
					salida.mostrarString("Correo electrónico (e_mail): ");
					String e_mail = entrada.leerString();
					
					boolean correcto = false;
					
					while (correcto == false) {
						salida.mostrarString("Es usted un particular o una empresa (P/E)? ");
						String tipo = entrada.leerString();
						
						switch(tipo) {	/*De momento se queda así, pero la intención es cambiarlo ya que tampoco es lógico pedir 
										 *los apellidos al final de todos los demás datos) */ 
							case "P":
							case "p": //NOTA: poner método para automáticamente poner la letra en Mayúscula
								salida.mostrarString("		En ese caso, inserte su apellido: ");
								String apellido = entrada.leerString();
								Cliente particular = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellido);
								operaciones.addCliente(particular);
								correcto=true;
								break;
								
							case "E":
							case "e":
								Cliente empresa = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
								operaciones.addCliente(empresa);
								correcto=true;
								break;
								
							default:
								salida.mostrarString("Opción no válida");
						}
						
					}							
					break;
							
				case "2":
					DNI = pedirDNI();
					operaciones.removeCliente(DNI);
					break;
							
				case "3":
					DNI = pedirDNI();
					cliente = operaciones.getCliente(DNI);
					if ( cliente != null) {  //hacemos la comprobación aquí de momento (si el cliente existe o no)
						salida.mostrarString("Por favor, indique la nueva tarifa deseada (€/min): ");
						Double EurMin = entrada.leerDouble();
						tarifa = new Tarifa(EurMin);	//Tampoco está tratada la excepción en caso de que no den un double
						operaciones.setTarifaCliente(cliente, tarifa);
					}else {
						salida.mostrarString("No es posible realizar esta operación");
					}
					break;
							
				case "4":	//Entendemos que "recuperar datos" es sacar por pantalla al cliente buscado
							/* NOTA: no está tratada la excepción en caso de que no estuviera el cliente
							 * en el caso anterior sí que hacemos una pequeña comprobación, de momento no
							 * vamos a tratar con excepciones
							 */
						/* Mostrar por pantalla al cliente*/
					DNI = pedirDNI();
					cliente = operaciones.getCliente(DNI); 
					salida.mostrarString(cliente.toStringCliente());
					break;
							
				case "5":	//Entendemos que "recuperar listado" es sacar por pantalla al los clientes buscados
					salida.mostrarString("Lista de clientes: ");				
					salida.mostrarString(operaciones.toStringListaClientes());
							
							/*System.out.print("DNI: ");
							String DNII = cogerDatos(); 
							Cliente cliente = principal.getCliente(DNII);
							if (cliente != null) {
							
							LLAMADAS
								*/
					break;
							
				case "6":
					iniciar();
					break;
							
				case "7":
					salir();
							
				default:
					salida.mostrarString("Opción no válida");
			}
		}
				
	}
	
	
	public void opcion2() {
		
		while (salir == false) {
			salida.mostrarString("Elija una opción:");
			salida.mostrarString(
							"	1) Dar de alta una llamada\n"
							+ "	2) Realizar un listado de llamdas de un cliente\n"
							+ "	3) Volver al menú anterior\n"
							+ "	4) Salir\n");
		
			salida.mostrarString("Opción: ");
			opcion = entrada.leerString();
		
			
			String DNI;
			Cliente cliente;
					
			switch(opcion) {
				case "1":
					salida.mostrarString("Teléfono: ");
					String telef = entrada.leerString();
					salida.mostrarString("Duración (en minutos): ");
					double duracion = entrada.leerDouble(); 
					Llamada llamada = new Llamada(telef, duracion);
					salida.mostrarString("DNI del cliente: ");
					DNI = entrada.leerString();
					cliente = operaciones.getCliente(DNI);
					operaciones.addLlamada(llamada,cliente);
					break;
					
				case "2":
					DNI = pedirDNI();
					cliente = operaciones.getCliente(DNI);
					salida.mostrarString(cliente.toStringListaLlamadas());
					break;
					
				case "3":
					iniciar();
					break;
					
				case "4":
					salir();
					
				default:
					salida.mostrarString("Opción no válida");
			}
			
		}
		
		
	}
	
	public void opcion3() {
		while (salir == false) {
			
			salida.mostrarString("Elija una opción:");
			salida.mostrarString(
							"	1) Emitir factura para un cliente\n"
							+ "	2) Recuperar datos de una factura a partir de su código\n"
							+ "	3) Recuperar todas las facturas de un cliente\n"
							+ "	4) Volver al menú anterior\n"
							+ "	5) Salir\n");
			salida.mostrarString("Opción: ");
					
			opcion = entrada.leerString();
			String DNI;
			Cliente cliente;
			long ID;
			Factura factura;
					
			switch(opcion) {
				case "1":
					salida.mostrarString("DNI del cliente: ");
					DNI = entrada.leerString();
					cliente = operaciones.getCliente(DNI);
					salida.mostrarString("Período: "); 
					salida.mostrarString("Fecha inicio (AAAA/MM/DD): ");
					String fecha = entrada.leerString();
					LocalDateTime fechaInicio = crearFecha(fecha); 
					salida.mostrarString("Fecha fin (AAAA/MM/DD): ");
					fecha = entrada.leerString();
					LocalDateTime fechaFin = crearFecha(fecha); 
					factura = new Factura(cliente, fechaInicio, fechaFin);
					operaciones.addFactura(factura);
					cliente.addFactura(factura);
					break;
					
				case "2":
					salida.mostrarString("ID de la factura: ");
					ID = entrada.leerLong();
					factura = operaciones.getFactura(ID);
					if (factura != null) {
						salida.mostrarString(factura.toStringFactura());						
					}
					break;
					
				case "3":
					DNI = pedirDNI();
					cliente = operaciones.getCliente(DNI);
					cliente.toStringFacturas();  //AQUIII
					break;
					
				case "4":
					iniciar();
					break;
					
				case "5":
					salir();
					
				default:
					salida.mostrarString("Opción no válida");
						
			}
	
		}
	
	}
	
}
