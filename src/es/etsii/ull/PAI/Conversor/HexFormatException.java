/**
 * Programa que dado un número en hexadecimal realiza su conversión y muestra 
 * el número en formato decimal.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.etsii.ull.PAI.Conversor;
public class HexFormatException extends Exception{

  /**
   * Constructor de la Excepción que maneja un fallo de formato de entrada
   * @param mensaje Mensaje de ayuda al usuario.
   */
	public HexFormatException(String mensaje) {
		System.out.println(mensaje);
	}

}
