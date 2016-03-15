package es.esit.ull.PAI.Conversor;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorEntradaGUI extends JPanel {
  private JTextField entradaValor;                  // Entrada de texto del valor de la moneda.
  private JLabel etiqueta;                          // Etiqueta del panel.
  private final String etiqueta1 = "1 Euro is";
  private String etiqueta2;                         // Etiqueta del nombre de la moneda.
  public ConversorEntradaGUI(String moneda) {
    etiqueta2 = moneda;
    iniciarComponente();
  }
  private void iniciarComponente() {
    new JPanel();
    setLayout(new GridLayout(1, 3));
    entradaValor = new JTextField();
    etiqueta = new JLabel(etiqueta1);
    add(etiqueta);
    add(entradaValor);
    etiqueta = new JLabel(etiqueta2); //falt
    add(etiqueta);
  }
}
