/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class ConversorGUI extends JPanel {
	private String tituloBorde;		      	  // Titulo del borde del panel
	private ConversorEntradaGUI entrada;	  // Campo de entrada de la cantidad en euros
	private ConversorSalidaGUI salida;      // Campo de entrada de la cantidad en euros
	private JLabel resultado;		         	  // muestra los valores de las monedas en los dos sistemas
	private JLabel tituloResultado;         // Etiqueta con el titulo de que tipo de moneda es el resultado.
	private final String euros = "Euros";   // Moneda que nunca cambia.
	
	public ConversorGUI(Moneda moneda) {
		iniciarComponente(moneda);
	}
	private void iniciarComponente(Moneda moneda) {
		tituloBorde = moneda.getNombreMoneda();
		new JPanel();
		setBorder(BorderFactory.createTitledBorder(tituloBorde));
		setLayout(new GridLayout(3, 1));
		entrada = new ConversorEntradaGUI(moneda);
		add(entrada);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		tituloResultado = new JLabel(euros);
		tituloResultado.setForeground(Color.BLUE);
		panel.add(tituloResultado);
		tituloResultado = new JLabel(moneda.getNombreMoneda());
		tituloResultado.setForeground(Color.BLUE);
		panel.add(tituloResultado);
		add(panel);
		salida = new ConversorSalidaGUI(moneda);
		add(salida);
	}

}
