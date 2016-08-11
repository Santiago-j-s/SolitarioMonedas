package controlador;

import vista.CasillaButton;

/**
 * Escuchador para los botones cuando se juega sin preguntas
 * 
 * @author Dibez, Santana
 *
 */
public class BotonListenerSinPregunta extends BotonListenerPadre {

  ManejadorJuego manejador;
  CasillaButton casilla;

  /**
   * Constructor
   * 
   * @param manejador
   * 
   */
  public BotonListenerSinPregunta(ManejadorJuego manejador) {
    super(manejador);
  }
  
  public void llamarPregunta() {
    correcto();
  }
}