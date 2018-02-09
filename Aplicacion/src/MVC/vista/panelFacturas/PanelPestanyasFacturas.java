package MVC.vista.panelFacturas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelPestanyasFacturas {
	
	public PanelPestanyasFacturas() {
		//constructor por defecto
	}
	
	
	public JTabbedPane iniciarPestanyasFacturas() {
		
		JTabbedPane opcionesFacturas= new JTabbedPane();
		
		JPanel crearFactura = new JPanel();
		opcionesFacturas.add("Crear Factura",crearFactura);
		//set de controlador3 que se le pasará
		
		JPanel facturaCodigo = new JPanel();
		opcionesFacturas.add("Factura por código",facturaCodigo);
		//set de controlador3 que se le pasará
		
		JPanel facturaCliente = new JPanel();
		opcionesFacturas.add("Factura por Cliente",facturaCliente);
		//set de controlador3 que se le pasará
		
		JPanel facturaFechas = new JPanel();
		opcionesFacturas.add("Listado Facturas (fechas)",facturaFechas);
		//set de controlador3 que se le pasar
		
		
		return opcionesFacturas;
	}

}
