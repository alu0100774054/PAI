package es.etsii.ull.PAI.AnalizadorTextos;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnalizadorTextoInverso extends JFrame {
	TreeMap<String, Integer> mapaPalabras;
	private final static int ANCHO = 200;
	private final static int ALTO = 200;
	
	public AnalizadorTextoInverso(String nombrefichero) throws FileNotFoundException {
		new JFrame("Analizador");
		setSize(ANCHO, ALTO);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelTexto = new JPanel(new FlowLayout());
		JTextField texto = new JTextField("Introduce aquí el texto.");
		panelTexto.add(texto);
		add(panelTexto);
		mapaPalabras = new TreeMap<String, Integer>();
		cargarFichero(nombrefichero);
	}
	private void cargarFichero(String nombrefichero) throws FileNotFoundException {
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
				//System.out.println("analizando ---> " + token);
				if (encontrarOcurrencia(token.toLowerCase())) {
					eliminarPalabra(token.toLowerCase());
				} else {
					mapaPalabras.put(token.toLowerCase(), 1);
				}
			}
		}
	}

	private void eliminarPalabra(String token) {
	    // TODO Auto-generated method stub
		System.out.println("eliminando ---> " + token);
	    mapaPalabras.remove(token);
	  }

	private boolean encontrarOcurrencia(String token) {
		// TODO Auto-generated method stub
		if (mapaPalabras.containsKey(token.toLowerCase())) {
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
		Iterator iteradorMapa = mapaPalabras.keySet().iterator();
		System.out.println("Clave ---> Valor");
		String[] palabras = new String[mapaPalabras.size()];
		int i = 0;
		while(iteradorMapa.hasNext()){
			Object palabra = iteradorMapa.next();
			palabras[i] = (String) palabra;
			i++;
		}
		for (int j = i - 1; j >= 0; j--) {
			System.out.println(palabras[j]);
		}
	}
}
