package gestion;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;

import aplicacion.Fechador;


public interface Generica {
	
	public <T> boolean existe(T dato, TreeMap lista);
	
	public <T extends Fechador> LinkedList recuperarEntreFechas( LinkedList<T> lista, LocalDateTime inicio, LocalDateTime fin);

	public <U extends Fechador,T> LinkedList<U> recuperarLista(TreeMap<T,U> lista);
	
	public <V extends Fechador,T,U> LinkedList<V> recuperarListaDeLista(T dato,TreeMap<T,U> lista);
	
}
