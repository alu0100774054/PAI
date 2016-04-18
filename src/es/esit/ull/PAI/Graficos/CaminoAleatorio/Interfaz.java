package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Interfaz extends JFrame {
  private Dimension dimension;
  private Menu menu;
  private Mapa mapa;
  
  public Interfaz(int densidad) {
    iniciarInterfaz();
    iniciarComponentes(densidad);
  }

  private void iniciarComponentes(int densidad) {
    setLayout(new BorderLayout());
    mapa = new Mapa(densidad);
    menu = new Menu(mapa);
    add(mapa, BorderLayout.CENTER);
    add(menu, BorderLayout.PAGE_END);
  }

  private void iniciarInterfaz() {
    dimension=super.getToolkit().getScreenSize();
    super.setSize(dimension);
    super.setUndecorated(true);
    setTitle("Generdor de caminos aleatorios");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null); 
  }
}
