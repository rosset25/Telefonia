package modeloDeTablas;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import clases.clientes.Cliente;
//sirve para introducir los datos de los clientes
//hacer lo mismo para facturas y llamadas, es todo igual lo unico que se cambia son los nombres que se quieren mostrar
public class ModeloTablaClientes extends AbstractTableModel{
	
	private final String nameColumns[] = {"DNI","nombre","direccion","fecha"}; //si hacen falta mas datos se añaden
	private Object data[][] = new String[0][nameColumns.length];
	
	@Override
	public int getColumnCount() {
		return nameColumns.length;
	}
	@Override
	public int getRowCount() {
		return data.length;
	}
	@Override
	public Object getValueAt(int i, int j) {
		return data[i][j];
	}
	
	@Override
	public String getColumnName(int column){
		return nameColumns[column];
	}
	
	public void setData(Collection<Cliente> information){
		//se crea la tabla del tamaño que toca
		this.data = new String[information.size()][nameColumns.length];
		
		//se itera sobre la coleccion que se ha pasado y se extraen los datos
		int i=0;
		for(Cliente actual : information){
			data[i][0] = actual.getDNI();
			data[i][1] = actual.getNombre();
			data[i][2] = actual.getDireccion().toString();
			data[i][3] = actual.getFecha().toString();
			i++;
			
		}
	}
	
	
	
	
	

}
