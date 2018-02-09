package clases.clientes.tarifa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import clases.Llamada;

public class prueba_decorador {

	public static void main(String[] args) {
		
		LocalDateTime fecha = LocalDateTime.of(2017, 3, 8, 1, 12);	//miércoles, fuera de ofertas
		LocalDateTime manyana = LocalDateTime.of(2017, 7, 3, 10, 40);	//martes
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
		
		Tarifa tarifa1 = new TarifaBasica(0.2);
		Tarifa tarifa2 = new TarifaBasica(0.3);
		
		tarifa1 = new Dia(tarifa1, 0.12);
		tarifa1 = new Sabados(tarifa1, 0.1);
//		
//		tarifa1 = new Noche(tarifa1, 0.1);
//		tarifa1 = new Sabados(tarifa1, 0);
//		tarifa1 = new Tarde(tarifa1, 0.4);
//		
//		//tarifa2 = new Sabados(tarifa2, 0);
//		tarifa1 = new Dia(tarifa2, 0.1);
//		tarifa1 = new Sabados(tarifa1, 0.1);
//		
//		tarifa1 = new Noche(tarifa1, 0.1);
//		tarifa1 = new Sabados(tarifa1, 0);
//		tarifa1 = new Tarde(tarifa1, 0);
		//tarifa2 = new Noche(tarifa2, 0.1);
		
		//TARIFA 4 (Miércoles (noche) -- 8/3/2017 22:22
				tarifa1 = null;
				tarifa1 = new TarifaBasica(0.4);
				tarifa1 = new Noche(tarifa1, 0.12);	//se aplica
				tarifa1 = new Domingos(tarifa1, 0.15);	//no se aplica
				tarifa1 = new Dia(tarifa1, 0.1);	//no se aplica
				tarifa1 = new Noche(tarifa1, 0.01);	//se aplica (gana)
				tarifa1 = new Sabados(tarifa1, 0);	//no aplica 
				tarifa1 = new Dia(tarifa1, 0.12);	//no se aplica
				//tarifa1 = new Noche(tarifa1, 0.1);	//se aplica 
				tarifa1 = new Domingos(tarifa1, 0);	//no se aplica
				tarifa1 = new Tarde(tarifa1, 0.2);	//no se aplica
				
				//double importe = tarifa1.calcularTipoOferta(llamManyana);
				double total= tarifa1.calcularPrecioLlamada(llamNoche);
				System.out.println(tarifa1.calcularPrecioLlamada(llamNoche));
				//System.out.println(tarifa2.calcularPrecioLlamada(llamDomTarde));

	}

}
