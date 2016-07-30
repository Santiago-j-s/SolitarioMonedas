package controlador;

import juego.HistoricoPreguntas;
import juego.Pregunta;

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

  private HacerPregunta hacerPregunta;
  private HistoricoPreguntas preguntas;

  public BotonListenerPregunta(ManejadorJuego manejador) {
    super(manejador);

    this.setPreguntas(new HistoricoPreguntas());
    this.setHacerPregunta(null);
  }

  /**
   * @return the hacerPregunta
   */
  private HacerPregunta getHacerPregunta() {
    return hacerPregunta;
  }

  /**
   * @param hacerPregunta
   *          the hacerPregunta to set
   */
  private void setHacerPregunta(HacerPregunta hacerPregunta) {
    this.hacerPregunta = hacerPregunta;
  }

  /**
   * @return the preguntaRandom
   */
  private HistoricoPreguntas getPreguntas() {
    return preguntas;
  }

  /**
   * @param preguntaRandom
   *          the preguntaRandom to set
   */
  private void setPreguntas(HistoricoPreguntas preguntas) {
    this.preguntas = preguntas;
  }

  /**
   * Crea una ventana con una pregunta, lanza el método 'corecto' o 'incorrecto'
   * según el resultado de la respuesta a la pregunta.
   */
  @Override
  public void llamarPregunta() {
    Pregunta pregunta = this.getPreguntas().sortearPregunta();
    HacerPregunta ventanaPregunta = new HacerPregunta(pregunta);
    this.setHacerPregunta(ventanaPregunta);
    this.getHacerPregunta().addObservadorPregunta(this);
    this.getManejadorPrincipal().getVentanaPrincipal().setEnabled(false);
  }

  /**
   * Permite continuar el juego
   */
  @Override
  public void correcto() {
    if (this.getHacerPregunta() != null) {
      this.getHacerPregunta().getVentanaPregunta().dispose();
    }
    
    super.correcto();
  }

  /**
   * Salta otra pregunta
   */
  @Override
  public void incorrecto() {
    this.getHacerPregunta().getVentanaPregunta().dispose();
    this.llamarPregunta();
  }
}
