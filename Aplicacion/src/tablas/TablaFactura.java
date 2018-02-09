package tablas;

import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JTable;

import clases.Factura;
import clases.clientes.Cliente;
import modeloDeTablas.ModeloTablaClientes;
import modeloDeTablas.ModeloTablaFacturas;

public class TablaFactura extends JPanel{
	
	//es la propia tabla de facturas
		private static TablaFactura instance;
		
		public static TablaFactura  getInstance(){
			if(instance == null){
				instance = new TablaFactura ();
			}
			return instance;
		}
		
		ModeloTablaFacturas modelo = new ModeloTablaFacturas();
		Tabla TABLA = new Tabla();
		
		private TablaFactura(){
			TABLA.setModel(modelo);
			add(TABLA);
			validate();
			repaint();
		}
		
		public JTable getTable(){
			return TABLA.getTable();
		}
		
		public void mostrarTodasLasFacturas(Collection<Factura> all){
			ModeloTablaFacturas modelo = new ModeloTablaFacturas();
			modelo.setData(all);
			TABLA.setModel(modelo);
		}
		
		public void setModel(ModeloTablaFacturas modelo2){
			TABLA.setModel(modelo2);
		}

}
