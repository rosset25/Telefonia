package test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.Test;

import aplicacion.BaseDeDatos;
import clases.Factura;
import clases.Llamada;
import clases.clientes.Cliente;
import clases.clientes.Direccion;
import clases.clientes.Empresa;
import clases.clientes.Particular;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import es.uji.www.GeneradorDatosINE;
import excepciones.ClienteExcepcion;

public class BasedeDatos {
	
	GeneradorDatosINE generador = new GeneradorDatosINE();
	
	private String DNI = generador.getNIF();
	private String nombre = generador.getNombre();
	private String e_mail = "pepito@uji.es";
	private String provincia=generador.getProvincia();
	private String poblacion=generador.getPoblacion(provincia);
	private Direccion direccion = new Direccion("12600", provincia, poblacion);
	private LocalDateTime fechaAlta = LocalDateTime.now(); 
	private Tarifa tarifa = new TarifaBasica(0.2); 
	private String apellidos = generador.getApellido();
	
	
	private double importe = 5.75;
	private LocalDateTime fechaEmision = LocalDateTime.now();
	private LocalDateTime inicio= LocalDateTime.now(); //sale en rojo porque ya esta anticuado ese formato de fecha, pero es correcto
	private LocalDateTime fin= inicio.plusMonths(1);
	
	
	BaseDeDatos basedatos = new BaseDeDatos();
	
	
	@Test
	public void testGetCliente() throws ClienteExcepcion {
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		cUno.setDNI("12584875N");
		cDos.setDNI("12584875N");
		assertEquals(cUno.getDNI(),is("53789790N"));
		assertEquals(cDos.getDNI(),is("53789790N"));
		assertNull(basedatos.getCliente("5378979NN"));
	}
	
	
	
	@Test
	public void testRemoveCliente() throws ClienteExcepcion {
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		cUno.setDNI("53789790N");
		cDos.setDNI("53789790N");
		basedatos.getCliente(DNI);
		
		//assertThat(basedatos.removeCliente(cUno.getDNI()), is(true));
		//assertThat(basedatos.removeCliente(cUno.getDNI()), is(false));
		//assertThat(basedatos.removeCliente(cDos.getDNI()), is(true));
		//assertThat(basedatos.removeCliente(cDos.getDNI()), is(false));
	}
	
	
	
	@Test
	public void testGetFactura() throws ClienteExcepcion {
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		cUno.setDNI("53789790N");
		cDos.setDNI("53789790N");
		basedatos.getCliente(DNI);
		LocalDateTime fecha1 = LocalDateTime.of(2017, 2, 2, 5, 15);
		LocalDateTime fecha2 = LocalDateTime.of(2016, 6, 30, 18, 0);
		Llamada llamada1 = new Llamada("65894875N","695800000",5.4, fecha1);
		Llamada llamada2 = new Llamada("00000528N","666666888",4.1, fecha2);
		Llamada llamada3 = new Llamada("11111111F","589999922",3.8, fecha1);
		LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();
		Factura factura = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
		factura.getID();
		factura.getDNI();
		basedatos.getFactura(factura.getID());
		
		assertEquals(basedatos.getFactura(1), factura);
		assertNull(basedatos.getFactura(123));
	}
	
	@Test
	public void testAddCliente(){
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		cUno.setDNI("53789790N");
		cDos.setDNI("53789790N");
		try {
			basedatos.getCliente(DNI);
			fail("53789790N no esta en la base de datos");
		} catch (ClienteExcepcion e) {
			
		}
		//assertThat(basedatos.addCliente(cUno,cUno.getDNI()), is(false));
		//assertThat(basedatos.addCliente(cDos,cDos.getDNI()), is(false));
		//assertThat(basedatos.addCliente(cUno,cUno.getDNI()), is(true));
		//assertThat(basedatos.addCliente(cDos,cDos.getDNI()), is(true));
	}
	
		
	

}
