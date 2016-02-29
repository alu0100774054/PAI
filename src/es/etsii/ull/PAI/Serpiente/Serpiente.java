package es.etsii.ull.PAI.Serpiente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class Serpiente {
	private static int numSerpientes;
	private int idSerpiente;
	
	public Serpiente() {
		// TODO Auto-generated constructor stub
		numSerpientes++;
		setIdSerpiente(numSerpientes);
	}
	
	public int getIdSerpiente() {
		return idSerpiente;
	}

	public void setIdSerpiente(int idSerpiente) {
		this.idSerpiente = idSerpiente;
	}

	public int reptar() {
		return getIdSerpiente();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Serpiente> mascotas = new ArrayList<Serpiente>();
		Serpiente serpiente = null;
		// Ejercicio 2
		for (int i = 0; i < 5; i++) {
			serpiente = new Serpiente();
			mascotas.add(serpiente);
		}
		Iterator<Serpiente> iteradorSerpientes = mascotas.iterator();
		while(iteradorSerpientes.hasNext()){
			Serpiente serp = iteradorSerpientes.next();
			System.out.println("Nº de serpiente = " + serp.reptar());
		}
		// Ejercicio 3
		Serpiente serpiente2 = new Serpiente();
		Serpiente serpiente3 = new Serpiente();
		Serpiente serpiente4 = new Serpiente();
		Map<String, Serpiente> mapaSerpientes = new TreeMap<String, Serpiente>();
		mapaSerpientes.put("arturo", serpiente2);
		mapaSerpientes.put("eugenia", serpiente3);
		mapaSerpientes.put("pedro", serpiente4);
		System.out.println("\n tamaño del mapa: " + mapaSerpientes.size());
		// Recorrer mapa con iterador
		Iterator iteradorMap = mapaSerpientes.keySet().iterator();
		System.out.println("Clave ---> Valor");
		while(iteradorMap.hasNext()){
		  Object nombreSerpiente = iteradorMap.next();
		  System.out.println(nombreSerpiente + " ---> " + mapaSerpientes.get(nombreSerpiente).reptar());
		}
		// Recorrer mapa con foreach
		System.out.println("\nClave ---> Valor");
		for (Map.Entry<String, Serpiente> ser : mapaSerpientes.entrySet()) {		
			String nombre = ser.getKey();
			Serpiente serpi = ser.getValue();
			System.out.println(nombre + " ---> " + serpi.getIdSerpiente());
		}
	}
}
