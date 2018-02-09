package test;	//TODO revisar TESTS!

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import clases.clientes.Cliente;
import clases.clientes.Direccion;
import clases.clientes.Empresa;
import clases.clientes.Particular;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import es.uji.www.GeneradorDatosINE;

public class ClienteTest {
	GeneradorDatosINE generador;
	private String DNI = generador.getNIF();
	private String nombre = generador.getNombre();
	
	private String e_mail = "pepito@uji.es";
	private String provincia=generador.getProvincia();
	private String poblacion=generador.getPoblacion(provincia);
	private Direccion direccion = new Direccion("12600", provincia, poblacion);
	private LocalDateTime fechaAlta = LocalDateTime.now(); 
	private Tarifa tarifa = new TarifaBasica(0.5); // FIXME Esto es necesario que sea un objeto
								// de la clase Tarifa (HAY QUE CREARLA..... PEREZAAAA
	private String apellidos = generador.getApellido();
	//falta poner el tipo de cada uno(String..bla bla)
	
	@Test	
	public void testFecha(){
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		assertEquals(cUno.getFecha(),is(fechaAlta));
		assertEquals(cDos.getFecha(),is(fechaAlta));
		
		
	}
	
	@Test
	public void testDNI(){
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		assertEquals(cUno.getDNI(),is(DNI));
		assertEquals(cDos.getDNI(),is(DNI));
		cUno.setDNI("5248762J");
		assertEquals(cUno.getDNI(),is("5248762J"));
		cDos.setDNI("5589684M");
		assertEquals(cDos.getDNI(),is("5589684M"));
	}
	
	@Test
	public void testNombre(){
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		assertEquals(cUno.getNombre(),is(nombre));
		assertEquals(cDos.getNombre(),is(nombre));
		cUno.setNombre("maria");
		assertEquals(cUno.getNombre(),is("maria"));
		cDos.setNombre("juan");
		assertEquals(cDos.getNombre(),is("juan"));
	}
	
	@Test
	public void testDireccion(){
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		assertEquals(cUno.getDireccion(),is(direccion));
		assertEquals(cDos.getDireccion(),is(direccion));
		Direccion direccion1 = new Direccion("12345","Valencia","Valencia");	
		cUno.setDireccion(direccion1);
		assertEquals(cUno.getDireccion(),is(direccion1));
		Direccion direccion2 = new Direccion("12580","Castellon","Castellon");
		cDos.setDireccion(direccion2);
		assertEquals(cDos.getDireccion(),is(direccion2));
	}
	
	@Test
	public void testTarifa(){
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		assertEquals(cUno.getTarifa(),is(tarifa));	
		assertEquals(cDos.getTarifa(),is(tarifa));	
		
	}
	
	@Test
	public void testApellidos(){
		Particular cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		assertEquals(cUno.getApellidos(),is(apellidos));
		cUno.setApellidos("martinez");
		assertEquals(cUno.getApellidos(),is("martinez"));
	}
	
	@Test
	public void testE_mail(){
		Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		assertEquals(cUno.getE_mail(),is(e_mail));
		assertEquals(cDos.getE_mail(),is(e_mail));
		cUno.setE_mail("pepito@uji.es");
		assertEquals(cUno.getE_mail(),is("pepito@uji.es"));
		cDos.setE_mail("pepa@uji.es");
		assertEquals(cDos.getE_mail(),is("pepa@uji.es"));
		

		
	}

}
