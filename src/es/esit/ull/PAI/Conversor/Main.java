/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

import java.awt.EventQueue;

public class Main {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Conversor conversor = new Conversor(Double.parseDouble(args[0]));
                conversor.setVisible(true);
            }
        });
  }

}
