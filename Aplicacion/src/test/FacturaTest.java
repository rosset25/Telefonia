package test;	//TODO revisar TESTS!

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.Test;

import clases.Factura;
import clases.Llamada;
import clases.clientes.Cliente;
import clases.clientes.Direccion;
import clases.clientes.Particular;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import es.uji.www.GeneradorDatosINE;
public class FacturaTest {
	GeneradorDatosINE generador;
	private Tarifa tarifa = new TarifaBasica(0.5);	//mirar CLASE TARIFA
	private double importe = 3.6;
	private LocalDateTime fechaEmision = LocalDateTime.now();
	private LocalDateTime inicio= LocalDateTime.now(); //sale en rojo porque ya esta anticuado ese formato de fecha, pero es correcto
	private LocalDateTime fin= inicio.plusMonths(1);
	private LocalDateTime fecha1 = LocalDateTime.of(2017, 2, 2, 5, 15);
	private LocalDateTime fecha2 = LocalDateTime.of(2016, 6, 30, 18, 0);

	@Test
	public void testTarifa() {
		Direccion direccion = new Direccion("12345","Valencia","Valencia");
		Tarifa tarifa = new TarifaBasica(0.5);
		Cliente cliente = new Particular(generador.getNIF(),generador.getNombre(), direccion, tarifa,"e_mail", generador.getApellido());
		Llamada llamada1 = new Llamada("65894875N","695800000",5.4, fecha1);
		Llamada llamada2 = new Llamada("00000528N","666666888",4.1, fecha1);
		Llamada llamada3 = new Llamada("11111111F","589999922",3.8, fecha2);
		LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();
		Factura factura = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
		assertEquals(factura.getTarifa(),is(tarifa));
		
	}
	
	@Test
	public void testImporte(){
		Direccion direccion = new Direccion("12345","Valencia","Valencia");
		Tarifa tarifa = new TarifaBasica(0.5);
		Cliente cliente = new Particular(generador.getNIF(),generador.getNombre(), direccion, tarifa,"e_mail", generador.getApellido());
		Llamada llamada1 = new Llamada("65894875N","695800000",5.4, fecha1);
		Llamada llamada2 = new Llamada("00000528N","666666888",4.1, fecha1);
		Llamada llamada3 = new Llamada("11111111F","589999922",3.8, fecha2);
		LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();
		Factura factura = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
		assertEquals(factura.getImporteTarifa(),is(importe));
		
	}
	
	@Test
	public void testFechaEmision(){
		Direccion direccion = new Direccion("12345","Valencia","Valencia");
		Tarifa tarifa = new TarifaBasica(0.5);
		Cliente cliente = new Particular(generador.getNIF(),generador.getNombre(), direccion, tarifa,"e_mail", generador.getApellido());
		Llamada llamada1 = new Llamada("65894875N","695800000",5.4, fecha1);
		Llamada llamada2 = new Llamada("00000528N","666666888",4.1, fecha1);
		Llamada llamada3 = new Llamada("11111111F","589999922",3.8, fecha2);
		LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();
		Factura factura = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
		assertEquals(factura.getFechaEmision(),is(fechaEmision));
	
		
	}
	
	@Test 
	public void testFechaInicio(){
		Direccion direccion = new Direccion("12345","Valencia","Valencia");
		Tarifa tarifa = new TarifaBasica(0.5);
		Cliente cliente = new Particular(generador.getNIF(),generador.getNombre(), direccion, tarifa,"e_mail", generador.getApellido());
		Llamada llamada1 = new Llamada("65894875N","695800000",5.4, fecha1);
		Llamada llamada2 = new Llamada("00000528N","666666888",4.1, fecha1);
		Llamada llamada3 = new Llamada("11111111F","589999922",3.8, fecha2);
		LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();
		Factura factura = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
		assertEquals(factura.getInicio(),is(inicio));
	
		
	}
	
	@Test
	public void testFechaFfin(){
		Direccion direccion = new Direccion("12345","Valencia","Valencia");
		Tarifa tarifa = new TarifaBasica(0.5);
		Cliente cliente = new Particular(generador.getNIF(),generador.getNombre(), direccion, tarifa,"e_mail", generador.getApellido());
		Llamada llamada1 = new Llamada("65894875N","695800000",5.4, fecha1);
		Llamada llamada2 = new Llamada("00000528N","666666888",4.1, fecha1);
		Llamada llamada3 = new Llamada("11111111F","589999922",3.8, fecha2);
		LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();
		Factura factura = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
		assertEquals(factura.getFin(),is(fin));
		
		
		
	}
}
