package vista;

import java.util.Scanner;

public class Consola implements Input,Output {	//  Output<> <-- Consola --> Input<>
	
	/*Esta clase, la intención de separar entrada y salida, está hecha
	 * para hacer de intermediario y ser usada por el menú.
	 * Con ella podremos mostrar por pantalla en el menú lo que nos 
	 * interese, sin necesidad de cambiar el menú en caso de que no usemos
	 * syso para sacar por pantalla los elementos
	 * Más adelante se pretende añadir más métodos o posibilidades
	 * en función de la aplicación
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
		int numero = scanner.nextInt();
		scanner.nextLine();	//Por si acaso se queda sin leer \n
		return numero;
	}

	@Override
	public double leerDouble() {	//Lee un número en coma flotante
		double numero = scanner.nextDouble();
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
