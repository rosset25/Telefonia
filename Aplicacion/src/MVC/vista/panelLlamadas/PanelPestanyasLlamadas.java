package MVC.vista.panelLlamadas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import MVC.controlador.Controlador1;
import MVC.controlador.Controlador2;

public class PanelPestanyasLlamadas {
	
	private Controlador2 controlador = null;
	
	private PanelCrearLlamada creado = new PanelCrearLlamada();
	
	public PanelPestanyasLlamadas() {
		//constructor por defecto
	}
	

	public void setControlador2(Controlador2 c) {
		this.controlador = c;
	}
	

	public JTabbedPane iniciarPestanyasLlamadas() {
		
		JTabbedPane opcionesFacturas= new JTabbedPane();
		
		JPanel nuevaLlamada = new JPanel(); //nuevaLlamada = creado.creacionLlamada();
		// es el panel de las llamadas, aún no está echo..
		//creado.setControlador2(controlador)
		//TODO añadir también la vista correspondiente
		opcionesFacturas.add("Nueva Llamada",nuevaLlamada);
		
		JPanel llamadasCliente = new JPanel();
		opcionesFacturas.add("Listado Llamadas",llamadasCliente);
		
		JPanel llamadasFechas = new JPanel();
		opcionesFacturas.add("Listado Llamadas (fechas)",llamadasFechas);
		
		//prueba
//		JLabel uno1 = new JLabel("ffffffffffffffffffffff");
//		JLabel dos1 = new JLabel("aaaaaaaaaaa");
//		pepa11.add(uno1);
//		pepa21.add(dos1);
		
		
		return opcionesFacturas;
		
	}


	
	
}
