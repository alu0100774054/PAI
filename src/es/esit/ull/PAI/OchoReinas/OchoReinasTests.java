/**
 * Conjunto de tests para la Clase OchoReinas.java
 * @author: Erik Andreas Barreto de Vera
 * @version: 22/03/2016/A
 */
package es.esit.ull.PAI.OchoReinas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OchoReinasTests {
  private OchoReinas problema;
  private final int tamanio = 8; 
  
  @Before
  public void setUp() throws Exception {
    problema = new OchoReinas(tamanio);
  }

  @Test
  public void testCrearObjeto() {
    assertNotNull(problema);
  }
  
  @Test
  public void testComprobarSoluciones() {
    problema.buscarSoluciones();
    assertTrue(problema.getSoluciones().size() == 92);
  }

}
