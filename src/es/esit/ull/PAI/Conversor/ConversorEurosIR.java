/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosIR extends Moneda {
  private final String nombreMoneda = "franz.franco";     // Nombre de la moneda. 
	private Double euros;						                     		// Cantidad en euros ingresada por el usuario.
	private Double conversion;									            // Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 0.79;	         	// Factor que relaciona el cambio.
	
	/**
   * Constructor del conversor de dos monedas.
   * @param euros Cantidad de euros que queremos convertir.
   */
	public ConversorEurosIR(Double euros) {
		this.euros = euros;
		conversion = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public Double getIr() {
		return conversion;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public void setIr(Double ir) {
		this.conversion = ir;
	}
  public String getNombreMoneda() {
    return nombreMoneda;
  }
  public Double getConversion() {
    return conversion;
  }
  public void setConversion(Double conversion) {
    this.conversion = conversion;
  }
	
}
