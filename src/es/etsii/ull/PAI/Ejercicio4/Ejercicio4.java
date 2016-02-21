package es.etsii.ull.PAI.Ejercicio4;
import java.math.*;

/**
 * Este programa debe reconocer si dos números son iguales o no dado
 * un determinado umbral de precisión.
 * @author: Erik Andreas Barreto de Vera
 * @version: 20/02/2016/A
 */

public class Ejercicio4 {

	private Double num1;	// Número a comparar con num2
	private Double num2;	// Número comparado con num1
	private Double eps;		// Umbral de precisión

	/**
	 * Constructor con parámetros.
	 * @param numero1 Número con el que comparar.
	 * @param numero2 Número con el que queremos comparar.
	 * @param epsilon Umbral de precisión.
	 */
	public Ejercicio4(Double numero1, Double numero2, Double epsilon) {
		num1 = numero1;
		num2 = numero2;
		eps = epsilon;
	}
	
	/**
	 * Método que compara comprueba si se cumple que |x − y| ≤ max(x, y) ∗ ε
	 */
	public void calcularPrecision() {
		// TODO Auto-generated method stub
		double abs = calcularValorAbsolutoDiferencia();
		if (Math.abs(abs) <= Math.max(num1, num2) * eps)
			System.out.println(num1 + " y " + num2 + " son iguales: true");
		else
			System.out.println(num1 + " y " + num2 + " son iguales: false");
	}

	/**
	 * Método que calcula el valor absoluto de la diferencia de dos valores.
	 * @return El resultado de |x − y|
	 */
	private double calcularValorAbsolutoDiferencia() {
		// TODO Auto-generated method stub
		return (Math.abs(num1) - Math.abs(num2));
	}

	public static void main(String[] args) {
		String numero1 = args[0];
		String numero2 = args[1];
		String epsilon = args[2];

		Ejercicio4 comparador = new Ejercicio4(Double.parseDouble(numero1), 
											   Double.parseDouble(numero2), 
											   Double.parseDouble(epsilon));
		comparador.calcularPrecision();
	}
}
