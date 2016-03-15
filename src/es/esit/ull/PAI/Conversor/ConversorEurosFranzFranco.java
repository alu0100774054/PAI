/**
 * Programa que lee un texto y muestra en orden alfabéticamente inverso las palabras que no están duplicadas.
 * @author: Erik Andreas Barreto de Vera
 * @version: 06/03/2016/A
 */
package es.esit.ull.PAI.Conversor;

public class ConversorEurosFranzFranco {
  private final String nombreMoneda = "franz.franco";     // Nombre de la moneda.
	private Double euros;							                     	// Cantidad en euros ingresada por el usuario.
	private Double franz_franco;			                			// Cantidad en marco alemán ingresada por el usuario.
	private final Double factorConversion = 6.56;		        // Factor que relaciona el cambio.
	
	public ConversorEurosFranzFranco(Double euros) {
		this.euros =  euros;
		franz_franco = euros * factorConversion;
	}
	public Double getEuros() {
		return euros;
	}
	public Double getFranz_franco() {
		return franz_franco;
	}
	public Double getFactorConversion() {
		return factorConversion;
	}
	public void setEuros(Double euros) {
		this.euros = euros;
	}
	public void setFranz_franco(Double franz_franco) {
		this.franz_franco = franz_franco;
	}
  public String getNombreMoneda() {
    return nombreMoneda;
  }
	
}
