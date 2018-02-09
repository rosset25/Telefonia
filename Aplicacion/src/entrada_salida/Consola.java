package entrada_salida;

import java.util.Scanner;

public class Consola implements Input,Output {	//  Output<> <-- Consola --> Input<>
	
	/*
	 * Punto de relaci�n entre entrada y salida
	 * que est�n desacopladas
	 * 
	 */
	
	private Scanner scanner = new Scanner(System.in);

	public Consola() {	//Constructor por defecto
		
	}
	
	@Override
	public void mostrarString(String mensaje) {	//Muestra por pantalla
		System.out.println(mensaje);
		
	}

	@Override
	public String leerString() {	//Lee una cadena
		return scanner.nextLine();
	}

	@Override
	public int leerInt() {	//Lee un entero
							/* Por el momento no lo usamos, 
							pero está por si acaso tuviéramos que leer un entero */
		int numero = scanner.nextInt();	//TODO lanzar excepci�n
		scanner.nextLine();	//Por si acaso se queda sin leer \n
		return numero;
	}

	@Override
	public double leerDouble() {	//Lee un número en coma flotante
		double numero = scanner.nextDouble();	//TODO lanzar excepcion
		scanner.nextLine();	//Por si acaso se queda sin leer \n
		return numero;
	}
	
	@Override
	public long leerLong() {
		long numero = scanner.nextLong();
		scanner.nextLine();
		return numero;
	}
	
	

}
