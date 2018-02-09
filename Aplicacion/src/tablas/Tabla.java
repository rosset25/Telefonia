package tablas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class Tabla extends JPanel{
	
	private JTable tabla;
	JScrollPane scrollPane_1;
	
	//se crea el panel
	public Tabla(){
		scrollPane_1 = new JScrollPane();
		add(scrollPane_1);
		
		tabla = new JTable();
		scrollPane_1.setViewportView(tabla); //creo la tabla y la añado al panel
		
		tabla.setAutoCreateRowSorter(true); //para poder reordenar las filas en funcion de la columna
		
	}
	
	public void setModel(TableModel modelo){
		tabla.setModel(modelo);
	}
	
	public TableModel getModel(){
		return tabla.getModel();
	}
	
	public JTable getTable(){
		return tabla;
	}
	
	public JScrollPane getScrollPanel(){
		return this.scrollPane_1;
	}

}
