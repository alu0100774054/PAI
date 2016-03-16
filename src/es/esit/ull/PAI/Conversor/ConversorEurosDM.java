/**
 * Programa que dado un valor en euros, muestra su conversión correspondiente en otra moneda.
 * @author: Erik Andreas Barreto de Vera
 * @version: 14/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosDM extends Moneda {
  private final String nombreMoneda = "DM";     // Nombre de la moneda.
	private Double euros;						            	// Cantidad en euros ingresada por el usuario.
	private Double conversion;						        // Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 1.96;	// Factor que relaciona el cambio.
	
	/**
   * Constructor del conversor de dos monedas.
   * @param euros Cantidad de euros que queremos convertir.
   */
	public ConversorEurosDM(Double euros) {
	  super();
		this.euros = euros;
		conversion = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public Double getFactorConversion() {
		return factorConversion;
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
