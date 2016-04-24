/**
 * PRÁCTICA 9: Camino aleatorio
 * Programa que muestre en pantalla una ventana 
 * con una cuadricula de tamaño X determinada por un parámetro densidad y 
 * que genera un camino aleatorio hacia uno de los bordes.
 * @author: Erik Andreas Barreto de Vera
 * @email: alu0100774054@ull.edu.es
 * @version: 20/04/2016
 */
package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Interfaz extends JFrame {
  private Dimension dimension;
  private Menu menu;
  private Mapa mapa;
  
  /**
   * Método que inicializa la interfaz del programa.
   * @param densidad Densidad de la rejilla.
   */
  public Interfaz(int densidad) {
    iniciarInterfaz();
    iniciarComponentes(densidad);
  }

  /**
   * Método que inicializa los componentes de la interfaz.
   * @param densidad Densidad de la rejilla.
   */
  private void iniciarComponentes(int densidad) {
    setLayout(new BorderLayout());
    mapa = new Mapa(densidad);
    menu = new Menu(mapa);
    add(mapa, BorderLayout.CENTER);
    add(menu, BorderLayout.PAGE_END);
  }

  /**
   * Método que inicializa la interfaz.
   */
  private void iniciarInterfaz() {
    dimension=super.getToolkit().getScreenSize();
    super.setSize(dimension);
    super.setUndecorated(true);
    setTitle("Generdor de caminos aleatorios");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null); 
  }
}
