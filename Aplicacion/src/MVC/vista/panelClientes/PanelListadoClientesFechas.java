package MVC.vista.panelClientes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MVC.controlador.Controlador1;
import clases.clientes.Cliente;
import genericos.Genericos;
import modeloDeTablas.ModeloTablaClientes;
import tablas.TablaCliente;

public class PanelListadoClientesFechas extends JPanel {
	
	// Creo el modelo de datos para la tabla
	ModeloTablaClientes modelo = new ModeloTablaClientes();
	JPanel panel;
	JButton actualizar;
	
	JTextField diaInicio;
	JTextField mesInicio;
	JTextField anyoInicio;
	
	JTextField diaFin;
	JTextField mesFin;
	JTextField anyoFin;
	
	// Se inicia el panel que ontiene la tabla con los clientes
	public PanelListadoClientesFechas(Controlador1 controlador) {
		
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
		
		actualizar = new JButton("Buscar");
		
		// Action listener para el boton que refresque la tabla cuando se pulse
		actualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Es necesario crear un nuevo modelo para la tabla
					modelo = new ModeloTablaClientes();
					
					// Obtiene todos los clientes actuales del sistema
					Collection<Cliente> total = controlador.getListaClientes();
					
					// Se crean las fechas de los campos de texto
					LocalDate inicio = LocalDate.of(Integer.parseInt(anyoInicio.getText()), Integer.parseInt(mesInicio.getText()), Integer.parseInt(diaInicio.getText()));
					LocalDate fin = LocalDate.of(Integer.parseInt(anyoFin.getText()), Integer.parseInt(mesFin.getText()), Integer.parseInt(diaFin.getText()));
					
					// La hora de inicio para los dias es las 00:00
					LocalTime time = LocalTime.parse("00:00");
					
					// Filtra por las fechas que ha introducido el usuario
					total = Genericos.recuperarEntreFechas(total, inicio.atTime(time), fin.atTime(time));
					
					// Se insertan todos los datos en su estado actual en el nuevo modelo
					modelo.setData(total);
					// Se añade el nuevo modelo a la tabla para que se vean los datos
					tabla.setModel(modelo);
					// Se repinta la tabla para ver los cambios efectuados
					tabla.repaint();
				} catch (Exception ex) {
					System.out.println("Se han introducido mal las fechas");
					JOptionPane.showMessageDialog(panel, "Error en las fechas introducidas");
				}
				
			}
		});
		
		// Panel donde se añaden los textos para introducir la fecha
		JPanel botones = new JPanel();
		
		diaInicio = new JTextField();
		diaInicio.setColumns(2);
		botones.add(diaInicio);
		
		mesInicio = new JTextField();
		mesInicio.setColumns(2);
		botones.add(mesInicio);
		
		anyoInicio = new JTextField();
		anyoInicio.setColumns(4);
		botones.add(anyoInicio);
		
		botones.add(new JLabel(" hasta "));
		
		diaFin  = new JTextField();
		diaFin.setColumns(2);
		botones.add(diaFin);
		
		mesFin  = new JTextField();
		mesFin.setColumns(2);
		botones.add(mesFin);
		
		anyoFin  = new JTextField();
		anyoFin.setColumns(4);
		botones.add(anyoFin);
		
		this.add(botones);
		this.add(actualizar);
		this.add(panel);
	}
	
}
