package es.esit.ull.PAI.Conversor;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorSalidaGUI extends JPanel {
  private JTextField resultados;        // Salida de texto del valor de la moneda.
  private JLabel monedaLabel;               // Monedas a mostrar.
  public ConversorSalidaGUI(Moneda moneda) {
    
    iniciarComponente(moneda);
  }
  private void iniciarComponente(Moneda moneda) {
    new JPanel();
    setLayout(new GridLayout(1, 2));
    resultados = new JTextField("100");
    add(resultados);
    resultados = new JTextField(String.valueOf(moneda.getConversion()));
    add(resultados);
  }
}
