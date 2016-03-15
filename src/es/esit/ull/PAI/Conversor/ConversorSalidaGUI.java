package es.esit.ull.PAI.Conversor;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorSalidaGUI extends JPanel {
  private JTextField resultados;        // Salida de texto del valor de la moneda.
  private JLabel monedaLabel;               // Monedas a mostrar.
  public ConversorSalidaGUI(String moneda) {
    
    iniciarComponente(moneda);
  }
  private void iniciarComponente(String moneda) {
    new JPanel();
    setLayout(new GridLayout(2, 2));
    monedaLabel = new JLabel(moneda);
    add(monedaLabel);
    add(monedaLabel);
    resultados = new JTextField();
    add(resultados);
    resultados = new JTextField();
    add(resultados);
  }
}
