package controlador;

import pregunta.FachadaHacerPregunta;
import pregunta.ObservadorPregunta;

/**
 * Invocado cuando se presiona una casilla.
 * 
 * Verifica si la casilla contiene una moneda o no. Si la casilla contiene una
 * moneda colorea las direcciones de salto posibles y pregunta por la dirección
 * en que se desea saltar.
 * 
 * Cada 3 saltos presenta una pregunta, cada vez que la pregunta es respondida
 * incorrectamente, salta otra pregunta. No permite continuar jugando hasta que
 * no se responda de forma correcta una pregunta
 *
 * @author Dibez, Santana
 *
 */
public class BotonListenerPregunta extends BotonListenerPadre
    implements ObservadorPregunta {

  private FachadaHacerPregunta hacerPregunta;

  public BotonListenerPregunta(ManejadorJuego manejador) {
    super(manejador);
    this.hacerPregunta = new FachadaHacerPregunta();
  }

  /**
   * Crea una ventana con una pregunta, lanza el método 'corecto' o 'incorrecto'
   * según el resultado de la respuesta a la pregunta.
   */
  @Override
  public void llamarPregunta() {
    this.getManejadorPrincipal().getVentanaPrincipal().setEnabled(false);
    this.hacerPregunta.lanzarPregunta(this);
  }

  /**
   * Permite continuar el juego
   */
  @Override
  public void correcto() {
    this.hacerPregunta.cerrarVentana();
    super.correcto();
  }

  /**
   * Salta otra pregunta
   */
  @Override
  public void incorrecto() {
    this.hacerPregunta.cerrarVentana();
    this.llamarPregunta();
  }
}
