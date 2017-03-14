package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import aplicacion.BaseDeDatos;

public class main implements Serializable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	
		BaseDeDatos telefonia = new BaseDeDatos();	//será como nuestra "Base de Datos" y el menú operará con él
		Consola consola = new Consola();  //Es la case que implementa la entrada y la salida
		Principal menu = new Principal();
		
		/*en vez de crear un menú al que le pasemos los parámetros, 
		usamos los sets para "inicializarlo"
		*/
		
		
		menu.setInput(consola);	
		menu.setOutput(consola);
		menu.setOperaciones(telefonia); //con ello ya podemos usar la interfaz sin 
		
		
		menu.iniciar();
		
	}
	
	
}
