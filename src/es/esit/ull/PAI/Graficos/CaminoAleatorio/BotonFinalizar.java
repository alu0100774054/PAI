package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonFinalizar extends JButton implements ActionListener {
  private final String MENSAJE = "Finalizar";
  private Mapa mapa;
  
  public BotonFinalizar(Mapa mapa) {
    this.mapa = mapa;
    setText(getMENSAJE());
    addActionListener(this);
    setFocusable(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //mapa.parar();
  }

  private String getMENSAJE() {
    return MENSAJE;
  }
}
