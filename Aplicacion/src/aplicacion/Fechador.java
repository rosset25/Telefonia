package aplicacion;

import java.time.LocalDateTime;

public interface Fechador {	// Cliente, Llamada y Factura usan esta interface
	
	public LocalDateTime getFecha(); 
}
