package es.etsii.ull.PAI.JuegoPremio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class JuegoPremio {
  private int numeroUsuario1;
  private int numeroUsuario2;
  private int numeroUsuario3;
  private int numeroPremio1;
  private int numeroPremio2;
  private int numeroPremio3;
  private boolean premio1;
  private boolean premio2;
  private boolean premio3;
  private boolean premio4;
  
  public boolean isPremio1() {
    return premio1;
  }

  public void setPremio1(boolean premio1) {
    this.premio1 = premio1;
  }

  public boolean isPremio2() {
    return premio2;
  }

  public void setPremio2(boolean premio2) {
    this.premio2 = premio2;
  }

  public boolean isPremio3() {
    return premio3;
  }

  public void setPremio3(boolean premio3) {
    this.premio3 = premio3;
  }

  public boolean isPremio4() {
    return premio4;
  }

  public void setPremio4(boolean premio4) {
    this.premio4 = premio4;
  }

  TreeMap<Integer, Integer> combinacion;

  public int getNumeroUsuario1() {
    return numeroUsuario1;
  }

  public void setNumeroUsuario1(int numeroUsuario1) {
    this.numeroUsuario1 = numeroUsuario1;
  }

  public int getNumeroUsuario2() {
    return numeroUsuario2;
  }

  public void setNumeroUsuario2(int numeroUsuario2) {
    this.numeroUsuario2 = numeroUsuario2;
  }

  public int getNumeroUsuario3() {
    return numeroUsuario3;
  }

  public void setNumeroUsuario3(int numeroUsuario3) {
    this.numeroUsuario3 = numeroUsuario3;
  }

  public int getNumeroPremio1() {
    return numeroPremio1;
  }

  public void setNumeroPremio1(int numeroPremio1) {
    this.numeroPremio1 = numeroPremio1;
  }

  public int getNumeroPremio2() {
    return numeroPremio2;
  }

  public void setNumeroPremio2(int numeroPremio2) {
    this.numeroPremio2 = numeroPremio2;
  }

  public int getNumeroPremio3() {
    return numeroPremio3;
  }

  public void setNumeroPremio3(int numeroPremio3) {
    this.numeroPremio3 = numeroPremio3;
  }

  public TreeMap<Integer, Integer> getCombinacion() {
    return combinacion;
  }

  public void setCombinacion(TreeMap<Integer, Integer> combinacion) {
    this.combinacion = combinacion;
  }

  public JuegoPremio(String n1, String n2, String n3) {
    setNumeroUsuario1(Integer.parseInt(n1));
    setNumeroUsuario2(Integer.parseInt(n2));
    setNumeroUsuario3(Integer.parseInt(n3));
    setNumeroPremio1((int) (Math.random() * 9 + 1));
    setNumeroPremio2((int) (Math.random() * 9 + 1));
    setNumeroPremio3((int) (Math.random() * 9 + 1));
    combinacion = new TreeMap<Integer, Integer>();
    combinacion.put(getNumeroUsuario1(), getNumeroPremio1());
    combinacion.put(getNumeroUsuario2(), getNumeroPremio2());
    combinacion.put(getNumeroUsuario3(), getNumeroPremio3());
    setPremio1(false);
    setPremio2(false);
    setPremio3(false);
    setPremio4(false);
    comprobarCombinacion();
  }

  private void comprobarCombinacion() {
    Iterator it = combinacion.keySet().iterator();
    int premioGordo = 0;
    int premioPeque = 0;
    while (it.hasNext()) {
      Integer clave = (Integer) it.next();
      System.out.println("Numero usuario: " + clave + " --> número premiado: " + combinacion.get(clave));
      if (clave == combinacion.get(clave)) {
        premioGordo++;
      }
      if (clave == getNumeroPremio1() || clave == getNumeroPremio2() || clave == getNumeroPremio3()) {
        premioPeque++;
      }
    }
    if (premioGordo == 3) {
      setPremio4(true);
    }
    switch (premioPeque) {
    case 0:
      System.out.println("No has ganado ningún premio.");
      System.exit(0);
      break;
    case 1:
      System.out.println("Has ganado 1.000€ de premio.");
      setPremio1(true);
      break;
    case 2:
      System.out.println("Has ganado 2.000€ de premio.");
      setPremio2(true);
      break;
    case 3:
      System.out.println("Has ganado 3.000€ de premio.");
      setPremio3(true);
      break;
    default:
      System.out.println("Error interno.");
      break;
    }
  }
}
