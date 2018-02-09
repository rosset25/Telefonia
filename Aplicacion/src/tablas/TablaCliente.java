package tablas;

import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JTable;

import clases.clientes.Cliente;
import modeloDeTablas.ModeloTablaClientes;

public class TablaCliente extends JPanel{
	//es la propia tabla de clientes
	private static TablaCliente instance;
	
	public static TablaCliente getInstance(){
		instance = new TablaCliente();
		return instance;
	}
	
	ModeloTablaClientes modelo = new ModeloTablaClientes();
	Tabla TABLA = new Tabla();
	
	private TablaCliente(){
		TABLA.setModel(modelo);
		add(TABLA);
		validate();
		repaint();
	}
	
	public JTable getTable(){
		return TABLA.getTable();
	}
	
	public void mostrarTodosLosClientes(Collection<Cliente> all){
		ModeloTablaClientes modelo = new ModeloTablaClientes();
		modelo.setData(all);
		TABLA.setModel(modelo);
	}
	
	public void setModel(ModeloTablaClientes modelo2){
		TABLA.setModel(modelo2);
	}

}
