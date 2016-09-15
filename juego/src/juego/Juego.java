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
public class Juego {

  private Tablero tablero;

  private int cantSaltos;
  
  private static final int SALTOS_PARA_PREGUNTA = 2;

  /**
   * Constructor. Inicializa un tablero de juego. La cantidad de monedas inicial
   * se deduce de la cantidad de casillas disponibles que no son nulas o vacias.
   * 
   * @param cantFilas
   *          - cantidad de filas que contendrá el tablero
   * @param cantColumnas
   *          - cantidad de filas que contendrá el tablero
   * @param cantNulas
   *          - cantidad de casillas nulas que contendrá el tablero
   * @param cantVacias
   *          - cantidad de casillas vacias que contendrá el tablero
   * 
   */
  public Juego(int cantFilas, int cantColumnas, int cantNulas, int cantVacias) {
    this.setTablero(new Tablero5x5());
    this.setCantSaltos(1);
  }

  /**
   * Constructor defecto. 5 filas, 5 columnas, 9 casillas nulas, 2 casillas
   * vacias
   */
  public Juego() {
    this(5, 5, 9, 2);
  }

  /**
   * @return the tablero
   */
  public Tablero getTablero() {
    return tablero;
  }

  /**
   * @param tablero
   *          the tablero to set
   */
  private void setTablero(Tablero tablero) {
    this.tablero = tablero;
  }

  /**
   * @return the cantSaltos
   */
  public int getCantSaltos() {
    return cantSaltos;
  }

  /**
   * @param cantSaltos
   *          the cantSaltos to set
   */
  private void setCantSaltos(int cantSaltos) {
    this.cantSaltos = cantSaltos;
  }

  /**
   * @return la cantidad de filas del tablero
   */
  public int getCantFilas() {
    return this.getTablero().getCantFilas();
  }

  /**
   * 
   * @param fila
   * @param columna
   * @return la casilla del tablero correspondiente a la fila y a la columna
   *         pasadas como parámetros
   */
  public Casilla getCasilla(int fila, int columna) {
    return this.getTablero().getCasilla(fila, columna);
  }

  /**
   * @return the cantColumnas
   */
  public int getCantColumnas() {
    return this.getTablero().getCantColumnas();
  }

  /**
   * @param fila
   * @param columna
   * @param direccion
   * @return true si la casilla de esa fila y columna contiene una moneda y si
   *         la moneda puede saltar en la dirección indicada. false en caso
   *         contrario.
   */
  public boolean puedeSaltar(int fila, int columna, Direccion direccion) {

    Tablero tablero = this.getTablero();

    switch (direccion) {
    case Arriba:
      return tablero.esMoneda(fila, columna)
          && tablero.esMoneda(fila - 1, columna)
          && tablero.esVacia(fila - 2, columna);
    case Abajo:
      return tablero.esMoneda(fila, columna)
          && tablero.esMoneda(fila + 1, columna)
          && tablero.esVacia(fila + 2, columna);
    case Derecha:
      return tablero.esMoneda(fila, columna)
          && tablero.esMoneda(fila, columna + 1)
          && tablero.esVacia(fila, columna + 2);
    case Izquierda:
      return tablero.esMoneda(fila, columna)
          && tablero.esMoneda(fila, columna - 1)
          && tablero.esVacia(fila, columna - 2);
    default:
      return false;
    }
  }

  /**
   * @param fila
   * @param columna
   * @return true si la casilla de esa fila y columna contiene una moneda y si
   *         dicha moneda puede saltar en cualquier dirección. false en caso
   *         contrario
   */
  public boolean puedeSaltar(int fila, int columna) {

    for (Direccion direccion : Direccion.values()) {
      if (puedeSaltar(fila, columna, direccion)) {
        return true;
      }
    }

    return false;
  }

  public ArrayList<Direccion> direccionesSalto(int fila, int columna) {
    ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
    for (Direccion direccion : Direccion.values()) {
      if (puedeSaltar(fila, columna, direccion)) {
        direcciones.add(direccion);
      }
    }
    return direcciones;
  }
  
  /**
   * Determina si es tiempo de hacer una pregunta
   * @return
   */
  public boolean tiempoPregunta() {
    int cantSaltos = this.getCantSaltos();
    return (cantSaltos % SALTOS_PARA_PREGUNTA == 0);
  }

  /**
   * Devuelve la cantidad de posibles saltos de una moneda
   * 
   * @param fila
   * @param columna
   * @return
   */
  public int cantDireccionesSalto(int fila, int columna) {
    return direccionesSalto(fila, columna).size();
  }

  /**
   * Ejecuta el salto de una moneda a una casilla situada en los parametros
   * fila,columna con el movimiento en direccion del parametro
   * 
   * @param fila
   * @param columna
   * @param cadenaDireccion
   */
  public void saltar(int fila, int columna, Direccion direccion) {
    Tablero tablero = this.getTablero();

    if (puedeSaltar(fila, columna, direccion)) {
      tablero.setCantMonedas(tablero.getCantMonedas() - 1);
      tablero.setCantVacias(tablero.getCantVacias() + 1);
      this.setCantSaltos(this.getCantSaltos() + 1);

      switch (direccion) {
      case Arriba:
        tablero.setCasilla(fila, columna, Casilla.Vacia);
        tablero.setCasilla(fila - 1, columna, Casilla.Vacia);
        tablero.setCasilla(fila - 2, columna, Casilla.Moneda);
        break;

      case Abajo:
        tablero.setCasilla(fila, columna, Casilla.Vacia);
        tablero.setCasilla(fila + 1, columna, Casilla.Vacia);
        tablero.setCasilla(fila + 2, columna, Casilla.Moneda);
        break;

      case Derecha:
        tablero.setCasilla(fila, columna, Casilla.Vacia);
        tablero.setCasilla(fila, columna + 1, Casilla.Vacia);
        tablero.setCasilla(fila, columna + 2, Casilla.Moneda);
        break;

      case Izquierda:
        tablero.setCasilla(fila, columna, Casilla.Vacia);
        tablero.setCasilla(fila, columna - 1, Casilla.Vacia);
        tablero.setCasilla(fila, columna - 2, Casilla.Moneda);
        break;
      }
    }
  }

  /**
   * @return true si queda una sola moneda, false en caso contrario
   */
  public boolean victoria() {

    Tablero tablero = this.getTablero();

    if (tablero.getCantMonedas() == 1)
      return true;
    else
      return false;
  }

  /**
   * @return true si ninguna moneda puede saltar en ninguna dirección. false si
   *         al menos una moneda puede saltar en alguna dirección.
   */
  public boolean derrota() {

    Tablero tablero = this.getTablero();

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
    if(victoria() || derrota()) {
      return true;
    } else {
      return false;
    }
  }
}
