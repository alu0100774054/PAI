/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosBEF {
	private Double euros;								// Cantidad en euros ingresada por el usuario.
	private Double bef;									// Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 40.3399;	// Factor que relaciona el cambio.
	public ConversorEurosBEF(Double euros) {
		this.euros =  euros;
		bef = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public Double getDm() {
		return bef;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public void setDm(Double dm) {
		this.bef = dm;
	}
	
}
