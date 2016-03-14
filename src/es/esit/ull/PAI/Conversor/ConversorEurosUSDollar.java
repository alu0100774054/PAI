/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosUSDollar {
	private Double euros;								// Cantidad en euros ingresada por el usuario.
	private Double us_dollar;							// Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 1.06;		// Factor que relaciona el cambio.
	public ConversorEurosUSDollar(Double euros) {
		this.euros = euros;
		us_dollar = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public Double getUs_dollar() {
		return us_dollar;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public void setUs_dollar(Double us_dollar) {
		this.us_dollar = us_dollar;
	}
	
}
