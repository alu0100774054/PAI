/**
 * Crea objetos serpiente.
 * @author erikbarretodevera
 * @version: 18/02/2016/A
 */
package es.etsii.ull.PAI.Serpiente2;
import java.util.ArrayList;
import java.util.Iterator;

import es.etsii.ull.PAI.Serpiente.Serpiente;

public class Serpiente2 {
  private static int numSerpientes;
  private int idSerpiente;
  /**
   * Constructor.
   */
  public Serpiente2() {
    // TODO Auto-generated constructor stub
    numSerpientes++;
    setIdSerpiente(numSerpientes);
  }
  /**
   * Obtiene el número que identifica que serpiente es.
   * @return Número de la serpiente.
   */
  public int getIdSerpiente() {
    return idSerpiente;
  }
  /**
   * Establece cual es el número de serpiente que la identifica.
   * @param idSerpiente Número que la identifica.
   */
  public void setIdSerpiente(int idSerpiente) {
    this.idSerpiente = idSerpiente;
  }
  /**
   * Obtiene el número que identifica que serpiente es.
   * @return Número de la serpiente.
   */
  public int reptar() {
    return getIdSerpiente();
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ArrayList<Serpiente> mascotas = new ArrayList<Serpiente>();
    Serpiente serpiente = null;
    // Ejercicio 2
    for (int i = 0; i < 5; i++) {
      serpiente = new Serpiente();
      mascotas.add(serpiente);
    }
    Iterator<Serpiente> iteradorSerpientes = mascotas.iterator();
    while(iteradorSerpientes.hasNext()){
      Serpiente serp = iteradorSerpientes.next();
      System.out.println("Nº de serpiente = " + serp.reptar());
    }
  }

}
