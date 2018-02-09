package MVC.vista.panelClientes;

import java.awt.Color;		
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Fabrica.FabricaCliente;
import Fabrica.FabricaClienteEstandar;
import MVC.controlador.Controlador1;
import clases.clientes.Cliente;
import clases.clientes.Direccion;
import clases.clientes.tarifa.Tarifa;
import excepciones.ClienteExcepcion;


public class PanelCrearCliente implements VistaDatosCliente, VistaDNI{		//TODO MODIFICADO
	
	private Controlador1 controlador = null;	//Controlador1 -> operaciones con los clientes
	
	//paneles de la clase
	private JPanel panelPrincipal = new JPanel();	//panel que englobará los diversos subpaneles	
	private JPanel panelTipoCliente = new JPanel();	//empresa o particular?
	private JPanel panelDatosCliente = new JPanel();	//datos personales
	private PanelTarifa tipoTarifa = new PanelTarifa();
	
	private VistaTarifa vistaTarifa = tipoTarifa;
	
	//Datos para crear nuevo cliente
	private JTextField DNI = new JTextField();
	private JTextField nombre = new JTextField();
	private JTextField apellidos = new JTextField();
	private JTextField CP = new JTextField();
	private JTextField poblacion = new JTextField();
	private JTextField provincia = new JTextField();
	private JTextField e_mail = new JTextField();
	
	private JLabel etq1 = new JLabel("DNI: ");
	private JLabel etq2 = new JLabel("Nombre: ");
	private JLabel etq3 = new JLabel("Apellidos: ");
	private JLabel etq4 = new JLabel("CP: ");
	private JLabel etq5 = new JLabel("Población: ");
	private JLabel etq6 = new JLabel("Provincia: ");
	private JLabel etq7 = new JLabel("e_mail: ");
	
	private JRadioButton particular = new JRadioButton("Particular");
	private JRadioButton empresa = new JRadioButton("Empresa");
	
	private JButton enviar = new JButton("ENVIAR");
	
	
	public PanelCrearCliente() {
	}
	
	public void setControlador(Controlador1 c) {
		controlador = c;
		//una vez ponemos el controlador que queremos, debemos pasarle la vista
		controlador.setVistaPanelTarifa(vistaTarifa);
		controlador.setVistaPanelCrearCliente(this, this);
	}
	
	
	public JPanel creacionCliente() {
		
		
		panelPrincipal.setLayout(new BoxLayout (panelPrincipal, BoxLayout.PAGE_AXIS));
		
		
		/**
		 * Se añadirá el tipo de cliente junto con sus datos personales
		 */

		
		JPanel datosPersonales = new JPanel();		
		//datosPersonales.setLayout(new BoxLayout (datosPersonales, BoxLayout.LINE_AXIS));
		
		datosPersonales.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Datos Personales del Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		

		panelTipoCliente.setLayout(new BoxLayout (panelTipoCliente, BoxLayout.PAGE_AXIS));
		datosPersonales.add(panelTipoCliente);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(particular);
		grupo1.add(empresa);
		
		
		
		JLabel tipoCliente = new JLabel("Elija el tipo de Cliente: ");
		panelTipoCliente.add(tipoCliente);
		panelTipoCliente.add(particular);
		particular.setSelected(true);
		panelTipoCliente.add(empresa);
		
		//mejorar implementación de esto
		empresa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				apellidos.setVisible(false);
				etq3.setVisible(false);
			}
		});

		particular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				apellidos.setVisible(true);
				etq3.setVisible(true);
			}
		});
		
		//añadir etiquetitas grid
		JPanel datosIzquierda = new JPanel();
		datosIzquierda.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 100));
		datosIzquierda.setLayout(new BoxLayout (datosIzquierda, BoxLayout.Y_AXIS));
		
		
		this.DNI.setColumns(9);
		this.nombre.setColumns(20);
		this.apellidos.setColumns(20);
		
		JPanel datosDerecha = new JPanel();
		datosDerecha.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 20));
		datosDerecha.setLayout(new BoxLayout (datosDerecha, BoxLayout.Y_AXIS));
		
		this.CP.setColumns(5);
		this.poblacion.setColumns(10);
		this.provincia.setColumns(10);
		
		datosIzquierda.add(etq1);
		datosIzquierda.add(DNI);
		datosIzquierda.add(etq2);
		datosIzquierda.add(nombre);
		datosIzquierda.add(etq3);
		datosIzquierda.add(apellidos);
		datosIzquierda.add(etq7);
		datosIzquierda.add(e_mail);
		datosDerecha.add(etq4);
		datosDerecha.add(CP);
		datosDerecha.add(etq5);
		datosDerecha.add(poblacion);
		datosDerecha.add(etq6);
		datosDerecha.add(provincia);
		
		datosPersonales.add(datosIzquierda);
		datosPersonales.add(datosDerecha);
		panelPrincipal.add(datosPersonales);
		
		
		JPanel tipo = tipoTarifa.getTarifaOfertas();
		panelPrincipal.add(tipo);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new BoxLayout (panelBoton, BoxLayout.PAGE_AXIS));
		panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
		panelBoton.add(enviar);
		panelPrincipal.add(panelBoton);
		
		enviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					accionBotonCrearCliente();					
				} catch (ClienteExcepcion e1) {
					e1.printStackTrace();
				}
			}
		});
		
		return panelPrincipal;
		
	}

	public void accionBotonCrearCliente() throws ClienteExcepcion{
		int opTarifa1 = tipoTarifa.getOpcionTarifa1();
		int opTarifa2 = tipoTarifa.getOpcionTarifa2();
		int opCliente = tipoCliente();
		controlador.addCliente(opTarifa1, opTarifa2, opCliente);
	}
	
	public int tipoCliente() {	
		//De momento se queda así, posiblemente sería mejor hacer otra cosa
		if (particular.isSelected()) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public String getDNI(){
		return DNI.getText();
	}
	
	@Override
	public String getNombre(){
		return nombre.getText();
	}
	
	@Override
	public String getApellidos(){
		return apellidos.getText();
	}
	
	@Override
	public String getCP(){
		return CP.getText();
	}
	
	@Override
	public String getPoblacion(){
		return poblacion.getText();
	}
	
	@Override
	public String getProvincia(){
		return provincia.getText();
	}
	
	@Override
	public String getE_mail(){
		return e_mail.getText();
	}

	
	
	

}
