package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonIniciar extends JButton implements ActionListener {
  private final String MENSAJE = "Iniciar";
  private Mapa mapa;
  
  public BotonIniciar(Mapa mapa) {
    this.mapa = mapa;
    addActionListener(this);
    setFocusable(true);
    setText(getMENSAJE());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("pulsado");
    mapa.resolverCamino();
  }

  private String getMENSAJE() {
    return MENSAJE;
  }
  
}
