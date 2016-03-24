/**
 * Programa que encuentra las 92 soluciones posibles para el problema 
 * de las "Ocho Reinas". Características:
 * 
 * 1) Colocar en un tablero 8 reinas sin que estas se amenacen.
 * 
 * 2) Existen 92 soluciones posibles (sólo 12 son únicas) para
 *    un tablero de 8 x 8.
 * 
 * 3) Algoritmo aplicado: Fuerza bruta.
 * 
 * @author: Erik Andreas Barreto de Vera
 * @version: 22/03/2016/A
 */
package es.esit.ull.PAI.OchoReinas;

import java.util.ArrayList;

public class OchoReinas {
  private final int VALOR_DEFECTO = -1;                      // Valor por defecto si 
  // no hay solución aún.
  private final int TAMANIO_TABLERO;                         // Tamaño del problema.
  private boolean[] vectorFilas;                             // Vector con las filas.
  private boolean[] vectorColumnas;                          // Vector con las columnas.
  private boolean[] diagonalSuperior;                        // Vector con la diagonal superior.
  private boolean[] diagonalInferior;                        // Vector con la diagonal inferior.
  private int[] solucionIndividual;                          // Vector con la solución.
  private boolean haySolucion;                               // Hay solucion.
  private ArrayList solucionesPosibles = new ArrayList();    // Array con las soluciones.
  private boolean sols;                                      // Hay más soluciones.


  public OchoReinas(int tamanio) throws Exception {
    if (tamanio < 4) {
      throw new Exception("No existe solución para un tablero tan pequeño.");
    }
    TAMANIO_TABLERO = tamanio;
    inicializar();
  }

  private void inicializar() {
    vectorFilas = new boolean[TAMANIO_TABLERO];
    vectorColumnas = new boolean[TAMANIO_TABLERO];
    solucionIndividual = new int[TAMANIO_TABLERO];
    for (int i = 0; i < TAMANIO_TABLERO; i++){
      vectorFilas [i] = true;
      vectorColumnas [i] = true;
      solucionIndividual [i] = VALOR_DEFECTO;
    }
    diagonalInferior = new boolean[2 * TAMANIO_TABLERO - 1];
    diagonalSuperior = new boolean[2 * TAMANIO_TABLERO - 1];
    for (int i = 0; i < 2 * TAMANIO_TABLERO - 1; i++){
      diagonalInferior[i] = true;
      diagonalSuperior[i] = true;
    }
    haySolucion = false;
  }

  private void buscarSolucion(int fila) {
    int col = 0;
    // Comprobamos no salir del tablero y que todavía no es la solución.
    while (col < getTamanioTablero() && !isHaySolucion()) {
      // Si fila, columna o diagonales están libres de amenaza.
      if (getVectorFilas(fila) && getVectorColumnas(col)                  
          && getDiagonalInferior(col - fila + getTamanioTablero() - 1)
          && getDiagonalSuperior(col + fila)){
        
        // añado y actualizo las condiciones.
        setSolucion(fila, col);
        setVectorFilas(fila, false);
        setVectorColumnas(col, false);
        setDiagonalInferior(col - fila + getTamanioTablero() - 1, false);
        setDiagonalSuperior(col + fila, false);

        // Solución encontrada.
        if (fila == getTamanioTablero() - 1 && solucionNueva(getSolucion())) {
          setHaySolucion(true);
        } else {
          // Probar de nuevo.
          if (fila + 1 < getTamanioTablero()) {
            buscarSolucion(fila + 1); 
          }
          // Resetear.
          if (!isHaySolucion()) {
            setSolucion(fila, VALOR_DEFECTO);
            setVectorFilas(fila, true);
            setVectorColumnas(col, true);
            setDiagonalInferior(col - fila + getTamanioTablero() - 1, true);
            setDiagonalSuperior(col + fila, true);
          }
        }
      }
      col++;
    }
  }

  public void buscarSoluciones() {
    boolean isSolucion = true;
    while (isSolucion) {
      buscarSolucion(0);
      if (solucionNueva(getSolucion())) {
        isSolucion = true;
        agregarSolucion();
      } else {
        isSolucion = false;
      }
      inicializar();
    }
  }

  private void agregarSolucion() {
    getSoluciones().add(getSolucion());  
  }

  private boolean solucionNueva(int[] nuevaSolucion) {
    if (nuevaSolucion[0] == VALOR_DEFECTO) return false;
    boolean esNueva = true;
    int i = 0;
    while (i < getSoluciones().size() && esNueva) { 
      int[] unaSol = (int[]) getSoluciones().get(i);
      esNueva = !sonIguales(unaSol,nuevaSolucion);
      i++;
    }

    return esNueva;
  }

  private  boolean sonIguales (int[] a, int[] b) {
    int i = 0;
    int j = 0;
    boolean isIguales = true;        
    while ((i < a.length) && (j < b.length)) {
      if (a[i] != b[j]) {
        return false;
      }
      i++;
      j++;            
    }
    return isIguales;
  }

  public void imprimirSoluciones() {
    for (int i = 0; i < getSoluciones().size();i++){
      int[] aux  = (int[]) getSoluciones().get(i);
      System.out.println("Solucion " + ( i + 1) + " : ");
      for (int j = 0; j<aux.length;j++){
        System.out.print("( " + ( j + 1 ) + ", " + (aux[j] + 1 ) + " ) ");
      }
      System.out.println("");
    }
  }
  
  private boolean[] getVectorFilas() {
    return vectorFilas;
  }

  private void setVectorFilas(boolean[] vectorFilas) {
    this.vectorFilas = vectorFilas;
  }

  private boolean getVectorFilas(int indice) {
    return vectorFilas[indice];
  }

  private void setVectorFilas(int indice, boolean elemento) {
    vectorFilas[indice] = elemento;
  }

  private boolean[] getVectorColumnas() {
    return vectorColumnas;
  }

  private boolean getVectorColumnas(int indice) {
    return vectorColumnas[indice];
  }

  private void setVectorColumnas(boolean[] vectorColumnas) {
    this.vectorColumnas = vectorColumnas;
  }

  private void setVectorColumnas(int indice, boolean elemento) {
    vectorColumnas[indice] = elemento;
  }

  private boolean[] getDiagonalSuperior() {
    return diagonalSuperior;
  }

  private boolean getDiagonalSuperior(int indice) {
    return diagonalSuperior[indice];
  }

  private void setDiagonalSuperior(boolean[] diagonalSuperior) {
    this.diagonalSuperior = diagonalSuperior;
  }

  private void setDiagonalSuperior(int indice, boolean elemento) {
    diagonalSuperior[indice] = elemento;
  }

  private boolean[] getDiagonalInferior() {
    return diagonalInferior;
  }

  private boolean getDiagonalInferior(int indice) {
    return diagonalInferior[indice];
  }

  private void setDiagonalInferior(boolean[] diagonalInferior) {
    this.diagonalInferior = diagonalInferior;
  }

  private void setDiagonalInferior(int indice, boolean elemento) {
    diagonalInferior[indice] = elemento;
  }

  private int[] getSolucion() {
    return solucionIndividual;
  }

  private int getSolucion(int indice) {
    return solucionIndividual[indice];
  }

  private void setSolucion(int[] solucion) {
    this.solucionIndividual = solucion;
  }

  private void setSolucion(int indice, int elemento) {
    solucionIndividual[indice] = elemento;
  }

  private boolean isHaySolucion() {
    return haySolucion;
  }

  private void setHaySolucion(boolean haySolucion) {
    this.haySolucion = haySolucion;
  }

  public ArrayList getSoluciones() {
    return solucionesPosibles;
  }

  private void setSoluciones(ArrayList soluciones) {
    this.solucionesPosibles = soluciones;
  }

  private boolean isSols() {
    return sols;
  }

  private void setSols(boolean sols) {
    this.sols = sols;
  }

  private int getTamanioTablero() {
    return TAMANIO_TABLERO;
  }

}
