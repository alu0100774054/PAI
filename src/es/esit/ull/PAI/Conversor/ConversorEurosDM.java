/**
 * Programa que dado un valor en euros, muestra su conversión correspondiente en otra moneda.
 * @author: Erik Andreas Barreto de Vera
 * @version: 14/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosDM {
	private Double euros;							// Cantidad en euros ingresada por el usuario.
	private Double dm;								// Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 1.96;	// Factor que relaciona el cambio.
	public ConversorEurosDM(Double euros) {
		this.euros = euros;
		dm = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public Double getDm() {
		return dm;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public void setDm(Double dm) {
		this.dm = dm;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	
}
