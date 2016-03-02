/**
 * Maneja excepciones de cualquier tipo que herede de java.lang.Exception y 
 * pasa la excepción a la clase Exception para que maneje la excepcion generada.
 * @author erikbarretodevera
 * @version: 18/02/2016/A
 */
package es.etsii.ull.PAI.Excepciones;
import java.lang.Exception;
import java.lang.Throwable;

public class WrongParameterException extends Exception {
  private static final long serialVersionUID = 1L;
  /**
   * Llama al constructor de java.lang.Exception.
   * @param message Mensaje que genera la excepción.
   * @param cause Excepción a tratar.
   */
  public WrongParameterException(String message, Throwable cause) {
    super(message, cause);
  }
  /**
   * Llama al constructor de java.lang.Exception.
   * @param message Mensaje que genera la excepción.
   */
  public WrongParameterException(String message) {
    super(message);
  }
  /**
   * Llama al constructor de java.lang.Exception.
   * @param cause Excepción a tratar.
   */
  public WrongParameterException(Throwable cause) {
    super(cause);
  }
  

}
