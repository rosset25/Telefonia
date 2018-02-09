package clientes;

import java.util.Date;

public class Particular extends Cliente{	//Clase Hijo
	
	private static final long serialVersionUID = 6170137852616540159L;
	
	//Atributos
	
	private String apellidos;	//sólo una atributo más que Cliente
	
	/*Constructor
	 *
	*/
	
	public Particular(String DNI, String nombre, Direccion direccion, Tarifa tarifa, String e_mail, String apellidos) {
		super(DNI, nombre, direccion, tarifa, e_mail);
		this.apellidos = apellidos;
	}
	//////////////////////////////////7
	
	//gets y sets
	public String getApellidos() {
		return this.apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	////////////////////////////////

	
	//toString()
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-- CLIENTE --\n");
		sb.append("_____________\n\n");
		sb.append("	Nombre: " + this.getNombre() + "\n");
		sb.append("	Apellidos: " + this.apellidos + "\n");
		sb.append("	DNI: " + this.getDNI() + "\n");
		sb.append("	Direcci�n: \n" + this.getDireccion().toString() + "\n");
		sb.append("	Tarifa: " + this.getTarifa().toString() + "\n");
		sb.append("	e-mail: " + this.getE_mail() + "\n");
		return sb.toString();
	}
	//////////////////////////////////
}
