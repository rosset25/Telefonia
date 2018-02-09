package menus;

public enum Menu0 {
	
	CLIENTES("Clientes"),
	LLAMADAS("Llamadas"),
	FACTURAS("Facturas"),
	SALIR("Salir");
	
	private String descripcion;
	
	private Menu0(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;	
	}	
	
	public static Menu0 getOpcion(int i) {	//TODO lanzar EXCEPCI�N si te dan un String/Double en vez de un Int
		return values()[i];					// (repetir con el resto de men�s)
		}
		
	public static String getMenu0() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Menu0 opcion: Menu0.values()) {
			sb.append(" ");
			sb.append(opcion.ordinal());
			sb.append(") ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();	
	}
}
