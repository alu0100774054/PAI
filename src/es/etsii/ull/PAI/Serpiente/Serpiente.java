package es.etsii.ull.PAI.Serpiente;

import java.util.ArrayList;
import java.util.Iterator;

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
		return idSerpiente;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Serpiente> mascotas = new ArrayList<Serpiente>();
		Serpiente serpiente = null;
		
		for (int i = 0; i < 5; i++) {
			serpiente = new Serpiente();
			mascotas.add(serpiente);
		}
		Iterator<Serpiente> iteradorSerpientes = mascotas.iterator();
		while(iteradorSerpientes.hasNext()){
			Serpiente serp = iteradorSerpientes.next();
			System.out.print(serp.getIdSerpiente());
		}
	}

}
