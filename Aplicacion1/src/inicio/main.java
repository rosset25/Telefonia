package inicio;

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
		
		
		Inicio inicio = new Inicio();
		inicio.iniciarPrograma();

		
	}
	
	
}
