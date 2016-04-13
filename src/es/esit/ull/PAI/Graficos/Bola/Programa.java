/**
 * PRÁCTICA 8: MOVIMIENTO Y CONTROL DE UN OBJETO GRÁFICO
 * Programa que muestre en pantalla una ventana 
 * rectangular con fondo de color azul sobre la que se vera un círculo 
 * centrado en la ventana y un panel con cuatro botones que permiten 
 * mover el círculo hacia arriba, abajo, izquierda y derecha.
 * @author: Erik Andreas Barreto de Vera
 * @email: alu0100774054@ull.edu.es
 * @version: 07/04/2016
 */
package es.esit.ull.PAI.Graficos.Bola;

import javax.swing.JFrame;

public class Programa extends JFrame {
  private final int ANCHO_VENTANA = 800;
  private final int ALTO_VENTANA = 822;
  private Interfaz interfaz;
  
  /**
   * Constructor del frame del programa.
   * @param desplazamiento Cantidad en pixeles que se desplaza la pelota.
   */
  public Programa(int desplazamiento) {
    interfaz = new Interfaz(desplazamiento);
    interfaz.setName("Interfaz");
    iniciarComponentes();
  }
  
  /**
   * Método que inicializa los componentes.
   */
  private void iniciarComponentes() {
    add(interfaz);

    setTitle("Mueve la pelota");
    setLocationRelativeTo(null);
    System.out.println("hola");
    setSize(getANCHO_VENTANA(), getALTO_VENTANA());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  private int getANCHO_VENTANA() {
    return ANCHO_VENTANA;
  }

  private int getALTO_VENTANA() {
    return ALTO_VENTANA;
  }

  public Interfaz getInterfaz() {
    return interfaz;
  }

  private void setInterfaz(Interfaz interfaz) {
    this.interfaz = interfaz;
  }
  
}
