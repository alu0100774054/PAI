package es.esit.ull.PAI.Graficos.CaminoAleatorio;

public class Nodo {
  private int coordenadaX;
  private int coordenadaY;
  private boolean visitado;
  
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
