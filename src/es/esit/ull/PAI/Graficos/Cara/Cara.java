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
  private final int DIMENSIONES_DEL_OJO = 10; // Dimensiones del ojo.
  private final int SEPARACION_DEL_OJO = 30;  // Distancia del centro del ojo.
  
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
    
    // Dibujar ojo
    g2d.fillOval((this.getWidth() / 2) - getSEPARACION_DEL_OJO(), 
        (this.getHeight() / 2) - getSEPARACION_DEL_OJO(), 
        getDIMENSIONES_DEL_OJO(),
        getDIMENSIONES_DEL_OJO());
    
    g2d.fillOval((this.getHeight() / 2) + getSEPARACION_DEL_OJO(), 
        (this.getHeight() / 2) - getSEPARACION_DEL_OJO(), 
        getDIMENSIONES_DEL_OJO(), 
        getDIMENSIONES_DEL_OJO());
  }

  private int getDIMENSIONES_DEL_OJO() {
    return DIMENSIONES_DEL_OJO;
  }

  private int getSEPARACION_DEL_OJO() {
    return SEPARACION_DEL_OJO;
  }
  
}
