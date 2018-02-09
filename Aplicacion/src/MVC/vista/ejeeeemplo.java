package MVC.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Dimension;

public class ejeeeemplo {

	private JFrame frame;
	private JTextField nombre;
	private JTextField edad;
	private JTextPane datosPrevios;
	
	private Map<String, Integer> datos = new HashMap<String, Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejeeeemplo window = new ejeeeemplo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ejeeeemplo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelDatosEntrada = new JPanel();
		frame.getContentPane().add(panelDatosEntrada);
		panelDatosEntrada.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelNombre = new JPanel();
		panelDatosEntrada.add(panelNombre);
		panelNombre.setBounds(new Rectangle(76, 35, 0, 0));
		panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
		
		JLabel lblHola = new JLabel("Nombre:");
		panelNombre.add(lblHola);
		
		nombre = new JTextField();
		panelNombre.add(nombre);
		nombre.setColumns(10);
		
		JPanel panelEdad = new JPanel();
		panelDatosEntrada.add(panelEdad);
		panelEdad.setLayout(new BoxLayout(panelEdad, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Edad");
		panelEdad.add(lblNewLabel);
		
		edad = new JTextField();
		panelEdad.add(edad);
		edad.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		panelDatosEntrada.add(btnEnviar);
		
		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = nombre.getText();
					int year = Integer.parseInt( edad.getText() );
					edad.setForeground(Color.BLACK);
					datos.put(name, year);
					StringBuilder st = new StringBuilder();
					for( String n: datos.keySet() )
						st.append("Nombre: " + n + " edad: " + datos.get(n) + "\n");
					datosPrevios.setText(st.toString());
				} catch (Exception ex) {
					edad.setForeground(Color.RED);
				}
			}
		});
		
		JPanel panelMostrarDatos = new JPanel();
		panelMostrarDatos.setMinimumSize(new Dimension(30, 30));
		frame.getContentPane().add(panelMostrarDatos);
		
		JLabel lblDatosIntroducidos = new JLabel("Datos introducidos:");
		panelMostrarDatos.add(lblDatosIntroducidos);
		
		datosPrevios = new JTextPane();
		datosPrevios.setEditable(false);
		datosPrevios.setSize(new Dimension(40, 40));
		datosPrevios.setBounds(new Rectangle(2, 2, 9, 8));
		panelMostrarDatos.add(datosPrevios);
	}

}
