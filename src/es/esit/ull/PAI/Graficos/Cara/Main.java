package es.esit.ull.PAI.Graficos.Cara;

import javax.swing.JFrame;

public class Main extends JFrame {
  private final int ANCHO = 300;  // Ancho de la ventana.
  private final int ALTO = 300;   // Alto de la ventana.

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
    add(new Cara());

    setTitle("Cara");
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

