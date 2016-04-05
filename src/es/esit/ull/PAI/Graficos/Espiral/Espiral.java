package es.esit.ull.PAI.Graficos.Espiral;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Espiral extends JPanel {
  private int distancia;             // Distancia de cada linea.
  private final int REDUCCION = 10;  // Distancia que reduce la espiral.
  /**
   * Constructor de la Escalera.
   */
  public Espiral(int dimension) {
    distancia = dimension;
    System.out.println(distancia);
    iniciarComponentes();
  }
  /**
   * Método que inicializa los componentes.
   */
  private void iniciarComponentes() {
    setBackground(Color.white);
    setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), 
        BorderFactory.createLoweredBevelBorder()));
  }
  /**
   * Método que sobreescribe el paintComponent.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);
    pintarEspiral(g);
  }
  private void pintarEspiral(Graphics g) {
 // Iniciar variables.
    int factor = getDistancia();
    int terminar = factor / 2;
    int x = 0;
    int y = getREDUCCION();
    int x_superior = 0;
    int y_superior = 0;
    while(x != terminar) {
      x_superior = factor;
      y_superior = factor - getREDUCCION();
      g.drawLine(x, y, x_superior, y);
      g.drawLine(x_superior, y, x_superior, y_superior);
      x += getREDUCCION();
      if (y != terminar) {
        y += getREDUCCION();
        g.drawLine(x_superior, y_superior, x, y_superior);
        g.drawLine(x, y_superior, x, y);
      }
      factor -= getREDUCCION();
    } 
  }
  private int getDistancia() {
    return distancia;
  }
  private void setDistancia(int distancia) {
    this.distancia = distancia;
  }
  private int getREDUCCION() {
    return REDUCCION;
  }
  
}
