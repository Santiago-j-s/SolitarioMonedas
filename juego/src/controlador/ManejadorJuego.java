package controlador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import juego.Direccion;
import juego.ControladorTablero;
import juego.Tablero;
import menuinicial.VentanaPrincipal;
import pregunta.Observador;
import vista.CasillaButton;
import vista.PreguntaDireccion;
import vista.PanelTablero;

/**
 * Clase que relaciona los diferentes elementos de la GUI con la lógica del
 * juego que se encuentra en la clase 'Tablero' del paquete 'modelo'
 * 
 * @author Dibez, Santana
 *
 */
public class ManejadorJuego {

  private ControladorTablero juego;
  private PanelTablero panelTablero;
  private VentanaPrincipal ventanaPrincipal;
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final AccionClicAbstract accionBoton;

  /**
   * Crea y muestra la ventana principal con el tablero de juego.
   */
  public ManejadorJuego(String categoria, VentanaPrincipal ventana) {
    this.accionBoton = new AccionClicPregunta(this, categoria);
    iniciarJuego(ventana);
  }

  public ManejadorJuego(VentanaPrincipal ventana) {
    this.accionBoton = new AccionClic(this);
    iniciarJuego(ventana);
  }

  private void iniciarJuego(VentanaPrincipal ventana) {
    this.ventanaPrincipal = ventana;
    this.inicializarPanelTablero(this.accionBoton);
  }
  
  private void mensajeFinJuego() {
    if(juego.fin()) {
      String mensaje = juego.victoria() ? "Felicidades, ha ganado" : "Ha perdido";
      JOptionPane.showMessageDialog(ventanaPrincipal, mensaje);
    }
  }
  
  private Direccion preguntarDireccion(int fila, int columna) {
    ArrayList<Direccion> direcciones = juego.direccionesSalto(fila, columna);
    logger.warning(direcciones.toString());
    panelTablero.colorearDireccionesSalto(panelTablero.getBoton(fila, columna), direcciones);
    PreguntaDireccion dialog = new PreguntaDireccion(direcciones);
    return dialog.getDireccion();
  }
  
  public void accionClicMoneda(CasillaButton casilla, Observador o) {
    int fila = panelTablero.getFila(casilla);
    int columna = panelTablero.getColumna(casilla);
    logger.info(String.format("Click en: (%d, %d)", fila, columna));
    
    int direcciones = juego.cantDireccionesSalto(fila, columna);
    
    if(direcciones > 0) {
      if(juego.tiempoPregunta()) {
        ventanaPrincipal.setEnabled(false);
        o.llamarPregunta();
      } else {
        this.accionCasilla(casilla);
      }
    }
  }
  
  public void accionCasilla(CasillaButton casilla) {
    int fila = panelTablero.getFila(casilla);
    int columna = panelTablero.getColumna(casilla);
    
    panelTablero.colorearBoton(casilla, Color.MAGENTA);
    int direcciones = juego.cantDireccionesSalto(fila, columna);
    if(direcciones == 1) {
      Direccion d = juego.direccionesSalto(fila, columna).get(0);
      saltar(fila, columna, d);
    } else if(direcciones > 1) {
      try {
        Direccion d = preguntarDireccion(fila, columna);
        this.saltar(fila, columna, d);
      } catch (NullPointerException e) {
        e.printStackTrace();
      }
    }
    
    ventanaPrincipal.setEnabled(true);
    ventanaPrincipal.toFront();
    this.mensajeFinJuego();
  }
  
  private void saltar(int fila, int columna, Direccion d) {
    this.juego.saltar(fila, columna, d);
    this.panelTablero.actualizar();
  }
  
  /**
   * Prepara el panel con la interfaz gráfica del tablero según el modelo
   */
  private void inicializarPanelTablero(AccionClicAbstract escuchadorBoton) {
    juego = new ControladorTablero();
    Tablero tablero = juego.getTablero();
    this.panelTablero = PanelTablero.crearTablero(tablero, escuchadorBoton);
    this.ventanaPrincipal.setearPanelTablero(this.panelTablero);
  }
}
