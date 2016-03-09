/**
 * Programa que dado un número en hexadecimal realiza su conversión y muestra 
 * el número en formato decimal.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.etsii.ull.PAI.Conversor;

public class Main {
	public static void main(String[] args) throws HexFormatException {
		Conversor conversor = new Conversor(args[0]);
	}

}
