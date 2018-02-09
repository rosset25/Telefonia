package test;	//TODO revisar TESTS!

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import clases.Llamada;
import es.uji.www.GeneradorDatosINE;
import static org.hamcrest.CoreMatchers.is;

public class LlamadaTest {
	
	GeneradorDatosINE generador;
	private String telefono = "658955111";
	private LocalDateTime fecha = LocalDateTime.now();
	private double duracion = 45.56;
	
	@Test
	public void testTelefono() {
		Llamada llamada = new Llamada("50000004N","666875409",4.1, fecha);
		assertEquals(llamada.getTelefono(),is(telefono));
		llamada.setTelefono("65899925");
		assertEquals(llamada.getTelefono(),is("65899925"));
		
	}
	
	@Test
	public void testDuracion(){
		Llamada llamada = new Llamada("50000004N","666875409",4.1, fecha);
		assertEquals(llamada.getDuracion(),is(duracion));
		
	}
	
	@Test
	public void testFecha(){
		Llamada llamada = new Llamada("50000004N","666875409",4.1, fecha);
		assertEquals(llamada.getFecha(),is(fecha));
		
	}

}
