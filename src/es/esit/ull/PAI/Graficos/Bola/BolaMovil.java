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

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BolaMovil extends JPanel {
  private int desplazamiento;                 // Cantidad en pixeles que se desplaza la pelota.
  private final int DIMENSION_PELOTA = 80;
  private int posicionX;
  private int posicionY;
  private final int MITAD = 2;
  
  public BolaMovil(int desplazamiento) {
    this.desplazamiento = desplazamiento;
    iniciarComponetes();
  }

  private void iniciarComponetes() {
    setBackground(new Color(1, 255, 255));  // Azul claro.
    
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    dibujarPelota(g);
    
  }

  private void dibujarPelota(Graphics g) {
    g.setColor(Color.RED);
    setPosicionX((getWidth() / MITAD) - (DIMENSION_PELOTA / 2));
    setPosicionY((getHeight() / MITAD) - (DIMENSION_PELOTA / 2));
    System.out.println("(" + getPosicionX() + " " + getPosicionY() + ")");
    g.fillOval(getPosicionX(), getPosicionY(), getDIMENSION_PELOTA(), getDIMENSION_PELOTA());
  }

  private int getDesplazamiento() {
    return desplazamiento;
  }

  private void setDesplazamiento(int desplazamiento) {
    this.desplazamiento = desplazamiento;
  }

  private int getDIMENSION_PELOTA() {
    return DIMENSION_PELOTA;
  }

  private int getPosicionX() {
    return posicionX;
  }

  private void setPosicionX(int posicionX) {
    this.posicionX = posicionX;
  }

  private int getPosicionY() {
    return posicionY;
  }

  private void setPosicionY(int posicionY) {
    this.posicionY = posicionY;
  }

  private int getMITAD() {
    return MITAD;
  }
  
  
}
