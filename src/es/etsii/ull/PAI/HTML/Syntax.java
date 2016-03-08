package es.etsii.ull.PAI.HTML;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Syntax {
  private final String ENCABEZADO = "<!DOCTYPE html>";
  private final String INICIO_HEAD = "<head>";
  private final String FIN_HEAD = "</head>";
  private final String FORMATO = "<meta charset=\"utf-8\">";
  private final String INICIO_BODY = "<body>";
  private final String FIN_BODY = "</body>";
  private final String INICIO_TITTLE = "<title>";
  private final String FIN_TITTLE= "</title>";
  private final String INICIO_COMENTARIO_LARGO = "/*";
  private final String FIN_COMENTARIO_LARGO = "*/";
  private final String COMENTARIO_CORTO = "//";
  private final String CADENA_LITERAL = "\"";
  private final String COLOR_RESERVADAS = "<font color=\"BLACK\">";
  private final String COLOR_COMENTARIO = "<font color=\"GREEN\">";
  private final String COLOR_LITERALES = "<font color=\"BLUE\">";
  private final String FIN_COLOR_RESERVADAS = "</font>";
  private final String FIN_COLOR_COMENTARIO = "</font>";
  private final String FIN_COLOR_LITERALES = "</font>";
  private final String[] RESERVADAS = {"abstract", "double", "int", "strictfp", 
      "boolean", "else", "interface", "super", "break", "extends", "long", 
      "switch", "byte", "final", "native", "synchronized", "case", "finally", 
      "new", "this", "catch", "float", "package", "throw", "char", "for", 
      "private", "throws", "class", "goto", "protected", "transient", "const", 
      "if", "public", "try", "continue", "implements", "return", "void", 
      "default", "import", "short", "volatile", "do", "instanceof", "static", 
  "while"};
  private String nombreFicheroHTML;

  public String getNombreFicheroHTML() {
    return nombreFicheroHTML;
  }

  public void setNombreFicheroHTML(String nombreFicheroHTML) {
    this.nombreFicheroHTML = nombreFicheroHTML;
  }

  public String getENCABEZADO() {
    return ENCABEZADO;
  }

  public String getINICIO_HEAD() {
    return INICIO_HEAD;
  }

  public String getFIN_HEAD() {
    return FIN_HEAD;
  }

  public String getFORMATO() {
    return FORMATO;
  }

  public String getINICIO_BODY() {
    return INICIO_BODY;
  }

  public String getFIN_BODY() {
    return FIN_BODY;
  }

  public String getINICIO_TITTLE() {
    return INICIO_TITTLE;
  }

  public String getFIN_TITTLE() {
    return FIN_TITTLE;
  }

  public String getINICIO_COMENTARIO_LARGO() {
    return INICIO_COMENTARIO_LARGO;
  }

  public String getFIN_COMENTARIO_LARGO() {
    return FIN_COMENTARIO_LARGO;
  }

  public String getCOMENTARIO_CORTO() {
    return COMENTARIO_CORTO;
  }

  public String getCADENA_LITERAL() {
    return CADENA_LITERAL;
  }

  public String getCOLOR_RESERVADAS() {
    return COLOR_RESERVADAS;
  }

  public String getCOLOR_COMENTARIO() {
    return COLOR_COMENTARIO;
  }

  public String getCOLOR_LITERALES() {
    return COLOR_LITERALES;
  }

  public String getFIN_COLOR_RESERVADAS() {
    return FIN_COLOR_RESERVADAS;
  }

  public String getFIN_COLOR_COMENTARIO() {
    return FIN_COLOR_COMENTARIO;
  }

  public String getFIN_COLOR_LITERALES() {
    return FIN_COLOR_LITERALES;
  }

  public String[] getRESERVADAS() {
    return RESERVADAS;
  }

  public Syntax(String nombreFichero) throws FileNotFoundException {
    setNombreFicheroHTML(nombreFichero);
    lecturaFichero(getNombreFicheroHTML());
  }

  private void lecturaFichero(String nombreFicheroHTML2) throws FileNotFoundException {
    // Fichero del que queremos leer
    File fichero = new File(getNombreFicheroHTML());
    Scanner s = null;
    // Leemos el contenido del fichero
    System.out.println("... Leemos el contenido del fichero ...\n");
    s = new Scanner(fichero);
    while (s.hasNextLine()) {
      String linea = s.nextLine();  // Guardamos la linea en un String
      StringTokenizer st = new StringTokenizer(linea, "\",;:.?()[]/\\ ");
      while (st.hasMoreTokens()) { 
        String token = st.nextToken();
        System.out.println("leyendo ---> " + token);
      }
    }
  }
}
