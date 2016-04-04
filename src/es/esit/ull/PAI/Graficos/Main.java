/**
 * Programa que dibuje en una ventana la representación gráfica de una función.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {
  private final int ANCHO = 800;  // Ancho de la ventana.
  private final int ALTO = 800;   // Alto de la ventana.
  /**
   * Constructor de la clase principal.
   */
  public Main(Double terminoA, Double terminoB, Double constante) {
    iniciarComponentes(terminoA, terminoB, constante);
  }
  
  /**
   * Método que inicializa los componentes.
   */
  private void iniciarComponentes(Double terminoA, Double terminoB, Double constante) {
    add(new Cuadratica(terminoA, terminoB, constante));

    setTitle("Gráfica");
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
    Main programa = new Main(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
    programa.setVisible(true);
  }

}
