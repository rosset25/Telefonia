package aplicacion;

import java.time.LocalDateTime;
import java.util.Date;

public interface Fechador {	// Cliente, Llamada y Factura usan esta interface
	
	public LocalDateTime getFecha(); 
}
