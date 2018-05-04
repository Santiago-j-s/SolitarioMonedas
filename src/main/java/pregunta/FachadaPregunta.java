package pregunta;

import java.io.IOException;

import fx.pregunta.FxPanelPregunta;
import fx.pregunta.FxPanelSeleccion;
import pregunta.modelo.Categorizable;
import pregunta.modelo.ObservadoresPregunta;
import pregunta.modelo.Pregunta;

/**
 * Clase que muestra una pregunta en pantalla y las opciones disponibles para
 * responderla.
 *
 * @author Dibez, Santana
 *
 */
public class FachadaPregunta {
  private final ObservadoresPregunta observadoresPregunta = new ObservadoresPregunta();
  private final FxPanelPregunta panelPregunta = new FxPanelPregunta(this);
  
  public FachadaPregunta(String categoria) {
    panelPregunta.setCategoria(categoria);
  }

  /**
   * Lanza una ventana con una pregunta
   * 
   * @param observador
   *          al responder la pregunta se activará el método 'correcto' o
   *          'incorrecto' de los observadores
   */
  public Pregunta lanzarPregunta() {
    return panelPregunta.lanzarPregunta();
  }

  public void cerrarPregunta() {
    panelPregunta.cerrarPregunta();
  }

  /**
   * Lanza la ventana que permite seleccionar una pregunta.
   */
  public static void lanzarVentanaSeleccion(Categorizable categorizable) {
    try {
      FxPanelSeleccion controllerSeleccion =
          new FxPanelSeleccion(categorizable);
      controllerSeleccion.lanzarVentanaSeleccion();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ObservadoresPregunta getObservadoresPregunta() {
    return observadoresPregunta;
  }
}