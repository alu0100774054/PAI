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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.function.BooleanSupplier;

import javax.swing.JButton;

import com.sun.glass.events.MouseEvent;

public class Boton extends JButton implements ActionListener {
  private String accion;          // Nombre de la acción que realiza el botón.
  private int tipo;               // Diferencia el tipo de movimiento.
  private final int ARRIBA = 1;
  private final int ABAJO = 2;
  private final int IZQUIERDA = 3;
  private final int DERECHA = 4;
  private BolaMovil pelota;
  
  public Boton(String accion, int tipo, BolaMovil pelota) {
    this.accion = accion;
    this.tipo = tipo;
    this.pelota = pelota;
    if (tipo == getARRIBA()) {
      this.setName("Arriba");
    }
    if (tipo == getABAJO()) {
      setName("Abajo");
    }
    if (tipo == getIZQUIERDA()) {
      setName("Izquierda");
    }
    if (tipo == getDERECHA()) {
      setName("Derecha");
    }
    addActionListener(this);
    iniciarComponentes();
  }

  private void iniciarComponentes() {
    setText(getAccion());
  }

  private String getAccion() {
    return accion;
  }

  private int getTipo() {
    return tipo;
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

  private BolaMovil getPelota() {
    return pelota;
  }

  private void setPelota(BolaMovil pelota) {
    this.pelota = pelota;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    setFocusable(false);
    if (getTipo() == getARRIBA()) {
      getPelota().moverArriba();     
    }
    if (getTipo() == getABAJO()) {
      getPelota().moverAbajo();
    }
    if (getTipo() == getIZQUIERDA()) {
      getPelota().moverIzquierda();
    }
    if (getTipo() == getDERECHA()) {
      getPelota().moverDerecha();
    }
  }
  
}
