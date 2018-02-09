package gestion;			//TODO NO ESTÁN TRATADAS LAS EXCEPCIONES YA EXISTENTES REFERENTES 
							import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;

import Fabrica.FabricaCliente;
import Fabrica.FabricaClienteEstandar;
import Fabrica.FabricaTarifa1;
import Fabrica.FabricaTarifa2;
import Fabrica.FabricaTarifaParametizada1;
import Fabrica.FabricaTarifaParametizada2;
import MVC.modelo.Modelo;
import aplicacion.Fechador;
import clases.Factura;
import clases.Llamada;
import clases.clientes.Cliente;
import clases.clientes.Direccion;
import clases.clientes.Empresa;
import clases.clientes.Particular;
import clases.clientes.tarifa.Domingos;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import entrada_salida.Input;
import entrada_salida.Output;
import excepciones.ClienteExcepcion;
import excepciones.FechaExcepcion;
import menus.Menu0;
import menus.Menu1;
import menus.Menu2;
import menus.Menu3;
import menus.MenuTipoCliente;
import menus.MenuTipoTarifa1;
import menus.MenuTipoTarifa2;

public class Principal implements Serializable {

	private static final long serialVersionUID = 1478217409153240166L;

	// Atributos
	
	private Input entrada; // entrada de datos
	private Output salida; // salida de datos
	private Modelo operaciones; /*
											 * Interfaz que relaciona Principal con
											 * la BaseDeDatos
											 */
	private int opcion;
	private boolean salir = false;
	private boolean salirMenu;
	
	// Constructor por defecto
	public Principal() {
		super();
	}
	/////////////////////

	// inicializar la entrada y salida de datos
	public void setInput(Input in) {
		this.entrada = in;
	}

	public void setOutput(Output out) {
		this.salida = out;
	}

	public void setOperaciones(Modelo operaciones) {
		this.operaciones = operaciones;
	}
	////////////////////////////

	public void salir() { // Finalizar el programa
		salir = true;
		salida.mostrarString("Gracias por su visita.");
	}
	//////////////////////

	public LocalDateTime crearFecha(String fecha) throws FechaExcepcion { // TODO done exception
																			
		String[] f = fecha.split("/");
		int dia, mes, anyo;
		try {
			dia = Integer.parseInt(f[0]);
			mes = Integer.parseInt(f[1]);
			anyo = Integer.parseInt(f[2]);
		} catch (IndexOutOfBoundsException e) {
			throw new FechaExcepcion();
		}

		// Comprobar dia mes y aÃ±o
		if (anyo < 0)
			throw new FechaExcepcion();
		if (mes < 0 || mes > 12)
			throw new FechaExcepcion();
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (dia <= 0 || dia > 31) {
				throw new FechaExcepcion();
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (dia <=0 || dia > 30 ) {
				throw new FechaExcepcion();
			}
			break;
		case 2:
			if ((dia <=0 || dia > 29) || ( dia == 29 && anyo%4 != 0)) {
				throw new FechaExcepcion();
			}
		}

		LocalDateTime ff = LocalDateTime.of(Integer.parseInt(f[2]), Integer.parseInt(f[1]), Integer.parseInt(f[0]), 23,
				59, 59);
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
	// Genï¿½rica

	public <T extends Fechador> LinkedList<T> periodoFechas(LinkedList<T> lista) {
		salida.mostrarString("Perï¿½odo: ");
		boolean fechaCorrecta = false;
		String  fecha;
		LocalDateTime fechaInicio = null;
		LocalDateTime fechaFin = null;
		
		while (!fechaCorrecta) {
			fecha = pedirDatos("Fecha inicio (DD/MM/AAAA): ");
			try {
				fechaInicio = crearFecha(fecha);
				fechaCorrecta = true;
			} catch (FechaExcepcion ex) {
				salida.mostrarString("Fecha invalida, por favor introduzca una nueva.");
			}
		}
		fechaCorrecta = false;
		
		while (!fechaCorrecta) {
			fecha = pedirDatos("Fecha inicio (DD/MM/AAAA): ");
			try {
				fechaFin = crearFecha(fecha);
				fechaCorrecta = true;
			} catch (FechaExcepcion ex) {
				salida.mostrarString("Fecha invalida, por favor introduzca una nueva.");
			}
		}
				
		return operaciones.recuperarEntreFechas(lista, fechaInicio, fechaFin);
	}

	//////////////////////////////////////////

	// Creaciï¿½n CLIENTES	
	public void crearCliente() throws ClienteExcepcion {	/*FIXME Ponemos aquí la excepción porque nada más 
															 *introducir el DNI comprobamos si existe, asi que 
															 *en principio no hace falta hacer excepción en 
															 *operaciones.addCliente
															 */
		String DNI = null;
		String nombre, apellidos, CP, poblacion, provincia, e_mail;
		Direccion direccion;
		Tarifa tarifa;
		FabricaCliente fabrica = new FabricaClienteEstandar();
		Cliente cliente = null;
		double eur_min;
		
		salida.mostrarString("Elija un tipo de Cliente:");
		salida.mostrarString(MenuTipoCliente.getMenuTipoCliente());
		
		opcion = entrada.leerInt(); 
		MenuTipoCliente opcionMenu = MenuTipoCliente.getOpcion(opcion);
		
		//TODO PREGUNTAR: si cambiamos la creación de los tipos de cliente
		switch (opcionMenu) { 	//NOTA: aqune sea repetitivo, tenemos que pedir los datos para
								//cada tipo de cliente , ya que podrían pedir cosas distintas
								//además, no es común que se pidan los apellidos al final
		case EMPRESA:	
			DNI = pedirDatos("DNI: ");
			nombre = pedirDatos("Nombre: ");
			salida.mostrarString("Datos de su domicilio:");
			CP = pedirDatos("     CP:");
			poblacion = pedirDatos("     Poblaciï¿½n:");
			provincia = pedirDatos("     Provï¿½ncia:");
			direccion = new Direccion(CP, poblacion, provincia);
			e_mail = pedirDatos("Correo electrï¿½nico (e_mail): "); 
			
			eur_min = pedirDatosDouble("Aï¿½ada una tarifa Base(ï¿½/min): "); 
			tarifa = new TarifaBasica(eur_min);
			tarifa = crearOfertaTarifa1(tarifa);
			tarifa = crearOfertaTarifa1(tarifa);
			
			cliente = fabrica.getEmpresa(DNI, nombre, direccion, tarifa, e_mail) ;	
			break;

		case PARTICULAR:
			DNI = pedirDatos("DNI: ");
			nombre = pedirDatos("Nombre: ");
			apellidos = pedirDatos("Apellidos: ");
			salida.mostrarString("Datos de su domicilio:");
			CP = pedirDatos("     CP:");
			poblacion = pedirDatos("     Poblaciï¿½n:");
			provincia = pedirDatos("     Provï¿½ncia:");
			direccion = new Direccion(CP, poblacion, provincia);
			e_mail = pedirDatos("Correo electrï¿½nico (e_mail): "); //Preguntar por qué
			
			eur_min = pedirDatosDouble("Aï¿½ada una tarifa inicial (ï¿½/min): ");
			tarifa = new TarifaBasica(eur_min);
			tarifa = crearOfertaTarifa1(tarifa);
			tarifa = crearOfertaTarifa2(tarifa);
			
			cliente = fabrica.getParticular(DNI, nombre, direccion, tarifa, e_mail, apellidos) ;	
			break;
		}
	
		try {
			operaciones.addCliente(cliente, DNI); 
			salida.mostrarString("Cliente aï¿½adido \n"); 
		}catch (ClienteExcepcion e)	{
			salida.mostrarString("No se pudo realizar la operación");
		}
	}
	/////////////////////////////////////////////////
	
	//Creación Oferta Tarifa
	public Tarifa crearOfertaTarifa1(Tarifa tarifa) {	//TODO CAMBIAR, sólo se puede elegir entre
														//mañana, tarde, noche y sabados o domingos
		
			salida.mostrarString("Elija la oferta deseada: ");
			salida.mostrarString(MenuTipoTarifa1.getMenuTipoTarifa());
			opcion = entrada.leerInt(); 
			MenuTipoTarifa1 opcionMenu = MenuTipoTarifa1.getOpcion(opcion);
			double oferta = pedirDatosDouble("Indique el coste de la oferta: ");
			FabricaTarifa1 fabrica = new FabricaTarifaParametizada1();
			tarifa = fabrica.getTipoTarifa(opcionMenu, tarifa, oferta);

		return tarifa;
	}
	
	public Tarifa crearOfertaTarifa2(Tarifa tarifa) {	//TODO CAMBIAR, sólo se puede elegir entre
		//mañana, tarde, noche y sabados o domingos

		salida.mostrarString("Elija la oferta deseada: ");
		salida.mostrarString(MenuTipoTarifa2.getMenuTipoTarifa());
		opcion = entrada.leerInt(); 
		MenuTipoTarifa2 opcionMenu = MenuTipoTarifa2.getOpcion(opcion);
		double oferta = pedirDatosDouble("Indique el coste de la oferta: ");
		FabricaTarifa2 fabrica = new FabricaTarifaParametizada2();
		tarifa = fabrica.getTipoTarifa(opcionMenu, tarifa, oferta);
		
		return tarifa;
	}
	//////////////////////////////////////////////

	
	// Creaciï¿½n LLAMADAS
	public void crearLlamada() {
		String DNI = pedirDatos("DNI del cliente: ");
		if (operaciones.getListaLlamadas().containsKey(DNI)) {
			String telef = pedirDatos("Telï¿½fono: ");
			double duracion = pedirDatosDouble("Duraciï¿½n (en minutos): ");
			LocalDateTime fecha = LocalDateTime.of(2017, 4, 11, 16, 45);	//TODO PROVISIONAL
			Llamada llamada = new Llamada(DNI, telef, duracion, fecha);
			operaciones.addLlamada(llamada);
		} else {
			salida.mostrarString("No se pudo realizar la operaciï¿½n");
		}
	}
	///////////////////////////////////

	// Creaciï¿½n FACTURAS
	public void crearFactura() {
		
		boolean tarifaCorrecta = false;
		String DNI = null;
		
		Tarifa tarifa = null;
	
		try {
			DNI = pedirDatos("DNI del cliente: ");
			tarifa = operaciones.getCliente(DNI).getTarifa();
			salida.mostrarString("Perï¿½odo: ");
			LocalDateTime inicio = null;
			boolean fechaCorrecta = false; 
			
			while (!fechaCorrecta) {
				String fecha = pedirDatos("Fecha inicio (DD/MM/AAAA): ");
				try {
					inicio = crearFecha(fecha); 
					fechaCorrecta = true;
				} catch (FechaExcepcion ex) {
					salida.mostrarString("Fecha invalida, por favor introduzca una nueva.");
				}
			}
			
			LocalDateTime fin = inicio.plusMonths(1); // se lanza arriba la
														// excepciï¿½n y se trata
														// aquï¿½

			operaciones.addFactura(DNI, inicio, fin, tarifa);
			
		}catch (ClienteExcepcion ex) {
			salida.mostrarString("Cliente no válido");
		}
		
		
				
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public void iniciar() throws ClienteExcepcion { // Iniciamos el menï¿½ principal con las tres opciones

		while (this.salir == false) {

			salida.mostrarString("Bienvenido");
			salida.mostrarString("Elija una opciï¿½n:");
			salida.mostrarString(Menu0.getMenu0());
			
			opcion = entrada.leerInt(); 
			Menu0 opcionMenu = Menu0.getOpcion(opcion);
			
			
			switch (opcionMenu) { 
			
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
				salida.mostrarString("Opciï¿½n no vï¿½lida");
			}
		}

	}
	/////////////////////////////////////

	// CLIENTES
	public void opcion1() throws ClienteExcepcion { // TODO tratar EXCEPCIï¿½N: opciï¿½n del menï¿½ invï¿½lida,
							// en vez de un Int dan un String

			salirMenu = false;
			String DNI;
			Tarifa tarifa;
			LinkedList lista;

			while (! salirMenu) {
				salida.mostrarString(Menu1.getMenu1());
				opcion = entrada.leerInt(); 
				Menu1 opcionMenu = Menu1.getOpcion(opcion);
			
				switch (opcionMenu) {
				case NUEVO_CLIENTE:
					crearCliente();
					break;
	
				case BORRAR_CLIENTE:
					DNI = pedirDatos("DNI del cliente que se desea borrar: ");
					operaciones.removeCliente(DNI);
					break;
	
				case CAMBIAR_TARIFA:
					DNI = pedirDatos("Introduce DNI del cliente: ");
					if (operaciones.getListaClientes().containsKey(DNI)) {
						double eurMin = pedirDatosDouble("Nueva tarifa Básica deseada(ï¿½/min): "); //TODO aaa			
						tarifa = new TarifaBasica(eurMin);
						tarifa = crearOfertaTarifa1(tarifa);
						tarifa = crearOfertaTarifa1(tarifa);
						operaciones.setTarifaCliente(operaciones.getCliente(DNI), tarifa);
					} else {
						salida.mostrarString("No es posible realizar esta operaciï¿½n");
					}
					break;
	
				case RECUPERAR_DATOS:
					DNI = pedirDatos("Introduce DNI del cliente: ");
					if (operaciones.getListaClientes().containsKey(DNI)) {
						salida.mostrarString(operaciones.getCliente(DNI).toString());
					} else {
						salida.mostrarString("El cliente buscado no existe o no se ha dado de alta");
					}
					break;
	
				case RECUPERAR_CLIENTES: //TODO TRATAR EXCEPCIÓN SI LISTA ESTÁ VACÍA
					lista = new LinkedList();
					lista.addAll(operaciones.getListaClientes().values());
						salida.mostrarString(operaciones.toStringListaClientes(lista));
					break;
	
				case LISTADO_CLIENTES_FECHAS: //TODO TRATAR EXCEPCIÓN SI LISTA ESTÁ VACÍA
					lista = new LinkedList();
					lista.addAll(operaciones.getListaClientes().values());
						LinkedList listaFechas = periodoFechas(lista);
						salida.mostrarString(operaciones.toStringListaLlamadas(listaFechas));
					break;
	
				case ANTERIOR:
					salirMenu = true;
					iniciar();
					break;
	
				case SALIR:
					salirMenu = true;
					salir();
					break;
	
				default:
					salida.mostrarString("Opciï¿½n no vï¿½lida");
				}
			}
	}
	//////////////////////////////

	// LLAMADAS
	public void opcion2() throws ClienteExcepcion { // TODO tratar EXCEPCIï¿½N: opciï¿½n del menï¿½ invï¿½lida,
							// en vez de un Int dan un String
		
			salirMenu = false;
			HashMap listaLlamadas;
			String DNI;
			LinkedList lista;
			
			
			while (! salirMenu) {
				salida.mostrarString(Menu2.getMenu2());
				opcion = entrada.leerInt(); 
				Menu2 opcionMenu = Menu2.getOpcion(opcion);
			
				switch (opcionMenu) {
				case NUEVA_LLAMADA:
					crearLlamada();
					break;
	
				case LLAMADAS:
					// listaLlamadas= operaciones.getListaLlamadas();
					DNI = pedirDatos("Introduce DNI del cliente: "); 
					listaLlamadas = operaciones.getListaLlamadas();
					// Se pueden imprimir las llamadas de clientes ya dados de baja
					if (listaLlamadas.containsKey(DNI)) {
						lista = (LinkedList) listaLlamadas.get(DNI);
						salida.mostrarString(operaciones.toStringListaLlamadas(lista)); 
					}
					break;
	
				case LISTADO_LLAMADAS_FECHAS:
					DNI = pedirDatos("Introduce DNI del cliente: ");
					listaLlamadas = operaciones.getListaLlamadas();
					if (listaLlamadas.containsKey(DNI)) {
						lista = (LinkedList) listaLlamadas.get(DNI);
						LinkedList listaFechasLlamadas = periodoFechas(lista);
						salida.mostrarString(operaciones.toStringListaLlamadas(listaFechasLlamadas));
					}
					break;
	
				case ANTERIOR:
					salirMenu = true;
					iniciar();
					break;
	
				case SALIR:
					salirMenu = true;
					salir();
					break;
	
				default:
					salida.mostrarString("Opciï¿½n no vï¿½lida");
				}
			}
	}

	public void opcion3() throws ClienteExcepcion { 
		
			salirMenu = false;
			String DNI;
			long ID;
			Factura factura;
			
			HashMap facturasClientes;
			LinkedList lista;
			
			while (!salirMenu) {
				salida.mostrarString(Menu3.getMenu3());
				opcion = entrada.leerInt(); 
				Menu3 opcionMenu = Menu3.getOpcion(opcion);
			
				switch (opcionMenu) {
	
				case NUEVA_FACTURA:
					crearFactura();
					break;
	
				case CODIGO:
					salida.mostrarString("ID de la factura: ");
					ID = entrada.leerLong();
					factura = operaciones.getFactura(ID);
					if (factura != null) { 
						salida.mostrarString(factura.toString());
					}
					break;
	
				case FACTURA_CLIENTE:
					DNI = pedirDatos("DNI del cliente: ");
					facturasClientes = operaciones.getListaFacturasDeClientes();
					if (facturasClientes.containsKey(DNI)) {
						lista  = (LinkedList<Factura>) facturasClientes.get(DNI);
						salida.mostrarString(operaciones.toStringListaFacturasDeCliente(lista)); 
					}
					break;
	
				case LISTADO_FACTURAS_FECHAS: 
					
					DNI = pedirDatos("DNI del cliente: ");
					 facturasClientes = operaciones.getListaFacturasDeClientes();
					if (facturasClientes.containsKey(DNI)) {
						lista  = (LinkedList<Factura>) facturasClientes.get(DNI);
						LinkedList listaFechasFacturas = periodoFechas(lista);
						salida.mostrarString(operaciones.toStringListaFacturasDeCliente(listaFechasFacturas)); 
					}
					break;
	
				case ANTERIOR:
					salirMenu = true;
					iniciar();
					break;
	
				case SALIR:
					salirMenu = true;
					salir();
					break;
	
				default:
					salida.mostrarString("Opciï¿½n no vï¿½lida");
	
				}
			}

	}

}
