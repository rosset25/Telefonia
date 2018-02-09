package MVC.vista;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import MVC.controlador.Controlador1;
import MVC.controlador.Controlador2;
import MVC.controlador.ControladorClientes;
import MVC.controlador.ControladorLlamadas;
import MVC.modelo.Modelo;
import MVC.vista.panelClientes.PestanyasClientes;
import MVC.vista.panelFacturas.PanelPestanyasFacturas;
import MVC.vista.panelLlamadas.PanelPestanyasLlamadas;
import aplicacion.BaseDeDatos;
import serializable.CrearSerializable;

public class PanelInicio {

	//TODO en la entrga final hay que tener en cuenta las excepciones que podamos tratar
	//para ponerlas en rojito o algo -> ej. introducir una tarifa errónea, que no sean números
	
	private JFrame frame;
	private Modelo modelo = null;
	
	private Controlador1 controlador1 = null;
	private Controlador2 controlador2 = null;
	
	//TODO incluir esto luego en el main real
	
	public static void main(String[] args) {	//main provisional
		
		EventQueue.invokeLater(new Runnable() {	//esta mierda se puede 
			public void run() {					//poner en otro sitio que no sea el main?
				try {
					//TODO hay que poner ya lo que estaría en nuestro main para que se guarden las cosas
					
					BaseDeDatos baseDeDatos = CrearSerializable.cargarBaseDeDatos();
					Modelo modelo = baseDeDatos;
					//TODO iniciar toooodas las pestañas de mierda y pasarlas como parámetro para
					//pestanyasClientes y el resto de pestañas
					
					ControladorClientes controladorClientes = new ControladorClientes();
					Controlador1 controlador1 = controladorClientes;
					controlador1.setModelo(modelo);
					
					ControladorLlamadas controladorLlamadas = new ControladorLlamadas();
					Controlador2 controlador2 = controladorLlamadas;
					controlador2.setModelo(modelo);
					
					PanelInicio ventana = new PanelInicio();
					ventana.setControlador1(controlador1);
					ventana.setControlador2(controlador2);
					ventana.setModelo(modelo);
					
					ventana.iniciarPanelPrincipal();
					ventana.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	protected void setModelo(Modelo m) {
		this.modelo = m;
	}

	protected void setControlador1(Controlador1 c){
		this.controlador1 = c;
	}
	
	protected void setControlador2 (Controlador2 c){
		this.controlador2 = c;
	}
	
	
	public PanelInicio() {
		//constructor por defecto
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void iniciarPanelPrincipal() {
		frame = new JFrame();
		frame.setBounds(200, 200, 1000, 650);
		
		// Se llama al metodo de guardar cada vez que se cierra la aplicacion
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controlador1.salir();
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//TODO AL DARLE AL BOTÓN DE CERRAR HAY QUE PONER QUE GUARDE EL ARCHIVO EN UN DOCUMENTO

		//Creación Pestañas principales
		JTabbedPane pestanyas = new JTabbedPane();
		
		//Opciones de CLIENTES
		PestanyasClientes op1 = new PestanyasClientes();
		op1.setControlador1(controlador1);		
		JTabbedPane pestanyaClientes = op1.iniciarPestanyasClientes();
		pestanyas.add("Clientes",pestanyaClientes);
		
		//Opciones de LLAMADAS
		PanelPestanyasLlamadas op2 = new PanelPestanyasLlamadas();	//controlador2
		op2.setControlador2(controlador2);
		JTabbedPane pestanyaLlamadas = op2.iniciarPestanyasLlamadas();
		pestanyas.add("Llamadas",pestanyaLlamadas);
		
		//Opciones de FACTURAS
		PanelPestanyasFacturas op3 = new PanelPestanyasFacturas();	//controlador3
		JTabbedPane pestanyaFacturas = op3.iniciarPestanyasFacturas();
		//controlador 3
		pestanyas.add("Facturas",pestanyaFacturas);
		
		frame.add(pestanyas);
	
	}

}
