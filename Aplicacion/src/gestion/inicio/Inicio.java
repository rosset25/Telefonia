package gestion.inicio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import aplicacion.BaseDeDatos;
import entrada_salida.Consola;
import excepciones.ClienteExcepcion;
import gestion.Principal;

public class Inicio {
	
	private BaseDeDatos telefonia = new BaseDeDatos();	//Nuestra Base de Datos

	public Inicio() {
		
	}
	
	public void iniciarPrograma() throws ClienteExcepcion {
		
		recuperarDatos();
		
		Consola consola = new Consola();  //Es la case que implementa la entrada y la salida
		Principal menu = new Principal();	//Opciones de los men�s
		
		menu.setInput(consola);	
		menu.setOutput(consola);
		menu.setOperaciones(telefonia); //Para relacionar la Base de Datos con los men�s 
		
		menu.iniciar();	//Iniciar programa (pantalla men�s)
		
		almacenarDatos();
		
		System.exit(0);
		
	}
	
	
	private void recuperarDatos() {		//Recuperar datos o crear un nuevo fichero
		ObjectInputStream ois = null;	//en caso de que no exista ninguno
		try{
			try {
				FileInputStream fis = new FileInputStream("telefonia.bin");
				ois = new ObjectInputStream(fis);
				telefonia = (BaseDeDatos)ois.readObject();
			}
			finally {
				if(ois != null) ois.close();
			}
		}
		catch(FileNotFoundException exc) {
			System.err.println("Fichero de datos no existe. Se crea una nueva Base de Datos.");
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc) {
			exc.printStackTrace();
		}
		
			
	}
	
	
	private void almacenarDatos() {	//Almacenar los datos antes de finalizar programa
		ObjectOutputStream oos=null;
		try {
			try {
				FileOutputStream fos = new FileOutputStream("telefonia.bin");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(telefonia);
			}
			finally {
				oos.close();
			}
		}
		catch(FileNotFoundException exc) {
			System.out.println("El fichero no existe.");
			exc.printStackTrace();
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		
		System.out.println("Guardado completado");
		
	}
	
	
}
