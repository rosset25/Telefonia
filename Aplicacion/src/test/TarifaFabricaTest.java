package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import Fabrica.FabricaCliente;
import Fabrica.FabricaClienteEstandar;
import Fabrica.FabricaTarifa1;
import Fabrica.FabricaTarifa2;
import Fabrica.FabricaTarifaParametizada1;
import Fabrica.FabricaTarifaParametizada2;
import clases.Llamada;
import clases.clientes.tarifa.Dia;
import clases.clientes.tarifa.Domingos;
import clases.clientes.tarifa.Sabados;
import clases.clientes.tarifa.Tarde;
import clases.clientes.tarifa.Tarifa;
import clases.clientes.tarifa.TarifaBasica;
import es.uji.www.GeneradorDatosINE;
import menus.MenuTipoTarifa1;
import menus.MenuTipoTarifa2;

public class TarifaFabricaTest {		
	
	GeneradorDatosINE generador = new GeneradorDatosINE();
	FabricaTarifa1 fabrica1 =new FabricaTarifaParametizada1();
	FabricaTarifa2 fabrica2 =new FabricaTarifaParametizada2();
	private Tarifa tarifa = new TarifaBasica(0.5);
	
	
	@Test
	public void testFabricaDecorador() {
		Tarifa dia = new Dia(tarifa,0.1);		//no se aplica
		Tarifa diaFabrica = fabrica1.getTipoTarifa(MenuTipoTarifa1.DIA, tarifa, 0.1);
		assertEquals(dia.toString(),diaFabrica.toString());
		
		Tarifa domingos= new Domingos(tarifa,0.0);	//no se aplica
		Tarifa domingosFabrica = fabrica2.getTipoTarifa(MenuTipoTarifa2.DOMINGOS, tarifa, 0.0);
		assertEquals(domingos.toString(),domingosFabrica.toString());
		
		Tarifa sabados= new Sabados(tarifa,0.4);	//se aplica
		Tarifa sabadosFabrica = fabrica2.getTipoTarifa(MenuTipoTarifa2.SABADOS, tarifa, 0.4);
		assertEquals(sabados.toString(),sabadosFabrica.toString());
		
		Tarifa tarde = new Tarde(tarifa,0.3);		//se aplica
		Tarifa tardeFabrica = fabrica1.getTipoTarifa(MenuTipoTarifa1.TARDE, tarifa, 0.3);
		assertEquals(tarde.toString(),tardeFabrica.toString());
		
		Tarifa nada = new TarifaBasica(0);
		Tarifa nadaFabrica = fabrica1.getTipoTarifa(MenuTipoTarifa1.NOCHE, tarifa, 0);
		assertEquals(nada.toString(),nadaFabrica.toString());
		
	
	}
		
}
