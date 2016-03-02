package es.etsii.ull.PAI.Serpiente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;
/**
 * Crea objetos serpiente.
 * @author erikbarretodevera
 * @version: 18/02/2016/A
 */
public class Serpiente {
  private static int numSerpientes;
  private int idSerpiente;
  /**
   * Constructor.
   */
  public Serpiente() {
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
  private void setIdSerpiente(int idSerpiente) {
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
  }
}
