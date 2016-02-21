package es.etsii.ull.PAI.Ejercicio1;

/**
* Este programa es capaz de ejecutar las operaciones básicas siguientes sobre numeros racionales:
* Suma
* Resta
* Multiplicación 
* División
* @author: Erik Andreas Barreto de Vera
* @version: 20/02/2016/A
*/

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Racional ejemplo1 = new Racional(3, 4);
		Racional ejemplo2 = new Racional(3, 1);
		Racional ejemplo3 = ejemplo1.suma(ejemplo2);
		Racional ejemplo4 = ejemplo1.multiplicar(ejemplo2);
		
		System.out.println(ejemplo1.toString());
		System.out.println(ejemplo2.toString());
		System.out.println(ejemplo3.toString());
		System.out.println(ejemplo4.toString());
	}

}
