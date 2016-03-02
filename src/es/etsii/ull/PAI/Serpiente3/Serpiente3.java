/**
 * Crea objetos serpiente.
 * @author erikbarretodevera
 * @version: 18/02/2016/A
 */
package es.etsii.ull.PAI.Serpiente3;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import es.etsii.ull.PAI.Serpiente.Serpiente;

public class Serpiente3 {
  private static int numSerpientes;
  private int idSerpiente;
  /**
   * Constructor.
   */
  public Serpiente3() {
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
    // Ejercicio 3
    Serpiente serpiente2 = new Serpiente();
    Serpiente serpiente3 = new Serpiente();
    Serpiente serpiente4 = new Serpiente();
    Map<String, Serpiente> mapaSerpientes = new TreeMap<String, Serpiente>();
    mapaSerpientes.put("arturo", serpiente2);
    mapaSerpientes.put("eugenia", serpiente3);
    mapaSerpientes.put("pedro", serpiente4);
    System.out.println("\n tamaño del mapa: " + mapaSerpientes.size());
    // Recorrer mapa con iterador
    Iterator iteradorMap = mapaSerpientes.keySet().iterator();
    System.out.println("Clave ---> Valor");
    while(iteradorMap.hasNext()){
      Object nombreSerpiente = iteradorMap.next();
      System.out.println(nombreSerpiente + " ---> " + mapaSerpientes.get(nombreSerpiente).reptar());
    }
    // Recorrer mapa con foreach
    System.out.println("\nClave ---> Valor");
    for (Map.Entry<String, Serpiente> ser : mapaSerpientes.entrySet()) {    
      String nombre = ser.getKey();
      Serpiente serpi = ser.getValue();
      System.out.println(nombre + " ---> " + serpi.getIdSerpiente());
    }
  }

}
