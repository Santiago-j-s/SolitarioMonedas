package controlador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import juego.Direccion;
import juego.Juego;
import juego.Tablero;
import menuinicial.VentanaPrincipal;
import pregunta.Observador;
import vista.CasillaButton;
import vista.PanelAyuda;
import vista.PanelAyudaPreguntas;
import vista.PanelAyudaSinPreguntas;
import vista.PreguntaDireccion;
import vista.PanelTablero;
import vista.Recursos;
import vista.PanelJuego;

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
  private JFrame ventanaPrincipal;
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   * Crea y muestra la ventana principal con el tablero de juego.
   */
  public ManejadorJuego(String filename, VentanaPrincipal ventana) {
    BotonListenerPadre accionBoton = new BotonListenerPregunta(this, filename);
    Recursos recursos = ventana.getRecursos();
    
    this.inicializarPanelTablero(accionBoton, recursos);
    PanelAyuda panelAyuda = new PanelAyudaPreguntas();
    iniciarJuego(ventana, panelAyuda);
  }

  public ManejadorJuego(VentanaPrincipal ventana) {
    BotonListenerPadre accionBoton = new BotonListenerSinPregunta(this);
    Recursos recursos = ventana.getRecursos();
    
    this.inicializarPanelTablero(accionBoton, recursos);
    PanelAyuda panelAyuda = new PanelAyudaSinPreguntas();
    iniciarJuego(ventana, panelAyuda);
  }

  private void iniciarJuego(VentanaPrincipal ventana, PanelAyuda panelAyuda) {
    this.ventanaPrincipal = ventana;
    PanelJuego panelJuego = new PanelJuego(this.panelTablero, panelAyuda);
    ventana.mostrarJuego(panelJuego);
  }
  
  public void verificarFinJuego() {
    if(juego.victoria()) {
      JOptionPane.showMessageDialog(ventanaPrincipal, "Felicidades, ha ganado.");
    } else if(juego.derrota()) {
      JOptionPane.showMessageDialog(ventanaPrincipal, "Ha perdido.");
    }
  }
  
  public Direccion preguntarDireccion(int fila, int columna) {
    ArrayList<Direccion> direcciones = juego.direccionesSalto(fila, columna);
    logger.warning(direcciones.toString());
    panelTablero.colorearDireccionesSalto(panelTablero.getBoton(fila, columna), direcciones);
    PreguntaDireccion dialog = new PreguntaDireccion(direcciones);
    return dialog.getDireccion();
  }
  
  public void accionClicMoneda(CasillaButton casilla, Observador o) {
    int fila = panelTablero.getFila(casilla);
    int columna = panelTablero.getColumna(casilla);
    
    int direcciones = juego.cantDireccionesSalto(fila, columna);
    
    if(direcciones > 0) {
      if(juego.tiempoPregunta()) {
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
    this.verificarFinJuego();
  }
  
  /**
   * Realiza el salto de una moneda
   * @param fila
   * @param columna
   * @param d
   */
  public void saltar(int fila, int columna, Direccion d) {
    this.juego.saltar(fila, columna, d);
    this.panelTablero.actualizar();
  }
  
  /**
   * @return the ventanaPrincipal
   */
  protected JFrame getVentanaPrincipal() {
    return ventanaPrincipal;
  }
  
  /**
   * Prepara el panel con la interfaz gráfica del tablero según el modelo
   */
private void inicializarPanelTablero(BotonListenerPadre escuchadorBoton, Recursos recursos) {
    juego = new Juego();
    Tablero tablero = juego.getTablero();
    this.panelTablero = PanelTablero.crearTablero(tablero, recursos, escuchadorBoton);
    
    panelTablero.setVisible(true);
  }
}
