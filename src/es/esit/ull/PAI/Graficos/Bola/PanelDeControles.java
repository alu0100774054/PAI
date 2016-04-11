package es.esit.ull.PAI.Graficos.Bola;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelDeControles extends JPanel {

  public PanelDeControles() {
    iniciarComponentes();
  }

  private void iniciarComponentes() {
    setLayout(new GridLayout(1, 3));
    add(new ControlIzquierda());
    add(new ControlCentral());
    add(new ControlDerecha());    
  }
}
