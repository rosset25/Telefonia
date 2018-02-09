package clases.clientes;		//TODO done

import clases.clientes.tarifa.Tarifa;

public class Empresa extends Cliente{  //Clase Hijo de Cliente 

	//No necesitamos ning�n atributo adicional
	
	
	private static final long serialVersionUID = 3030945013882921333L;

	//Constructor	
	public Empresa(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail) {
		super(DNI, nombre, direccion, tarifa, e_mail);
	}
	
	//No necesitamos cambiar el toString
} 
