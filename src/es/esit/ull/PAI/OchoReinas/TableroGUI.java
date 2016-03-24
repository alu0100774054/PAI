package es.esit.ull.PAI.OchoReinas;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class TableroGUI extends JPanel {
  private CasillaGUI casillaTablero;  // Casilla del tablero.
  
  public TableroGUI(int tamanio) {
    new JPanel();
    setLayout(new GridLayout(tamanio, tamanio));
    for (int i = 0; i < tamanio * tamanio; i++) {
      casillaTablero = new CasillaGUI();
      add(casillaTablero);
    }   
  }
}
