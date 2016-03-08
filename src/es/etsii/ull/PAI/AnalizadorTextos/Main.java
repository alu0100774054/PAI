package es.etsii.ull.PAI.AnalizadorTextos;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if (args.length > 1) {
		      System.out.println("Introduzca sólo un fichero.");
		      System.exit(0);
		    } else {
		      AnalizadorTextoInverso analizador = new AnalizadorTextoInverso(String.valueOf(args[0]));
		      analizador.recorrerOrdenado();
		    }
	}

}
