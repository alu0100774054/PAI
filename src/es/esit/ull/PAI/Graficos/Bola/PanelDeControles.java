/**
 * PRÁCTICA 8: MOVIMIENTO Y CONTROL DE UN OBJETO GRÁFICO
 * Programa que muestre en pantalla una ventana 
 * rectangular con fondo de color azul sobre la que se vera un círculo 
 * centrado en la ventana y un panel con cuatro botones que permiten 
 * mover el círculo hacia arriba, abajo, izquierda y derecha.
 * @author: Erik Andreas Barreto de Vera
 * @email: alu0100774054@ull.edu.es
 * @version: 07/04/2016
 */
package es.esit.ull.PAI.Graficos.Bola;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelDeControles extends JPanel {
  private ControlIzquierda controlIzquierda;
  private ControlCentral controlCentral;
  private ControlDerecha controlDerecha;
  
  /**
   * Constructor de los paneles con herramientas para el programa.
   * @param pelota Pelota.
   */
  public PanelDeControles(BolaMovil pelota) {
    controlIzquierda = new ControlIzquierda();
    controlCentral = new ControlCentral(pelota);
    controlDerecha = new ControlDerecha();
    iniciarComponentes();
  }

  /**
   * Método que inicializa los componentes.
   */
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
