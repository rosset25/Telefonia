package test;	

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

public class ClasesGenericas {
	
	GeneradorDatosINE generador = new GeneradorDatosINE();
	BaseDeDatos baseDatos = new BaseDeDatos();
	private LocalDateTime fecha = LocalDateTime.now();
	// TODO DONE crear 3 listas o 4, una de clientes(particular,empresa), una de llamadas y una de facturas
	// TODO DONE en cada uno de los 3 tests me hago un bucle y dentro inserto los datos, creandome clientes,facturas,llamadas para añadirlos en la lista, con facturas y llamadas lo mismo
	//luego llamar al metodo generico getEntreFechas
	//comprobar que los elementos que me ha devuelto el metodo son los que yo espero de la coleccion
	//en la lista original eliminar los que no estan entre las fechas y luego comprobar las dos listas
	
	@Test
	public void ClienteParticularGenerico() throws ClienteExcepcion{
		String DNI = generador.getNIF();
		String nombre = generador.getNombre();
		String e_mail = "pepito@uji.es";
		String provincia=generador.getProvincia();
		String poblacion=generador.getPoblacion(provincia);
		Direccion direccion = new Direccion("12600", provincia, poblacion);
		Tarifa tarifa = new TarifaBasica(0.2); 
		String apellidos = generador.getApellido();
		LinkedList<Cliente> listaClientesParticulares = new LinkedList<Cliente>();
		LocalDateTime fecha1 = LocalDateTime.now();
		LocalDateTime fecha2 = fecha1.plusDays(12);
		
		
		for(int i=1;i<20;i++){
			Cliente particular = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
			listaClientesParticulares.add(particular);
			baseDatos.addCliente(particular, DNI);
		}
		
		//ssertEquals(baseDatos.recuperarEntreFechas(baseDatos.getListaClientes(), fecha1, fecha2),is(listaClientesParticulares));
		
		
//		for(int i=1;i<8;i++){
//			Cliente particularUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
//			Cliente particularDos = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
//			Cliente particularTres = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
//			Cliente particularCuatro = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
//			Cliente particularCinco = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
//			Cliente particularSeis = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
//			Cliente particularSiete = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
//			Cliente particularOcho = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
//			LinkedList<Cliente> listaClientesParticulares = new LinkedList<Cliente>();
//			
//			//hay que llamar al metodo generico recuperarEntreFechas
//			//y hay que hacer la comprobacion assert
//		 }
	
		 
		
		 
	}
	
	@Test
	public void ClienteEmpresaGenerico() throws ClienteExcepcion{
		String DNI = generador.getNIF();
		String nombre = generador.getNombre();
		String e_mail = "pepito@uji.es";
		String provincia=generador.getProvincia();
		String poblacion=generador.getPoblacion(provincia);
		Direccion direccion = new Direccion("12600", provincia, poblacion);
		Tarifa tarifa = new TarifaBasica(0.2); 
		BaseDeDatos baseDatos = new BaseDeDatos();
		LinkedList<Cliente> listaClientesEmpresas = new LinkedList<Cliente>();
		LocalDateTime fecha1 = LocalDateTime.now();
		LocalDateTime fecha2 = fecha1.plusDays(12);
		
		for(int i=1;i<20;i++){
			Cliente empresa = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
			listaClientesEmpresas.add(empresa);
			baseDatos.addCliente(empresa, DNI);
		}		
		
		//assertEquals(baseDatos.recuperarEntreFechas(baseDatos.getListaClientes(), fecha1, fecha2),is(listaClientesEmpresas));
//		for(int i=1;i<8;i++){
//			Cliente empresaUno = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
//			Cliente empresaDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
//			Cliente empresaTres = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
//			Cliente empresaCuatro = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
//			Cliente empresaCinco = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
//			Cliente empresaSeis = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
//			Cliente empresaSiete = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
//			Cliente empresaOcho = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
//			LinkedList<Cliente> listaClientesEmpresa = new LinkedList<Cliente>();

//		}
	}
	
	
	@Test
	public void LlamadaGenerico(){
//		String telefono = "658955111";
//		LocalDateTime fecha = LocalDateTime.now();
//		double duracion = 45.56;
		LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();
		LocalDateTime fecha1 = LocalDateTime.now();
		LocalDateTime fecha2 = fecha1.plusDays(12);
		
		for(int i=1;i<20;i++){
			Llamada llamada = new Llamada("50000004N","666875409",4.1, fecha);
			listaLlamadas.add(llamada);
			baseDatos.addLlamada(llamada);
		}	
		
		//assertEquals(baseDatos.recuperarEntreFechas(baseDatos.getListaLlamadas(), fecha1, fecha2),is(listaLlamadas));
		
//		for(int i=1; i<8; i++){
//			Llamada llamada1 = new Llamada("50000004N","666875409",4.1);
//			Llamada llamada2 = new Llamada("50000004N","666875409",4.1);
//			Llamada llamada3 = new Llamada("50000004N","666875409",4.1);
//			Llamada llamada4 = new Llamada("50000004N","666875409",4.1);
//			Llamada llamada5 = new Llamada("50000004N","666875409",4.1);
//			Llamada llamada6 = new Llamada("50000004N","666875409",4.1);
//			Llamada llamada7 = new Llamada("50000004N","666875409",4.1);
//			Llamada llamada8 = new Llamada("50000004N","666875409",4.1);
//			LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();	
//		}
	
	}
	
	
	@Test 
	public void FacturaGenerico(){
		Tarifa tarifa = new TarifaBasica(0.5);
		double importe = 3.6;
		LocalDateTime inicio= LocalDateTime.now(); 
		LocalDateTime fin= inicio.plusMonths(1);
		LinkedList<Llamada> listaLlamadas = new LinkedList<Llamada>();
		Llamada llamada1 = new Llamada("65894875N","695800000",5.4, fecha);
		listaLlamadas.add(llamada1);
		Llamada llamada2 = new Llamada("00000528N","666666888",4.1, fecha);
		listaLlamadas.add(llamada2);
		Llamada llamada3 = new Llamada("11111111F","589999922",3.8, fecha);
		listaLlamadas.add(llamada3);
		LinkedList<Factura> listaFacturas = new LinkedList<Factura>();
		
		for(int i=1;i<20;i++){
			Factura factura = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
			listaFacturas.add(factura);
		}	
		
//		for(int i=1; i<8; i++){
//			Factura factura1 = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
//			Factura factura2 = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
//			Factura factura3 = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
//			Factura factura4 = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
//			Factura factura5 = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
//			Factura factura6 = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
//			Factura factura7 = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
//			Factura factura8 = new Factura(generador.getNIF(),listaLlamadas,inicio,fin,tarifa);
//			LinkedList<Factura> listaFacturas = new LinkedList<Factura>();
//		}
	}
	
	
}
