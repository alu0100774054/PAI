package es.etsii.ull.PAI.JuegoPremio;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Main {
	
  public static void main(String[] args) {
    System.out.println("Bienvenido al Juego donde todo el mundo gana");
  
    JuegoPremio juego = new JuegoPremio(args[0], args[1], args[2]);
  }

}
