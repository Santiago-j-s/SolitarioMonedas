package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import juego.Casilla;
import juego.Direccion;
import juego.Tablero;

/**
 * Clase encargada de crear y asignar elementos al panel del tablero del juego
 * 
 * @author Dibez, Santana
 *
 */
public class PanelTablero extends JPanel {

  private static final long serialVersionUID = 1L;
  private static final int HEIGHT = 500;
  private static final int WIDTH = HEIGHT;
  private static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);

  private Recursos recursos;

  private Tablero tablero;
  private ImageIcon fondoTablero;

  private CasillaButton[][] tableroVista; // matriz de botones que contiene las
  // casillas

  /**
   * Constructor de la clase.
   * 
   * @param cantFilas
   *          - cantidad total de filas
   * @param cantColumnas
   *          - cantidad total de columnas
   */
  public PanelTablero(Tablero t, Recursos r) {
    this.tablero = t;
    this.setRecursos(r);

    int filas = t.getCantFilas();
    int cols = t.getCantColumnas();

    this.setLayout(new GridLayout(filas, cols));
    tableroVista = new CasillaButton[filas][cols];

    this.setOpaque(false);
    this.setPreferredSize(SIZE);
    this.actualizar();
  }

  /**
   * Metodo que agrega una imagen de fondo al panel del tablero
   */
  public void paint(Graphics g) {
    this.fondoTablero = getRecursos().getImgFondo();

    g.drawImage(this.fondoTablero.getImage(), this.getX(), this.getY(),
        this.getWidth(), this.getHeight(), null);

    this.paintComponents(g);
  }

  /**
   * 
   * @param fila
   * @param columna
   * @return el botón correspondiente a la fila y columna pasados como
   *         parámetros
   * @throws ArrayIndexOutOfBoundsException
   */
  public CasillaButton getBoton(int fila, int columna)
      throws ArrayIndexOutOfBoundsException {

    int filas = tablero.getCantFilas();
    int cols = tablero.getCantColumnas();

    if (fila < filas && columna < cols) {
      return tableroVista[fila][columna];
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * Metodo que establece un boton de tipoCasilla en el tablero ubicado en la
   * fila y columna pasados como parametros
   * 
   * @param fila
   * @param columna
   * @param tipoCasilla
   */
  public void setBoton(int fila, int columna, Casilla casilla) {
    if (getBoton(fila, columna) == null) {
      tableroVista[fila][columna] = new CasillaButton(getRecursos(), casilla);
    } else {
      tableroVista[fila][columna].setTipoCasilla(casilla);
    }
  }

  /**
   * 
   * @param casilla
   * @return la fila correspondiente al botón pasado como parámetro.
   */
  public int getFila(CasillaButton casilla) {
    Point punto = casilla.getLocation();
    int alturaCasilla = casilla.getSize().height;
    return (int) ((punto.getY() + alturaCasilla / 2) / (alturaCasilla));
  }

  /**
   * 
   * @param casilla
   * @return la columna correspondiente al botón pasado como parámetro.
   */
  public int getColumna(CasillaButton casilla) {
    Point punto = casilla.getLocation();
    Dimension dimensiones = casilla.getSize();
    return (int) ((punto.getX() + dimensiones.width / 2) / (dimensiones.width));
  }

  private Recursos getRecursos() {
    return recursos;
  }

  private void setRecursos(Recursos recursos) {
    this.recursos = recursos;
  }

  /**
   * Dota a las casillas del tablero de una imagen según cual sea su valor
   */
  public void actualizar() {
    int filas = tablero.getCantFilas();
    int cols = tablero.getCantColumnas();

    for (int fila = 0; fila < filas; fila++) {
      for (int columna = 0; columna < cols; columna++) {
        Casilla casilla = tablero.getCasilla(fila, columna);
        this.setBoton(fila, columna, casilla);
      }
    }
  }

  /**
   * Vuelve opaca a una casilla y setea su color de fondo
   * 
   * @param fila
   *          - la fila correspondiente a la casilla
   * @param columna
   *          - la columna correspondiente a la casilla
   * @param color
   *          - el color con que se pintará el fondo
   * @throws ArrayIndexOutOfBoundsException
   */
  public void colorearBoton(int fila, int columna, Color color)
      throws ArrayIndexOutOfBoundsException {

    int filas = tablero.getCantFilas();
    int cols = tablero.getCantColumnas();

    if (fila < filas && columna < cols) {
      this.getBoton(fila, columna).setContentAreaFilled(true);
      this.getBoton(fila, columna).setBackground(color);
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * Colorea las casillas a las que una moneda puede saltar
   * 
   * @param direcciones
   *          - las direcciones a las que la moneda puede saltar
   */
  public void colorearDireccionesSalto(CasillaButton casilla,
      List<Direccion> direcciones) {
    int fila = getFila(casilla);
    int columna = getColumna(casilla);
    
    if (direcciones.contains(Direccion.Derecha)) {
      this.colorearBoton(fila, columna+2, Color.GREEN);
    }
    if (direcciones.contains(Direccion.Izquierda)) {
      this.colorearBoton(fila, columna-2, Color.GREEN);
    }
    if (direcciones.contains(Direccion.Arriba)) {
      this.colorearBoton(fila-2, columna, Color.GREEN);
    }
    if (direcciones.contains(Direccion.Abajo)) {
      this.colorearBoton(fila+2, columna, Color.GREEN);
    }
  }
}
