/**
 * Programa que dibuje en una ventana la representación gráfica de una función.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {

  public Main() {
    iniciarComponentes();
  }
  private void iniciarComponentes() {
    add(new JButton("prueba"));

    setTitle("Cuadrática");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
  }
  public static void main(String[] args) {
    Main programa = new Main();
    programa.setVisible(true);
  }

}
