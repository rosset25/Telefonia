package test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.Test;

import Fabrica.FabricaCliente;
import Fabrica.FabricaClienteEstandar;
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


public class FabricaClienteTest {
	
	GeneradorDatosINE generador = new GeneradorDatosINE();
	
	FabricaCliente fabrica =new FabricaClienteEstandar();
	
	
	@Test //particular
	public void ClienteParticuarTest(){
		 String DNI = generador.getNIF();
		 String nombre = generador.getNombre();
		 String e_mail = "pepito@uji.es";
		 String provincia=generador.getProvincia();
		 String poblacion=generador.getPoblacion(provincia);
		 Direccion direccion = new Direccion("12600", provincia, poblacion);
		 Tarifa tarifa = new TarifaBasica(0.2); 
		 String apellidos = generador.getApellido();
		 
		 Cliente cUno = new Particular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		 Cliente clienteFabrica = fabrica.getParticular(DNI, nombre, direccion, tarifa, e_mail, apellidos);
		 assertEquals(cUno.toString().substring(0, clienteFabrica.toString().length()-4),clienteFabrica.toString().substring(0, clienteFabrica.toString().length()-4));
		
	}
	
	@Test	//empresa
	public void ClienteEmpresaTest(){
		 String DNI = generador.getNIF();
		 String nombre = generador.getNombre();
		 String e_mail = "pepito@uji.es";
		 String provincia=generador.getProvincia();
		 String poblacion=generador.getPoblacion(provincia);
		 Direccion direccion = new Direccion("12600", provincia, poblacion);
		 Tarifa tarifa = new TarifaBasica(0.2); 

		 
		 Cliente cDos = new Empresa(DNI, nombre, direccion, tarifa, e_mail);
		 Cliente clienteFabrica = fabrica.getEmpresa(DNI, nombre, direccion, tarifa, e_mail);
		 assertEquals(cDos.toString().substring(0, clienteFabrica.toString().length()-4),clienteFabrica.toString().substring(0, clienteFabrica.toString().length()-4));
		
	}
}
