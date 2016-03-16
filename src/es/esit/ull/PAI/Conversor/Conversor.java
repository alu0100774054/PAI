/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Conversor extends JFrame {
  private ConversorGUI panel;		               // Panel con la conversión de cada moneda
  private ConversorEurosDM dm;                 // Conversor de euros a dm
  private ConversorEurosBEF bef;               // Conversor de euros a bef
  private ConversorEurosFranzFranco fFranc;    // Conversor de euros a fFranc
  private ConversorEurosIR ir;                 // Conversor de euros a ir
  private ConversorEurosLiraIT liraIT;         // Conversor de euros a libraIT
  private ConversorEurosUSDollar usDollar;     // Conversor de euros a usDollar

  /**
   * Constructor del controlador.
   * @param cantidad Cantidad que se quiere convertir.
   */
  public Conversor(Double cantidad) {
    iniciarInterfaz(cantidad);
  }
  
  /**
   * Inicializa la interfaz.
   * @param cantidad Cantidad que se quiere convertir.
   */
  private void iniciarInterfaz(Double cantidad) {
    setTitle("Conversor de euros");
    setSize(300, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(6, 1));
    iniciarComponentes(cantidad);
  }
  
  /**
   * Inicializa los componentes de la interfaz.
   * @param cantidad Cantidad que se quiere convertir.
   */
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
  
  public ConversorGUI getPanel() {
    return panel;
  }
  
  public void setPanel(ConversorGUI panel) {
    this.panel = panel;
  }
  
  public ConversorEurosDM getDm() {
    return dm;
  }
  
  public void setDm(ConversorEurosDM dm) {
    this.dm = dm;
  }
  
  public ConversorEurosBEF getBef() {
    return bef;
  }
  
  public void setBef(ConversorEurosBEF bef) {
    this.bef = bef;
  }
  
  public ConversorEurosFranzFranco getfFranc() {
    return fFranc;
  }
  
  public void setfFranc(ConversorEurosFranzFranco fFranc) {
    this.fFranc = fFranc;
  }
  
  public ConversorEurosIR getIr() {
    return ir;
  }
  
  public void setIr(ConversorEurosIR ir) {
    this.ir = ir;
  }
  
  public ConversorEurosLiraIT getLiraIT() {
    return liraIT;
  }
  
  public void setLiraIT(ConversorEurosLiraIT liraIT) {
    this.liraIT = liraIT;
  }
  
  public ConversorEurosUSDollar getUsDollar() {
    return usDollar;
  }
  
  public void setUsDollar(ConversorEurosUSDollar usDollar) {
    this.usDollar = usDollar;
  } 
}
