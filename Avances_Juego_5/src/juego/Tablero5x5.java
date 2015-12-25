package juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que crea un tablero de 5 filas por 
 * 5 columnas implementando la interfaz tablero
 * y define a su vez la distribucion de sus
 * casillas
 * 
 * @author Dibez, Santana
 *
 */
public class Tablero5x5 implements Tablero {
	
	Casilla[][] tablero;
	
	private int cantFilas;
	private int cantColumnas;
	
	private int cantMonedas;
	private int cantVacias;
	
	/**
	 * Da los valores iniciales correspondientes 
	 * 	a todas las casillas del Tablero.
	 */
	public Tablero5x5() {

		int filas = 5;
		int columnas = 5;
		int vacias = 2;
		int nulas = 9;
		
		this.setCantFilas(filas);
		this.setCantColumnas(columnas);
		
		this.setCantVacias(vacias);
		this.setCantMonedas((filas * columnas) - (vacias + nulas));
		
		this.setTablero(new Casilla[filas][columnas]);
		
		rellenarConMonedas();
		
		completaTableroDesdeArchivo();
		
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
	 * Define a que casillas les corresponden monedas
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
	 * Elige de forma aleatoria un tablero 
	 * a partir de los datos del archivo Tableros.txt
	 */
	private void completaTableroDesdeArchivo() {
		String nombreArchivo = "/Tableros.txt";
		
		try {

			BufferedReader readerTableros = new BufferedReader
			(
				new InputStreamReader
				(
					getClass().getResourceAsStream(nombreArchivo)
				)
			);
			
			ArrayList<String> stringTableros = new ArrayList<String>();
			
			String line;
			
			while ((line = readerTableros.readLine()) != null) {
				stringTableros.add(line);
			}
			
			readerTableros.close();
			
			Random g = new Random();
			
			int numAlAzar = g.nextInt(stringTableros.size() / 2) * 2;
			
			String[] nulas = stringTableros.get(numAlAzar).split(";");
			String[] vacias = stringTableros.get(numAlAzar + 1).split(";");
			
			for (String nula: nulas) {
				int filaNula = Character.getNumericValue(nula.charAt(0));
				int colNula = Character.getNumericValue(nula.charAt(1));
				this.setCasilla(filaNula, colNula, Casilla.Nula);
			}
			
			for(String vacia: vacias) {
				int filaVacia = Character.getNumericValue(vacia.charAt(0));
				int colVacia = Character.getNumericValue(vacia.charAt(1));
				this.setCasilla(filaVacia, colVacia, Casilla.Vacia);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
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
