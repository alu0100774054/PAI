/**
 * Programa que lee un fichero y crea un fichero de salida index.html
 * que va a permitir visualizar el contenido en un navegador.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.etsii.ull.PAI.HTML;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Syntax s = new Syntax(args[0]);
  }

}
