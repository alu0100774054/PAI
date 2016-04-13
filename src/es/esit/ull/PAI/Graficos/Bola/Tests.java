package es.esit.ull.PAI.Graficos.Bola;

import static org.junit.Assert.fail;

import javax.swing.JFrame;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.Test;

public class Tests {
  private FrameFixture ventana;
  private Programa programa;
  private final int DESPLAZAMIENTO = 20;
  
  @Before
  public void initialize() throws Exception {
    programa = new Programa(getDESPLAZAMIENTO());
    ventana = new FrameFixture(programa);
  }

  @Test
  public void test() {
    //Comprueba que no sobrepasa los limites
    // Limite por la izquierda.
    for (int i = getPrograma().getInterfaz().getPelota().getPosicionX(); i > 0; i -= getPrograma().getInterfaz().getPelota().getDesplazamiento()) {
      ventana.button("Izquierda").click();
    }
    // Límite por la derecha.
    for (int i = getPrograma().getInterfaz().getPelota().getPosicionX(); i < getPrograma().getInterfaz().getPelota().getWidth(); i += getPrograma().getInterfaz().getPelota().getDesplazamiento()) {
      ventana.button("Derecha").click();
    }
    // Límite por arriba.
    for (int i = getPrograma().getInterfaz().getPelota().getPosicionY(); i > 0; i -= getPrograma().getInterfaz().getPelota().getDesplazamiento()) {
      ventana.button("Arriba").click();
    }
    // Límite por abajo.
    for (int i = getPrograma().getInterfaz().getPelota().getPosicionY(); i < getPrograma().getInterfaz().getPelota().getHeight(); i += getPrograma().getInterfaz().getPelota().getDesplazamiento()) {
      ventana.button("Abajo").click();
    }
  }

  private FrameFixture getVentana() {
    return ventana;
  }

  private void setVentana(FrameFixture ventana) {
    this.ventana = ventana;
  }

  private Programa getPrograma() {
    return programa;
  }

  private void setPrograma(Programa programa) {
    this.programa = programa;
  }

  private int getDESPLAZAMIENTO() {
    return DESPLAZAMIENTO;
  }

}
