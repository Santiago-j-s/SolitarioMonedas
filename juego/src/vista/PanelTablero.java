package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JPanel;

import controlador.AccionClicAbstract;
import juego.TipoCasilla;
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

  // Largo y ancho del tablero
  private static final Dimension SIZE = new Dimension(500, 500);

  // Imagen del fondo del panel del tablero
  private Image fondoTablero;

  // Imágenes de las casillas
  private Map<String, Icon> imgsCasilla;

  private final Tablero tablero; // Tablero de juego
  private final int filas; // Cantidad de filas
  private final int columnas; // Cantidad de columnas

  // Los botones que representan las casillas del tablero
  private final CasillaButton[][] casillas;

  /**
   * @param cantFilas
   *          cantidad total de filas
   * @param cantColumnas
   *          cantidad total de columnas
   */
  public PanelTablero(Tablero t, AccionClicAbstract accionBoton) {
    this.fondoTablero = Recursos.IMG_FONDO.getImage();
    this.setImgsCasilla();

    tablero = t;
    filas = t.getCantFilas();
    columnas = t.getCantColumnas();

    this.setLayout(new GridLayout(filas, columnas));
    casillas = new CasillaButton[filas][columnas];

    this.setPreferredSize(SIZE);

    this.inicializar(accionBoton);
    this.setVisible(true);
  }
  
  public static final PanelTablero crearTablero(Tablero t, AccionClicAbstract accionBoton) {
    return new PanelTablero(t, accionBoton);
  }

  /**
   * Inyecta las imágenes para las casillas El HashMap imgsCasilla obtiene de r
   * las imágenes para las casillas del tablero
   * 
   * @param r
   */
  private void setImgsCasilla() {
    this.imgsCasilla = new HashMap<String, Icon>();

    imgsCasilla.put("Moneda", Recursos.IMG_MONEDA);
    imgsCasilla.put("Nula", Recursos.IMG_NULA);
    imgsCasilla.put("Vacia", Recursos.IMG_VACIA);
  }

  /**
   * Metodo que agrega una imagen de fondo al panel del tablero
   */
  public void paint(Graphics g) {
    g.drawImage(fondoTablero, this.getX(), this.getY(), this.getWidth(),
        this.getHeight(), null);

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

    if (fila < filas && columna < columnas) {
      return casillas[fila][columna];
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * Actualiza la imágen de la casilla que se encuentra en fila 'fila' y columna
   * 'columna'
   * 
   * @param fila
   *          la fila en que se encuentra el botón
   * @param columna
   *          la columna en que se encuentra el botón
   * @param casilla
   *          el tipo de casilla
   */
  private void setBoton(int fila, int columna, TipoCasilla casilla) {
    getBoton(fila, columna).setTipoCasilla(casilla);
  }

  /**
   * Crea la casilla y la pone en el tablero
   * 
   * @param fila
   *          la fila en que se encuentra el botón
   * @param columna
   *          la columna en que se encuentra el botón
   * @param casilla
   *          el tipo de casilla
   */
  private void inicializarBoton(int fila, int columna, TipoCasilla casilla, AccionClicAbstract accion) {
    CasillaButton boton = new CasillaButton(casilla, imgsCasilla);
    boton.addActionListener(accion);
    casillas[fila][columna] = boton;
    this.add(boton);
  }

  /**
   * 
   * @param casilla
   * @return la fila correspondiente al botón pasado como parámetro.
   */
  public int getFila(CasillaButton casilla) {
    Point punto = casilla.getLocation();
    int alturaCasilla = casilla.getSize().height;
    double mitad = alturaCasilla / 2;
    return (int) ((punto.getY() + mitad) / alturaCasilla);
  }

  /**
   * 
   * @param casilla
   * @return la columna correspondiente al botón pasado como parámetro.
   */
  public int getColumna(CasillaButton casilla) {
    Point punto = casilla.getLocation();
    int anchoCasilla = casilla.getSize().width;
    double mitad = anchoCasilla / 2;
    return (int) ((punto.getX() + mitad) / anchoCasilla);
  }

  /**
   * Crea las casillas del tablero
   * @param accion 
   */
  private void inicializar(AccionClicAbstract accion) {
    for (int fila = 0; fila < filas; fila++) {
      for (int columna = 0; columna < columnas; columna++) {
        TipoCasilla casilla = tablero.getCasilla(fila, columna).getTipoCasilla();
        this.inicializarBoton(fila, columna, casilla, accion);
      }
    }
  }

  /**
   * Actualiza las imágenes de las casillas
   */
  public void actualizar() {
    for (int fila = 0; fila < filas; fila++) {
      for (int columna = 0; columna < columnas; columna++) {
        TipoCasilla casilla = tablero.getCasilla(fila, columna).getTipoCasilla();
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
  public void colorearBoton(CasillaButton casilla, Color color)
      throws ArrayIndexOutOfBoundsException {

    casilla.colorear(color);
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
    CasillaButton blanco = null;

    if (direcciones.contains(Direccion.Derecha)) {
      blanco = this.getBoton(fila, columna + 2);
      blanco.colorear(Color.GREEN);
    }
    if (direcciones.contains(Direccion.Izquierda)) {
      blanco = this.getBoton(fila, columna - 2);
      blanco.colorear(Color.GREEN);
    }
    if (direcciones.contains(Direccion.Arriba)) {
      blanco = this.getBoton(fila - 2, columna);
      blanco.colorear(Color.GREEN);
    }
    if (direcciones.contains(Direccion.Abajo)) {
      blanco = this.getBoton(fila + 2, columna);
      blanco.colorear(Color.GREEN);
    }
    if(blanco == null) {
      throw new NullPointerException();
    }
    this.repaint();
  }
}
