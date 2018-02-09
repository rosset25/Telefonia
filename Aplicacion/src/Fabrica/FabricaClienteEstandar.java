package Fabrica;

import java.io.Serializable;

import clases.clientes.Cliente;
import clases.clientes.Direccion;
import clases.clientes.Empresa;
import clases.clientes.Particular;
import clases.clientes.tarifa.Tarifa;

public class FabricaClienteEstandar implements FabricaCliente, Serializable{

	private static final long serialVersionUID = -9133715307860025676L;

	public FabricaClienteEstandar() {	//Constructor por defecto
		super();
	}

	@Override
	public Cliente getEmpresa(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail) {
		
		Cliente cliente = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		return cliente;
	}

	@Override
	public Cliente getParticular(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail,
			String apellidos) {
		
		Cliente cliente = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		return cliente;
	}
	
	
}
