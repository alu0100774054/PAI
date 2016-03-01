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

public class AnalizadorTexto {
  Map<String, Integer> mapaPalabras;
  public AnalizadorTexto(String nombrefichero) throws FileNotFoundException {
    // TODO Auto-generated constructor stub
    mapaPalabras = new HashMap<String, Integer>();
    cargarFichero(nombrefichero);
  }

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

  private void incrementarOcurrencia(String token) {
    // TODO Auto-generated method stub
    mapaPalabras.put(token, mapaPalabras.get(token) + 1);
  }

  private boolean encontrarOcurrencia(String token) {
    // TODO Auto-generated method stub
    if (mapaPalabras.containsKey(token)) {
      return true;
    } else {
      return false;
    }
  }

  public void recorrerMapa() {
    Iterator iteradorMapa = mapaPalabras.keySet().iterator();
    System.out.println("Clave ---> Valor");
    while(iteradorMapa.hasNext()){
      Object palabra = iteradorMapa.next();
      System.out.println(palabra + " ---> " + mapaPalabras.get(palabra));
    }
  }

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
