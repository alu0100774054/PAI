package es.esit.ull.PAI.Graficos.Bola;

import static org.junit.Assert.fail;

import javax.swing.JFrame;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.Test;

public class Tests {
  private FrameFixture ventana;
  private Programa programa;
  
  @Before
  public void initialize() throws Exception {
    programa = new Programa(30);
    ventana = new FrameFixture(programa);
  }

  @Test
  public void test() {
    //ventana.show();
    ventana.button("Arriba").click();
    ventana.button("Abajo").click();
    ventana.button("Izquierda").click();
    for (int i = 0; i < 10; i++) {
      ventana.button("Derecha").click();
    }
    
  }

}
