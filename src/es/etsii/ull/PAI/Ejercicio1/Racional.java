package es.etsii.ull.PAI.Ejercicio1;
import java.util.Scanner;

/**
* Este programa es capaz de ejecutar las operaciones básicas siguientes sobre numeros racionales:
* Suma
* Resta
* Multiplicación 
* División
* @author: Erik Andreas Barreto de Vera
* @version: 20/02/2016/A
*/

public class Racional {
	
	private int num;				// Numerador
	private int den;				// Denominador
	Racional simplificado;			// Fracción simplificada
	private Scanner sc;				// Scanner para leer valor desde teclado
	
	/**
     * Constructor para un número Racional
     */
	public Racional() {
		num = 1;
		den = 1;
	}
	
	/**
     * Constructor para un número Racional con parámetros
     * @param numIn numerador
     * @param denIn denominador
     */
	public Racional(int numIn, int denIn) {
		if (denIn == 0){
			comprobarDenominador(denIn);
			num = numIn;
	    } else {
	    	num = numIn;
			den = denIn;
		}	
	}
	
	/**
     * Método que comprueba que el denominador no tenga valor cero
     * @param denIn denominador
     */
	private void comprobarDenominador(int denIn) {
		sc = new Scanner(System.in);
		while (denIn == 0) {
			System.out.println("El denominador no puede ser cero, prueba otro");
			denIn = sc.nextInt();
		}
		den = denIn;
	}
	
	/**
     * Método que imprime el número Racional
     */
	public String toString() {
		return String.valueOf(num) + "/" + String.valueOf(den);
	}
	
	/**
     * Método que calcula el mínimo común multiplo de dos números
     * @param a primer número
     * @param b segundo número
     */
	private int minimoComun(int a, int b) {
		return (a/maximoComun(a, b) * b);
	}
	
	/**
     * Método que calcula el máximo común multiplo de dos números
     * @param a primer número
     * @param b segundo número
     */
	private int maximoComun(int a, int b) {
		if (b == 0)
			return a;
		else return maximoComun(b, a%b);
	}
	
	/**
     * Método que simplifica un número racional
     */
	private Racional simplificar() {
		Racional resultado = null;
		int mcd = maximoComun(num, den);
		int nuevoNumerador = num / mcd;
		int nuevoDenominador = den /mcd;
		resultado = new Racional(nuevoNumerador, nuevoDenominador);
		return resultado;
	}
	
	/**
     * Método que suma dos números racionales
     * @param other otro número Racional
     * @return Racional un objeto tipo Racional con el resultado
     */
	public Racional suma(Racional other) {
		Racional resultado = null;
		if (den == other.den) 
			resultado = new Racional(num + other.num, den);
		else {
			resultado = new Racional(num * other.den, den * other.num);
			simplificado = resultado.simplificar();
		}
		return simplificado;
	}
	
	/**
     * Método que multiplica dos números racionales
     * @param other otro número Racional
     * @return Racional un objeto tipo Racional con el resultado
     */
	public Racional multiplicar(Racional other) {
		Racional resultado = new Racional(num * other.num, den * other.den);
		return simplificado = resultado.simplificar();
	}
	
	/**
     * Método que divide dos números racionales
     * @param other otro número Racional
     * @return Racional un objeto tipo Racional con el resultado
     */
	public Racional dividir(Racional other) {
		Racional resultado = new Racional(num * other.den, den * other.num);
		return simplificado = resultado.simplificar();
	}
	
}
