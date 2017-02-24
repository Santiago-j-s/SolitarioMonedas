package juego;

import java.util.ArrayList;

/**
 * La clase Tablero permite instanciar un objeto tablero Un objeto tablero puede
 * visualizarse como un conjunto de casillas dispuestas en filas y columnas.
 * 
 * Las casillas pueden contener una moneda, estar vacias, o ser nulas
 * (inutilizables).
 * 
 * @author Dibez, Santana
 *
 */
public class ControladorTablero {
  private Tablero tablero;
  private int cantSaltos = 1;
  
  private static final int SALTOS_PARA_PREGUNTA = 2;

  /**
   * Constructor defecto. 5 filas, 5 columnas, 9 casillas nulas, 2 casillas
   * vacias
   */
  public ControladorTablero() {
    this.tablero = new Tablero5x5();
  }

  public Tablero getTablero() {
    return tablero;
  }
  
  public boolean puedeSaltar(int fila, int columna) {
    return tablero.getCasilla(fila, columna).puedeSaltar();
  }
  
  /**
   * Determina si es tiempo de hacer una pregunta
   */
  public boolean tiempoPregunta() {
    return (cantSaltos % SALTOS_PARA_PREGUNTA == 0);
  }

  public void saltar(int fila, int columna, Direccion direccion) {
    if (tablero.getCasilla(fila, columna).puedeSaltar(direccion)) {
      tablero.getCasilla(fila, columna).saltar(direccion);
    }
    tablero.quitarMoneda();
    this.cantSaltos += 1;
  }

  public boolean victoria() {
    return tablero.getCantMonedas() == 1;
  }

  /**
   * @return true si ninguna moneda puede saltar en ninguna dirección. false si
   *         al menos una moneda puede saltar en alguna dirección.
   */
  public boolean derrota() {
    for (int fila = 0; fila < tablero.getCantFilas(); fila++) {
      for (int columna = 0; columna < tablero.getCantColumnas(); columna++) {
        if (this.puedeSaltar(fila, columna)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean fin() {
    return victoria() || derrota();
  }

  public ArrayList<Direccion> direccionesSalto(int fila, int columna) {
    return tablero.getCasilla(fila, columna).direccionesSalto();
  }
  
  public int cantDireccionesSalto(int fila, int columna) {
    return tablero.getCasilla(fila, columna).cantDireccionesSalto();
  }
}
