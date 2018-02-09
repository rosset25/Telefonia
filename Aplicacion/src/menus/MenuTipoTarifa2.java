package menus;

public enum MenuTipoTarifa2 {
	
	SABADOS("Oferta Sábados: Todo el día"),
	DOMINGOS("Oferta Domingos: Todo el día");
	
	private String descripcion;
	
	private MenuTipoTarifa2(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;	
	}	
	
	public static MenuTipoTarifa2 getOpcion(int i) {	//TODO lanzar EXCEPCI�N si te dan un String/Double en vez de un Int
		return values()[i];					// (repetir con el resto de men�s)
		}
		
	public static String getMenuTipoTarifa() {
		
		StringBuilder sb = new StringBuilder();
		
		for(MenuTipoTarifa2 opcion: MenuTipoTarifa2.values()) {
			sb.append(" ");
			sb.append(opcion.ordinal());
			sb.append(" - ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();	
	}
}
