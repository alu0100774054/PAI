/**
 * Programa que dibuje en una ventana la representación gráfica de una función.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos.Cara;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cara extends JPanel {
  private final int DIMENSIONES_DEL_OJO = 20; // Dimensiones del ojo.
  private final int SEPARACION_DEL_OJO = 30;  // Distancia del centro del ojo.
  private final int DIMENSION_CARA = 150;     // Dimensiones del contorno de la cara.
  private final int SEPARACION_BOCA_NORTE = 20;     // Distancia del centro de la boca.
  private final int SEPARACION_BOCA_LATERAL = 30;     // Distancia del centro de la boca.
  private final int SEPARACION_BOCA_SUR = 40;     // Distancia del centro de la boca.
  
  public Cara() {
    iniciarComponentes();
  }

  private void iniciarComponentes() {
    setBackground(Color.white);
    setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), 
        BorderFactory.createLoweredBevelBorder()));
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    dibujarCara(g);
  }

  private void dibujarCara(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setPaint(Color.black);
    //pintarPlano(g);
    pintarOjos(g2d);
    pintarBoca(g2d);
  }

  private void pintarBoca(Graphics2D g2d) {
    g2d.setColor(Color.red);
    g2d.drawLine((this.getWidth() / 2) - getSEPARACION_BOCA_LATERAL(),
        (this.getHeight() / 2) + getSEPARACION_BOCA_NORTE(), 
        (this.getWidth() / 2) + getSEPARACION_BOCA_LATERAL(), 
        (this.getHeight() / 2) + getSEPARACION_BOCA_NORTE());
  }

  private void pintarOjos(Graphics2D g2d) {
    g2d.setColor(Color.blue);
    // Dibujar ojo
    g2d.fillOval((this.getWidth() / 2) - getSEPARACION_DEL_OJO() - (getDIMENSIONES_DEL_OJO()), 
        (this.getHeight() / 2) - getSEPARACION_DEL_OJO(), 
        getDIMENSIONES_DEL_OJO(),
        getDIMENSIONES_DEL_OJO());
    
    g2d.fillOval((this.getWidth() / 2) + getSEPARACION_DEL_OJO(), 
        (this.getHeight() / 2) - getSEPARACION_DEL_OJO(), 
        getDIMENSIONES_DEL_OJO(), 
        getDIMENSIONES_DEL_OJO());
    
    g2d.drawOval((this.getWidth() / 2) - (getDIMENSION_CARA() / 2), 
        (this.getHeight() / 2) - (getDIMENSION_CARA() / 2),
        getDIMENSION_CARA(), 
        getDIMENSION_CARA());
  }

  private void pintarPlano(Graphics g) {
    g.setColor(Color.red);
    // basico
    g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
    g.drawLine(this.getWidth() / 2, 0,this.getWidth() / 2 , this.getHeight());
    // ojos
    g.drawLine(0, 
        (this.getHeight() / 2) - getSEPARACION_DEL_OJO(), 
        this.getWidth(), 
        (this.getHeight() / 2) - getSEPARACION_DEL_OJO());
    // izq
    g.drawLine((this.getWidth() / 2) - getSEPARACION_DEL_OJO() - (getDIMENSIONES_DEL_OJO() / 2),
        0,
        (this.getWidth() / 2) - getSEPARACION_DEL_OJO() - (getDIMENSIONES_DEL_OJO() / 2),
        this.getHeight());
    // dcha
    g.drawLine((this.getWidth() / 2) + getSEPARACION_DEL_OJO() + (getDIMENSIONES_DEL_OJO() / 2),
        0,
        (this.getWidth() / 2) + getSEPARACION_DEL_OJO() + (getDIMENSIONES_DEL_OJO() / 2),
        this.getHeight());
    // boca
    //norte
    g.drawLine((this.getWidth() / 2) - getSEPARACION_BOCA_LATERAL(),
        (this.getHeight() / 2) + getSEPARACION_BOCA_NORTE(), 
        (this.getWidth() / 2) + getSEPARACION_BOCA_LATERAL(), 
        (this.getHeight() / 2) + getSEPARACION_BOCA_NORTE());
    // sur
    g.drawLine((this.getWidth() / 2) - getSEPARACION_BOCA_LATERAL(),
        (this.getHeight() / 2) + getSEPARACION_BOCA_SUR(), 
        (this.getWidth() / 2) + getSEPARACION_BOCA_LATERAL(), 
        (this.getHeight() / 2) + getSEPARACION_BOCA_SUR());
    // este
    g.drawLine((this.getWidth() / 2) - getSEPARACION_BOCA_LATERAL(), 
        (this.getHeight() / 2) + getSEPARACION_BOCA_NORTE(),
        (this.getWidth() / 2) - getSEPARACION_BOCA_LATERAL(), 
        (this.getHeight() / 2) + getSEPARACION_BOCA_SUR());
    // oeste
    g.drawLine((this.getWidth() / 2) + getSEPARACION_BOCA_LATERAL(), 
        (this.getHeight() / 2) + getSEPARACION_BOCA_NORTE(),
        (this.getWidth() / 2) + getSEPARACION_BOCA_LATERAL(), 
        (this.getHeight() / 2) + getSEPARACION_BOCA_SUR());
  }

  private int getDIMENSIONES_DEL_OJO() {
    return DIMENSIONES_DEL_OJO;
  }

  private int getSEPARACION_DEL_OJO() {
    return SEPARACION_DEL_OJO;
  }

  private int getDIMENSION_CARA() {
    return DIMENSION_CARA;
  }

  private int getSEPARACION_BOCA_NORTE() {
    return SEPARACION_BOCA_NORTE;
  }

  private int getSEPARACION_BOCA_ESTE() {
    return SEPARACION_BOCA_LATERAL;
  }

  private int getSEPARACION_BOCA_SUR() {
    return SEPARACION_BOCA_SUR;
  }

  private int getSEPARACION_BOCA_LATERAL() {
    return SEPARACION_BOCA_LATERAL;
  }
  
}
