package menus;

public enum Menu1{
	
	NUEVO_CLIENTE("Dar de alta a un nuevo cliente"),
	BORRAR_CLIENTE("Borrar un cliente"),
	CAMBIAR_TARIFA("Cambiar la tarifa de un cliente"),
	RECUPERAR_DATOS("Recuperar los datos de un cliente"),
	RECUPERAR_CLIENTES("Recuperar listado de todos los clientes"),
	LISTADO_CLIENTES_FECHAS("Listado de clientes que fueron dados de alta entre dos fechas"),
	ANTERIOR("Volver al men� anterior"),
	SALIR("Salir");

	private String descripcion;
	
	private Menu1(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;	
	}	
	
	public static Menu1 getOpcion(int i) {
		return values()[i];
		}
		
	public static String getMenu1() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Menu1 opcion: Menu1.values()) {
			sb.append(" ");
			sb.append(opcion.ordinal());
			sb.append("--> ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();	
	}
	
}
