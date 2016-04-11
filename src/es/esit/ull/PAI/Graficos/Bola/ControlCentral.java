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
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class ControlCentral extends JPanel {
  private final String ARRIBA = "Arriba";
  private final String ABAJO = "Abajo";
  private final String DERECHA = "Derecha";
  private final String IZQUIERDA= "Izquierda";
  
  public ControlCentral() {
    iniciarComponentes();
  }
  private void iniciarComponentes() {
    JPanel arriba = new JPanel();
    arriba.setLayout(new GridLayout(4, 1));
    
    JPanel abajo = new JPanel();
    abajo.setLayout(new GridLayout(1, 1));
    
    JPanel laterales = new JPanel();
    arriba.setLayout(new GridLayout(1, 2));

    setLayout(new GridLayout(3, 1));
    // Añadir botones.
    arriba.add(new Boton(getARRIBA()), BorderLayout.NORTH);
    abajo.add(new Boton(getABAJO()), BorderLayout.SOUTH);
    laterales.add(new Boton(getIZQUIERDA()), BorderLayout.WEST);
    laterales.add(new Boton(getDERECHA()), BorderLayout.EAST);    
    
    add(arriba);
    add(laterales);
    add(abajo);
  }
  private String getARRIBA() {
    return ARRIBA;
  }

  private String getABAJO() {
    return ABAJO;
  }

  private String getDERECHA() {
    return DERECHA;
  }

  private String getIZQUIERDA() {
    return IZQUIERDA;
  }
}
