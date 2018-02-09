package menus;

public enum MenuTipoTarifa1 {
	
	DIA("Oferta mañanas: 9:00 - 13:00"),
	TARDE("Oferta tardes: 15:00 - 20:00"),
	NOCHE("Oferta noches: 21:00 - 00:00");
	
	private String descripcion;
	
	private MenuTipoTarifa1(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;	
	}	
	
	public static MenuTipoTarifa1 getOpcion(int i) {	//TODO lanzar EXCEPCI�N si te dan un String/Double en vez de un Int
		return values()[i];					// (repetir con el resto de men�s)
		}
		
	public static String getMenuTipoTarifa() {
		
		StringBuilder sb = new StringBuilder();
		
		for(MenuTipoTarifa1 opcion: MenuTipoTarifa1.values()) {
			sb.append(" ");
			sb.append(opcion.ordinal());
			sb.append(" - ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();	
	}
}
