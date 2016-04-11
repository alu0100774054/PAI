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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Interfaz extends JPanel {
  private BolaMovil pelota;
  private PanelDeControles controles;
  
  public Interfaz(int desplazamiento) {
    pelota = new BolaMovil(desplazamiento);
    addKeyListener(pelota);
    setFocusable(true);
    controles = new PanelDeControles(pelota);
    iniciarComponentes(desplazamiento);
  }

  private void iniciarComponentes(int desplazamiento) {
    
    setLayout(new GridLayout(2, 1));
    
    add(pelota);
    add(controles);
  }


}
