/**
 * Lanza excepciones que puedan causar la operacion de calcular el logaritmo de un numero
 * o errores que puedan producirse al pasarle un parámetro.
 * @author erikbarretodevera
 * @version: 18/02/2016/A
 */
package es.etsii.ull.PAI.Excepciones;

public class Log2 {

  public static void main(String[] args) throws WrongParameterException {
    try {
      if (Double.parseDouble(args[0]) <= 0) {
        throw new WrongParameterException("argumento igual o menos a cero");
      }
      double aDouble = Double.parseDouble(args[0]);
      System.out.println(Math.log(aDouble)); 
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Se lanza una excepcion del tipo: " + e);
    } catch (NumberFormatException e2) {
      //System.out.println("Se lanza una excepcion del tipo: " + e2);
      throw new WrongParameterException(e2);
    } catch (IllegalArgumentException e3) {
      System.out.println("Se lanza una excepcion del tipo: " + e3);
    }
  }

}
