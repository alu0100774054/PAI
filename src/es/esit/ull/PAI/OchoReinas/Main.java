/**
 * Programa principal
 * @author: Erik Andreas Barreto de Vera
 * @version: 22/03/2016/A
 */
package es.esit.ull.PAI.OchoReinas;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Main extends JFrame {
  private final int ANCHO = 800;  // Ancho de la ventana.
  private final int ALTO = 800;   // Alto de la ventana.
  private final int TAMANIO;
  
  private int getANCHO() {
    return ANCHO;
  }

  private int getALTO() {
    return ALTO;
  }

  private int getTAMANIO() {
    return TAMANIO;
  }

  public Main(int tamanio) {
    TAMANIO = tamanio;
    inicializarInterfaz();
  }
  
  private void inicializarInterfaz() {
    setTitle("Problema de las \"Ocho Reinas\"");
    setSize(getANCHO(), getALTO());
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE); 
    
    // Tablero de ajedrez.
    TableroGUI ajedrez = new TableroGUI(getTAMANIO());
    TitledBorder titulo;
    titulo = BorderFactory.createTitledBorder("Solución al problema de las Ocho Reinas", TitledBorder.CENTER);
    ajedrez.setBorder(titulo);
    add(ajedrez);
  }
  
  public static void main(String[] args) throws Exception {
    Main programa = new Main(Integer.parseInt(args[0]));
    programa.setVisible(true);
    
    // Resolver el problema.
    OchoReinas problema = new OchoReinas(Integer.parseInt(args[0]));
    problema.buscarSoluciones();
    problema.imprimirSoluciones();
  }

}
