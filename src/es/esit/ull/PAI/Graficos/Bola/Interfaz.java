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

public class Interfaz extends JPanel{
  
  
  public Interfaz(int desplazamiento) {
    iniciarComponentes(desplazamiento);
  }

  private void iniciarComponentes(int desplazamiento) {
    setLayout(new GridLayout(2, 1));
    add(new BolaMovil(desplazamiento));
    add(new PanelDeControles());
  }

}
