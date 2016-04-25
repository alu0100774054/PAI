package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Navegador extends Applet {
  private Dimension dimension;
  private Menu menu;
  private Mapa mapa;

  @Override
  public void init() {
    super.init();
    setLayout(new BorderLayout());
    dimension=super.getToolkit().getScreenSize();
    super.setSize(dimension);
    mapa = new Mapa(20);
    menu = new Menu(mapa);
    add(mapa, BorderLayout.CENTER);
    add(menu, BorderLayout.PAGE_END);
  }

}
