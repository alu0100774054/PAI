package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import es.esit.ull.PAI.Graficos.Bola.BotonTamanio;
import javafx.scene.image.Image;
import sun.awt.image.PixelConverter.Rgba;

public class Menu extends JPanel {
  private BotonIniciar botonIniciar;
  private BotonFinalizar botonFinalizar;
  private BotonCambiarColor botonCambiarColor;
  private BotonTamanio botonTamanio;
  private Color colorFondo;
  
  public Menu(Mapa mapa) {
    establecerEstilo();
    iniciarComponentes(mapa);
  }

  private void establecerEstilo() {
    colorFondo = new Color(89, 64, 127);
    setBackground(getColorFondo());
  }

  private void iniciarComponentes(Mapa mapa) {
    botonIniciar = new BotonIniciar(mapa);
    botonFinalizar = new BotonFinalizar(mapa);
    botonCambiarColor = new BotonCambiarColor(mapa);
    botonTamanio = new BotonTamanio(mapa);
    add(botonIniciar);
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
