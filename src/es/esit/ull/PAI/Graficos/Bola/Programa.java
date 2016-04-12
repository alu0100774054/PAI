package es.esit.ull.PAI.Graficos.Bola;

import javax.swing.JFrame;

public class Programa extends JFrame {
  private final int ANCHO_VENTANA = 800;
  private final int ALTO_VENTANA = 822;
  private Interfaz interfaz;
  
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
}
