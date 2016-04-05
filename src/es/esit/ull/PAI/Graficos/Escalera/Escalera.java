/**
 * Programa que dibuje en una ventana la representación gráfica de una escalera.
 * @author: Erik Andreas Barreto de Vera
 * @version: 04/04/2016
 */
package es.esit.ull.PAI.Graficos.Escalera;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Escalera extends JPanel {
  private final int SEPARACION_LATERAL = 30;
  private final int SEPARACION_ESCALON = 10;
  private final int ESCALONES = 10;
  private final int ALTURA = 100;
  
  /**
   * Constructor de la Escalera.
   */
  public Escalera() {
    iniciarComponentes();
  }
  /**
   * Método que inicializa los componentes.
   */
  private void iniciarComponentes() {
    setBackground(Color.white);
    setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), 
        BorderFactory.createLoweredBevelBorder()));
  }
  /**
   * Método que sobreescribe el paintComponent.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    dibujarDefectos(g);
    int incrementoEscalon = 0;
    for (int escalon = 1; escalon < getESCALONES(); escalon++) {
      incrementoEscalon = escalon * getSEPARACION_ESCALON();
      dibujarEscalon(g, escalon, incrementoEscalon);
    }
  }
  /**
   * Método que corrige los defectos generados al utilizar un bucle simple 
   * para completar los escalones, como la base o la pared.
   * @param g Clase con los gráficos.
   */
  private void dibujarDefectos(Graphics g) {
    // pared
    g.drawLine(getSEPARACION_LATERAL(), 
        getSEPARACION_LATERAL(),
        getSEPARACION_LATERAL(),
        getSEPARACION_LATERAL() + getSEPARACION_ESCALON() * getESCALONES());
    // comienzo
    g.drawLine(getSEPARACION_LATERAL(), 
        getSEPARACION_LATERAL(), 
        getSEPARACION_LATERAL() + getSEPARACION_ESCALON(), 
        getSEPARACION_LATERAL());

    g.drawLine(getSEPARACION_LATERAL() + getSEPARACION_ESCALON(), 
        getSEPARACION_LATERAL(), 
        getSEPARACION_LATERAL() + getSEPARACION_ESCALON(),
        getSEPARACION_LATERAL() + getSEPARACION_ESCALON());
    //base
    g.drawLine(getSEPARACION_LATERAL(), 
        getSEPARACION_LATERAL() + getESCALONES() * getSEPARACION_ESCALON(), 
        getSEPARACION_LATERAL() + getESCALONES() * getSEPARACION_ESCALON(), 
        getSEPARACION_LATERAL() + getESCALONES() * getSEPARACION_ESCALON());
  }
  /**
   * Método que dibuja cada uno de los escalones.
   * @param g Clase con los gráficos.
   * @param numeroEscalon número actual del escalón.
   * @param incremento Incremento según el escalón que estamos.
   */
  private void dibujarEscalon(Graphics g, int numeroEscalon, int incremento) {
    g.drawLine(getSEPARACION_LATERAL(), 
        getSEPARACION_LATERAL() + numeroEscalon * getSEPARACION_ESCALON(), 
        getSEPARACION_LATERAL() + incremento + getSEPARACION_ESCALON(), 
        getSEPARACION_LATERAL() + numeroEscalon * getSEPARACION_ESCALON());

    g.drawLine(getSEPARACION_LATERAL() + getSEPARACION_ESCALON() + numeroEscalon * getSEPARACION_ESCALON() , 
        getSEPARACION_LATERAL() + numeroEscalon * getSEPARACION_ESCALON(), 
        getSEPARACION_LATERAL() + getSEPARACION_ESCALON() + numeroEscalon * getSEPARACION_ESCALON(), 
        getSEPARACION_LATERAL() + numeroEscalon * getSEPARACION_ESCALON() + getSEPARACION_ESCALON());
  }

  private int getSEPARACION_LATERAL() {
    return SEPARACION_LATERAL;
  }

  private int getSEPARACION_ESCALON() {
    return SEPARACION_ESCALON;
  }

  private int getESCALONES() {
    return ESCALONES;
  }

  private int getALTURA() {
    return ALTURA;
  }


}
