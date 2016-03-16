/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

public class ConversorTest {
  private Conversor conversor;
  @Before
  public void setUp() throws Exception {
    conversor = new Conversor(1.0);
  }

  @Test
  public void test() {
    Double resultadoDM = new Double(1.96);
    assertEquals(resultadoDM, conversor.getDm().getConversion(), conversor.getDm().getConversion());
  }
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("ConversorTest");
  }
}
