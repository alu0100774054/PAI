/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.etsii.ull.PAI.AnalizadorTextos;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length > 1) {
		      System.out.println("Introduzca sólo un fichero.");
		      System.exit(0);
		    } else {
		      AnalizadorTextoInverso analizador = new AnalizadorTextoInverso(String.valueOf(args[0]));
		      analizador.recorrerOrdenado();
		    }
	}

}
