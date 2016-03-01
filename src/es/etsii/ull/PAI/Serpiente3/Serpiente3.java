package es.etsii.ull.PAI.Serpiente3;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import es.etsii.ull.PAI.Serpiente.Serpiente;

public class Serpiente3 {
  private static int numSerpientes;
  private int idSerpiente;

  public Serpiente3() {
    // TODO Auto-generated constructor stub
    numSerpientes++;
    setIdSerpiente(numSerpientes);
  }

  public int getIdSerpiente() {
    return idSerpiente;
  }

  public void setIdSerpiente(int idSerpiente) {
    this.idSerpiente = idSerpiente;
  }

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
