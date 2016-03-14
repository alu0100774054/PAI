package es.etsii.ull.PAI.Pruebas;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Movil extends JFrame {
  private JPanel teclado;
  private JPanel pantalla;
  private JButton boton;
  public Movil() {
    // TODO Auto-generated constructor stub
    setLayout(new GridLayout(2, 1));
    setTitle("Super Movil");
    setVisible(true);
    pack();
    teclado = new JPanel();
    pantalla = new JPanel();
    boton = new JButton("1");
    teclado.add(boton);
    boton = new JButton("2");
    teclado.add(boton);
    boton = new JButton("3");
    teclado.add(boton);
    boton = new JButton("4");
    teclado.add(boton);
    boton = new JButton("5");
    teclado.add(boton);
    boton = new JButton("6");
    teclado.add(boton);
    boton = new JButton("7");
    teclado.add(boton);
    boton = new JButton("8");
    teclado.add(boton);
    boton = new JButton("9");
    teclado.add(boton);
    boton = new JButton("*");
    teclado.add(boton);
    boton = new JButton("0");
    teclado.add(boton);
    boton = new JButton("9");
    teclado.add(boton);
    pantalla.add(new JTextField("Llamando..."));
    add(pantalla);
    add(teclado);
  }
  public static void main(String[] args) {
    Movil m = new Movil();
  }
}
