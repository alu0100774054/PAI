package es.etsii.ull.PAI.Excepciones;

public class Log1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			double aDouble = Double.parseDouble(args[0]); 
			System.out.println(Math.log(aDouble));
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("Se lanza una excepcion del tipo: " + e);
		} catch (NumberFormatException e2) {
			// TODO: handle exception
			System.out.println("Se lanza una excepcion del tipo: " + e2);
		}
	}
}
