/**
 * Programa que dibuje en una ventana la representación gráfica de una función.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cuadratica extends JPanel {
  private static final int SEPARA_COORDENADA = 20; // Se utiliza para separar el nombre de la coordenada
  // de la linea de la coordenada(todos los casos).
  private final Double FACTOR_DE_ESCALA = 0.1;        // Factor de escala para distanciar los puntos.

  private Double terminoA;
  private Double terminoB;
  private Double constante;
  
  public Cuadratica(Double terminoA, Double terminoB, Double constante) {
    this.terminoA = terminoA;
    this.terminoB = terminoB;
    this.constante = constante;
    iniciarComponentes();
  }

  /**
   * Método que se encarga de inicializar el componente.
   */
  private void iniciarComponentes() {
    setBackground(Color.black);
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
    g.setColor(Color.white);
    g.drawString("Y", (this.getWidth() / 2 ) + getSeparaCoordenada(), getSeparaCoordenada());
    g.drawString("X", (this.getWidth() - getSeparaCoordenada()), (this.getHeight() / 2 ) - getSeparaCoordenada());
    
    // Pintamos la fórmula.
    g.setColor(Color.white);
    String formula = "Función: " + getTerminoA() + "x^2 + " + getTerminoB() + "x + " + getConstante();
    g.drawString(formula, getSeparaCoordenada(), getSeparaCoordenada());
    
    // Pintamos la función.
    dibujarPuntos(g, getTerminoA(), getHeight(), getTerminoB(), -getHeight(), getConstante());
  }

  private void dibujarPuntos(Graphics g, Double terminoA, int x2, Double terminoB, int x1, Double constante) {
    Graphics2D g2d = (Graphics2D) g;
    g.setColor(Color.white);
    System.out.println("Función: " + getTerminoA() + "x^2 + " + getTerminoB() + "x + " + getConstante());
    for (int i = x1; i < x2; i++) {
      Double y = (Math.pow(i, 2) * getTerminoA()) + (i * getTerminoB()) + getConstante();     // El 2 es el exponente al cuadrado.
      Double xp = (double) (i + 1);
      Double yp = (Math.pow(xp, 2) * getTerminoA()) + (xp * getTerminoB()) + getConstante();  // El 2 es el exponente al cuadrado.
      System.out.println("Dibujando: (" + i + ", " + y + "), (" + xp + ", " + yp + ")");
      g.drawLine((int) coord_x(i), (int) coord_y(y), (int) coord_x(xp), (int) coord_y(yp));
    }
  }

  private double coord_x(double x) {
    double real_x = x + this.getWidth() / 2;
    return real_x;
  }

  private double coord_y(double y) {
    double real_y = -y + this.getHeight() / 2;
    return real_y;
  }

  private Double getTerminoA() {
    return terminoA;
  }

  private void setTerminoA(Double terminoA) {
    this.terminoA = terminoA;
  }

  private Double getTerminoB() {
    return terminoB;
  }

  private void setTerminoB(Double terminoB) {
    this.terminoB = terminoB;
  }

  private Double getConstante() {
    return constante;
  }

  private void setConstante(Double constante) {
    this.constante = constante;
  }

  private static int getSeparaCoordenada() {
    return SEPARA_COORDENADA;
  }

  private Double getFACTOR_DE_ESCALA() {
    return FACTOR_DE_ESCALA;
  }
  
}
