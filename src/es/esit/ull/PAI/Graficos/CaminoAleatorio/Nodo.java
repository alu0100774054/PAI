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

public class Nodo {
  private int coordenadaX;
  private int coordenadaY;
  private boolean visitado;
  
  /**
   * Contruye un nodo que corresponde a una coordenada X e Y en la malla.
   * @param coordX coordenada X.
   * @param coordY coordenada Y.
   */
  public Nodo(int coordX, int coordY) {
    coordenadaX = coordX;
    coordenadaY = coordY;
    visitado = true;
  }

  public int getCoordenadaX() {
    return coordenadaX;
  }

  public void setCoordenadaX(int coordenadaX) {
    this.coordenadaX = coordenadaX;
  }

  public int getCoordenadaY() {
    return coordenadaY;
  }

  public void setCoordenadaY(int coordenadaY) {
    this.coordenadaY = coordenadaY;
  }

  public boolean isVisitado() {
    return visitado;
  }

  public void setVisitado(boolean visitado) {
    this.visitado = visitado;
  }

 
  
}
