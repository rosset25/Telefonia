package clientes;	//TODO done

import java.io.Serializable;

public class Direccion implements Serializable{	//Atributo de la clase Cliente
	
	private static final long serialVersionUID = -833430712788765267L;
	
	//Atributos
	private String CP;
	private String poblacion;
	private String provincia;
	
	//Constructor
	public Direccion(String CP, String poblacion, String provincia) { 
		//como no voy a hacer operaciones con el CP, me lo guardo como String
		//int solo para cuando voy ha hacer operaciones
		this.CP = CP;
		this.poblacion = poblacion;
		this.provincia = provincia;		
	}
	
	
	//gets y sets
	public String getCP() {
		return CP;
	}

	public void setCP(String CP) {
		this.CP = CP;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	////////////////////////////////
	
	//toString()
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("		CP: " + this.CP + "\n");
		sb.append("		Província: " + this.provincia + "\n");
		sb.append("		Población: " + this.poblacion);
		return sb.toString();
	}
	/////////////////////////////////


}
