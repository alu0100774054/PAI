package es.esit.ull.PAI.Conversor;

import java.awt.GridLayout;

import javax.swing.*;

public class ConversorGUI extends JPanel {
	private String tituloBorde;		      	// Titulo del borde del panel
	private ConversorEntradaGUI entrada;	// Campo de entrada de la cantidad en euros
	private ConversorSalidaGUI salida; // Campo de entrada de la cantidad en euros
	private JLabel resultado;		         	// muestra los valores de las monedas en los dos sistemas
	
	
	public ConversorGUI(String moneda) {
		iniciarComponente(moneda);
	}
	private void iniciarComponente(String moneda) {
		tituloBorde = moneda;
		new JPanel();
		setBorder(BorderFactory.createTitledBorder(tituloBorde));
		setLayout(new GridLayout(3, 1));
		entrada = new ConversorEntradaGUI(moneda);
		add(entrada);
		salida = new ConversorSalidaGUI(moneda);
		add(salida);
	}

}
