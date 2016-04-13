/**
 * PRÁCTICA 8: MOVIMIENTO Y CONTROL DE UN OBJETO GRÁFICO
 * Programa que muestre en pantalla una ventana 
 * rectangular con fondo de color azul sobre la que se vera un círculo 
 * centrado en la ventana y un panel con cuatro botones que permiten 
 * mover el círculo hacia arriba, abajo, izquierda y derecha.
 * @author: Erik Andreas Barreto de Vera
 * @email: alu0100774054@ull.edu.es
 * @version: 07/04/2016
 */
package es.esit.ull.PAI.Graficos.Bola;

public class Main {

  public static void main(String[] args) {
    if (args.length != 1) {
      instrucciones();
      System.exit(0);
    }
    Programa programa = new Programa(Integer.parseInt(args[0]));
    programa.setVisible(true);
  }
  
  /**
   * Método que muestra el mensaje de error cuando no se introducen 
   * bien los parámetros de entrada.
   */
  private static void instrucciones() {
    System.out.println("Debe introducir correctamente el parámetro.");
    System.out.println("Debe introducir por parámetro el número de pixeles que se va a desplazar "
        + "en cada movimiento."
        + "\nPara ello ejecute java <ejecutable> <parámetro>");
  }

}
