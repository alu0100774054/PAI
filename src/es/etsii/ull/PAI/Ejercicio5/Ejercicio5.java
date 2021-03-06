package es.etsii.ull.PAI.Ejercicio5;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Este programa calcula la diferencia en años meses y dias entre 
 * dos fechas pasadas por parámetros.
 * @author: Erik Andreas Barreto de Vera
 * @version: 20/02/2016/A
 */

public class Ejercicio5 {

	private int dia;	// Dia de nacimiento.
	private int mes;	// Mes de nacimiento.
	private int anyo;	// Año de nacimiento.

	/**
	 * Constructor con un parámetro que indica la fecha.
	 * @param fecha cadena con la fecha de nacimiento en formato String.
	 */
	public Ejercicio5(String fecha) {
		obtenerFecha(fecha);
	}

	/**
	 * Método que obtiene la diferencia entre dos fechas.
	 * @param FechaFin Objeto para comparar la fecha.
	 */
	public void obtenerDiferencia(Ejercicio5 FechaFin) {
		// TODO Auto-generated method stub
		int anios = 0;
		int mesesPorAnio = 0;
		int diasPorMes = 0;
		int diasTipoMes = 0;

		if (mes == 2) {
			// Febrero
			if ((FechaFin.anyo % 4 == 0) && ((FechaFin.anyo % 100 != 0) || (FechaFin.anyo % 400 == 0)))
				// Bisiesto
				diasPorMes = 29;
			else 
				diasTipoMes = 28;

		} else if (mes <= 7) {
			// De Enero a Julio los meses pares tienen 30 y los impares 31
			if (mes % 2 == 0) 
				diasTipoMes = 30;
			else
				diasTipoMes = 31;
		} else if (mes > 7) {
			// De Julio a Diciembre los meses pares tienen 31 y los impares 30
			if (mes % 2 == 0) 
				diasTipoMes = 31;
			else
				diasTipoMes = 30;
		}

		if ((anyo > FechaFin.anyo) || (anyo == FechaFin.anyo && mes > FechaFin.mes) 
				|| (anyo == FechaFin.anyo && mes == FechaFin.mes && dia > FechaFin.dia)) {
			System.out.println("La fecha de inicio ha de ser anterior a la fecha fin");
		} else {
			if (mes <= FechaFin.mes) {
				anios = FechaFin.anyo - anyo;
				if (dia <= FechaFin.dia) {
					mesesPorAnio = FechaFin.mes - mes; 
					diasPorMes = FechaFin.dia - dia;
				} else {
					if (FechaFin.mes == mes)
						anios = anios--;
					mesesPorAnio = (FechaFin.mes - mes - 1 + 12) % 12;
					diasPorMes = diasTipoMes - (dia - FechaFin.dia);
				}
			} else {
				anios = FechaFin.anyo - anyo - 1;
				if (dia > FechaFin.dia) {
					mesesPorAnio = FechaFin.mes - mes - 1 + 12;
					diasPorMes = diasTipoMes - (dia - FechaFin.dia);	
				} else {
					mesesPorAnio = FechaFin.mes - mes + 12;
					diasPorMes = FechaFin.dia - dia;
				}
			}	
		}
		System.out.println("Han transcurrido " + anios + " Años, " + mesesPorAnio + " Meses y " + diasPorMes + " Días.");
	}

	/**
	 * Método que obtiene la fecha a partir de un string y almacena los valores 
	 * en los atributos de la clase.
	 * @param fecha fecha que queremos guardar.
	 */
	private void obtenerFecha(String fecha) {
		// TODO Auto-generated method stub
		String[] fechaInicioDescompuesta = fecha.split("/");
		if (Integer.parseInt(fechaInicioDescompuesta[0]) > 0 && Integer.parseInt(fechaInicioDescompuesta[0]) <= 31) {
			dia = Integer.parseInt(fechaInicioDescompuesta[0]);
		} else {
			System.out.println("Compruebe que los dias están comprendidos en el rango: [1-31]");
			System.exit(0);
		}
		if (Integer.parseInt(fechaInicioDescompuesta[1]) > 0 && Integer.parseInt(fechaInicioDescompuesta[1]) <= 12) {
			if	(esBisiesto(Integer.parseInt(fechaInicioDescompuesta[1]), Integer.parseInt(fechaInicioDescompuesta[2])) && Integer.parseInt(fechaInicioDescompuesta[0]) <= 29) {
				System.out.println(fecha + "Es bisiesto");
				mes = Integer.parseInt(fechaInicioDescompuesta[1]);
			} else if (esBisiesto(Integer.parseInt(fechaInicioDescompuesta[1]), Integer.parseInt(fechaInicioDescompuesta[2])) == false && Integer.parseInt(fechaInicioDescompuesta[0]) <= 28) {
				System.out.println(fecha + "No es bisiesto");
				mes = Integer.parseInt(fechaInicioDescompuesta[1]);
			} else {
				System.out.println("Compruebe que el mes de febrero, puede que sea bisiesto.");
				System.exit(0);
			}
		} else {
			System.out.println("Compruebe que los meses están comprendidos en el rango: [1-12]");
			System.exit(0);
		}
		if (Integer.parseInt(fechaInicioDescompuesta[2]) > 0) {
			anyo = Integer.parseInt(fechaInicioDescompuesta[2]);
		} else {
			System.out.println("Compruebe que el año no sea negativo.");
			System.exit(0);
		}
		System.out.println(dia + "/" + mes + "/" + anyo);
	}
	/**
	 * Método que calcula si un año es bisiesto o no.
	 * @param mes mes de la fecha
	 * @param anio año de la fecha
	 * @return devuelve si el año es bisiesto o no.
	 */
	private boolean esBisiesto(int mes, int anio) {
		if (mes == 2 && (anio % 4 == 0))	// es bisiesto
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fechaInicio = args[0];
		String fechaFinal = args[1];
		Ejercicio5 Fecha1 = new Ejercicio5(fechaInicio);
		Ejercicio5 Fecha2 = new Ejercicio5(fechaFinal);
		Fecha1.obtenerDiferencia(Fecha2);
	}
}
