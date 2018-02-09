package MVC.vista.panelClientes;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import MVC.controlador.Controlador1;

public class PestanyasClientes{
	
	private Controlador1 controlador = null;
	private PanelCrearCliente creado = new PanelCrearCliente();
	private PanelBorrarCliente borrado = new PanelBorrarCliente();
	private PanelCambiarTarifa tarifa = new PanelCambiarTarifa();
	//terminar de poner el resto como atributos
	
	public PestanyasClientes() {
		//constructor por defecto
	}
	
	public void setControlador1(Controlador1 c){
		controlador = c;
	}
	
	
	public JTabbedPane iniciarPestanyasClientes() {
		
		//creación de clientes
		JTabbedPane opcionesClientes= new JTabbedPane();	
		JPanel crearCliente = creado.creacionCliente();		
		creado.setControlador(controlador);
		controlador.setVistaPanelCrearCliente(creado,creado);
		opcionesClientes.add("Crear Cliente",crearCliente);
		
		JPanel borrarCliente = borrado.borrarClientes();
		borrado.setControlador(controlador);
		controlador.setVistaPanelBorrarCliente(borrado);
		opcionesClientes.add("Borrar Cliente",borrarCliente);
		
		JPanel cambioTarifa = tarifa.cambioTarifa();
		tarifa.setControlador(controlador);
		controlador.setVistaCambiarTarifa(tarifa);
		opcionesClientes.add("Cambiar Tarifa",cambioTarifa);
		
		JPanel recuperarDatos = new JPanel();	//proporcionarle panel hecho
		opcionesClientes.add("Datos Cliente",recuperarDatos);
		
		JPanel recuperarClientes = new PanelListadoClientes(controlador);	//proporcionarle panel hecho
		opcionesClientes.add("Listado Clientes",recuperarClientes);
		
		JPanel listadoFechas = new PanelListadoClientesFechas(controlador);	//proporcionarle panel hecho
		opcionesClientes.add("Listado Clientes (fechas)",listadoFechas);
			
		return opcionesClientes;
	}

	
	
}
