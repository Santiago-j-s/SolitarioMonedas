package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controlador.AccionClicAbstract;
import juego.Casilla;
import juego.Tablero;

public class PanelTablero extends JPanel {

  private static final long serialVersionUID = 1L;

  private static final Dimension SIZE = new Dimension(500, 500);
  private ImageIcon fondoTablero;
  private Map<String, Icon> imgsCasilla;

  private final Tablero tablero;
  private final CasillaButton[][] casillas;

  public PanelTablero(Tablero t, AccionClicAbstract accionBoton) {
    this.fondoTablero = Recursos.IMG_FONDO;
    this.setImgsCasilla();

    tablero = t;
    int filas = t.getCantFilas();
    int columnas = t.getCantColumnas();
    this.setLayout(new GridLayout(filas, columnas));
    casillas = new CasillaButton[filas][columnas];

    this.setPreferredSize(SIZE);

    this.inicializar(accionBoton);
    this.setVisible(true);
  }
  
  private void setImgsCasilla() {
    this.imgsCasilla = new HashMap<String, Icon>();
    
    imgsCasilla.put("Moneda", Recursos.IMG_MONEDA);
    imgsCasilla.put("Nula", Recursos.IMG_NULA);
    imgsCasilla.put("Vacia", Recursos.IMG_VACIA);
  }

  /**
   * @Override
   */
  @Override
  public void paint(Graphics g) {
    g.drawImage(
        fondoTablero.getImage(),
        this.getX(),
        this.getY(),
        this.getWidth(),
        this.getHeight(),
        null
    );

    this.paintComponents(g);
  }

  public CasillaButton getBoton(int fila, int columna) throws IndexOutOfBoundsException {
    if(!tablero.estaEnTablero(fila, columna)) {
      throw new IndexOutOfBoundsException();
    }
    return casillas[fila][columna];
  }

  private void setBoton(Casilla casilla) {
    getBoton(casilla).setCasilla(casilla);
  }

  private CasillaButton getBoton(Casilla casilla) {
    return getBoton(casilla.getFila(), casilla.getColumna());
  }

  private void inicializarBoton(Casilla casilla, AccionClicAbstract accion) {
    CasillaButton boton = new CasillaButton(casilla, imgsCasilla);
    boton.addActionListener(accion);
    casillas[casilla.getFila()][casilla.getColumna()] = boton;
    this.add(boton);
  }
  
  /**
   * 
   * @param casilla
   * @return la fila correspondiente al botón pasado como parámetro.
   */
  private int getFila(CasillaButton casilla) {
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
  private int getColumna(CasillaButton casilla) {
    Point punto = casilla.getLocation();
    int anchoCasilla = casilla.getSize().width;
    double mitad = anchoCasilla / 2;
    return (int) ((punto.getX() + mitad) / anchoCasilla);
  }
  
  public Casilla getCasilla(CasillaButton casilla) {
    return tablero.getCasilla(getFila(casilla), getColumna(casilla));
  }

  private void inicializar(AccionClicAbstract accion) {
    tablero.getCasillas().forEach((casilla) -> {
      this.inicializarBoton(casilla, accion);
    }); 
  }

  public void actualizar() {
    tablero.getCasillas().forEach((casilla) -> {
      this.setBoton(casilla);
    });
  }

  public void colorearCasilla(Casilla casilla, Color color) {
    getBoton(casilla).colorear(color);
  }
  
  public void colorearCasillas(List<Casilla> casillasAColorear, Color color) {
    casillasAColorear.forEach(casilla -> colorearCasilla(casilla, color));
  }
}
