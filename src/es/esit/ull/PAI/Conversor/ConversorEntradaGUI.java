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

public class ConversorEntradaGUI extends JPanel {
  private JTextField entradaValor;                  // Entrada de texto del valor de la moneda.
  private JLabel etiqueta;                          // Etiqueta del panel.
  private final String etiqueta1 = "1 Euro is";     // Cadena constante antes de la entrada.

  /**
   * Constructor de la interfaz.
   * @param moneda Cantidad que se quiere convertir.
   */
  public ConversorEntradaGUI(Moneda moneda) {
    iniciarComponente(moneda);
  }
  
  /**
   * Inicializa los componentes de la interfaz.
   * @param moneda Cantidad que se quiere convertir.
   */
  private void iniciarComponente(Moneda moneda) {
    new JPanel();
    setLayout(new GridLayout(1, 3));
    entradaValor = new JTextField(String.valueOf(moneda.getFactorConversion()));
    entradaValor.setForeground(Color.BLUE);
    etiqueta = new JLabel(etiqueta1);
    etiqueta.setForeground(Color.BLUE);
    add(etiqueta);
    add(entradaValor);
    etiqueta = new JLabel(moneda.getNombreMoneda());
    etiqueta.setForeground(Color.BLUE);
    add(etiqueta);
  }

  public JTextField getEntradaValor() {
    return entradaValor;
  }

  public void setEntradaValor(JTextField entradaValor) {
    this.entradaValor = entradaValor;
  }

  public JLabel getEtiqueta() {
    return etiqueta;
  }

  public void setEtiqueta(JLabel etiqueta) {
    this.etiqueta = etiqueta;
  }

  public String getEtiqueta1() {
    return etiqueta1;
  }
  
}
