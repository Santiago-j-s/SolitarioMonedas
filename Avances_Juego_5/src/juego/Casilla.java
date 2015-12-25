package juego;

/**
 * Los valores posibles de una casilla son 'Moneda', 'Vacia' y 'Nula'
 * @author Dibez, Santana
 *
 */
public enum Casilla {
	Vacia, Moneda, Nula;
	
	/**
	 * @return una cadena. Los valores posibles son 3:
	 * 		- "V" si la casilla esta vacía
	 * 
	 * 		- "N" si la casilla es nula
	 * 
	 * 		- "M" si la casilla contiene una moneda
	 */
	@Override
	public String toString() {
		if (this.equals(Vacia)) return "V";
		else if (this.equals(Nula)) return "N";
		else return "M";
	}
}