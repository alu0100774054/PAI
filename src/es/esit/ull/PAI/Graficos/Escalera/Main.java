/**
 * Programa que dibuje en una ventana la representación gráfica de una esclaera.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos.Escalera;

import javax.swing.JFrame;

public class Main extends JFrame {
  private final int ANCHO = 200;  // Ancho de la ventana.
  private final int ALTO = 200;   // Alto de la ventana.

  /**
   * Constructor de la clase principal.
   */
  public Main() {
    iniciarComponentes();
  }

  /**
   * Método que inicializa los componentes.
   */
  private void iniciarComponentes() {
    add(new Escalera());

    setTitle("Escalera");
    setLocationRelativeTo(null);
    setSize(getANCHO(), getALTO());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


  private int getANCHO() {
    return ANCHO;
  }

  private int getALTO() {
    return ALTO;
  }
  public static void main(String[] args) {
    Main programa = new Main();
    programa.setVisible(true);
  }

}
