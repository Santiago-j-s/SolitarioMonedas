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

  private final Tablero tablero;
  private final CasillaButton[][] casillas;

  public PanelTablero(Tablero t, AccionClicAbstract accionBoton) {
    fondoTablero = Recursos.IMG_FONDO;

    tablero = t;
    int filas = t.getCantFilas();
    int columnas = t.getCantColumnas();
    setLayout(new GridLayout(filas, columnas));
    casillas = new CasillaButton[filas][columnas];

    setPreferredSize(SIZE);

    inicializar(accionBoton);
    setVisible(true);
  }

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

  private void inicializarBoton(Casilla casilla, AccionClicAbstract accion, Map<String, Icon> imgs) {
    CasillaButton boton = new CasillaButton(casilla, imgs);
    boton.addActionListener(accion);
    casillas[casilla.getFila()][casilla.getColumna()] = boton;
    this.add(boton);
  }
  
  private int getFila(CasillaButton casilla) {
    Point punto = casilla.getLocation();
    int alturaCasilla = casilla.getSize().height;
    double mitad = alturaCasilla / 2;
    return (int) ((punto.getY() + mitad) / alturaCasilla);
  }

  private int getColumna(CasillaButton casilla) {
    Point punto = casilla.getLocation();
    int anchoCasilla = casilla.getSize().width;
    double mitad = anchoCasilla / 2;
    return (int) ((punto.getX() + mitad) / anchoCasilla);
  }
  
  public Casilla getCasilla(CasillaButton casilla) {
    return tablero.getCasilla(getFila(casilla), getColumna(casilla));
  }

  
  private Map<String, Icon> obtenerImgsCasilla() {
    Map<String, Icon> imgsCasilla = new HashMap<String, Icon>();
    
    imgsCasilla.put("Moneda", Recursos.IMG_MONEDA);
    imgsCasilla.put("Nula", Recursos.IMG_NULA);
    imgsCasilla.put("Vacia", Recursos.IMG_VACIA);
    
    return imgsCasilla;
  }
  
  private void inicializar(AccionClicAbstract accion) {
    Map<String, Icon> imgs = obtenerImgsCasilla();
    
    tablero.getCasillas().forEach(casilla -> this.inicializarBoton(casilla, accion, imgs));
  }

  public void actualizar() {
    tablero.getCasillas().forEach(casilla -> this.setBoton(casilla));
  }

  public void colorearCasilla(Casilla casilla, Color color) {
    getBoton(casilla).colorear(color);
  }
  
  public void quitarColor(Casilla casilla) {
    getBoton(casilla).quitarColor();
  }
  
  public void colorearCasillas(List<Casilla> casillasAColorear, Color color) {
    casillasAColorear.forEach(casilla -> colorearCasilla(casilla, color));
  }
}
