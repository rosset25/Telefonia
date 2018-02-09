package tablas;

import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JTable;

import clases.Llamada;
import clases.clientes.Cliente;
import modeloDeTablas.ModeloTablaClientes;
import modeloDeTablas.ModeloTablaLlamadas;

public class TablaLlamada extends JPanel{
	
	//es la propia tabla de llamadas
		private static TablaLlamada instance;
		
		public static TablaLlamada getInstance(){
			if(instance == null){
				instance = new TablaLlamada();
			}
			return instance;
		}
		
		ModeloTablaLlamadas modelo = new ModeloTablaLlamadas();
		Tabla TABLA = new Tabla();
		
		private TablaLlamada(){
			TABLA.setModel(modelo);
			add(TABLA);
			validate();
			repaint();
		}
		
		public JTable getTable(){
			return TABLA.getTable();
		}
		
		public void mostrarTodasLasLlamadas(Collection<Llamada> all){
			ModeloTablaLlamadas modelo = new ModeloTablaLlamadas();
			modelo.setData(all);
			TABLA.setModel(modelo);
		}
		
		public void setModel(ModeloTablaLlamadas modelo2){
			TABLA.setModel(modelo2);
		}

}
