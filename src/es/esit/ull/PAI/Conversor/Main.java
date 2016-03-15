package es.esit.ull.PAI.Conversor;

import java.awt.EventQueue;

public class Main {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Conversor conversor = new Conversor();
                conversor.setVisible(true);
            }
        });
  }

}
