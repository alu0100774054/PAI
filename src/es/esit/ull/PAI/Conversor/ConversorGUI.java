package es.esit.ull.PAI.Conversor;

import javax.swing.*;

public class ConversorGUI extends JPanel {
	private String tituloBorde;			// Titulo del borde del panel
	private JLabel etiqueta;			// Etiqueta del panel.
	private JTextField valorEntrada;	// Campo de entrada de la cantidad en euros
	private JLabel resultado;			// muestra los valores de las monedas en los dos sistemas
	
	public ConversorGUI(String moneda) {
		iniciarComponente(moneda);
	}
	private void iniciarComponente(String moneda) {
		tituloBorde = moneda;
		new JPanel();
		setBorder(BorderFactory.createTitledBorder(tituloBorde));
	}

}
