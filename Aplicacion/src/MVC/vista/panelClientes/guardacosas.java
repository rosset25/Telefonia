package MVC.vista.panelClientes;

public class guardacosas {
	
//	panel.setLayout(new BoxLayout (panel, BoxLayout.PAGE_AXIS));
//	
//	panel.setLayout(new BoxLayout (panel, BoxLayout.PAGE_AXIS));
//	
//	ButtonGroup grupo1 = new ButtonGroup();
//	grupo1.add(sabados);
//	grupo1.add(domingos);
//	
//	ButtonGroup grupo2 = new ButtonGroup();
//	grupo2.add(manyana);
//	grupo2.add(tarde);
//	grupo2.add(noche);
//	
//	JPanel tarifas = new JPanel();
//	
//	tarifas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
//			"Tarifa Base", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
//	
//	JLabel tarifaBase = new JLabel("Nueva tarifa base: ");
//	tarifas.add(tarifaBase);	//Jlabel
//	tarifas.add(tarifaBaseElegida);	//JTextField
//	tarifaBaseElegida.setColumns(5);
//	JLabel eur_min = new JLabel("€/min");
//	tarifas.add(eur_min);
//	
//	panel.add(tarifas);
//	//TODO BUSCAR forma de bajar el panel 1 y 2 creados para tarifa
//
//	JPanel tarifa1 = new JPanel();
//	tarifa1.setLayout(new BoxLayout (tarifa1, BoxLayout.PAGE_AXIS));
//	JPanel tarifa11 = new JPanel();
//	
//	tarifa1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
//			"Oferta 1", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
//	
//	//panel para escribir la oferta 1 (panel dentro de tarifa1
//	JLabel oferta1 = new JLabel("Tarifa de la Oferta 1: ");	
//	tarifa11.add(oferta1);
//	tarifa11.add(costeOferta1);
//	this.costeOferta1.setColumns(5);
//	JLabel eur_min1 = new JLabel("€/min");
//	tarifa11.add(eur_min1);
//	tarifa1.add(tarifa11);
//	
//	JLabel opciones1 = new JLabel("Elija una de las opciones: \n");
//	tarifa1.add(opciones1);
//	
//	tarifa1.add(manyana);
//	manyana.setSelected(true);
//	tarifa1.add(tarde);
//	tarifa1.add(noche);
//	
//	
//	panel.add(tarifa1);
//	
//	JPanel tarifa2 = new JPanel();
//	tarifa2.setLayout(new BoxLayout (tarifa2, BoxLayout.PAGE_AXIS));
//	JPanel tarifa22 = new JPanel();
//	
//	tarifa2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
//			"Oferta 2", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
//	tarifa2.setBorder(new TitledBorder("Oferta 2"));
//	
//	//panel para escribir la oferta 2 (panel dentro de tarifa2
//	JLabel oferta2 = new JLabel("Tarifa de la Oferta 2: ");	
//	tarifa22.add(oferta2);
//	tarifa22.add(costeOferta2);
//	this.costeOferta2.setColumns(5);
//	JLabel eur_min2 = new JLabel("€/min");
//	tarifa22.add(eur_min2);
//	tarifa2.add(tarifa22);
//	
//	
//	JLabel opciones2 = new JLabel("Elija una de las opciones: \n");
//	tarifa2.add(opciones2);
//	
//	tarifa2.add(sabados);
//	sabados.setSelected(true);
//	tarifa2.add(domingos);
//	
//	panel.add(tarifa2);
//	
//	
//	JPanel panelBoton = new JPanel();
//	panelBoton.setLayout(new BoxLayout (panelBoton, BoxLayout.PAGE_AXIS));
//	panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
//	panelBoton.add(cambiar);
//	
//	panel.add(panelBoton);
//	
//	cambiar.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			//controlador.
//			
//		}
//		
//	});
//	
//	return panel;
//	
//	
//}
//
//
//
//	
//	
//	
//	
//	
//	//tarifas.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//
////	JPanel clientPanel = new JPanel();
////	clientPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
////			"Informacion cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
//	/*tarifas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cambio de Tarifa y Ofertas",
//			TitledBorder.LEADING, TitledBorder.TOP, null, null));
//	*/
//	
//	
//	JPanel tarifas = new JPanel();
//	
////	tarifas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
////			"Tarifa Base", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
////	
////	JLabel tarifaBase = new JLabel("Nueva tarifa base: ");
////	tarifas.add(tarifaBase);	//Jlabel
////	tarifas.add(tarifaBaseElegida);	//JTextField
////	tarifaBaseElegida.setColumns(9);
////	
////	
////	panel.add(tarifas);
////	//TODO BUSCAR forma de bajar el panel 1 y 2 creados para tarifa
//
//	JPanel tarifa1 = new JPanel();
//	tarifa1.setLayout(new BoxLayout (tarifa1, BoxLayout.PAGE_AXIS));
//	JPanel tarifa11 = new JPanel();
//	
//	tarifa1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
//			"Oferta 1", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
//	
//	//panel para escribir la oferta 1 (panel dentro de tarifa1
//	JLabel oferta1 = new JLabel("Tarifa de la Oferta 1: ");	
//	tarifa11.add(oferta1);
////	tarifa11.add(costeOferta1);
////	this.costeOferta1.setColumns(5);
//	JLabel eur_min1 = new JLabel("€/min");
//	tarifa11.add(eur_min1);
//	tarifa1.add(tarifa11);
//	
//	JLabel opciones1 = new JLabel("Elija una de las opciones: \n");
//	tarifa1.add(opciones1);
//	
//	//JRadioButton bot = new JRadioButton(); TODO JRadioButton
//	
////	panel.add(tarifa1);
//	
//	JPanel tarifa2 = new JPanel();
//	tarifa2.setLayout(new BoxLayout (tarifa2, BoxLayout.PAGE_AXIS));
//	JPanel tarifa22 = new JPanel();
//	
//	tarifa2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
//			"Oferta 2", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
//	tarifa2.setBorder(new TitledBorder("Oferta 2"));
//	
//	//panel para escribir la oferta 2 (panel dentro de tarifa2
//			JLabel oferta2 = new JLabel("Tarifa de la Oferta 2: ");	
//			tarifa22.add(oferta2);
////			tarifa22.add(costeOferta2);
////			this.costeOferta2.setColumns(5);
//			JLabel eur_min2 = new JLabel("€/min");
//			tarifa22.add(eur_min2);
//			tarifa2.add(tarifa22);
//	
//	
//	JLabel opciones2 = new JLabel("Elija una de las opciones: \n");
//	tarifa2.add(opciones2);
//	
//	//JRadioButton bot = new JRadioButton(); TODO JRadioButton
//	
////	panel.add(tarifa2);
//	
//	return panel;

}
