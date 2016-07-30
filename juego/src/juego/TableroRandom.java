package juego;

import java.util.Random;

/**
 * Clase que genera un tablero aleatorio 
 * implementando la interfaz tablero
 * @author Dibez, Santana
 *
 */
public class TableroRandom implements Tablero {
	
	Casilla[][] tablero;
	
	private int cantFilas;
	private int cantColumnas;
	
	private int cantMonedas;
	private int cantVacias;
	
	/**
	 * Da los valores iniciales correspondientes 
	 * 	a todas las casillas del Tablero.
	 */
	public TableroRandom(int filas, int columnas, int vacias, int nulas) {
		
		this.setCantFilas(filas);
		this.setCantColumnas(columnas);
		
		this.setCantVacias(vacias);
		this.setCantMonedas((filas * columnas) - (vacias + nulas));
		
		this.setTablero(new Casilla[filas][columnas]);
		
		rellenarConMonedas();
		
		Random random = new Random();
		
		agregarCasillasVacias(random, vacias);
		agregarCasillasNulas(random, nulas);
		
		this.setTablero(tablero);
	}

	/**
	 * @return the cantFilas
	 */
	public int getCantFilas() {
		return cantFilas;
	}

	/**
	 * @param cantFilas the cantFilas to set
	 */
	private void setCantFilas(int cantFilas) {
		this.cantFilas = cantFilas;
	}

	/**
	 * @return the cantColumnas
	 */
	public int getCantColumnas() {
		return cantColumnas;
	}

	/**
	 * @param cantColumnas the cantColumnas to set
	 */
	private void setCantColumnas(int cantColumnas) {
		this.cantColumnas = cantColumnas;
	}

	/**
	 * @return the cantMonedas
	 */
	public int getCantMonedas() {
		return cantMonedas;
	}

	/**
	 * @param cantMonedas the cantMonedas to set
	 */
	public void setCantMonedas(int cantMonedas) {
		this.cantMonedas = cantMonedas;
	}

	/**
	 * @return the cantVacias
	 */
	public int getCantVacias() {
		return cantVacias;
	}

	/**
	 * @param cantVacias the cantVacias to set
	 */
	public void setCantVacias(int cantVacias) {
		this.cantVacias = cantVacias;
	}

	/**
	 * @return the tablero
	 */
	private Casilla[][] getTablero() {
		return tablero;
	}

	/**
	 * @param tablero the tablero to set
	 */
	private void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}
	
	/**
	 * Modifica la casilla señalada por 'fila' y 'columna'
	 *  con el valor de 'casilla'
	 * @param fila
	 * @param columna
	 * @param casilla
	 */
	public void setCasilla(int fila, int columna, Casilla casilla) {
		tablero[fila][columna] = casilla;
	}
	
	/**
	 * 
	 * @param fila
	 * @param columna
	 * @return la casilla del tablero correspondiente 
	 * 	a la fila y a la columna pasadas como parámetros
	 */
	public Casilla getCasilla(int fila, int columna) {
		return getTablero()[fila][columna];
	}

	/**
	 * Metodo privado que ingresa monedas
	 * en las casillas del tablero
	 */
	private void rellenarConMonedas() {
		
		int filas = this.getCantFilas();
		int columnas = this.getCantColumnas();
		
		for (int fila = 0; fila < filas; fila++) {
			for (int columna = 0; columna < columnas; columna++) {
				this.setCasilla(fila, columna, Casilla.Moneda);
			}
		}
	}
	
	/**
	 * Metodo privado que agrega al tablero la cantidad
	 * de casillas vacias indicadas en el parametro vacias
	 * de forma aleatoria
	 * @param random
	 * @param vacias
	 */
	private void agregarCasillasVacias(Random random, int vacias) {
		
		int filas = this.getCantFilas();
		int columnas = this.getCantColumnas();
		
		for (int i = 0; i < vacias; i++) {
			int filaAzar = random.nextInt(filas);
			int colAzar = random.nextInt(columnas);
			
			Casilla casillaAzar = this.getCasilla(filaAzar, colAzar);
			
			if (casillaAzar.equals(Casilla.Moneda)) {
				this.setCasilla(filaAzar, colAzar, Casilla.Vacia);
				vacias += 1;
			}
		}
	}
	
	/**
	 * Metodo privado que agrega al tablero la cantidad
	 * de casillas nulas indicadas en el parametro vacias
	 * de forma aleatoria
	 * @param random
	 * @param vacias
	 */	
	private void agregarCasillasNulas(Random random, int nulas) {
		
		int filas = this.getCantFilas();
		int columnas = this.getCantColumnas();
		
		for (int i = 0; i < nulas; i++) {
			int filaAzar = random.nextInt(filas);
			int colAzar = random.nextInt(columnas);
			
			Casilla casillaAzar = this.getCasilla(filaAzar, colAzar);
						
			if (casillaAzar.equals(Casilla.Moneda)) {
				setCasilla(filaAzar, colAzar, Casilla.Nula);
				nulas += 1;
			}
		}
	}
	
	/**
	 * 
	 * @param fila
	 * @param columna
	 * @return true si la casilla de esa fila y columna contiene una moneda,
	 * 	false en caso contrario.
	 */
	public boolean esMoneda(int fila, int columna) {
		tablero = this.getTablero();
		
		boolean respuesta = false;
		
		if (fila >= 0 && columna >= 0 && fila < this.getCantFilas() 
				&& columna < this.getCantColumnas()) 
		{
			if (getCasilla(fila, columna).equals(Casilla.Moneda))
			{
				respuesta = true;
			}
		}
		
		return respuesta;
	}
	
	/**
	 * 
	 * @param fila
	 * @param columna
	 * @return true si la casilla de esa fila y columna contiene esta vacía,
	 * 	false en caso contrario.
	 */
	public boolean esVacia(int fila, int columna) {
		tablero = this.getTablero();
		boolean respuesta = false;
		
		if (fila >= 0 && columna >= 0 && fila < this.getCantFilas()
				&& columna < this.getCantColumnas()) 
		{
			if (getCasilla(fila, columna).equals(Casilla.Vacia)) 
			{
				respuesta = true;
			}
		}
		
		return respuesta;
	}
	
	/**
	 * Muestra el tablero en la pantalla.
	 * Solo para própositos de testeo y desarrollo.
	 */
	public void imprimirTablero() {
		
		tablero = this.getTablero();
		
		for (int fila = 0; fila < this.getCantFilas(); fila++) {
			for (int columna = 0; columna < this.getCantColumnas(); columna++) {
				System.out.print(getCasilla(fila, columna) + "\t");
			}
			
			System.out.println();
		}
	}
}
