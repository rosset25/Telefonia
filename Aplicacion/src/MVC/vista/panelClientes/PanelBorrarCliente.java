package MVC.vista.panelClientes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import MVC.controlador.Controlador1;
import excepciones.ClienteExcepcion;

public class PanelBorrarCliente implements VistaDNI{
	
	private Controlador1 controlador;
	private JPanel borrado = new JPanel();
	private JTextField DNIcliente;
	
	public PanelBorrarCliente() {
		//Constructor por defecto
	}
	
	
	public void setControlador(Controlador1 c){
		controlador = c;
	}
	
	public JPanel borrarClientes() {
		
		//borrado.setLayout(new GridLayout(5, 5, 0, 0));
		
		
		borrado.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cliente a borrar de la compañía",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel DNI = new JLabel("DNI del Cliente: ");
		borrado.add(DNI);
		this.DNIcliente = new JTextField();
		borrado.add(DNIcliente);
		this.DNIcliente.setColumns(9);
		
		JButton borrar = new JButton("BORRAR");
		
		borrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.removeCliente(DNIcliente.getText());
					//FIXME : !!!!Que lo haga todo el controlador!!!
					//y desde el propio modelo se mirará si existe
					// No puedes mirar nada directamente con el modelo, las operaciones
					// las ha de hacer el controlador sobre el modelo, no la vista
					
					// Cuando se ha borrado con exito, habira que indicarle algun mensaje
					// al usuario de que se ha realizado la operacion
				} catch (ClienteExcepcion e1) {
					e1.printStackTrace(); //Etoh qe eh? 
					JOptionPane.showMessageDialog(borrado, "Cliente no encontrado, imposible borrar");
					//FIXME Etoh eh algo que está mal ahora mismo, porque se ha de gestionar
					// la excepcion y no simplemente mostrar el error por consola
					// TODO si el cliente no esta en la base de datos, habra que mostrar un
					// dialogo indicando que no se ha podido borrar.
				}
			}
		});
		
		borrado.add(borrar);
		
		return borrado;
		//PersonalInfo.setLayout(new GridLayout(1, 1, 0, 0));
		
	}


	@Override
	public String getDNI() {
		return DNIcliente.getText();
	}
	

}
