package es.etsii.ull.PAI.AnalizadorTextos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Cuenta el número de ocurrencias de cada palabra a medida que analiza un testo pasado por fichero de entrada,
 * mostrando finalmente cada palabra y e número de veces que se repite.
 * @author erikbarretodevera
 * @version: 18/02/2016/A
 */
public class AnalizadorTexto {
  Map<String, Integer> mapaPalabras;
  public AnalizadorTexto(String nombrefichero) throws FileNotFoundException {
    // TODO Auto-generated constructor stub
    mapaPalabras = new HashMap<String, Integer>();
    cargarFichero(nombrefichero);
  }
  /**
   * Lee el texto a partir de un fichero que se le pasa por parámetro y para cada palabra llama al método que 
   * analiza la ocurrencia.
   * @param nombrefichero Fichero desde el que queremos leer el texto.
   * @throws FileNotFoundException Excepcion si no encuentra el fichero.
   */
  private void cargarFichero(String nombrefichero) throws FileNotFoundException {
    // TODO Auto-generated method stub
    File fichero = new File(nombrefichero);
    Scanner s = null;
    // Leemos el contenido del fichero
    System.out.println("... Leemos el contenido del fichero ...\n");
    s = new Scanner(fichero);
    // Leemos linea a linea el fichero
    while (s.hasNextLine()) {
      String linea = s.nextLine(); 	// Guardamos la linea en un String
      StringTokenizer st = new StringTokenizer(linea, "\",;:.?()[]/\\ ");
      while (st.hasMoreTokens()) { 
        String token = st.nextToken();
        System.out.println("analizando ---> " + token);
        if (encontrarOcurrencia(token)) {
          incrementarOcurrencia(token);
        } else {
          mapaPalabras.put(token, 1);
        }
      }
    }
  }
  /**
   * Incrementa el contador de una determinada palabra.
   * @param token Es la palabra que se repite.
   */
  private void incrementarOcurrencia(String token) {
    // TODO Auto-generated method stub
    mapaPalabras.put(token, mapaPalabras.get(token) + 1);
  }
  /**
   * Busca si la palabra que se le pasa ya ha sido analizada y en tal caso incrementar 
   * el número de ocurrencias
   * @param token Palabra que queremos analizar.
   * @return Si se repite la palabra.
   */
  private boolean encontrarOcurrencia(String token) {
    // TODO Auto-generated method stub
    if (mapaPalabras.containsKey(token)) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * Recorre el mapa con un iterador.
   */
  public void recorrerMapa() {
    Iterator iteradorMapa = mapaPalabras.keySet().iterator();
    System.out.println("Clave ---> Valor");
    while(iteradorMapa.hasNext()){
      Object palabra = iteradorMapa.next();
      System.out.println(palabra + " ---> " + mapaPalabras.get(palabra));
    }
  }
  /**
   * Recorre el mapa con un iterador mostrando el resultado ordenado alfabeticamente.
   */
  public void recorrerOrdenado() {
    List sortedKeys=new ArrayList(mapaPalabras.keySet());
    Collections.sort(sortedKeys);
    Iterator<String> it = sortedKeys.iterator();	 
    while (it.hasNext()) {
      Object palabra = it.next();
      System.out.println(palabra + " ---> " + mapaPalabras.get(palabra));
    }
  }
  public static void main(String[] args) throws FileNotFoundException {
    // TODO Auto-generated method stub
    if (args.length > 1) {
      System.out.println("Introduzca sólo un fichero.");
      System.exit(0);
    } else {
      AnalizadorTexto analizador = new AnalizadorTexto(String.valueOf(args[0]));
      analizador.recorrerOrdenado();
    }
  }

}
