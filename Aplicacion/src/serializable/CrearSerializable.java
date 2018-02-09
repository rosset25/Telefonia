package serializable;	

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
		//TODO NO SE CARGA POSIBLEMETE POR UN ERROR EN EL GUARDADO
		// Revisar que todas las clases implementen Serializable y tengan su ID bien
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
				FileOutputStream fos = new FileOutputStream("BaseDeDatosCompanyia.bin");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(principal);
				System.out.println("Guardado COMPLETADO");
			}
			catch (Exception e){
				System.out.println("Se ha producido un error al guardar");
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
