package juego;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Clase que crea un tablero de 5 filas por 
 * 5 columnas implementando la interfaz tablero
 * y define a su vez la distribucion de sus
 * casillas
 * 
 * @author Dibez, Santana
 */
public class Tablero5x5 implements Tablero {
	private final Casillas casillas;
  private final int filas = 5;
	private final int columnas = 5;
	private int cantMonedas;
  private final Logger logger = Logger.getLogger(getClass().getName());
	
	public Tablero5x5() {
	  this.casillas = new Casillas(filas, columnas);

	  int vacias = 2;
		int nulas = 9;
		this.cantMonedas = (filas * columnas) - (vacias + nulas);

		completaTableroDesdeArchivo();
	}

	public int getCantFilas() {
		return filas;
	}

	public int getCantColumnas() {
		return columnas;
	}

	public int getCantMonedas() {
		return cantMonedas;
	}

	@Override
	public Casilla getCasilla(int fila, int columna) {
	  if(!estaEnTablero(fila, columna)) {
	    return null;
	  }
		return casillas.getCasilla(fila, columna);
	}

	private BufferedReader abrirArchivo(String nombreArchivo) {
	  return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(nombreArchivo)));
	}
	
	private ArrayList<String> lineasArchivo(String nombreArchivo) {
	  ArrayList<String> lineas = new ArrayList<String>();
	  
	  try {
	    BufferedReader bf = abrirArchivo(nombreArchivo);
	    String linea;
	    
	    while ((linea = bf.readLine()) != null) {
	      lineas.add(linea);
	    }
	    
	    bf.close();
	  } catch (Exception e) {
	    e.printStackTrace();
	    System.exit(1);
	  }
	  
	  return lineas;
	}
	
	private void completaTableroDesdeArchivo() {
		String nombreArchivo = "/Tableros.txt"; // TODO: Recurso
		ArrayList<String> lineas = lineasArchivo(nombreArchivo);
			
		Random g = new Random();
		int lineaAlAzarPar = g.nextInt(lineas.size() / 2) * 2;
		String[] nulas = lineas.get(lineaAlAzarPar).split(";");
		String[] vacias = lineas.get(lineaAlAzarPar + 1).split(";");
		
		for (String nula: nulas) {
			int fila = Character.getNumericValue(nula.charAt(0));
			int columna = Character.getNumericValue(nula.charAt(1));
			casillas.setCasilla(fila, columna, TipoCasilla.Nula);
			logger.info(String.format("Casilla Nula en (%d, %d)", fila, columna));
		}
		
		for(String vacia: vacias) {
			int fila = Character.getNumericValue(vacia.charAt(0));
			int columna = Character.getNumericValue(vacia.charAt(1));
			casillas.setCasilla(fila, columna, TipoCasilla.Vacia);
			logger.info(String.format("Casilla Vacía en (%d, %d)", fila, columna));
		}
	}
	
	private boolean esTipoCasilla(int fila, int columna, TipoCasilla tipoCasilla) {
	  return estaEnTablero(fila, columna) && getCasilla(fila, columna).esTipoCasilla(tipoCasilla);
	}
	
	public boolean esMoneda(int fila, int columna) {
		return esTipoCasilla(fila, columna, TipoCasilla.Moneda);
	}
	
	public boolean esVacia(int fila, int columna) {
	  return esTipoCasilla(fila, columna, TipoCasilla.Vacia);
	}

  private boolean estaEnTablero(int fila, int columna) {
    boolean filaEnTablero = (fila >= 0 && fila < this.filas);
    boolean columnaEnTablero = (columna >= 0 && columna < this.columnas);
    return (filaEnTablero && columnaEnTablero) ? true : false;
  }
  
  @Override
  public void quitarMoneda() {
    this.cantMonedas -= 1;
  }
}
