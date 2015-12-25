package juego;

/**
 * Un objeto Tablero puede visualizarse como un conjunto de casillas 
 * dispuestas en filas y columnas.
 * 
 * Las casillas pueden contener una moneda, estar vacias, o ser nulas (inutilizables).
 * 
 * @author Dibez, Santana
 *
 */
public interface Tablero {

	public int getCantFilas();
	
	public int getCantColumnas();
	
	public Casilla getCasilla(int fila, int columna);

	public void setCasilla(int fila, int columna, Casilla vacia);
	
	public void setCantMonedas(int monedas);
	
	public void setCantVacias(int vacias);

	public int getCantMonedas();

	public int getCantVacias();
	
	public boolean esMoneda(int fila, int columna);
	
	public boolean esVacia(int fila, int columna);
}
