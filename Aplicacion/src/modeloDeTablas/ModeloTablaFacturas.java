package modeloDeTablas;

import java.util.Collection;

import javax.swing.table.AbstractTableModel;

import clases.Factura;
import clases.clientes.Cliente ;

public class ModeloTablaFacturas extends AbstractTableModel{
	private final String nameColumns[] = {"DNI","tarifa","importe","fecha","emision","fin","ID"}; //si hacen falta mas datos se añaden, si ves que alguno no es necesario quitalo
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
	
	public void setData(Collection<Factura> information){
		//se crea la tabla del tamaño que toca
		this.data = new String[information.size()][nameColumns.length];
		
		//se itera sobre la coleccion que se ha pasado y se extraen los datos
		int i=0;
		for(Factura actual : information){
			data[i][0] = actual.getDNI();
			data[i][1] = actual.getTarifa();
			data[i][2] = actual.getImporteTarifa();
			data[i][3] = actual.getFecha().toString();
			data[i][4] = actual.getFechaEmision().toString();
			data[i][5] = actual.getFin().toString();
			data[i][6] = actual.getID();
			
			i++;
			
		}
	}
	
	

}
