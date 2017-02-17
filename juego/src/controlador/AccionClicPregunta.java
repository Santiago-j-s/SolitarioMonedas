package controlador;

import javax.swing.SwingUtilities;

import pregunta.FachadaPregunta;
import pregunta.Observador;

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
public class AccionClicPregunta extends AccionClicAbstract
    implements Observador {

  private final FachadaPregunta hacerPregunta;

  public AccionClicPregunta(ManejadorJuego manejador, String categoria) {
    super(manejador);
    hacerPregunta = new FachadaPregunta();
    hacerPregunta.setCategoria(categoria);
  }
  
  public void setCategoria(String categoria) {
    this.hacerPregunta.setCategoria(categoria);
  }

  /**
   * Crea una ventana con una pregunta, lanza el método 'corecto' o 'incorrecto'
   * según el resultado de la respuesta a la pregunta.
   */
  @Override
  public void llamarPregunta() {
    SwingUtilities.invokeLater(() -> {
      manejador.getVentanaPrincipal().setEnabled(false);
      hacerPregunta.getObservadoresPregunta().removeAllObservadores();
      hacerPregunta.getObservadoresPregunta().addObservador(this);
    });
    hacerPregunta.lanzarPregunta();
  }
  
  public void correcto() {
    SwingUtilities.invokeLater(() -> {
      super.correcto();
      hacerPregunta.cerrarPregunta();
    });
  }
  
  public void incorrecto() {
    SwingUtilities.invokeLater(() -> {
      super.incorrecto();
    });
  }
}
