package inicio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import aplicacion.BaseDeDatos;
import entrada_salida.Consola;
import gestion.Principal;

public class Inicio {
	
	private BaseDeDatos telefonia = new BaseDeDatos();	//será como nuestra "Base de Datos" y el menú operará con él

	public Inicio() {
		
	}
	
	public void iniciarPrograma() {
		
		recuperarDatos();
		
		Consola consola = new Consola();  //Es la case que implementa la entrada y la salida
		Principal menu = new Principal();
		
		/*en vez de crear un menú al que le pasemos los parámetros, 
		usamos los sets para "inicializarlo"
		*/
		
		menu.setInput(consola);	
		menu.setOutput(consola);
		menu.setOperaciones(telefonia); //con ello ya podemos usar la interfaz sin 
		
		menu.iniciar();
		
		almacenarDatos();
		
		
	}
	
	
	private void recuperarDatos() {
		ObjectInputStream ois = null;
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
	
	
	private void almacenarDatos() {
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
		
	}
	
	
}
