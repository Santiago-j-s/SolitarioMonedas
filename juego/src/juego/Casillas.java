package juego;

import java.util.Arrays;

public class Casillas {
  public final Casilla[] tablero;
  private final int filas;
  private final int columnas;
  private final int cantCasillas;
  private final Iterable<Casilla> iterator;

  public Casillas(int filas, int columnas) {
    this.filas = filas;
    this.columnas = columnas;
    this.cantCasillas = filas * columnas;
    
    tablero = new Casilla[cantCasillas];
    this.rellenarConMonedas();
    this.iterator = Arrays.asList(tablero);
  }
  
  int getIndex(int fila, int columna) {
    if(fila >= filas || columna >= columnas) {
      throw new IndexOutOfBoundsException();
    }
    return fila * columnas + columna;
  }
  
  private void rellenarConMonedas() {
    for (int fila = 0; fila < filas; fila++) {
      for(int columna = 0; columna < columnas; columna++) {
        tablero[getIndex(fila, columna)] = new Casilla(this, TipoCasilla.Moneda, fila, columna);
      }
    }
  }
  
  public Casilla getCasilla(int fila, int columna) {
    int index = getIndex(fila, columna);
    return this.tablero[index];
  }
  
  public void setCasilla(int fila, int columna, TipoCasilla tipoCasilla) {
    Casilla casilla = this.getCasilla(fila, columna);
    casilla.setTipoCasilla(tipoCasilla);
  }

  public boolean estaEnTablero(int fila, int columna) {
    boolean filaEnTablero = (fila >= 0 && fila < this.filas);
    boolean columnaEnTablero = (columna >= 0 && columna < this.columnas);
    return (filaEnTablero && columnaEnTablero) ? true : false;
  }
  
  public Iterable<Casilla> getIterable() {
    return iterator;
  }
}