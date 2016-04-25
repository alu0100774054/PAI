package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.Test;

public class TestCamino {
  private FrameFixture ventana;
  private Interfaz programa;
  private int densidad = 20;

  @Before
  public void initialize() throws Exception {
    programa = new Interfaz(getDensidad());
    ventana = new FrameFixture(programa);
  }

  @Test
  public void test() {
    ventana.button("botonIniciar").click();

  }

  public FrameFixture getVentana() {
    return ventana;
  }

  public void setVentana(FrameFixture ventana) {
    this.ventana = ventana;
  }

  public Interfaz getPrograma() {
    return programa;
  }

  public void setPrograma(Interfaz programa) {
    this.programa = programa;
  }

  public int getDensidad() {
    return densidad;
  }

  public void setDensidad(int densidad) {
    this.densidad = densidad;
  }

}
