/**
 * Programa que dibuje en una ventana la representación gráfica de una función.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {
  private final int ANCHO = 400;  // Ancho de la ventana.
  private final int ALTO = 400;   // Alto de la ventana.

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
    add(new Cuadratica());

    setTitle("Cuadrática");
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
