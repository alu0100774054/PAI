/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorSalidaGUI extends JPanel {
  private JTextField resultados;            // Salida de texto del valor de la moneda.
  private JLabel monedaLabel;               // Monedas a mostrar.
  
  /**
   * Constructor de la interfaz.
   * @param moneda Cantidad que se quiere convertir.
   */
  public ConversorSalidaGUI(Moneda moneda) {
    iniciarComponente(moneda);
  }
  
  /**
   * Inicializa los componentes de la interfaz.
   * @param moneda Cantidad que se quiere convertir.
   */
  private void iniciarComponente(Moneda moneda) {
    new JPanel();
    setLayout(new GridLayout(1, 2));
    resultados = new JTextField(String.valueOf(moneda.getEuros()));
    resultados.setForeground(Color.BLUE);
    add(resultados);
    resultados = new JTextField(String.valueOf(moneda.getConversion()));
    resultados.setForeground(Color.BLUE);
    add(resultados);
  }
}
