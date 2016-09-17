package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import vista.CasillaButton;
import vista.PanelIngresoDireccion;
import vista.PanelTablero;
import juego.Direccion;
import juego.Juego;
import pregunta.ObservadorPregunta;

/**
 * Clase padre de todas las clases que implementan escuchadores para las
 * casillas del tablero
 * 
 * @author Dibez, Santana
 */
public abstract class BotonListenerPadre
    implements ActionListener, ObservadorPregunta {

  protected ManejadorJuego manejador;
  private CasillaButton casillaPresionada;

  protected BotonListenerPadre(ManejadorJuego manejador) {
    this.manejador = manejador;
  }

  /**
   * @return the casillaPresionada
   */
  private CasillaButton getCasillaPresionada() {
    return casillaPresionada;
  }

  /**
   * @param casillaPresionada
   *          the casillaPresionada to set
   */
  private void setCasillaPresionada(CasillaButton casillaPresionada) {
    this.casillaPresionada = casillaPresionada;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    CasillaButton casilla = (CasillaButton) e.getSource();
    accionClicMoneda(casilla);
  }

  public abstract void llamarPregunta();

  public void correcto() {
    CasillaButton casilla = this.getCasillaPresionada();
    saltar(casilla);
  }

  public void incorrecto() {}

  private void accionClicMoneda(CasillaButton casilla) {
    ManejadorJuego manejador = this.manejador;
    Juego juego = manejador.getJuego();
    PanelTablero panel = manejador.getPanelTablero();

    int fila = panel.getFila(casilla);
    int columna = panel.getColumna(casilla);

    if (juego.cantDireccionesSalto(fila, columna) > 0) {
      this.setCasillaPresionada(casilla);
      if (juego.tiempoPregunta()) {
        this.llamarPregunta();
      } else {
        this.correcto();
      }
    }
  }

  /**
   * Colorea las casillas en que la moneda seleccionada puede saltar
   * 
   * @param casilla
   *          - el botón correspondiente a la moneda seleccionada
   * @return true si la moneda tiene saltos posibles, false si no los tiene
   */
  private void colorearDireccionesSalto(CasillaButton casilla) {

    ManejadorJuego manejador = this.manejador;
    Juego juego = manejador.getJuego();
    PanelTablero panel = manejador.getPanelTablero();

    int fila = panel.getFila(casilla);
    int columna = panel.getColumna(casilla);

    ArrayList<Direccion> direcciones = juego.direccionesSalto(fila, columna);
    panel.colorearDireccionesSalto(casilla, direcciones);
  }

  private Direccion preguntarDireccion(int fila, int columna) {
    ManejadorJuego manejador = this.manejador;
    Juego juego = manejador.getJuego();
    ArrayList<Direccion> direcciones = juego.direccionesSalto(fila, columna);

    return preguntarDireccion(direcciones);
  }

  /**
   * Consulta al usuario en que dirección desea saltar
   * 
   * @param direcciones
   * @return una cadena con la dirección
   */
  private Direccion preguntarDireccion(ArrayList<Direccion> direcciones) {
    ManejadorJuego manejador = this.manejador;
    JFrame ventanaPrincipal = manejador.getVentanaPrincipal();

    JDialog ventana = new JDialog(ventanaPrincipal, "Dirección");

    PanelIngresoDireccion panelDireccion = new PanelIngresoDireccion(ventana,
        direcciones);

    int ventanaPosX = ventanaPrincipal.getX();
    int ventanaPosY = ventanaPrincipal.getY();
    int ventanaTamX = ventanaPrincipal.getSize().width;

    ventana.add(panelDireccion);
    ventana.setLocation(ventanaPosX + ventanaTamX, ventanaPosY);

    panelDireccion.setVisible(true);

    return panelDireccion.getDireccion();
  }

  private void saltar(CasillaButton casilla) {
    ManejadorJuego manejador = this.manejador;
    PanelTablero panel = manejador.getPanelTablero();

    colorearDireccionesSalto(casilla);

    int fila = panel.getFila(casilla);
    int columna = panel.getColumna(casilla);

    saltar(fila, columna);
  }

  private void saltar(int fila, int columna) {
    ManejadorJuego manejador = this.manejador;
    PanelTablero panel = manejador.getPanelTablero();
    Juego juego = manejador.getJuego();

    panel.colorearBoton(fila, columna, Color.MAGENTA);

    int cantDirecciones = juego.cantDireccionesSalto(fila, columna);

    if (cantDirecciones == 1) {
      Direccion d = juego.direccionesSalto(fila, columna).get(0);
      this.saltar(fila, columna, d);
    } else if (cantDirecciones > 1) {
      try {
        Direccion direccion = preguntarDireccion(fila, columna);
        this.saltar(fila, columna, direccion);
      } catch (NullPointerException e) {
        System.out.println(e);
      }
    }

    panel.actualizar();
    manejador.getVentanaPrincipal().setEnabled(true);
    manejador.getVentanaPrincipal().toFront();
    
    this.manejador.verificarFinJuego();;
  }

  /**
   * Llama al método saltar de 'tablero' y modifica las casillas de la IGU en
   * consecuencia
   * 
   * @param fila
   *          - Fila de la moneda que realizará el salto
   * @param columna
   *          - Columna de la moneda que realizará el salto
   * @param d
   *          - Dirección en la que saltará la moneda
   */
  private void saltar(int fila, int columna, Direccion d) {
    manejador.getJuego().saltar(fila, columna, d);
    manejador.getPanelTablero().actualizar();
  }
}
