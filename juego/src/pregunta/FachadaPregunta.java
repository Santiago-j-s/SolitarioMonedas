package pregunta;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.embed.swing.JFXPanel;

/**
 * Clase que muestra una pregunta en pantalla y las opciones disponibles para
 * responderla.
 *
 * @author Dibez, Santana
 *
 */
public class FachadaPregunta {

  private final Preguntas preguntas;
  private Pregunta preguntaActual;
  private final FxPanelPregunta app;
  private final JFXPanel panel;
  private final List<Observador> observadores = new ArrayList<Observador>();
  private VentanaPregunta ventana;

  /**
   * Inicializa las preguntas
   */
  public FachadaPregunta(String filename) {
    preguntas = new Preguntas(filename);
    app = new FxPanelPregunta(this);
    panel = app.start();
  }

  /**
   * Lanza una ventana con una pregunta
   * 
   * @param observador al responder la pregunta se activará 
   *  el método 'correcto' o 'incorrecto' de los observadores
   */
  public Pregunta lanzarPregunta() {
    preguntaActual = this.preguntas.sortearPregunta();
    app.setPregunta(preguntaActual);
    ventana = new VentanaPregunta(panel);
    return preguntaActual;
  }
  
  public void cerrarPregunta() {
    ventana.cerrar();
  }
  
  public void addObservador(Observador o) {
    observadores.add(o);
  }
  
  public void removeObservador(Observador o) {
    observadores.remove(o);
  }
  
  public void removeAllObservadores() {
    observadores.clear();
  }
  
  public void correcto() {
    observadores.forEach(Observador::correcto);
  }
  
  public void incorrecto() {
    observadores.forEach(Observador::incorrecto);
  }
  
  /**
   * Lanza la ventana que permite seleccionar una pregunta.
   */
  public static void lanzarSeleccion() {
    Path path = Paths.get("juego", "src", "recursos", "preguntas");
    try {
      JFXPanel panel = new FxPanelSeleccion(path).start();
      new VentanaSeleccion(panel);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}