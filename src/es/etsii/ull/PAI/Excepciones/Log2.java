package es.etsii.ull.PAI.Excepciones;

public class Log2 {

  public static void main(String[] args) throws WrongParameterException {
    try {
      if (Double.parseDouble(args[0]) <= 0) {
        throw new WrongParameterException("argumento igual o menos a cero");
      }
      double aDouble = Double.parseDouble(args[0]);
      System.out.println(Math.log(aDouble)); 
    } catch (WrongParameterException e4) {
      // TODO: handle exception
      System.out.println("Se lanza una excepcion del tipo: " + e4);
    } catch (ArrayIndexOutOfBoundsException e) {
      // TODO: handle exception
      System.out.println("Se lanza una excepcion del tipo: " + e);
    } catch (NumberFormatException e2) {
      // TODO: handle exception
      //System.out.println("Se lanza una excepcion del tipo: " + e2);
      throw new WrongParameterException(e2);
    } catch (IllegalArgumentException e3) {
      // TODO: handle exception
      System.out.println("Se lanza una excepcion del tipo: " + e3);
    }
  }

}
