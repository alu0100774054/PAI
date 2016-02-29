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

	public String getPalabras(int indice) {
		return palabras.get(indice);
	}

	public Integer getOcurrencias(int indice) {
		return ocurrencias.get(indice);
	}

	public void setPalabras(ArrayList<String> palabras) {
		this.palabras = palabras;
	}

	public void setOcurrencias(ArrayList<Integer> ocurrencias) {
		this.ocurrencias = ocurrencias;
	}
	
	public void setOcurrencias(int indice, int contador) {
		ocurrencias.set(indice, contador);
	}

	public void setPalabras(String palabra) {
		palabras.add(palabra);
	}

	private void analizar(String palabra) {
		// TODO Auto-generated method stub
		if (getPalabras().size() == 0) {
			System.out.println("... Iniciando analisis ...");
			setPalabras(palabra);
		} else {
			encontrarOcurrencia(palabra);
		}
	}

	private void actualizarOcurrencia(int indice) {
		// TODO Auto-generated method stub
		int incrementado = getOcurrencias(indice) + 1;
		setOcurrencias(indice, incrementado);
	}

	private void encontrarOcurrencia(String palabra) {
		// TODO Auto-generated method stub
		for (int i = 0; i < getPalabras().size(); i++) {
			System.out.println("analizando " + getPalabras(i) + " y " + palabra);
			if (getPalabras(i).equals(palabra)) {
				//actualizarOcurrencia(i);
				break;
			}
		}
		setPalabras(palabra);
		//actualizarOcurrencia(getPalabras().size());
	}

	@Override
	public String toString() {
		// falta
		return "AnalizadorTexto [palabras=" + palabras + ", ocurrencias=" + ocurrencias + "]";
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

	public void recorrerPalabras() {
		for (int i = 0;i < getPalabras().size(); i++)
			System.out.println("Palabra[" + i + "] = " + getPalabras(i));
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
