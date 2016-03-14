package es.esit.ull.PAI.Conversor;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Conversor extends JFrame {
	private ConversorGUI panel;		// Panel con la conversión de cada moneda
	
	public Conversor() {
		iniciarInterfaz();
	}
	private void iniciarInterfaz() {

		setTitle("Conversor de euros");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 1));
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		panel = new ConversorGUI("DM");
		add(panel);
		panel = new ConversorGUI("Belg.Franc");
		add(panel);
		panel = new ConversorGUI("Franz.Franc");
		add(panel);
		panel = new ConversorGUI("Ir.Pfund");
		add(panel);
		panel = new ConversorGUI("Ital.Lira");
		add(panel);
		panel = new ConversorGUI("US$");
		add(panel);
	}
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
