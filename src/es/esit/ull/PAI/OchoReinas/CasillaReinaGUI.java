package es.esit.ull.PAI.OchoReinas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CasillaReinaGUI extends JPanel {
  private Image fondoReina;  // Fondo de la casilla de la reina;
  
  public CasillaReinaGUI() {
    new JPanel();
    inicializarComponente();
  }

  private void inicializarComponente() {
    loadImage();
    
    int ancho = getFondoBlanco().getWidth(this);
    int alto =  getFondoBlanco().getHeight(this);
    setPreferredSize(new Dimension(ancho, alto)); 
  }

  private void loadImage() {
    ImageIcon fondo = new ImageIcon("images/reina.png");
    fondoReina = fondo.getImage(); 
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.cyan);
    g.drawImage(fondoReina, 0, 0, null);
    
  }

  private Image getFondoBlanco() {
    return fondoReina;
  }

  private void setFondoBlanco(Image fondoBlanco) {
    this.fondoReina = fondoBlanco;
  }
}
