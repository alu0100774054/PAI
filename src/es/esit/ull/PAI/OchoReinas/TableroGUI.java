package es.esit.ull.PAI.OchoReinas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TableroGUI extends JPanel implements KeyListener, ActionListener {
	private CasillaBlancaGUI casillaTablero;  // Casilla blanca del tablero.
	private CasillaNegraGUI casillaTablero2;  // Casilla negra del tablero.
	private CasillaReinaGUI casillaTablero3;  // Casilla reina del tablero.
	private OchoReinas problema;              // Clase que gestiona el problema.
	private final int REINA = -1;             // Valor que diferencia la reina de las demás.
	private int numeroSolucion = 0;
	private final int TAMANIO;
	private ArrayList soluciones;
	private int[][] tablero = {
			{ 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0 }
	};
	private final int[][] tableroMolde = {
			{ 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0 }
	};

	private Timer timer;
	private final int DELAY = 10;

	public TableroGUI(int tamanio) throws Exception {
		TAMANIO = tamanio;
		new JPanel();
		addKeyListener(this);
		setFocusable(true);
		timer = new Timer(DELAY, this);
		timer.start();
		setLayout(new GridLayout(getTAMANIO(), getTAMANIO()));
		solucionar();
		for (int i = 0; i < getTAMANIO(); i++) {
			for (int j = 0; j < getTAMANIO(); j++) {
				if (getTableroElemento(i, j) == 0) {
					casillaTablero = new CasillaBlancaGUI();
					add(casillaTablero); 
				} else if (getTableroElemento(i, j) == 1) {
					casillaTablero2 = new CasillaNegraGUI(); 
					add(casillaTablero2); 
				} 
				else if (getTableroElemento(i, j) == -1) {
					casillaTablero3 = new CasillaReinaGUI(); 
					add(casillaTablero3);
				}
			} 
		}    
	}
	private void solucionar() throws Exception {
		problema = new OchoReinas(getTAMANIO());
		problema.buscarSoluciones();
		soluciones = problema.getSoluciones();
		int[] aux  = (int[]) soluciones.get(getNumeroSolucion());
		System.out.println("Solucion " + ( getNumeroSolucion() + 1) + " : ");
		for (int j = 0; j < aux.length; j++) {
			setTableroReina(j, aux[j]);
			System.out.print("( " + ( j + 1 ) + ", " + (aux[j] + 1 ) + " ) ");
		}
		System.out.println("");
	}
	private void resetearTablero() {
		tablero.equals(tableroMolde);
	}
	private CasillaReinaGUI getCasillaTablero3() {
		return casillaTablero3;
	}
	private void setCasillaTablero3(CasillaReinaGUI casillaTablero3) {
		this.casillaTablero3 = casillaTablero3;
	}

	private int getTAMANIO() {
		return TAMANIO;
	}
	private int getNumeroSolucion() {
		return numeroSolucion;
	}
	private void setNumeroSolucion(int numeroSolucion) {
		this.numeroSolucion = numeroSolucion;
	}
	private int getTableroElemento(int fila, int columna) {
		return tablero[fila][columna];
	}
	private void setTableroReina(int fila, int columna) {
		tablero[fila][columna] = getREINA();
	}
	private CasillaBlancaGUI getCasillaTablero() {
		return casillaTablero;
	}
	private void setCasillaTablero(CasillaBlancaGUI casillaTablero) {
		this.casillaTablero = casillaTablero;
	}
	private CasillaNegraGUI getCasillaTablero2() {
		return casillaTablero2;
	}
	private void setCasillaTablero2(CasillaNegraGUI casillaTablero2) {
		this.casillaTablero2 = casillaTablero2;
	}
	private OchoReinas getProblema() {
		return problema;
	}
	private void setProblema(OchoReinas problema) {
		this.problema = problema;
	}
	private ArrayList getSoluciones() {
		return soluciones;
	}
	private void setSoluciones(ArrayList soluciones) {
		this.soluciones = soluciones;
	}
	private int[][] getTablero() {
		return tablero;
	}
	private void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}
	private int getREINA() {
		return REINA;
	}


	private void actualizar() throws Exception {
		resetearTablero();
		solucionar();
		removeAll();
		validate();
		System.out.println(getComponentCount());
		new JPanel();
		setLayout(new GridLayout(getTAMANIO(), getTAMANIO()));
		for (int i = 0; i < getTAMANIO(); i++) {
			for (int j = 0; j < getTAMANIO(); j++) {
				if (getTableroElemento(i, j) == 0) {
					//removeAll();
					casillaTablero = new CasillaBlancaGUI();
					add(casillaTablero); 
					
				} else if (getTableroElemento(i, j) == 1) {
					//removeAll();
					casillaTablero2 = new CasillaNegraGUI(); 
					add(casillaTablero2);
				} 
				else if (getTableroElemento(i, j) == -1) {
					//removeAll();
					casillaTablero3 = new CasillaReinaGUI(); 
					add(casillaTablero3);
				}
				validate();
			} 
		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("derecha");
			setNumeroSolucion(getNumeroSolucion() + 1);
			try {
				actualizar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (key == KeyEvent.VK_LEFT) {
			System.out.println("izquierda");
			setNumeroSolucion(getNumeroSolucion() - 1);
			try {
				actualizar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("derecha");
			setNumeroSolucion(getNumeroSolucion() + 1);
			try {
				actualizar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (key == KeyEvent.VK_LEFT) {
			System.out.println("izquierda");
			setNumeroSolucion(getNumeroSolucion() - 1);
			try {
				actualizar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint(); 
	}
}
