package es.esit.ull.PAI.OchoReinas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CasillaNegraGUI extends JPanel {
  private Image fondoNegro;  // Fondo de la casilla negra;
  
  public CasillaNegraGUI() {
    new JPanel();
    inicializarComponente();
  }

  private void inicializarComponente() {
    loadImage();
    
    int ancho = getFondoNegro().getWidth(this);
    int alto =  getFondoNegro().getHeight(this);
    setPreferredSize(new Dimension(ancho, alto)); 
  }

  private void loadImage() {
    ImageIcon fondo = new ImageIcon("images/casillaNegra.png");
    fondoNegro = fondo.getImage(); 
  }
  
  @Override
  public void paintComponent(Graphics g) {
    //super.paintComponent(g);
    
    g.drawImage(fondoNegro, 0, 0, null);
  }

  private Image getFondoNegro() {
    return fondoNegro;
  }

  private void setFondoNegro(Image fondoNegro) {
    this.fondoNegro = fondoNegro;
  }

 
}
