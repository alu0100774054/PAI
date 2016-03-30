package es.esit.ull.PAI.OchoReinas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CasillaReinaGUI extends JPanel {
  private Image fondoReina;  // Fondo de la casilla de la reina;
  
  public CasillaReinaGUI(int fondo) {
    new JPanel();
    inicializarComponente(fondo);
  }

  private void inicializarComponente(int fondo) {
    loadImage(fondo);
    
    int ancho = getFondoBlanco().getWidth(this);
    int alto =  getFondoBlanco().getHeight(this);
    setPreferredSize(new Dimension(ancho, alto)); 
  }

  private void loadImage(int colorFondo) {
    if (colorFondo % 2 == 0) {
      ImageIcon fondo = new ImageIcon("images/casillaBlancaReina.png");
      fondoReina = fondo.getImage();
    } else {
      ImageIcon fondo = new ImageIcon("images/casillaNegraReina.png");
      fondoReina = fondo.getImage();
    } 
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.cyan);
    int x = (this.getWidth() - fondoReina.getWidth(null)) / 2;
    int y = (this.getHeight() - fondoReina.getHeight(null)) / 2;
    g.drawImage(fondoReina, x, y, null);
    
  }

  private Image getFondoBlanco() {
    return fondoReina;
  }

  private void setFondoBlanco(Image fondoBlanco) {
    this.fondoReina = fondoBlanco;
  }
}
