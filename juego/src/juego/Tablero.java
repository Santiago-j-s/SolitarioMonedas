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
	public void quitarMoneda();
	public int getCantMonedas();
  public boolean esMoneda(int fila, int columna);
  public boolean esVacia(int fila, int columna);
  public boolean estaEnTablero(int fila, int columna);
  public boolean hayCasillasConSaltos();
  public Iterable<Casilla> getCasillas();
}
