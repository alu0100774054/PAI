/**
 * Programa que dado un número en hexadecimal realiza su conversión y muestra 
 * el número en formato decimal.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.etsii.ull.PAI.Conversor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Conversor extends JFrame {
	private final static int ANCHO = 200;        // Ancho de la ventana.
	private final static int ALTO = 200;         // Alto de la ventana.
	private JPanel entrada;                      // Panel de entrada del número
	private JLabel etiquetaEntrada;              // Etiqueta de la entrada.
	private JTextField entradaHex;               // Entrada del número.
	
	/**
	 * Constructor del conversor.
	 * @param hex Número en formato Hexadecimal
	 * @throws HexFormatException Excepción personalizada si el formato es inválido.
	 */
	public Conversor(String hex) throws HexFormatException {
		new JFrame("Conversor");
		setSize(ANCHO, ALTO);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entrada = new JPanel();
		etiquetaEntrada = new JLabel("Introducir número Hexadecimal");
		entradaHex = new JTextField("Hexadecimal aquí");
		entrada.add(etiquetaEntrada);
		entrada.add(entradaHex);
		entrada.add(new JButton("Calcular"));
		add(entrada);
		
		hex2decimal(hex);
	}
	/**
	 * Método que realiza la conversión Hexadecimal-Decimal.
	 * @param hex Número en formato Hexadecimal.
	 * @throws HexFormatException Excepción personalizada si el formato es inválido.
	 */
	private void hex2decimal(String hex) throws HexFormatException {
		int sum = 0;
	    int nuevoNumero = 0;
	    String digit = hex.toUpperCase();
	    for(int i = 0;i < digit.length();i++)
	    {
	        char c = digit.charAt(digit.length() - i - 1);
	        if (c >= 'G' || c <= 'Z' || c >= 'g' || c <= 'z' ) {
				throw new HexFormatException("Revisar el número Hexadecimal (Ej: 7D).");
			}
	        if(c == 'A' || c == 'a') {
	            nuevoNumero = 10;
	        }
	        if(c == 'B' || c == 'b') {
	        	nuevoNumero = 11;
	        }
	        if(c == 'C' || c == 'c') {
	        	nuevoNumero = 12;
	        }
	        if(c == 'D' || c == 'd') {
	        	nuevoNumero = 13;
	        }
	        if(c == 'E' || c == 'e') {
	        	nuevoNumero = 14;
	        }
	        if(c == 'F' || c == 'f') {
	        	nuevoNumero = 15;
	        } else {
	        	nuevoNumero = Character.getNumericValue(c);
	        	//throw new NumberFormatException;
	        }
	        sum = (int) (sum + nuevoNumero * Math.pow(16, i));
	    }
	    System.out.println(" HexaDecimal to Decimal conversion is ---> " + sum);
	}
	
}
