/**
 * PRÁCTICA 9: Camino aleatorio
 * Programa que muestre en pantalla una ventana 
 * con una cuadricula de tamaño X determinada por un parámetro densidad y 
 * que genera un camino aleatorio hacia uno de los bordes.
 * @author: Erik Andreas Barreto de Vera
 * @email: alu0100774054@ull.edu.es
 * @version: 20/04/2016
 */
package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonIniciar extends JButton implements ActionListener {
  private final String MENSAJE = "Iniciar";
  private Mapa mapa;
  
  /**
   * Constructo del botón que inicia el programa.
   * @param mapa
   */
  public BotonIniciar(Mapa mapa) {
    this.mapa = mapa;
    setName("botonIniciar");
    addActionListener(this);
    setFocusable(true);
    setText(getMENSAJE());
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("pulsado");
    mapa.iniciar();
  }

  private String getMENSAJE() {
    return MENSAJE;
  }
  
}
