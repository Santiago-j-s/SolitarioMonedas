package juego;

import java.util.List;

public class Juego {
  private Tablero tablero;
  private EstadoJuego estado = new EstadoJuego();
  
  private static final int SALTOS_PARA_PREGUNTA = 2;

  /**
   * Constructor defecto. 5 filas, 5 columnas, 9 casillas nulas, 2 casillas
   * vacias
   */
  public Juego() {
    this.tablero = new Tablero5x5();
  }

  private Casilla getCasilla(int fila, int columna) {
    return tablero.getCasilla(fila, columna);
  }

  public Tablero getTablero() {
    return tablero;
  }
  
  public boolean puedeSaltar(int fila, int columna) {
    return getCasilla(fila, columna).puedeSaltar();
  }
  
  /**
   * Determina si es tiempo de hacer una pregunta
   */
  public boolean tiempoPregunta() {
    return (estado.getCantSaltos() % SALTOS_PARA_PREGUNTA == 0);
  }
  
  public void saltar(Casilla casilla, Direccion direccion) {
    casilla.saltar(direccion);
    tablero.quitarMoneda();
    estado.add1Salto();
  }

  public boolean victoria() {
    return tablero.getCantMonedas() == 1;
  }

  public boolean derrota() {
    return tablero.hayCasillasConSaltos();
  }
  
  public boolean fin() {
    return victoria() || derrota();
  }

  public List<Direccion> direccionesSalto(Casilla casilla) {
    return casilla.direccionesSalto();
  }
}
