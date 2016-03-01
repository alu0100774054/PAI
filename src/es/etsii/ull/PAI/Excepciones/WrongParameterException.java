package es.etsii.ull.PAI.Excepciones;
import java.lang.Exception;
import java.lang.Throwable;

public class WrongParameterException extends Exception {
  private static final long serialVersionUID = 1L;

  public WrongParameterException(String message, Throwable cause) {
    super(message, cause);
    // TODO Auto-generated constructor stub
  }

  public WrongParameterException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  public WrongParameterException(Throwable cause) {
    super(cause);
    // TODO Auto-generated constructor stub
  }
  

}
