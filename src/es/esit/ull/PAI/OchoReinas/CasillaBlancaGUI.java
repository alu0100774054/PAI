package es.esit.ull.PAI.OchoReinas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.image.*;

public class CasillaBlancaGUI extends JPanel {
  private Image fondoBlanco;  // Fondo de la casilla blanca;
  
  public CasillaBlancaGUI() {
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
    ImageIcon fondo = new ImageIcon("images/casillaBlanca.png");
    fondoBlanco = fondo.getImage(); 
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    g.drawImage(fondoBlanco, 0, 0, null);
  }

  private Image getFondoBlanco() {
    return fondoBlanco;
  }

  private void setFondoBlanco(Image fondoBlanco) {
    this.fondoBlanco = fondoBlanco;
  }

}
