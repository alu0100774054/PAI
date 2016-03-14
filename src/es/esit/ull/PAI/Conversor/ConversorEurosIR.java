/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosIR {
	private Double euros;								// Cantidad en euros ingresada por el usuario.
	private Double ir;									// Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 0.79;		// Factor que relaciona el cambio.
	public ConversorEurosIR(Double euros) {
		this.euros = euros;
		ir = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public Double getIr() {
		return ir;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public void setIr(Double ir) {
		this.ir = ir;
	}
	
}
