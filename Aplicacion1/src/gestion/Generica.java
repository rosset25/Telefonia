package gestion;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;

import aplicacion.Fechador;

public interface Generica {
	
	public <T> boolean existe(T dato, TreeMap lista);
	
	public <T extends Fechador,U> LinkedList recuperarEntreFechas( TreeMap<U,T> lista, LocalDateTime inicio, LocalDateTime fin);

	public <U extends Fechador,T> LinkedList<U> recuperarLista(TreeMap<T,U> lista);
	
}
