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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class Mapa extends JPanel implements Runnable {
  private Thread hilo;
  private volatile boolean corriendo = false;     // Indica si el programa está calculando las direcciones, o no.
  private volatile boolean parado = false;        // Indica cuando el programa termino de solucionar.
  private int densidad;                           // Densidad de la rejilla.
  private final int DIREC_POSIBLES = 4;           // Direcciones posibles, Norte, Este, Sur, Oeste.
  private final int RANGO_COLORES = 256;          // Limite superior para crear números RGB.
  private int origenX;
  private int origenY;
  private boolean iniciado = false;               // Permite mostrar sólo la rejilla en el paintComponent().
  private int relacionX;                          // Cantidad de desplazamiento en el eje X.
  private int relacionY;                          // Cantidad de desplazamiento en el eje Y.
  private int siguienteX;
  private int siguienteY;
  private int anchoVentana;
  private int altoVentana;
  private Color colorFondo;
  private ArrayList<Nodo> solucion;               // Vector con todas las coordenadas parte de la solución.
  private int direccion;                          // Dirección a la que vamos a movernos.
  private boolean cambiarColor = false;
  private int gamaR;  
  private int gamaG;
  private int gamaB;

  public Mapa(int densidad) {
    this.densidad = densidad;
    origenX = 0;
    origenY = 0;
    relacionX = 0;
    relacionY = 0;
    siguienteX = 0;
    siguienteY = 0;
    anchoVentana = 0;
    altoVentana = 0;
    solucion = new ArrayList<Nodo>();
    establecerEstilo();
    iniciarComponentes();
  }

  private void establecerEstilo() {
    colorFondo = Color.WHITE;
    setBackground(getColorFondo());
  }

  private void iniciarComponentes() {

  }

  @Override
  public void run() {
    resolver();
  }

  public void iniciar() {
    if (getHilo() == null && !isCorriendo()) {
      setHilo(new Thread(this));
      getHilo().start();
    } else if (!isCorriendo()) {
      getHilo().stop();
      reiniciar();
      getHilo().start();
      //resolver();
    }
  }
  public void resolver() {
    corriendo = true;
    while (isCorriendo()) {
      resolverCamino();
    }
  }
  public void reiniciar() { 
    reiniciarDatos();
    repaint();
  }
  private void reiniciarDatos() {
    setHilo(null);
    setIniciado(false);
    setParado(false);
    setCorriendo(false);
    setOrigenX(0);
    setOrigenY(0);
    setRelacionX(0);
    setRelacionY(0);
    setSiguienteX(0);
    setSiguienteY(0);
    setAnchoVentana(0);
    setAltoVentana(0);
    setSolucion(null);
    setSolucion(new ArrayList<Nodo>());
  }

  public void pausar() {
    getHilo().suspend();
  }

  public void parar() {
    getHilo().stop();
    System.exit(0);
  }

  public void actualizar(int densidad) {
    reiniciar();
    setDensidad(densidad);
    repaint();
    iniciar();
  }

  public void resolverCamino() {
    while (!isParado()) {
      resolverSiguiente();
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      repaint();
    }
    repaint();
  }

  private void mostrarSolucion() {
    for (int i = 0; i < getSolucion().size(); i++) {
      System.out.println("[" + i + "]= " 
          + getSolucion().get(i).getCoordenadaX() + " " 
          + getSolucion().get(i).getCoordenadaY());

    }
  }

  private void resolverSiguiente() {
    if (getSolucion().size() == 0) {
      getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));
    }
    if (getOrigenX() > 0 && getOrigenX() < getAnchoVentana() && getOrigenY() > 0 && getOrigenY() < getAltoVentana()) {
      setDireccion(siguienteDireccion());
      switch (getDireccion()) {
      // Arriba
      case 0:
        setSiguienteX(getOrigenX());
        setSiguienteY(getOrigenY() - getRelacionY());
        setOrigenX(getSiguienteX());
        setOrigenY(getSiguienteY());
        System.out.println(getOrigenX() + " " + getOrigenY());
        getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));

        break;
      // Abajo
      case 1:
        setSiguienteX(getOrigenX());
        setSiguienteY(getOrigenY() + getRelacionY());
        setOrigenX(getSiguienteX());
        setOrigenY(getSiguienteY());
        System.out.println(getOrigenX() + " " + getOrigenY());
        getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));

        break;
      // Derecha
      case 2:
        setSiguienteX(getOrigenX() + getRelacionX());
        setSiguienteY(getOrigenY());
        setOrigenX(getSiguienteX());
        setOrigenY(getSiguienteY());
        System.out.println(getOrigenX() + " " + getOrigenY());
        getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));

        break;
      // Izquierda
      case 3:
        setSiguienteX(getOrigenX() - getRelacionX());
        setSiguienteY(getOrigenY());
        setOrigenX(getSiguienteX());
        setOrigenY(getSiguienteY());
        System.out.println(getOrigenX() + " " + getOrigenY());
        getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));

        break;     
      default:
        System.out.println("Fallo creando dirección");
        break;
      }
    } else {
      setParado(true);
    }

  }

  private int retroceder() {
    return (int) Math.floor(Math.random() * getSolucion().size());
  }


  private int siguienteDireccion() {
    return (int) Math.floor(Math.random() * getDIREC_POSIBLES());
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (isIniciado() == false) {
      dibujarCuadricula(g);
    } else 
      dibujarSolucion(g);
  }

  private void dibujarSolucion(Graphics g) {
    // Pinta la cuadricula.
    dibujarCuadricula(g);
    g.setColor(new Color(gamaR, gamaG, gamaB));
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(3));
    for (int i = 0; i < getSolucion().size() - 1; i++) {
      g2.drawLine(getSolucion().get(i).getCoordenadaX(), 
          getSolucion().get(i).getCoordenadaY(), 
          getSolucion().get(i + 1).getCoordenadaX(), 
          getSolucion().get(i + 1).getCoordenadaY());
    }
  }

  private void dibujarCuadricula(Graphics g) {
    setAnchoVentana(this.getWidth());
    setAltoVentana(this.getHeight());
    setRelacionX((this.getWidth() / getDensidad()));
    setRelacionY((this.getHeight() / getDensidad()));
    int incrementoX = 0;
    int incrementoY = 0;
    for (int i = 0; i <= getAnchoVentana(); i++) {
      // Guardar el centro del mapa.
      if (i == getDensidad() / 2 && !isIniciado()) {
        setOrigenX(incrementoX);
        setOrigenY(incrementoY);
      }
      // Lineas Verticales.
      g.drawLine(incrementoX, 0, incrementoX, this.getHeight());
      // Lineas horizontales.
      g.drawLine(0, incrementoY, this.getWidth(), incrementoY);
      // Incrementar coordenadas.
      incrementoX += getRelacionX();
      incrementoY += getRelacionY();
    }
    setIniciado(true);
  }

  public void cambiarColor(Graphics gr) {
    gamaR = (int) Math.floor(Math.random() * getRangoRGB());
    gamaG = (int) Math.floor(Math.random() * getRangoRGB());
    gamaB = (int) Math.floor(Math.random() * getRangoRGB());
    repaint();
  }
  
  private boolean repetido(int origenX2, int origenY2) {
    Iterator<Nodo> iterador = getSolucion().iterator();
    while(iterador.hasNext()){
      Nodo elemento = iterador.next();
      if (elemento.getCoordenadaX() == origenX2 && elemento.getCoordenadaY() == origenY2) {
        return true;
      }
    }
    return false;
  }


  private int getDensidad() {
    return densidad;
  }

  private void setDensidad(int densidad) {
    this.densidad = densidad;
  }

  private int getOrigenX() {
    return origenX;
  }

  private void setOrigenX(int origenX) {
    this.origenX = origenX;
  }

  private int getOrigenY() {
    return origenY;
  }

  private void setOrigenY(int origenY) {
    this.origenY = origenY;
  }

  private int getRelacionX() {
    return relacionX;
  }

  private void setRelacionX(int relacionX) {
    this.relacionX = relacionX;
  }

  private int getRelacionY() {
    return relacionY;
  }

  private void setRelacionY(int relacionY) {
    this.relacionY = relacionY;
  }

  private int getSiguienteX() {
    return siguienteX;
  }

  private void setSiguienteX(int siguienteX) {
    this.siguienteX = siguienteX;
  }

  private int getSiguienteY() {
    return siguienteY;
  }

  private void setSiguienteY(int siguienteY) {
    this.siguienteY = siguienteY;
  }

  private boolean isIniciado() {
    return iniciado;
  }

  private void setIniciado(boolean iniciado) {
    this.iniciado = iniciado;
  }


  private int getDIREC_POSIBLES() {
    return DIREC_POSIBLES;
  }

  private int getAnchoVentana() {
    return anchoVentana;
  }

  private void setAnchoVentana(int anchoVentana) {
    this.anchoVentana = anchoVentana;
  }

  private int getAltoVentana() {
    return altoVentana;
  }

  private void setAltoVentana(int altoVentana) {
    this.altoVentana = altoVentana;
  }

  private Color getColorFondo() {
    return colorFondo;
  }

  private void setColorFondo(Color colorFondo) {
    this.colorFondo = colorFondo;
  }

  private ArrayList<Nodo> getSolucion() {
    return solucion;
  }

  private void setSolucion(ArrayList<Nodo> solucion) {
    this.solucion = solucion;
  }

  public Thread getHilo() {
    return hilo;
  }

  public void setHilo(Thread hilo) {
    this.hilo = hilo;
  }

  public boolean isCorriendo() {
    return corriendo;
  }

  public void setCorriendo(boolean corriendo) {
    this.corriendo = corriendo;
  }

  public boolean isParado() {
    return parado;
  }

  public void setParado(boolean parado) {
    this.parado = parado;
  }

  public int getDireccion() {
    return direccion;
  }

  public void setDireccion(int direccion) {
    this.direccion = direccion;
  }

  public int getRangoRGB() {
    return RANGO_COLORES;
  }

  public boolean isCambiarColor() {
    return cambiarColor;
  }

  public void setCambiarColor(boolean cambiarColor) {
    this.cambiarColor = cambiarColor;
  }

  public int getRANGO_COLORES() {
    return RANGO_COLORES;
  }
  
}
