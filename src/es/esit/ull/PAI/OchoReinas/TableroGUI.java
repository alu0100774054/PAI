package es.esit.ull.PAI.OchoReinas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TableroGUI extends JPanel implements KeyListener, ActionListener {
  private CasillaBlancaGUI casillaTablero;  // Casilla blanca del tablero.
  private CasillaNegraGUI casillaTablero2;  // Casilla negra del tablero.
  private CasillaReinaGUI casillaTablero3;  // Casilla reina del tablero.
  private OchoReinas problema;              // Clase que gestiona el problema.
  private final int REINA = -1;             // Valor que diferencia la reina de las demás.
  private int numeroSolucion = 0;           // Número de la solución que actualmente se muestra.
  private final int TAMANIO;                // Tamaño del tablero.
  private ArrayList soluciones;             // Vector con las soluciones del problema.
  private int[][] tablero;                  // tablero sobre el que colocamos la solución.
  private int[][] tableroMolde;             // Molde para inicializar el tablero.

  public TableroGUI(int tamanio) throws Exception {
    TAMANIO = tamanio;
    tablero = new int[getTAMANIO()][getTAMANIO()];
    iniciarMolde();
    resetearTablero();
    new JPanel();
    addKeyListener(this);
    setFocusable(true);
    setLayout(new GridLayout(getTAMANIO(), getTAMANIO()));
    solucionar();

    // Construye el tablero.
    for (int i = 0; i < getTAMANIO(); i++) {
      for (int j = 0; j < getTAMANIO(); j++) {
        if (getTableroElemento(i, j) == 0) {
          casillaTablero = new CasillaBlancaGUI();
          add(casillaTablero); 
        } else if (getTableroElemento(i, j) == 1) {
          casillaTablero2 = new CasillaNegraGUI(); 
          add(casillaTablero2); 
        } 
        else if (getTableroElemento(i, j) == -1) {
          casillaTablero3 = new CasillaReinaGUI((i + j)); 
          add(casillaTablero3);
        }
      } 
    }    
  }

  private void iniciarMolde() {
    int molde[][] = new int[getTAMANIO()][getTAMANIO()];
    for (int i = 0; i < getTAMANIO(); i++) {
      for (int j = 0; j < getTAMANIO(); j++) {
        if ((i + j) % 2 == 0) {
          molde[i][j] = 0;
        } else {
          molde[i][j] = 1;
        }
      }
    }
    setTableroMolde(molde);
  }
  
  private void solucionar() throws Exception {
    problema = new OchoReinas(getTAMANIO());
    Temporizador temporizador = new Temporizador();
    temporizador.iniciarCronometro();
    problema.buscarSoluciones();
    temporizador.pararCronometro();
    soluciones = problema.getSoluciones();
    int[] aux  = (int[]) soluciones.get(getNumeroSolucion());
    System.out.println("Solucion " + ( getNumeroSolucion() + 1) + " : ");
    for (int j = 0; j < aux.length; j++) {
      setTableroReina(j, aux[j]);
      System.out.print("( " + ( j + 1 ) + ", " + (aux[j] + 1 ) + " ) ");
    }
    System.out.println("");
  }
  
  private void resetearTablero() {
    for (int i = 0; i < getTAMANIO(); i++)
      for (int j = 0; j < getTAMANIO(); j++)
        tablero[i][j] = tableroMolde[i][j];
  }

  private void actualizar() throws Exception {
    resetearTablero();
    solucionar();
    removeAll();
    validate();
    new JPanel();
    setLayout(new GridLayout(getTAMANIO(), getTAMANIO()));

    // Construye el tablero.
    for (int i = 0; i < getTAMANIO(); i++) {
      for (int j = 0; j < getTAMANIO(); j++) {
        if (getTableroElemento(i, j) == 0) {
          casillaTablero = new CasillaBlancaGUI();
          add(casillaTablero); 

        } else if (getTableroElemento(i, j) == 1) {
          casillaTablero2 = new CasillaNegraGUI(); 
          add(casillaTablero2);
        } 
        else if (getTableroElemento(i, j) == -1) {
          casillaTablero3 = new CasillaReinaGUI((i + j)); 
          add(casillaTablero3);
        }
        validate();
      } 
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    int key = e.getKeyCode();

    if ((key == KeyEvent.VK_RIGHT) && (getNumeroSolucion() + 1 <= soluciones.size())) {
      System.out.println("derecha");
      setNumeroSolucion(getNumeroSolucion() + 1);
      try {
        actualizar();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }

    if ((key == KeyEvent.VK_LEFT) && (getNumeroSolucion() - 1 >= 0)) {
      System.out.println("izquierda");
      setNumeroSolucion(getNumeroSolucion() - 1);
      try {
        actualizar();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if ((key == KeyEvent.VK_RIGHT) && (getNumeroSolucion() + 1 <= soluciones.size())) {
      System.out.println("derecha");
      setNumeroSolucion(getNumeroSolucion() + 1);
      try {
        actualizar();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }

    if ((key == KeyEvent.VK_LEFT) && (getNumeroSolucion() - 1 >= 0)) {
      System.out.println("izquierda");
      setNumeroSolucion(getNumeroSolucion() - 1);
      try {
        actualizar();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint(); 
  }

  private CasillaReinaGUI getCasillaTablero3() {
    return casillaTablero3;
  }
  private void setCasillaTablero3(CasillaReinaGUI casillaTablero3) {
    this.casillaTablero3 = casillaTablero3;
  }

  private int getTAMANIO() {
    return TAMANIO;
  }
  
  private int getNumeroSolucion() {
    return numeroSolucion;
  }
  
  private void setNumeroSolucion(int numeroSolucion) {
    this.numeroSolucion = numeroSolucion;
  }
  
  private int getTableroElemento(int fila, int columna) {
    return tablero[fila][columna];
  }
  
  private void setTableroReina(int fila, int columna) {
    tablero[fila][columna] = getREINA();
  }
  
  private CasillaBlancaGUI getCasillaTablero() {
    return casillaTablero;
  }
  
  private void setCasillaTablero(CasillaBlancaGUI casillaTablero) {
    this.casillaTablero = casillaTablero;
  }
  
  private CasillaNegraGUI getCasillaTablero2() {
    return casillaTablero2;
  }
  
  private void setCasillaTablero2(CasillaNegraGUI casillaTablero2) {
    this.casillaTablero2 = casillaTablero2;
  }
  
  private OchoReinas getProblema() {
    return problema;
  }
  
  private void setProblema(OchoReinas problema) {
    this.problema = problema;
  }
  
  private ArrayList getSoluciones() {
    return soluciones;
  }
  
  private void setSoluciones(ArrayList soluciones) {
    this.soluciones = soluciones;
  }
  
  private int[][] getTablero() {
    return tablero;
  }
  
  private void setTablero(int[][] tablero) {
    this.tablero = tablero;
  }
  
  private int getREINA() {
    return REINA;
  }

  private void setTableroMolde(int[][] tableroMolde) {
    this.tableroMolde = tableroMolde;
  }
  
  private int[][] getTableroMolde() {
    return tableroMolde;
  }
}
