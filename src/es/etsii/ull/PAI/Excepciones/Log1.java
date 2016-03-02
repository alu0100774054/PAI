/**
 * Lanza excepciones que puedan causar la operacion de calcular el logaritmo de
 * un numero
 * o errores que puedan producirse al pasarle un parámetro.
 * @author erikbarretodevera
 * @version: 18/02/2016/A
 */
package es.etsii.ull.PAI.Excepciones;

public class Log1 {
 
	public static void main(String[] args) {
		try {
			double aDouble = Double.parseDouble(args[0]); 
			System.out.println(Math.log(aDouble));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Se lanza una excepcion del tipo: " + e);
		} catch (NumberFormatException e2) {
			System.out.println("Se lanza una excepcion del tipo: " + e2);
		}
	}
}
