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
  private volatile boolean corriendo = false;
  private volatile boolean parado = false;
  private int densidad;
  private final int DIREC_POSIBLES = 4;
  private int origenX;
  private int origenY;
  private boolean iniciado = false;
  private int relacionX;
  private int relacionY;
  private int siguienteX;
  private int siguienteY;
  private int anchoVentana;
  private int altoVentana;
  private Color colorFondo;
  private ArrayList<Nodo> solucion;
  private int intentos;
  
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
    intentos = 0;
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

  public void resolverCamino() {
    getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));
    while (!isParado()) {
      resolverSiguiente();
      //repaint();
    }
    //mostrarSolucion();
    //parar();
  }

  private void mostrarSolucion() {
    for (int i = 0; i < getSolucion().size(); i++) {
      System.out.println("[" + i + "]= " 
          + getSolucion().get(i).getCoordenadaX() + " " 
          + getSolucion().get(i).getCoordenadaY());

    }
  }

  private void resolverSiguiente() {

    int direccion = siguienteDireccion();
    
    if (getOrigenX() > 0 && getOrigenX() < getAnchoVentana() && getOrigenY() > 0 && getOrigenY() < getAltoVentana()) {
      repaint();
      switch (direccion) {
      // Arriba
      case 0:
        if (repetido(getOrigenX(), getOrigenY() - getRelacionY())) {
          System.out.println("no se puede arriba");
          setIntentos(getIntentos() + 1);
          if (getIntentos() == 3) {
            int aleatorio = retroceder();
            setSiguienteX(getSolucion().get(aleatorio).getCoordenadaX());
            setSiguienteY(getSolucion().get(aleatorio).getCoordenadaY());
            setOrigenX(getSiguienteX());
            setOrigenY(getSiguienteY());
          }
        } else {
          setSiguienteX(getOrigenX());
          setSiguienteY(getOrigenY() - getRelacionY());
          setOrigenX(getSiguienteX());
          setOrigenY(getSiguienteY());
          System.out.println(getOrigenX() + " " + getOrigenY());
          getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));
        }
        break;
      // Abajo
      case 1:
        if (repetido(getOrigenX(), getOrigenY() + getRelacionY())) {
          System.out.println("no se puede abajo");
          setIntentos(getIntentos() + 1);
          if (getIntentos() == 3) {
            int aleatorio = retroceder();
            setSiguienteX(getSolucion().get(aleatorio).getCoordenadaX());
            setSiguienteY(getSolucion().get(aleatorio).getCoordenadaY());
            setOrigenX(getSiguienteX());
            setOrigenY(getSiguienteY());
          }
        } else {
          setSiguienteX(getOrigenX());
          setSiguienteY(getOrigenY() + getRelacionY());
          setOrigenX(getSiguienteX());
          setOrigenY(getSiguienteY());
          System.out.println(getOrigenX() + " " + getOrigenY());
          getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));
        }
        break;
      // Derecha
      case 2:
        if (repetido(getOrigenX() + getRelacionX(), getOrigenY())) {
          System.out.println("no se puede dcha");
          setIntentos(getIntentos() + 1);
          if (getIntentos() == 3) {
            int aleatorio = retroceder();
            setSiguienteX(getSolucion().get(aleatorio).getCoordenadaX());
            setSiguienteY(getSolucion().get(aleatorio).getCoordenadaY());
            setOrigenX(getSiguienteX());
            setOrigenY(getSiguienteY());
          }
        } else {
          setSiguienteX(getOrigenX() + getRelacionX());
          setSiguienteY(getOrigenY());
          setOrigenX(getSiguienteX());
          setOrigenY(getSiguienteY());
          System.out.println(getOrigenX() + " " + getOrigenY());
          getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));
        }
        break;
      // Izquierda
      case 3:
        if (repetido(getOrigenX() - getRelacionX(), getOrigenY())) {
          System.out.println("no se puede izq");
          setIntentos(getIntentos() + 1);
          if (getIntentos() == 3) {
            int aleatorio = retroceder();
            setSiguienteX(getSolucion().get(aleatorio).getCoordenadaX());
            setSiguienteY(getSolucion().get(aleatorio).getCoordenadaY());
            setOrigenX(getSiguienteX());
            setOrigenY(getSiguienteY());
          }
        } else {
          setSiguienteX(getOrigenX() - getRelacionX());
          setSiguienteY(getOrigenY());
          setOrigenX(getSiguienteX());
          setOrigenY(getSiguienteY());
          System.out.println(getOrigenX() + " " + getOrigenY());
          getSolucion().add(new Nodo(getOrigenX(), getOrigenY()));
        }
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

  public void iniciar() {
    if (getHilo() == null || !isCorriendo()) {
      setHilo(new Thread(this));
      getHilo().start();

    }
  }
  public void parar() {
    setCorriendo(false);
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
    g.setColor(Color.RED);
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(3));

    for (int i = 0; i < getSolucion().size() - 1; i++) {
      //System.out.println("dibujando" + getSolucion().get(i).getCoordenadaX() + " " + getSolucion().get(i).getCoordenadaY() + " " + getSolucion().get(i + 1).getCoordenadaX() + " " + getSolucion().get(i + 1).getCoordenadaY());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      g2.drawLine(getSolucion().get(i).getCoordenadaX(), 
          getSolucion().get(i).getCoordenadaY(), 
          getSolucion().get(i + 1).getCoordenadaX(), 
          getSolucion().get(i + 1).getCoordenadaY());
    }
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

  private void dibujarCuadricula(Graphics g) {
    setAnchoVentana(this.getWidth());
    setAltoVentana(this.getHeight());
    setRelacionX((this.getWidth() / getDensidad()));
    setRelacionY((this.getHeight() / getDensidad()));
    int incrementoX = 0;
    int incrementoY = 0;
    for (int i = 0; i <= getAnchoVentana(); i++) {
      // Guardar el centro del mapa.
      if (i == getDensidad() / 2) {
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

  public void actualizar(int densidad) {
    setDensidad(densidad);
    setIniciado(false);
    repaint();
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

  public int getIntentos() {
    return intentos;
  }

  public void setIntentos(int intentos) {
    this.intentos = intentos;
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

  @Override
  public void run() {
    corriendo = true;
    while (isCorriendo()) {
      resolverCamino();
      repaint();   
      try {
        Thread.sleep(200);
      } catch (Exception e) {}

    }
    System.exit(0);
  }


}
