package MVC.vista.panelClientes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import MVC.controlador.Controlador1;
import clases.clientes.Cliente;
import clases.clientes.tarifa.Tarifa;
import excepciones.ClienteExcepcion;
import menus.Menu1;
import menus.MenuTipoTarifa1;

public class PanelCambiarTarifa implements VistaDNI{	//Vista1 contiene métodos para: PanelCrearCliente, CambiarTarifa
	
	private Controlador1 controlador = null;
	
	private JPanel panelPrincipal = new JPanel();
	private JPanel panel = new JPanel();
	PanelTarifa oferta = new PanelTarifa();
	
	private JLabel etq1 = new JLabel("DNI: ");
	private JTextField DNI = new JTextField();
	
	private JButton cambiar = new JButton("CAMBIAR");
	
	
	public PanelCambiarTarifa() {
		//Constructor por defecto
	}
	
	public void setControlador(Controlador1 c) {
		controlador = c;
		
	}

	
	public JPanel cambioTarifa() {
		
		JPanel panelDNI = new JPanel();
		panelDNI.add(etq1);
		panelDNI.add(DNI);
		this.DNI.setColumns(9);
		panelPrincipal.add(panelDNI);
		panelPrincipal.setLayout(new BoxLayout (panelPrincipal, BoxLayout.PAGE_AXIS));
		
		this.panel = oferta.getTarifaOfertas();
		
		panelPrincipal.add(panel);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new BoxLayout (panelBoton, BoxLayout.PAGE_AXIS));
		panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
		panelBoton.add(cambiar);
		
		panelPrincipal.add(panelBoton);
		
		cambiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int op1 = oferta.getOpcionTarifa1();
					int op2 = oferta.getOpcionTarifa2();
					controlador.cambiarTarifaCliente(op1, op2);
				} catch (ClienteExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		return panelPrincipal;
		
	}

	@Override
	public String getDNI() {
		return DNI.getText();
	}

	

}
