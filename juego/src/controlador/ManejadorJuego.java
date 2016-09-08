package controlador;

import javax.swing.JFrame;

import juego.Juego;
import juego.Tablero;
import menuinicial.VentanaPrincipal;
import vista.PanelAyuda;
import vista.PanelAyudaPreguntas;
import vista.PanelAyudaSinPreguntas;
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
  private PanelJuego panelJuego;
  private Recursos recursos;

  /**
   * Crea y muestra la ventana principal con el tablero de juego.
   */
  public ManejadorJuego(String filename, VentanaPrincipal ventana) {
    this.recursos = ventana.getRecursos();
    this.inicializarPanelTablero(new BotonListenerPregunta(this, filename));
    PanelAyuda panelAyuda = new PanelAyudaPreguntas();
    iniciarJuego(ventana, panelAyuda);
  }

  public ManejadorJuego(VentanaPrincipal ventana) {
    this.recursos = ventana.getRecursos();
    this.inicializarPanelTablero(new BotonListenerSinPregunta(this));
    PanelAyuda panelAyuda = new PanelAyudaSinPreguntas();
    iniciarJuego(ventana, panelAyuda);
  }
  
  private void iniciarJuego(VentanaPrincipal ventana, PanelAyuda panelAyuda) {
    this.ventanaPrincipal = ventana;
    this.panelJuego = new PanelJuego(this.panelTablero, panelAyuda);
    ventana.mostrarJuego(panelJuego);
  }

  protected
      void setPanelJuego(PanelJuego panelJuego) {
    this.panelJuego = panelJuego;
  }

  /**
   * @return the tablero
   */
  protected
      Juego getJuego() {
    return juego;
  }

  /**
   * @param juego
   *          the tablero to set
   */
  protected
      void setJuego(Juego juego) {
    this.juego = juego;
  }

  /**
   * @return the panelTablero
   */
  protected
      PanelTablero getPanelTablero() {
    return panelTablero;
  }

  /**
   * @param panelTablero
   *          the panelTablero to set
   */
  protected
      void setPanelTablero(PanelTablero panelTablero) {
    this.panelTablero = panelTablero;
  }

  /**
   * @return the ventanaPrincipal
   */
  protected
      JFrame getVentanaPrincipal() {
    return ventanaPrincipal;
  }

  /**
   * Le da al botón señalado por 'fila' y 'columna' el valor correspondiente a
   * la misma casilla del tablero correspondiente al modelo y le añade el
   * escuchador pasado como parámetro
   *
   * @param fila
   * @param columna
   * @param escuchador
   */
  private
      void
      inicializarBoton(int fila, int columna, BotonListenerPadre escuchador) {
    PanelTablero panelTablero = this.getPanelTablero();

    panelTablero.add(panelTablero.getBoton(fila, columna));
    panelTablero.getBoton(fila, columna).addActionListener(escuchador);
  }

  /**
   * Prepara el panel con la interfaz gráfica del tablero según el modelo
   */
  private
      void inicializarPanelTablero(BotonListenerPadre escuchadorBoton) {
    this.setJuego(new Juego());

    Tablero tablero = this.getJuego().getTablero();
    int filas = tablero.getCantFilas();
    int cols = tablero.getCantColumnas();

    PanelTablero panelTablero = new PanelTablero(tablero, recursos);

    this.setPanelTablero(panelTablero);

    for (int fila = 0; fila < filas; fila++) {
      for (int columna = 0; columna < cols; columna++) {
        inicializarBoton(fila, columna, escuchadorBoton);
      }
    }

    this.getPanelTablero().setVisible(true);
  }
}
