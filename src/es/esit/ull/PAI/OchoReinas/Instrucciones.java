package es.esit.ull.PAI.OchoReinas;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Instrucciones extends JPanel {
  private JTextArea instrucciones;
  private final String INSTRUCCIONES = 
      "\n1 ) El programa muestra sólo una solución en cada momento, "
      + "para cambiar de solución siga la siguientes instrucciones."
      + "\n2 ) Pulsar la flecha de dirección del teclado hacia "
      + "la derecha para mostrar la siguiente solución al problema."
      + "\n3 ) Pulsar la flecha de dirección del teclado hacia"
      + "la izquierda para mostrar la solución anterior al problema."
      + "\n\nAutor: Erik Andreas Barreto de Vera."
      + "\nEscuela Superior de Ingeniería Técnica (ESIT)."
      + "\nUniversidad de La Laguna.";
  private final String TITULO = "Instrucciones del programa";
  
  public Instrucciones() {
    iniciarComponentes();
  }

  private void iniciarComponentes() {
    new JPanel();
    setBorder(BorderFactory.createTitledBorder(getTITULO()));
    setBackground(Color.WHITE);
    instrucciones = new JTextArea();
    instrucciones.setRows(6);
    instrucciones.setColumns(50);
    instrucciones.setLineWrap(true);
    instrucciones.setWrapStyleWord(true);
    JScrollPane scroll = new JScrollPane(instrucciones);
    instrucciones.setText(getINSTRUCCIONES());
    add(instrucciones);
  }

  private JTextArea getInstrucciones() {
    return instrucciones;
  }

  private void setInstrucciones(JTextArea instrucciones) {
    this.instrucciones = instrucciones;
  }

  private String getINSTRUCCIONES() {
    return INSTRUCCIONES;
  }

  private String getTITULO() {
    return TITULO;
  }
  
}
