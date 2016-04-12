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

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class ControlCentral extends JPanel {
  private final String ARRIBA_MSG = "Arriba";
  private final String ABAJO_MSG = "Abajo";
  private final String DERECHA_MSG = "Derecha";
  private final String IZQUIERDA_MSG = "Izquierda";
  private final int ARRIBA = 1;
  private final int ABAJO = 2;
  private final int IZQUIERDA = 3;
  private final int DERECHA = 4;
  private Boton arriba;
  private Boton abajo;
  private Boton izquierda;
  private Boton derecha;

  public ControlCentral(BolaMovil pelota) {
    arriba = new Boton(getARRIBA_MSG(), getARRIBA(), pelota);
    abajo = new Boton(getABAJO_MSG(), getABAJO(), pelota);
    izquierda = new Boton(getIZQUIERDA_MSG(), getIZQUIERDA(), pelota);
    derecha = new Boton(getDERECHA_MSG(), getDERECHA(), pelota);
    iniciarComponentes(pelota);
  }
  private void iniciarComponentes(BolaMovil pelota) {
    JPanel arriba = new JPanel();
    arriba.setLayout(new GridLayout(1, 1));

    JPanel abajo = new JPanel();
    abajo.setLayout(new GridLayout(1, 1));

    JPanel laterales = new JPanel();
    arriba.setLayout(new GridLayout(1, 2));

    // Añadir botones.
    arriba.add(getArriba(), BorderLayout.NORTH);
    abajo.add(getAbajo(), BorderLayout.SOUTH);
    laterales.add(getIzquierda(), BorderLayout.WEST);
    laterales.add(getDerecha(), BorderLayout.EAST);    

    add(arriba);
    add(laterales);
    add(abajo);
  }
  private String getARRIBA_MSG() {
    return ARRIBA_MSG;
  }
  private String getABAJO_MSG() {
    return ABAJO_MSG;
  }
  private String getDERECHA_MSG() {
    return DERECHA_MSG;
  }
  private String getIZQUIERDA_MSG() {
    return IZQUIERDA_MSG;
  }
  private int getARRIBA() {
    return ARRIBA;
  }
  private int getABAJO() {
    return ABAJO;
  }
  private int getIZQUIERDA() {
    return IZQUIERDA;
  }
  private int getDERECHA() {
    return DERECHA;
  }
  private Boton getArriba() {
    return arriba;
  }
  private void setArriba(Boton arriba) {
    this.arriba = arriba;
  }
  private Boton getAbajo() {
    return abajo;
  }
  private void setAbajo(Boton abajo) {
    this.abajo = abajo;
  }
  private Boton getIzquierda() {
    return izquierda;
  }
  private void setIzquierda(Boton izquierda) {
    this.izquierda = izquierda;
  }
  private Boton getDerecha() {
    return derecha;
  }
  private void setDerecha(Boton derecha) {
    this.derecha = derecha;
  }

}
