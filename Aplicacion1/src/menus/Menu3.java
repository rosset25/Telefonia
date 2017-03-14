package menus;

public enum Menu3 {
	
	NUEVA_FACTURA("Emitir factura para un cliente"),
	CODIGO(" Recuperar datos de una factura a partir de su cÃ³digo"),
	FACTURA_CLIENTE("Recuperar todas las facturas de un cliente"),
	LISTADO_FACTURAS_FECHAS("Listado de facturas de un cliente emitidas entre dos fechas"),
	ANTERIOR("Volver al menú anterior"),
	SALIR("Salir");
	
	private String descripcion;
		
		private Menu3(String descripcion) {
			this.descripcion = descripcion;
		}
		
		public String getDescripcion() {
			return descripcion;	
		}	
		
		public static Menu3 getOpcion(int i) {
			return values()[i];
			}
			
		public static String getMenu3() {
			
			StringBuilder sb = new StringBuilder();
			
			for(Menu3 opcion: Menu3.values()) {
				sb.append(" ");
				sb.append(opcion.ordinal());
				sb.append("--> ");
				sb.append(opcion.getDescripcion());
				sb.append("\n");
			}
			return sb.toString();
			}
	

}
