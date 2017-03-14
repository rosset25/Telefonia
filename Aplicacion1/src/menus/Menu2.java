package menus;

public enum Menu2 {
	

	NUEVA_LLAMADA("Dar de alta una llamada"),
	LLAMADAS("Realizar un listado de llamdas de un cliente"),
	LISTADO_LLAMADAS_FECHAS("Listado de llamadas de un cliente que fueron realizadas entre dos fechas"),
	ANTERIOR("Volver al menú anterior"),
	SALIR("Salir");

	/*salida.mostrarString(
			"	1) Dar de alta una llamada\n"
			+ "	2) Realizar un listado de llamdas de un cliente\n"
			+ "	3) Volver al menÃº anterior\n"
			+ "	4) Salir\n");*/

	
	
	private String descripcion;
		
		private Menu2(String descripcion) {
			this.descripcion = descripcion;
		}
		
		public String getDescripcion() {
			return descripcion;	
		}	
		
		public static Menu2 getOpcion(int i) {
			return values()[i];
			}
			
		public static String getMenu2() {
			
			StringBuilder sb = new StringBuilder();
			
			for(Menu2 opcion: Menu2.values()) {
				sb.append(" ");
				sb.append(opcion.ordinal());
				sb.append("--> ");
				sb.append(opcion.getDescripcion());
				sb.append("\n");
			}
			return sb.toString();
			}
	

}
