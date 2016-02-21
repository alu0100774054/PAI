package es.etsii.ull.PAI.Ejercicio2;
import java.io.*;

/**
 * Este programa permite visualizar el número de veces que se repite los caracteres 'a' o 'A' 
 * en una cadena
 * @author: Erik Andreas Barreto de Vera
 * @version: 20/02/2016/A
 */

public class Ejercicio2 {

	private static int contador;	// Contador del número de repeticiones
	private static String texto;	// Cadena a analizar

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader in =  new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);
			System.out.print("Escriba el texto: ");
			texto = br.readLine();
			System.out.println(texto);
		} catch(java.io.IOException ioex) {
			System.out.println("error: " + ioex);
		}
		contarRepeticiones();
	}
	
	/**
	 * Método que cuenta el número de veces que se repite 'a' o 'A' en una cadena.
	 */
	private static void contarRepeticiones() {
		char[] arrayChar = texto.toCharArray();
		for (int i = 0; i < arrayChar.length; i++)
			if (arrayChar[i] == 'a' || arrayChar[i] == 'A')
				contador++;
		System.out.println("El número de caracteres a o A es:" + contador);
	}
}
