package es.esit.ull.PAI.OchoReinas;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;

import javafx.scene.image.Image;

public class CasillaGUI extends JPanel {
  
  public CasillaGUI() {
    new JPanel();
    JButton casilla = new JButton(new ImageIcon("images/casillaBlanca.png"));
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    //add(casilla);
  }

}
