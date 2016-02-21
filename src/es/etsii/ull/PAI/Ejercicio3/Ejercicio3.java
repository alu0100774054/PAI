package es.etsii.ull.PAI.Ejercicio3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Este programa debe simplemente, imprimir en pantalla la diferencia entre 
 * el valor máximo y ḿınimo de un vector de números.
 * @author: Erik Andreas Barreto de Vera
 * @version: 20/02/2016/A
 */

public class Ejercicio3 {

	private ArrayList<Integer> array;	// Vector de elementos
	private File fichero;				// Nombre del fichero
	private int minimo = 0;				// Valor minimo del vector
	private int maximo = 0;				// Valor máximo del vector
	
	/**
	 * Constructor de un vector de números pasados por fichero.
	 * @param nombreFichero Nombre del fichero que contiene los números a analizar.
	 */
	public Ejercicio3(File nombreFichero) {
		array = new ArrayList<Integer>();
		leerFichero(nombreFichero);
	}
	
	/**
	 * Método que obtiene el mayor y el menor de un vector de elementos.
	 * @return La diferencia entre el valor máximo y mínimo.
	 */
	public int obtenerRango() {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) > maximo) {
				maximo = array.get(i);
			} else if (array.get(i) < minimo) {
				minimo = array.get(i);
			}	
		}
		return maximo - minimo;
	}
	
	/**
	 * Método que lee los números desde un fichero y los almacena en un vector.
	 * @param nombreFichero Nombre del fichero que contiene los números a analizar.
	 */
	private void leerFichero(File nombreFichero) {
		Scanner scan = null;
		try {
			// Leemos el contenido del fichero
			System.out.println("Leemos el contenido del fichero " + nombreFichero);
			scan = new Scanner(fichero);

			// Leemos linea a linea el fichero
			while (scan.hasNextLine()) {
				String linea = scan.nextLine();// Guardamos la linea en un String
				System.out.println(linea);
				array.add(Integer.parseInt(linea));	
			}
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (scan != null)
					scan.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		File fichero = new File(args[0]);
		Ejercicio3 vector = new Ejercicio3(fichero);
		System.out.println("El rango del vector es: " + vector.obtenerRango());
	}
}
