package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import Fabrica.FabricaCliente;
import Fabrica.FabricaClienteEstandar;
import Fabrica.FabricaTarifa1;
import Fabrica.FabricaTarifaParametizada1;
import clases.Llamada;
import clases.clientes.tarifa.Dia;
import clases.clientes.tarifa.Domingos;
import clases.clientes.tarifa.Noche;
import clases.clientes.tarifa.Sabados;
import clases.clientes.tarifa.Tarde;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import es.uji.www.GeneradorDatosINE;
import menus.MenuTipoTarifa1;

public class TarifaDecoradorTest {		
	
	GeneradorDatosINE generador = new GeneradorDatosINE();
	FabricaTarifa1 fabrica =new FabricaTarifaParametizada1();
	private Tarifa tarifa = new TarifaBasica(0.5);
	
	
	@Test
	public void testFabricaDecorador() {
//		Tarifa dia = new Dia(tarifa,0.1);		//no se aplica
//		Tarifa diaFabrica = fabrica.getTipoTarifa(MenuTipoTarifa1.DIA, tarifa, 0.1);
//		assertEquals(dia.toString(),diaFabrica.toString());
		
		LocalDateTime fecha = LocalDateTime.of(2017, 3, 8, 1, 12);	//miércoles, fuera de ofertas
		LocalDateTime manyana = LocalDateTime.of(2017, 7, 1, 10, 40);	//martes
		LocalDateTime tarde = LocalDateTime.of(2017, 3, 7, 19, 12);	//martes
		LocalDateTime noche = LocalDateTime.of(2017, 3, 8, 22, 22);	//miércoles
		LocalDateTime sabadoNoches = LocalDateTime.of(2017, 3, 25, 22, 22);
		LocalDateTime domingoTardes = LocalDateTime.of(2017, 3, 26, 18, 43);
		LocalDateTime sabadoTardes = LocalDateTime.of(2017, 3, 25, 18, 44);
		LocalDateTime domingoManyanas = LocalDateTime.of(2017, 3, 26, 11, 12);
		
		Llamada llamManyana = new Llamada("65894875N","695800000",5.4, manyana);
		Llamada llamTarde = new Llamada("65894875N","695800000",5.4, tarde);
		Llamada llamNoche = new Llamada("65894875N","695800000",5.4, noche);
		Llamada llamSabNoche = new Llamada("65894875N","695800000",5.4, sabadoNoches);
		Llamada llamDomTarde = new Llamada("65894875N","695800000",5.4, domingoTardes);
		Llamada llamSabTarde = new Llamada("65894875N","695800000",5.4, sabadoTardes);
		Llamada llamDomManyana = new Llamada("65894875N","695800000",5.4, domingoManyanas);
		
		
		//TARIFA 1 (Sábado (tarde)) -- 25/3/2017 18:44
		Tarifa tarifa1 = new TarifaBasica(0.2);
		
		tarifa1 = new Tarde(tarifa1, 0.1);	//se aplica
		tarifa1 = new Sabados(tarifa1, 0);	//se aplica (gana)
		tarifa1 = new Dia(tarifa1, 0.12);	//no se aplica
		tarifa1 = new Noche(tarifa1, 0.1);	//no se aplica
		assertEquals(0,tarifa1.calcularPrecioLlamada(llamSabTarde), 0.01);
		System.out.println("me ha dado: " + tarifa1.calcularPrecioLlamada(llamSabTarde) + "y esperaba 0.0");
		
		//TARIFA 2 (Domingo (tarde)) -- 26/3/2017 18:43
		Tarifa tarifa2 = new TarifaBasica(0.3);	//no se aplica
		tarifa2 = new Sabados(tarifa2, 0);	//no se aplica
		tarifa2 = new Dia(tarifa2, 0.12);	//no se aplica
		tarifa2 = new Noche(tarifa2, 0.1);	//no se aplica
		assertEquals(1.62,tarifa2.calcularPrecioLlamada(llamDomTarde),0.01);
		System.out.println("me ha dado: " + tarifa2.calcularPrecioLlamada(llamDomTarde) + "y esperaba 1.62");
		
		//TARIFA 3 (Sábado (tarde)) -- 25/3/2017 18:44
		Tarifa tarifa3 = new TarifaBasica(0.2);
		tarifa3 = new Domingos(tarifa3, 0);	//no se aplica
		tarifa3 = new Dia(tarifa3, 0.12);	//no se aplica
		tarifa3 = new Tarde(tarifa3, 0.1);	//se aplica
		tarifa3 = new Noche(tarifa3, 0.1);	//no se aplica
		assertEquals(0.54,tarifa2.calcularPrecioLlamada(llamDomTarde), 0.01);
		
		//TARIFA 4 (Miércoles (noche) -- 8/3/2017 22:22
		Tarifa tarifa4 = new TarifaBasica(0.4);
		tarifa4 = new Noche(tarifa1, 0.12);	//se aplica
		tarifa4 = new Domingos(tarifa1, 0.15);	//no se aplica
		tarifa4 = new Noche(tarifa1, 0.01);	//se aplica (gana)
		tarifa4 = new Sabados(tarifa1, 0);	//no aplica 
		tarifa4 = new Dia(tarifa1, 0.12);	//no se aplica
		tarifa4 = new Noche(tarifa1, 0.1);	//se aplica 
		tarifa4 = new Domingos(tarifa1, 0);	//no se aplica
		tarifa4 = new Tarde(tarifa1, 0.2);	//no se aplica
		assertEquals(tarifa1.calcularPrecioLlamada(llamNoche),is(0.054));
		
	
	}
		
}
