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

import java.awt.Color;

import javax.swing.JPanel;

public class Menu extends JPanel {
  private BotonIniciar botonIniciar;
  private BotonFinalizar botonFinalizar;
  private BotonCambiarColor botonCambiarColor;
  private BotonTamanio botonTamanio;
  private BotonPausar botonPausar;
  private BotonReiniciar botonReiniciar;
  private Color colorFondo;
  
  /**
   * Construye un menú con la opciones para manipular el programa.
   * @param mapa Mapa.
   */
  public Menu(Mapa mapa) {
    establecerEstilo();
    iniciarComponentes(mapa);
  }

  /**
   * Método que establece el estilo del menú.
   */
  private void establecerEstilo() {
    colorFondo = new Color(89, 64, 127);
    setBackground(getColorFondo());
  }

  /**
   * Método que inicializa los componentes del menú.
   * @param mapa
   */
  private void iniciarComponentes(Mapa mapa) {
    botonIniciar = new BotonIniciar(mapa);
    botonFinalizar = new BotonFinalizar(mapa);
    botonCambiarColor = new BotonCambiarColor(mapa);
    botonTamanio = new BotonTamanio(mapa);
    botonPausar = new BotonPausar(mapa);
    botonReiniciar = new BotonReiniciar(mapa);
    
    add(botonIniciar);
    add(botonReiniciar);
    add(botonPausar);
    add(botonFinalizar);
    add(botonCambiarColor);
    add(botonTamanio);
  }

  private BotonIniciar getBotonIniciar() {
    return botonIniciar;
  }

  private void setBotonIniciar(BotonIniciar botonIniciar) {
    this.botonIniciar = botonIniciar;
  }

  private BotonFinalizar getBotonFinalizar() {
    return botonFinalizar;
  }

  private void setBotonFinalizar(BotonFinalizar botonFinalizar) {
    this.botonFinalizar = botonFinalizar;
  }

  private BotonCambiarColor getBotonCambiarColor() {
    return botonCambiarColor;
  }

  private void setBotonCambiarColor(BotonCambiarColor botonCambiarColor) {
    this.botonCambiarColor = botonCambiarColor;
  }

  private Color getColorFondo() {
    return colorFondo;
  }
  
}
