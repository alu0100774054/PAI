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
	}
}
