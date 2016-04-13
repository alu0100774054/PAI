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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class BolaMovil extends JPanel implements KeyListener, ActionListener {
  private int desplazamiento;                 // Cantidad en pixeles que se desplaza la pelota.
  private final int DIMENSION_PELOTA = 80;
  private int posicionX;
  private int posicionY;
  private final int MITAD = 2;
  private boolean iniciar = false;            // si no hemos iniciado la pelota en el centro.

  /**
   * Constructor de la pelota que se mueve.
   * @param desplazamiento Cantidad en pixeles que se desplaza la pelota.
   */
  public BolaMovil(int desplazamiento) {
    this.desplazamiento = desplazamiento;
    iniciarComponetes();
  }

  /**
   * Método que inicializa los componentes.
   */
  private void iniciarComponetes() {
    setBackground(new Color(1, 255, 255));  // Azul claro. 
  }

  /**
   * Método que inicia la pelota al medio.
   */
  public void iniciar() {
    setIniciar(true);
    setPosicionX((getWidth() / MITAD) - (DIMENSION_PELOTA / 2));
    setPosicionY((getHeight() / MITAD) - (DIMENSION_PELOTA / 2));
    System.out.println("(" + getPosicionX() + " " + getPosicionY() + ")");
  }

  /**
   * Método que se encarga de pintar los componentes.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (isIniciar() == false) {
      iniciar();
    }
    dibujarPelota(g);
  }
  /**
   * Método que dibuja la pelota.
   * @param g Graficos.
   */
  private void dibujarPelota(Graphics g) {
    g.setColor(Color.RED);  

    g.fillOval(getPosicionX(), getPosicionY(), getDIMENSION_PELOTA(), getDIMENSION_PELOTA());
  }

  public int getDesplazamiento() {
    return desplazamiento;
  }

  private void setDesplazamiento(int desplazamiento) {
    this.desplazamiento = desplazamiento;
  }

  private int getDIMENSION_PELOTA() {
    return DIMENSION_PELOTA;
  }

  public int getPosicionX() {
    return posicionX;
  }

  private void setPosicionX(int posicionX) {
    this.posicionX = posicionX;
  }

  public int getPosicionY() {
    return posicionY;
  }

  private void setPosicionY(int posicionY) {
    this.posicionY = posicionY;
  }

  private int getMITAD() {
    return MITAD;
  }

  private boolean isIniciar() {
    return iniciar;
  }

  private void setIniciar(boolean iniciar) {
    this.iniciar = iniciar;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int tecla = e.getKeyCode();

    if (tecla == KeyEvent.VK_LEFT) {
      moverIzquierda();
    }

    if (tecla == KeyEvent.VK_RIGHT) {
      moverDerecha();
    }

    if (tecla == KeyEvent.VK_UP) {
      moverArriba();
    }

    if (tecla == KeyEvent.VK_DOWN) {
      moverAbajo();
    }
    System.out.println("(" + getPosicionX() + ", " + getPosicionY() + ")");
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  }

  public void moverArriba() {
    if (getPosicionY() > 0) {
      if ((getPosicionY() - getDesplazamiento() < 0)) {
        setPosicionY(0);
      } else 
          setPosicionY(getPosicionY() - getDesplazamiento());
    }
    System.out.println("(" + getPosicionX() + ", " + getPosicionY() + ")");
    repaint();
    setFocusable(true);
  }

  public void moverAbajo() {
    if (getPosicionY() < (getHeight() - getDIMENSION_PELOTA())) {
      if (getPosicionY() + getDesplazamiento() > getHeight() - getDIMENSION_PELOTA()) {
        setPosicionY(getHeight() - getDIMENSION_PELOTA());
      } else
          setPosicionY(getPosicionY() + getDesplazamiento());
    }   
    System.out.println("(" + getPosicionX() + ", " + getPosicionY() + ")");
    repaint();setFocusable(true);
  }
  
  public void moverIzquierda() {
    if (getPosicionX() > 0) {
      if (getPosicionX() - getDesplazamiento() < 0) {
        setPosicionX(0);
      } else
          setPosicionX(getPosicionX() - getDesplazamiento());
    }   
    System.out.println("(" + getPosicionX() + ", " + getPosicionY() + ")");
    repaint();setFocusable(true);
  }
  
  public void moverDerecha() {
    if (getPosicionX() < (getWidth() - getDIMENSION_PELOTA())) {
      if (getPosicionX() + getDesplazamiento() > getWidth() - getDIMENSION_PELOTA()) {
        setPosicionX(getWidth() - getDIMENSION_PELOTA());
      } else 
          setPosicionX(getPosicionX() + getDesplazamiento());
    }   
    System.out.println("(" + getPosicionX() + ", " + getPosicionY() + ")");
    repaint();setFocusable(true);
  }

}
