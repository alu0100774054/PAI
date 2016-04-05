/**
 * Programa que dibuje en una ventana la representación gráfica de una espiral.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos.Espiral;

import javax.swing.JFrame;

public class Main extends JFrame {
  private int ancho = 200;  // Ancho de la ventana.
  private int alto = 200;   // Alto de la ventana.

  /**
   * Constructor de la clase principal.
   */
  public Main(int dimension) {
    ancho = dimension;
    alto = dimension;
    iniciarComponentes(dimension);
  }

  /**
   * Método que inicializa los componentes.
   */
  private void iniciarComponentes(int dimension) {
    add(new Espiral(dimension));

    setTitle("Espiral");
    setLocationRelativeTo(null);
    setSize(getAncho(), getAlto());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


  private int getAncho() {
    return ancho;
  }

  private int getAlto() {
    return alto;
  }
  public static void main(String[] args) {
    Main programa = new Main(Integer.parseInt(args[0]));
    programa.setVisible(true);
  }

}
