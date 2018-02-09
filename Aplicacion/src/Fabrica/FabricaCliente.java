package Fabrica;

import clases.clientes.Cliente;
import clases.clientes.Direccion;
import clases.clientes.tarifa.Tarifa;

public interface FabricaCliente {

	public Cliente getEmpresa(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail) ;	
	public Cliente getParticular(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail, String apellidos); 
	
}
