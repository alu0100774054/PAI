package es.etsii.ull.PAI.AnalizadorTextos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AnalizadorTexto {
	ArrayList<String> palabras;
	ArrayList<Integer> ocurrencias;
	public AnalizadorTexto(String nombrefichero) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		palabras = new ArrayList<String>();
		ocurrencias = new ArrayList<Integer>();
		cargarFichero(nombrefichero);
	}
	
	public ArrayList<String> getPalabras() {
		return palabras;
	}

	public ArrayList<Integer> getOcurrencias() {
		return ocurrencias;
	}

	public void setPalabras(ArrayList<String> palabras) {
		this.palabras = palabras;
	}

	public void setOcurrencias(ArrayList<Integer> ocurrencias) {
		this.ocurrencias = ocurrencias;
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
			StringTokenizer st = new StringTokenizer(linea, ",;:.?()[]/ ");
			while (st.hasMoreTokens()) { 
				String token = st.nextToken();
				analizar(token);
			}
		}
	}

	private void analizar(String token) {
		// TODO Auto-generated method stub
		if (palabras.size() == 0) {
			palabras.add(token);
			ocurrencias.add(0, 1);
		} else if (palabras.size() > 0) {
			int posicion = encontrarOcurrencia(token);
			ocurrencias.add(posicion, ocurrencias.get(posicion) + 1);
		}
	}

	private int encontrarOcurrencia(String token) {
		// TODO Auto-generated method stub
		for (int i = 0;i < palabras.size();i++) {
			if (palabras.get(i).equals(token)) {
				return i;
			}
		}
		palabras.add(token);
		return palabras.size();
	}

	public void recorrerPalabras() {
		for (int i = 0;i < getPalabras().size(); i++)
			System.out.println("Palabra[" + i + "] = " + palabras.get(i));
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if (args.length > 1) {
			System.out.println("Introduzca sólo un fichero.");
			System.exit(0);
		} else {
			AnalizadorTexto analizador = new AnalizadorTexto(String.valueOf(args[0]));
			analizador.recorrerPalabras();
		}
	}

}
