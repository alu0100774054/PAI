package es.esit.ull.PAI.Graficos.CaminoAleatorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonCambiarColor extends JButton implements ActionListener {
  private final String MENSAJE = "Cambiar Color";
  private Mapa mapa;
  
  public BotonCambiarColor(Mapa mapa) {
    this.mapa = mapa;
    setText(getMENSAJE());
    addActionListener(this);
    setFocusable(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
  }

  private String getMENSAJE() {
    return MENSAJE;
  }
}
