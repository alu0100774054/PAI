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

import javax.swing.JButton;

public class Boton extends JButton {
  private String accion;  // Nombre de la acción que realiza el botón.
  
  public Boton(String accion) {
    this.accion = accion;
    iniciarComponentes();
  }

  private void iniciarComponentes() {
    setText(getAccion());
  }

  private String getAccion() {
    return accion;
  }

  private void setAccion(String accion) {
    this.accion = accion;
  }
  
}
