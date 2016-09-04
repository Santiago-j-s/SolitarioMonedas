package pregunta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javafx.embed.swing.JFXPanel;

/**
 * Clase que muestra una pregunta en pantalla y las opciones disponibles para
 * responderla.
 *
 * @author Dibez, Santana
 *
 */
public class FachadaPregunta implements ActionListener {

  private Preguntas preguntas;
  private Pregunta preguntaActual;
  private ObservadorPregunta observador;
  private VentanaPregunta frame;
  private FxPanelPregunta app;
  private JFXPanel panel;

  /**
   * Inicializa las preguntas
   */
  public FachadaPregunta() {
    this.preguntas = new Preguntas("preguntas");
    this.app = new FxPanelPregunta();
    panel = this.app.start();
  }

  /**
   * Al responder una pregunta se activa este método.
   * 
   * @param e
   *          Evento que lanza el método
   */
  public void actionPerformed(ActionEvent e) {
    String respuesta = ((JButton) e.getSource()).getText();
    this.cerrarVentana();

    if (preguntaActual.correcta(respuesta)) {
      this.observador.correcto();
    } else {
      this.observador.incorrecto();
    }
  }

  /**
   * Lanza una ventana con una pregunta
   * 
   * @param observador
   *          Al responder la pregunta se activará el método 'correcto' o
   *          'incorrecto' del observador
   */
  
  public Pregunta lanzarPregunta()//ObservadorPregunta observador) {
  {
    this.preguntaActual = this.preguntas.sortearPregunta();
    this.app.setPregunta(preguntaActual);
    frame = new VentanaPregunta(panel);
    return this.preguntaActual;
  }
 
//  public String getPregunta

  private void cerrarVentana() {
    this.frame.cerrar();
  }
}