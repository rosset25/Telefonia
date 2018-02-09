package genericos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

import aplicacion.Fechador;

public class Genericos {
	
	public static <T extends Fechador> Collection<T> recuperarEntreFechas( Collection<T> lista, LocalDateTime inicio, LocalDateTime fin) {
		LinkedList<T> fechasValidas = new LinkedList<T>();
		for(T dato : lista) {
			LocalDateTime fecha = dato.getFecha();
			if( fecha.compareTo(inicio) >= 0 && fecha.compareTo(fin) <= 0) {
				fechasValidas.add(dato);
			}
		}
		
		return fechasValidas;
	}
}
