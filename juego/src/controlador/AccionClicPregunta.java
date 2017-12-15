package controlador;

import javax.swing.SwingUtilities;

import pregunta.FachadaPregunta;
import pregunta.modelo.Observador;

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
public class AccionClicPregunta extends AccionClicAbstract implements Observador {

  private final FachadaPregunta controladorPregunta;

  public AccionClicPregunta(ManejadorJuego manejador, String categoria) {
    super(manejador);
    controladorPregunta = new FachadaPregunta(categoria);
  }
  
  /**
   * Crea una ventana con una pregunta, lanza el método 'corecto' o 'incorrecto'
   * según el resultado de la respuesta a la pregunta.
   */
  @Override
  public void llamarPregunta() {
    SwingUtilities.invokeLater(() -> {
      controladorPregunta.getObservadoresPregunta().setObservador(this);
    });
    controladorPregunta.lanzarPregunta();
  }
  
  @Override
  public void correcto() {
    SwingUtilities.invokeLater(() -> {
      super.correcto();
      controladorPregunta.cerrarPregunta();
    });
  }
  
  @Override
  public void incorrecto() {
    SwingUtilities.invokeLater(() -> {
      super.incorrecto();
      controladorPregunta.cerrarPregunta();
    });
  }
}
