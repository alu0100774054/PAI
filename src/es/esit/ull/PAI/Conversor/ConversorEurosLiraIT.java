/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosLiraIT {
	private Double euros;								// Cantidad en euros ingresada por el usuario.
	private Double lira_IT;								// Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 1936.27;	// Factor que relaciona el cambio.
	public ConversorEurosLiraIT(Double euros) {
		this.euros = euros;
		lira_IT = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public Double getLira_IT() {
		return lira_IT;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public void setLira_IT(Double lira_IT) {
		this.lira_IT = lira_IT;
	}
	
}
