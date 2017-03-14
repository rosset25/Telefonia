package serializable;	//TODO NO SE GUARDA

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import aplicacion.BaseDeDatos;


public class CrearSerializable {
	
	public static BaseDeDatos cargarBaseDeDatos() {
		BaseDeDatos principal = new BaseDeDatos();
		
		try {
			FileInputStream fis = new FileInputStream("BaseDeDatosCompanyia.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois = new ObjectInputStream(fis);
			principal = (BaseDeDatos)ois.readObject();
		
		}catch(FileNotFoundException exc) {
			System.err.println("Fichero de datos no existe. Se crea una nueva BaseDeDatos.");
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc) {
			exc.printStackTrace();
		}
		
		return principal;
	
	}
	
		
	public static void guardarBaseDeDatos(BaseDeDatos principal) {
		ObjectOutputStream oos=null;
		try {
			try {
				FileOutputStream fos = new FileOutputStream("agenda.bin");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(principal);
			}
			finally {
				oos.close();
				System.out.println("Guardado COMPLETADO");
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
