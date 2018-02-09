package menus;

public enum MenuTipoCliente {
	
	PARTICULAR("Particular"),
	EMPRESA("Empresa");
	
	private String descripcion;
	
	private MenuTipoCliente(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;	
	}	
	
	public static MenuTipoCliente getOpcion(int i) {	//TODO lanzar EXCEPCI�N si te dan un String/Double en vez de un Int
		return values()[i];					// (repetir con el resto de men�s)
		}
		
	public static String getMenuTipoCliente() {
		
		StringBuilder sb = new StringBuilder();
		
		for(MenuTipoCliente opcion: MenuTipoCliente.values()) {
			sb.append(" ");
			sb.append(opcion.ordinal());
			sb.append(" - ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
		
	}
	
}
