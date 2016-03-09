/**
 * Juego en el que el usuario debe adivinar tres números generados aleatoriamente, 
 * según la combinación que acierte el usuario obtendrá un premio distinto.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.etsii.ull.PAI.JuegoPremio;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class JuegoPremio extends JFrame{
  private int numeroUsuario1;                  // Primer número del usuario
  private int numeroUsuario2;                  // Segundo número del usuario
  private int numeroUsuario3;                  // Tercer número del usuario
  private int numeroPremio1;                   // Primer número del premio
  private int numeroPremio2;                   // Segundo número del premio
  private int numeroPremio3;                   // Tercer número del premio
  private boolean premio1;                     // Gana 1.000€
  private boolean premio2;                     // Gana 2.000€
  private boolean premio3;                     // Gana 3.000€
  private boolean premio4;                     // Gana 10.000€
  private final String[] listaDeNumeros =      // Lista del comboBox
    {"1","2","3","4","5","6","7","8","9"};
  private final static int ANCHO = 200;        // Ancho de la ventana
  private final static int ALTO = 200;         // Alto de la ventana
  JPanel panelPremio;                          // Panel donde muestra el premio
  JPanel panelNumeros;                         // Panel donde muestra los números
  TreeMap<Integer, Integer> combinacion;       // Mapa con la combinacion del usuario y el juego
  /**
   * Gana 1.000€
   * @return Ha ganado el premio de 1.000€
   */
  public boolean isPremio1() {
    return premio1;
  }
  /**
   * Establece el premio a 1.000€
   * @param premio1 Establece el premio a 1.000€
   */
  public void setPremio1(boolean premio1) {
    this.premio1 = premio1;
  }
  /**
   * Gana 2.000€
   * @return Ha ganado el premio de 2.000€
   */
  public boolean isPremio2() {
    return premio2;
  }
  /**
   * Establece el premio a 2.000€
   * @param premio1 Establece el premio a 2.000€
   */
  public void setPremio2(boolean premio2) {
    this.premio2 = premio2;
  }
  /**
   * Gana 3.000€
   * @return Ha ganado el premio de 3.000€
   */
  public boolean isPremio3() {
    return premio3;
  }
  /**
   * Establece el premio a 3.000€
   * @param premio1 Establece el premio a 3.000€
   */
  public void setPremio3(boolean premio3) {
    this.premio3 = premio3;
  }
  /**
   * Gana 10.000€
   * @return Ha ganado el premio de 10.000€
   */
  public boolean isPremio4() {
    return premio4;
  }
  /**
   * Establece el premio a 10.000€
   * @param premio1 Establece el premio a 10.000€
   */
  public void setPremio4(boolean premio4) {
    this.premio4 = premio4;
  }
  /**
   * Obtiene el primer número del usuario.
   * @return Primer número.
   */
  public int getNumeroUsuario1() {
    return numeroUsuario1;
  }
  /**
   * Guarda el primer número del usuario.
   * @param numeroUsuario1 Primer número del usuario
   */
  public void setNumeroUsuario1(int numeroUsuario1) {
    this.numeroUsuario1 = numeroUsuario1;
  }
  /**
   * Obtiene el segundo número del usuario.
   * @return Primer número.
   */
  public int getNumeroUsuario2() {
    return numeroUsuario2;
  }
  /**
   * Guarda el segundo número del usuario.
   * @param numeroUsuario1 segundo número del usuario
   */
  public void setNumeroUsuario2(int numeroUsuario2) {
    this.numeroUsuario2 = numeroUsuario2;
  }
  /**
   * Obtiene el tercer número del usuario.
   * @return Primer número.
   */
  public int getNumeroUsuario3() {
    return numeroUsuario3;
  }
  /**
   * Guarda el tercer número del usuario.
   * @param numeroUsuario1 Tercer número del usuario
   */
  public void setNumeroUsuario3(int numeroUsuario3) {
    this.numeroUsuario3 = numeroUsuario3;
  }
  /**
   * Obtiene el primer número del juego.
   * @return  Primer número del juego.
   */
  public int getNumeroPremio1() {
    return numeroPremio1;
  }
  /**
   * Cambia el primer número del juego.
   * @param numeroPremio1 Primer número del juego.
   */
  public void setNumeroPremio1(int numeroPremio1) {
    this.numeroPremio1 = numeroPremio1;
  }
  /**
   * Obtiene el segundo número del juego.
   * @return  Segundo número del juego.
   */
  public int getNumeroPremio2() {
    return numeroPremio2;
  }
  /**
   * Cambia el segundo número del juego.
   * @param numeroPremio1 Segundo número del juego.
   */
  public void setNumeroPremio2(int numeroPremio2) {
    this.numeroPremio2 = numeroPremio2;
  }
  /**
   * Obtiene el tercer número del juego.
   * @return  Tercer número del juego.
   */
  public int getNumeroPremio3() {
    return numeroPremio3;
  }
  /**
   * Cambia el tercer número del juego.
   * @param numeroPremio1 tercer número del juego.
   */
  public void setNumeroPremio3(int numeroPremio3) {
    this.numeroPremio3 = numeroPremio3;
  }
  /**
   * Obtiene el mapa de la combinación.
   * @return  Combinación.
   */
  public TreeMap<Integer, Integer> getCombinacion() {
    return combinacion;
  }
  /**
   * Crea el mapa de la combinación.
   * @param combinacion Mapa con la combinación.
   */
  public void setCombinacion(TreeMap<Integer, Integer> combinacion) {
    this.combinacion = combinacion;
  }
  /**
   * Constructor
   * @param n1 Primer número del usuario
   * @param n2 Segundo número del usuario
   * @param n3 Tercer número del usuario.
   */
  public JuegoPremio(String n1, String n2, String n3) {
    new JFrame("juego");
    setSize(ANCHO, ALTO);
    setLayout(new FlowLayout());
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panelPremio = new JPanel();
    panelNumeros = new JPanel();
    JComboBox numeros1 = new JComboBox(listaDeNumeros);
    JComboBox numeros2 = new JComboBox(listaDeNumeros);
    JComboBox numeros3 = new JComboBox(listaDeNumeros);
    JButton boton = new JButton("Comprobar");
    panelNumeros.add(numeros1);
    panelNumeros.add(numeros2);
    panelNumeros.add(numeros3);
    panelNumeros.add(boton);
    add(panelNumeros);
    setNumeroUsuario1(Integer.parseInt(n1));
    setNumeroUsuario2(Integer.parseInt(n2));
    setNumeroUsuario3(Integer.parseInt(n3));
    setNumeroPremio1((int) (Math.random() * 9 + 1));
    setNumeroPremio2((int) (Math.random() * 9 + 1));
    setNumeroPremio3((int) (Math.random() * 9 + 1));
    combinacion = new TreeMap<Integer, Integer>();
    combinacion.put(getNumeroUsuario1(), getNumeroPremio1());
    combinacion.put(getNumeroUsuario2(), getNumeroPremio2());
    combinacion.put(getNumeroUsuario3(), getNumeroPremio3());
    setPremio1(false);
    setPremio2(false);
    setPremio3(false);
    setPremio4(false);
    comprobarCombinacion();
    JLabel premio = obtenerPremio();
    panelPremio.add(premio);
    add(panelPremio);
  }
  /**
   * Obtiene la Gui del premio
   * @return  Premio 
   */
  private JLabel obtenerPremio() {
    if (isPremio4()) {
      return new JLabel("Premio gordo: 10.000€");
    } else if (isPremio3()) {
      return new JLabel("Premio: 3.000€");
    } else if (isPremio2()) {
      return new JLabel("Premio: 2.000€");
    } else if (isPremio1()) {
      return new JLabel("Premio: 1.000€");
    } else {
      return new JLabel("No ganado ningún premio");
    }
  }
  /**
   * Comprueba la combinación del sistema y la del usuario
   */
  private void comprobarCombinacion() {
    Iterator it = combinacion.keySet().iterator();
    int premioGordo = 0;
    int premioPeque = 0;
    while (it.hasNext()) {
      Integer clave = (Integer) it.next();
      System.out.println("Numero usuario: " + clave + " --> número premiado: " + combinacion.get(clave));
      if (clave == combinacion.get(clave)) {
        premioGordo++;
      }
      if (clave == getNumeroPremio1() || clave == getNumeroPremio2() || clave == getNumeroPremio3()) {
        premioPeque++;
      }
    }
    if (premioGordo == 3) {
      System.out.println("Has ganado 10.000€ de premio.");
      setPremio4(true);
    }
    switch (premioPeque) {
    case 0:
      System.out.println("No has ganado ningún premio.");
      System.exit(0);
      break;
    case 1:
      System.out.println("Has ganado 1.000€ de premio.");
      setPremio1(true);
      break;
    case 2:
      System.out.println("Has ganado 2.000€ de premio.");
      setPremio2(true);
      break;
    case 3:
      System.out.println("Has ganado 3.000€ de premio.");
      setPremio3(true);
      break;
    default:
      System.out.println("Error interno.");
      break;
    }
  }
}
