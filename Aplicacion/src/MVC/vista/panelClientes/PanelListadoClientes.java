package MVC.vista.panelClientes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.controlador.Controlador1;
import modeloDeTablas.ModeloTablaClientes;
import tablas.TablaCliente;

public class PanelListadoClientes extends JPanel {
	
	// Creo el modelo de datos para la tabla
	ModeloTablaClientes modelo = new ModeloTablaClientes();
	JPanel panel;
	JButton actualizar;
	
	// Se inicia el panel que ontiene la tabla con los clientes
	public PanelListadoClientes(Controlador1 controlador) {
		
		// Panel que contiene la tabla
		panel = new JPanel();
		
		// Se aplica el patron de diseño Singelton para obtenr la misma tabla siempre
		// Util en caso de querer reutilizarla en varios paneles
		TablaCliente tabla = TablaCliente.getInstance();
		
		// Se pone en la parte superior del panel los nombres de las columnas
		panel.add(tabla.getTable().getTableHeader(), BorderLayout.NORTH);
		panel.add(tabla);
		
		// Se popula el modelo con los datos de la tabla
		modelo.setData(controlador.getListaClientes());
		
		// Se introduce el modelo con los datos en la tabla
		tabla.setModel(modelo);
		
		// Se inserta la tabla en el panel
		this.add(panel);
		
		actualizar = new JButton("Refrescar");
		
		// Action listener para el boton que refresque la tabla cuando se pulse
		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Es necesario crear un nuevo modelo para la tabla
				modelo = new ModeloTablaClientes();
				// Se insertan todos los datos en su estado actual en el nuevo modelo
				modelo.setData(controlador.getListaClientes());
				// Se añade el nuevo modelo a la tabla para que se vean los datos
				tabla.setModel(modelo);
				// Se repinta la tabla para ver los cambios efectuados
				tabla.repaint();
			}
		});
		this.add(actualizar);
	}
	
	
	/**
	 *  Faltaba indicar que PanelListadoCLientes extendia de JPanel, de ahi a que el 
	 *  this.add antes no funcionara pero ahora si esta bien.
	 *  
	 *  Ahora la tabla de clientes ya se dibuja correctamente y el boton refresca su 
	 *  contenido bien. Las tablas de llamadas y facturas seguirán la misma estructura
	 *  que para los clientes. Y las tablas de clientes entre fechas, facturas entre
	 *  fechas y llamadas entre fechas podrán usar las mismas tablas que se usan para
	 *  la visualizacion completa.
	 *  
	 *  
	 */
}
