package es.esit.ull.PAI.OchoReinas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OchoReinasTests {
  private OchoReinas problema;
  private OchoReinas problema2;
  
  @Before
  public void setUp() throws Exception {
    problema = new OchoReinas();
  }

  @Test
  public void testCrearObjeto() {
    assertNotNull(problema);
  }

}
