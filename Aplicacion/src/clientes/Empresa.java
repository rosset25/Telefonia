package clientes;		//TODO done

import java.io.Serializable;
import java.util.Date;

public class Empresa extends Cliente{  //Clase Hijo de Cliente 

	//No necesitamos ningún atributo adicional
	
	
	private static final long serialVersionUID = 3030945013882921333L;

	//Constructor	
	public Empresa(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail) {
		super(DNI, nombre, direccion, tarifa, e_mail);
	}
	
	//No necesitamos cambiar el toString
} 
