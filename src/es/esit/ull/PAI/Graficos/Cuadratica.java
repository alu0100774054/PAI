/**
 * Programa que dibuje en una ventana la representación gráfica de una función.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cuadratica extends JPanel {
  private static final int SEPARA_COORDENADA = 20; // Se utiliza para separar el nombre de la coordenada
                                                   // de la linea de la coordenada(todos los casos).
  private final Double FACTOR_DE_ESCALA = 0.1;        // Factor de escala para distanciar los puntos.
  
  private int coordenadaX;
  private int coordenadaY;
  
  public Cuadratica() {
    coordenadaX = 0;
    coordenadaY = 0;
    iniciarComponentes();
  }
  
  /**
   * Método que se encarga de inicializar el componente.
   */
  private void iniciarComponentes() {
    setBackground(Color.white);
    setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), 
        BorderFactory.createLoweredBevelBorder()));
  }

  /**
   * Método que se encarga de dibujar la función.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Pintamos el eje de coordenadas.
    g.setColor(Color.red);
    g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
    g.drawLine(this.getWidth() / 2, 0,this.getWidth() / 2 , this.getHeight());
    
    // Pintamos las etiquetas del eje.
    g.setColor(Color.black);
    g.drawString("Y", (this.getWidth() / 2 ) + getSeparaCoordenada(), getSeparaCoordenada());
    g.drawString("X", (this.getWidth() - getSeparaCoordenada()), (this.getHeight() / 2 ) - getSeparaCoordenada());
  }
  
  private void dibujar(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    
  }
  
  private double coord_x(double x)
  {
    double real_x = x+this.getWidth()/2;
    return real_x;
  }

  private double coord_y(double y) {
    double real_y = -y+this.getHeight()/2;
    return (real_y);
  }
  
  private int getCoordenadaX() {
    return coordenadaX;
  }
  private void setCoordenadaX(int coordenadaX) {
    this.coordenadaX = coordenadaX;
  }
  private int getCoordenadaY() {
    return coordenadaY;
  }
  private void setCoordenadaY(int coordenadaY) {
    this.coordenadaY = coordenadaY;
  }

  private static int getSeparaCoordenada() {
    return SEPARA_COORDENADA;
  }
  
}
