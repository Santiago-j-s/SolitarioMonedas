package controlador;

import java.awt.Color;
import java.util.List;
import java.util.logging.Logger;

import fx.juego.FxEstadisticas;
import juego.Direccion;
import juego.Casilla;
import juego.Juego;
import juego.Tablero;
import menuinicial.VentanaPrincipal;
import pregunta.modelo.Observador;
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
  private Juego juego;
  private PanelTablero panelTablero;
  private VentanaPrincipal ventanaPrincipal;
  private FxEstadisticas panelEstadisticas = new FxEstadisticas();
  private final Logger logger = Logger.getLogger(getClass().getName());
  
  private void iniciarPanelTablero(AccionClicAbstract accionBoton) {
    juego = new Juego();
    Tablero tablero = juego.getTablero();
    panelTablero = new PanelTablero(tablero, accionBoton);
  }
  
  private void iniciarVentanaPrincipal(AccionClicAbstract accionBoton, VentanaPrincipal ventana) {
    ventanaPrincipal = ventana;
    iniciarPanelTablero(accionBoton);
    ventanaPrincipal.setearPanelTablero(panelTablero);
  }

  /**
   * Crea y muestra la ventana principal con el tablero de juego.
   */
  public ManejadorJuego(String categoria, VentanaPrincipal ventana) {
    AccionClicAbstract accionBoton = new AccionClicPregunta(this, categoria);
    iniciarVentanaPrincipal(accionBoton, ventana);
  }

  public ManejadorJuego(VentanaPrincipal ventana) {
    AccionClicAbstract accionBoton = new AccionClic(this);
    iniciarVentanaPrincipal(accionBoton, ventana);
  }
  
  private void colorearCasillasSalto(Casilla casilla) {
    List<Casilla> casillas = casilla.casillasSalto();
    panelTablero.colorearCasillas(casillas, Color.GREEN);
  }
  
  private Direccion preguntarDireccion(List<Direccion> direcciones) {
    PreguntaDireccion dialog = new PreguntaDireccion(direcciones);
    return dialog.getDireccion();
  }
  
  private Direccion obtenerDireccion(List<Direccion> direcciones) {
    if (direcciones.size() == 1) {
      return direcciones.get(0);
    }
    Direccion direccion = preguntarDireccion(direcciones);
    return direccion;
  }
  
  private void deshabilitarVentanaPrincipal() {
    ventanaPrincipal.setEnabled(false);
  }
  
  private void habilitarVentanaPrincipal() {
    panelTablero.actualizar();
    ventanaPrincipal.setEnabled(true);
    ventanaPrincipal.toFront();
  }
 
  private void mensajeFinJuego() {
    String mensaje = juego.victoria() ? "¡Ha ganado!" : "Ha perdido";
    panelEstadisticas.lanzarEstadisticas(juego.getEstado(), mensaje);
  }
  
  private void saltoMoneda(Casilla casilla) {
    colorearCasillasSalto(casilla);
    List<Direccion> direcciones = juego.direccionesSalto(casilla);
    logger.info(String.format("Direcciones Posibles Salto: %s", direcciones.toString()));
    Direccion direccion = obtenerDireccion(direcciones);
    juego.saltar(casilla, direccion);
    if(juego.fin()) {
      mensajeFinJuego();
    }
    habilitarVentanaPrincipal();
  }
  
  private void accionClicCasilla(Casilla casilla, Observador o) {
    logger.info(String.format("Click en: (%d, %d)", casilla.getFila(), casilla.getColumna()));
    if(!casilla.puedeSaltar()) {
      panelTablero.quitarColor(casilla);
      return;
    }
    
    if(juego.tiempoPregunta()) {
      deshabilitarVentanaPrincipal();
      o.llamarPregunta();
      return;
    }
    
    saltoMoneda(casilla);
  }
  
  public void saltoMoneda(CasillaButton casilla) {
    saltoMoneda(panelTablero.getCasilla(casilla));
  }

  public void accionClicCasilla(CasillaButton casilla, Observador o) {
    casilla.colorear(Color.MAGENTA);
    accionClicCasilla(panelTablero.getCasilla(casilla), o);
  }
  
  public void acertarPregunta() {
    juego.acertar();
  }
  
  public void fallarPregunta() {
    juego.fallar();
  }
}
