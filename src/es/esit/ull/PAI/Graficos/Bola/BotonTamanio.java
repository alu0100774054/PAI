package es.esit.ull.PAI.Graficos.Bola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import es.esit.ull.PAI.Graficos.CaminoAleatorio.Mapa;

public class BotonTamanio extends JButton implements ActionListener {
  private final String MENSAJE = "Cambiar tamaño";
  private Mapa mapa;
  
  public BotonTamanio(Mapa mapa) {
    this.mapa = mapa;
    setText(getMENSAJE());
    addActionListener(this);
    setFocusable(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String entrada = JOptionPane.showInputDialog(this, "Introducir densidad:");
    int densidad = Integer.parseInt(entrada);
    mapa.actualizar(densidad);
  }

  private String getMENSAJE() {
    return MENSAJE;
  }
}
