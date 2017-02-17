package pregunta;

import java.io.IOException;
import java.util.ArrayList;

import vista.Recursos;

/**
 * Clase que muestra una pregunta en pantalla y las opciones disponibles para
 * responderla.
 *
 * @author Dibez, Santana
 *
 */
public class FachadaPregunta {
  private ObservadoresPregunta observadoresPregunta = new ObservadoresPregunta(new ArrayList<Observador>());
  private final FxPanelPregunta panelPregunta;

  /**
   * Inicializa las preguntas
   */
  public FachadaPregunta() {
    panelPregunta = new FxPanelPregunta(this);
  }

  /**
   * Lanza una ventana con una pregunta
   * 
   * @param observador al responder la pregunta se activará 
   *  el método 'correcto' o 'incorrecto' de los observadores
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
      FxPanelSeleccion controllerSeleccion = new FxPanelSeleccion(categorizable);
      controllerSeleccion.lanzarVentanaSeleccion();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public String getCategoria() {
    return panelPregunta.getCategoria();
  }

  public void setCategoria(String categoria) {
    panelPregunta.setCategoria(categoria);
  }

  public ObservadoresPregunta getObservadoresPregunta() {
    return observadoresPregunta;
  }
}