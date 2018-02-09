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

import Fabrica.FabricaTarifa1;
import Fabrica.FabricaTarifa2;
import Fabrica.FabricaTarifaParametizada1;
import Fabrica.FabricaTarifaParametizada2;
import MVC.controlador.Controlador1;
import clases.clientes.Cliente;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import excepciones.ClienteExcepcion;
import menus.Menu1;
import menus.MenuTipoTarifa1;
import menus.MenuTipoTarifa2;

public class PanelTarifa implements VistaTarifa{
	
	
	private JPanel panel = new JPanel();
	private JTextField tarifaBaseElegida = new JTextField();
	private JTextField costeOferta1 = new JTextField();
	private JTextField costeOferta2 = new JTextField();
	
	ButtonGroup grupo1 = new ButtonGroup();
	ButtonGroup grupo2 = new ButtonGroup();
	
	private JRadioButton sabados = new JRadioButton("Sábados");
	private JRadioButton domingos = new JRadioButton("Domingos");
	
	private JRadioButton manyana = new JRadioButton("Mañana");
	private JRadioButton tarde = new JRadioButton("Tarde");
	private JRadioButton noche = new JRadioButton("Noche");
	
	public PanelTarifa() {
		//Constructor por defecto
	}
	
	
	public JPanel getTarifaOfertas() {
		
		
		panel.setLayout(new BoxLayout (panel, BoxLayout.PAGE_AXIS));
		
		grupo1.add(sabados);
		grupo1.add(domingos);
		
		grupo2.add(manyana);
		grupo2.add(tarde);
		grupo2.add(noche);
		
		JPanel tarifas = new JPanel();
		
		tarifas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Tarifa Base", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel tarifaBase = new JLabel("Escriba una tarifa base: ");
		tarifas.add(tarifaBase);	//Jlabel
		tarifas.add(tarifaBaseElegida);	//JTextField
		tarifaBaseElegida.setColumns(5);
		JLabel eur_min = new JLabel("€/min");
		tarifas.add(eur_min);
		
		panel.add(tarifas);
		//TODO BUSCAR forma de bajar el panel 1 y 2 creados para tarifa
	
		JPanel tarifa1 = new JPanel();
		tarifa1.setLayout(new BoxLayout (tarifa1, BoxLayout.PAGE_AXIS));
		JPanel tarifa11 = new JPanel();
		
		tarifa1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Oferta 1", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		//panel para escribir la oferta 1 (panel dentro de tarifa1
		JLabel oferta1 = new JLabel("Tarifa de la Oferta 1: ");	
		tarifa11.add(oferta1);
		tarifa11.add(costeOferta1);
		this.costeOferta1.setColumns(5);
		JLabel eur_min1 = new JLabel("€/min");
		tarifa11.add(eur_min1);
		tarifa1.add(tarifa11);
		
		JLabel opciones1 = new JLabel("Elija una de las opciones: \n");
		tarifa1.add(opciones1);
		
		tarifa1.add(manyana);
		manyana.setSelected(true);
		tarifa1.add(tarde);
		tarifa1.add(noche);
		
		JPanel ofertas = new JPanel();
		ofertas.setLayout(new BoxLayout (ofertas, BoxLayout.LINE_AXIS));
		
		ofertas.add(tarifa1);
		
		JPanel tarifa2 = new JPanel();
		tarifa2.setLayout(new BoxLayout (tarifa2, BoxLayout.PAGE_AXIS));
		JPanel tarifa22 = new JPanel();
		
		tarifa2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Oferta 2", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tarifa2.setBorder(new TitledBorder("Oferta 2"));
		
		//panel para escribir la oferta 2 (panel dentro de tarifa2
		JLabel oferta2 = new JLabel("Tarifa de la Oferta 2: ");	
		tarifa22.add(oferta2);
		tarifa22.add(costeOferta2);
		this.costeOferta2.setColumns(5);
		JLabel eur_min2 = new JLabel("€/min");
		tarifa22.add(eur_min2);
		tarifa2.add(tarifa22);
		
		
		JLabel opciones2 = new JLabel("Elija una de las opciones: \n");
		tarifa2.add(opciones2);
		
		tarifa2.add(sabados);
		sabados.setSelected(true);
		tarifa2.add(domingos);
		
		ofertas.add(tarifa2);
		
		panel.add(ofertas);
		
		return panel;
		
	}
	
	
	//Posiblemente se eliminen los gets de las ofertas y la tarifa básica
	@Override
	public double getTarifaBasica() {
		return Double.parseDouble(this.tarifaBaseElegida.getText());
	}
	
	@Override
	public double getTarifaOferta1() {
		return Double.parseDouble(this.costeOferta1.getText());
	}
	
	@Override
	public double getTarifaOferta2() {
		return Double.parseDouble(this.costeOferta2.getText());
	}
	
	
	public int getOpcionTarifa1() {
		if (manyana.isSelected()) {
			return 0;
		}
		if (tarde.isSelected()) {
			return 1;
		}	
		return 2;	
	}
	
	public int getOpcionTarifa2() {
		if(sabados.isSelected()) {
			return 0;
		}
		
		return 1;
	}
	
	


}
