package es.esit.ull.PAI.Graficos.Bola;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelDeControles extends JPanel {

  public PanelDeControles(BolaMovil pelota) {
    iniciarComponentes(pelota);
  }

  private void iniciarComponentes(BolaMovil pelota) {
    setLayout(new GridLayout(1, 3));
    add(new ControlIzquierda());
    add(new ControlCentral(pelota));
    add(new ControlDerecha());    
  }
}
