package es.esit.ull.PAI.Graficos.Bola;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelDeControles extends JPanel {
  private ControlIzquierda controlIzquierda;
  private ControlCentral controlCentral;
  private ControlDerecha controlDerecha;
  
  public PanelDeControles(BolaMovil pelota) {
    controlIzquierda = new ControlIzquierda();
    controlCentral = new ControlCentral(pelota);
    controlDerecha = new ControlDerecha();
    iniciarComponentes();
  }

  private void iniciarComponentes() {
    setLayout(new GridLayout(1, 3));
    add(getControlIzquierda());
    add(getControlCentral());
    add(getControlDerecha());    
  }

  private ControlIzquierda getControlIzquierda() {
    return controlIzquierda;
  }

  private void setControlIzquierda(ControlIzquierda controlIzquierda) {
    this.controlIzquierda = controlIzquierda;
  }

  private ControlCentral getControlCentral() {
    return controlCentral;
  }

  private void setControlCentral(ControlCentral controlCentral) {
    this.controlCentral = controlCentral;
  }

  private ControlDerecha getControlDerecha() {
    return controlDerecha;
  }

  private void setControlDerecha(ControlDerecha controlDerecha) {
    this.controlDerecha = controlDerecha;
  }
  
}
