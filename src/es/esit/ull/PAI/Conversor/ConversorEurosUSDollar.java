/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosUSDollar extends Moneda {
  private final String nombreMoneda = "US$";      // Nombre de la moneda.
	private Double euros;								            // Cantidad en euros ingresada por el usuario.
	private Double conversion;					            // Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 1.06;		// Factor que relaciona el cambio.
	
	/**
   * Constructor del conversor de dos monedas.
   * @param euros Cantidad de euros que queremos convertir.
   */
	public ConversorEurosUSDollar(Double euros) {
		this.euros = euros;
		conversion = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public Double getUs_dollar() {
		return conversion;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public void setUs_dollar(Double us_dollar) {
		this.conversion = us_dollar;
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
