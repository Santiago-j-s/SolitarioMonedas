package juego;

import java.util.ArrayList;

public class Casilla {
  private TipoCasilla tipoCasilla;
  private final Casillas casillas;
  protected int fila;
  protected int columna;
  
  public Casilla(Casillas casillas, TipoCasilla tipo, int fila, int columna) {
    this.setTipoCasilla(tipo);
    this.fila = fila;
    this.columna = columna;
    this.casillas = casillas;
  }
  
  public int getFila() {
    return fila;
  }
  
  public int getColumna() {
    return columna;
  }
  
  public TipoCasilla getTipoCasilla() {
    return tipoCasilla;
  }
  
  public void setTipoCasilla(TipoCasilla tipoCasilla) {
    this.tipoCasilla = tipoCasilla;
  }
  
  public boolean esTipoCasilla(TipoCasilla tipo) {
    return tipo.equals(this.tipoCasilla);
  }
  
  public boolean esMoneda() {
    return this.esTipoCasilla(TipoCasilla.Moneda);
  }
  
  public boolean esVacia() {
    return this.esTipoCasilla(TipoCasilla.Vacia);
  }
  
  private Casilla arriba(int n) {
    return casillas.getCasilla(fila-n, columna);
  }
  
  private Casilla abajo(int n) {
    return casillas.getCasilla(fila+n, columna);
  }
  
  private Casilla izquierda(int n) {
    return casillas.getCasilla(fila, columna-n);
  }
  
  private Casilla derecha(int n) {
    return casillas.getCasilla(fila, columna+n);
  }
  
  private boolean saltoCaeEnTablero(Direccion direccion) {
    switch(direccion) {
    case Arriba: return casillas.estaEnTablero(fila-2, columna);
    case Abajo: return casillas.estaEnTablero(fila+2, columna);
    case Izquierda: return casillas.estaEnTablero(fila, columna-2);
    case Derecha: return casillas.estaEnTablero(fila, columna+2);
    default: throw new IndexOutOfBoundsException();
    }
  }
  
  private boolean puedeSaltarArriba() {
    boolean enTablero = saltoCaeEnTablero(Direccion.Arriba);
    return enTablero && arriba(1).esMoneda() && arriba(2).esVacia();
  }
  
  private boolean puedeSaltarAbajo() {
    boolean enTablero = saltoCaeEnTablero(Direccion.Abajo);
    return enTablero && abajo(1).esMoneda() && abajo(2).esVacia();
  }
  
  private boolean puedeSaltarDerecha() {
    boolean enTablero = saltoCaeEnTablero(Direccion.Derecha);
    return enTablero && derecha(1).esMoneda() && derecha(2).esVacia();
  }
  
  private boolean puedeSaltarIzquierda() {
    boolean enTablero = saltoCaeEnTablero(Direccion.Izquierda);
    return enTablero && izquierda(1).esMoneda() && izquierda(2).esVacia();
  }
  
  boolean puedeSaltar(Direccion direccion) {
    if(!esMoneda()) {
      return false;
    }
    
    switch(direccion) {
      case Arriba: return puedeSaltarArriba();
      case Abajo: return puedeSaltarAbajo();
      case Derecha: return puedeSaltarDerecha();
      case Izquierda: return puedeSaltarIzquierda();
      default: throw new IllegalArgumentException();
    }
  }
  
  public ArrayList<Direccion> direccionesSalto() {
    ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
    for (Direccion direccion : Direccion.values()) {
      if (puedeSaltar(direccion)) {
        direcciones.add(direccion);
      }
    }
    return direcciones;
  }
  
  public int cantDireccionesSalto() {
    return direccionesSalto().size();
  }
  
  public boolean puedeSaltar() {
    return cantDireccionesSalto() > 0;
  }
  
  public void saltar(Direccion direccion) {
    switch(direccion) {
    case Arriba:
      this.setTipoCasilla(TipoCasilla.Vacia);
      this.arriba(1).setTipoCasilla(TipoCasilla.Vacia);
      this.arriba(2).setTipoCasilla(TipoCasilla.Moneda);
      break;
      
    case Abajo:
      this.setTipoCasilla(TipoCasilla.Vacia);
      this.abajo(1).setTipoCasilla(TipoCasilla.Vacia);
      this.abajo(2).setTipoCasilla(TipoCasilla.Moneda);
      break;
    
    case Izquierda:
      this.setTipoCasilla(TipoCasilla.Vacia);
      this.izquierda(1).setTipoCasilla(TipoCasilla.Vacia);
      this.izquierda(2).setTipoCasilla(TipoCasilla.Moneda);
      break;
    
    case Derecha:
      this.setTipoCasilla(TipoCasilla.Vacia);
      this.derecha(1).setTipoCasilla(TipoCasilla.Vacia);
      this.derecha(2).setTipoCasilla(TipoCasilla.Moneda);
      break;
    }
  }
}
