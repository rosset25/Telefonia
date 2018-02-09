package MVC.controlador;

import java.util.Collection;

import MVC.modelo.Modelo;
import MVC.vista.panelClientes.VistaDNI;
import MVC.vista.panelClientes.VistaDatosCliente;
import MVC.vista.panelClientes.VistaTarifa;
import clases.clientes.Cliente;
import excepciones.ClienteExcepcion;

public interface Controlador1 {

	/* Sets de las diferentes Vistas para los Clientes */
	public void setVistaPanelCrearCliente(VistaDatosCliente v1, VistaDNI v2);

	public void setVistaPanelTarifa(VistaTarifa v);

	public void setVistaPanelBorrarCliente(VistaDNI v);

	public void setVistaCambiarTarifa(VistaDNI v);

	public void setModelo(Modelo modelo);

	// hecho
	public void removeCliente(String DNI) throws ClienteExcepcion;

	/**
	 * Indica al controlador que en la vista se ha pulado la opcion de mostrar
	 * los datos de un cliente
	 * 
	 * @param DNI
	 *            String que indica el DNI del cliente que se desea mostrar
	 * @throws ClienteExcepcion
	 *             En caso de que el cliente no este en la base de datos se
	 *             lanza una excepcion
	 */

	public Cliente getCliente(String DNI) throws ClienteExcepcion;

	/**
	 * Indica al controlador que se quieren ver todos los clientes guardados en
	 * la aplicacion.
	 * 
	 * @return List<Clientes> que contiene todos los clientes de la aplicacion
	 */

	public Collection<Cliente> getListaClientes();

	/**
	 * Indica al controlador que se ha pulsado sobre la opcion de crear cliente.
	 * Tras esta llamada el controlador recogerá todos los datos del cliente de
	 * la vista mediante la interfaz ObtenerDatosVista y creara el cliente para
	 * insertarlo en la base de datos.
	 */

	// hecho
	public void addCliente(int opcionTarifa1, int opcionTarifa2, int tipoCliente) throws ClienteExcepcion;

	/**
	 * Indica al controlador que se ha pulsado en actualizar la informacion de
	 * un cliente. El controlador tendra que recoger dicha informacion de la
	 * vista para modificar los campos que sean neceasrios. Los datos se
	 * obtienen mediante la interfaz ObtenerDatosVista.
	 * 
	 * NOTA: Este metodo es el empleado para actualizar la tarifa de un cliente.
	 * 
	 * @param DNI
	 *            String que contiene el DNI del cliente que se desea actualizar
	 * @throws ClienteException
	 *             En caso de que el cliente no exista en la base de datos.
	 */

	// hecho
	public void cambiarTarifaCliente(int op1, int op2) throws ClienteExcepcion;

	/**
	 * Indica al modelo que ha de guardar los datos en memoria porque se cierra
	 * la aplicación
	 */
	public void salir();
}
