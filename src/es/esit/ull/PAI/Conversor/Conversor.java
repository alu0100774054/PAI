package es.esit.ull.PAI.Conversor;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Conversor extends JFrame {
  private ConversorGUI panel;		// Panel con la conversión de cada moneda
  private ConversorEurosDM dm;
  private ConversorEurosBEF bef;
  private ConversorEurosFranzFranco fFranc;
  private ConversorEurosIR ir;
  private ConversorEurosLiraIT liraIT;
  private ConversorEurosUSDollar usDollar;

  public Conversor(Double cantidad) {
    iniciarInterfaz(cantidad);
  }
  private void iniciarInterfaz(Double cantidad) {

    setTitle("Conversor de euros");
    setSize(300, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(6, 1));
    iniciarComponentes(cantidad);
  }
  private void iniciarComponentes(Double cantidad) {
    dm = new ConversorEurosDM(cantidad);
    bef = new ConversorEurosBEF(cantidad);
    fFranc = new ConversorEurosFranzFranco(cantidad);
    ir = new ConversorEurosIR(cantidad);
    liraIT = new ConversorEurosLiraIT(cantidad);
    usDollar = new ConversorEurosUSDollar(cantidad);

    panel = new ConversorGUI(dm);
    add(panel);
    panel = new ConversorGUI(bef);
    add(panel);
    panel = new ConversorGUI(fFranc);
    add(panel);
    panel = new ConversorGUI(ir);
    add(panel);
    panel = new ConversorGUI(liraIT);
    add(panel);
    panel = new ConversorGUI(usDollar);
    add(panel);
  }
}
