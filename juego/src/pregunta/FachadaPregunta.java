package pregunta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Clase que muestra una pregunta en pantalla y las opciones disponibles para
 * responderla.
 *
 * @author Dibez, Santana
 *
 */
public class FachadaPregunta implements ActionListener {

  private HistoricoPreguntas preguntas;
  private Pregunta preguntaActual;
  private ObservadorPregunta observador;
  private VentanaPregunta frame;

  /**
   * Inicializa las preguntas
   */
  public FachadaPregunta() {
    this.preguntas = new HistoricoPreguntas("preguntas");
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
  public void lanzarPregunta(ObservadorPregunta observador) {
    preguntaActual = this.preguntas.sortearPregunta();
    PanelPregunta panel = new PanelPregunta(preguntaActual);

    this.observador = observador;

    panel.getBotones().forEach(boton -> boton.addActionListener(this));

    frame = new VentanaPregunta(panel);
  }

  private void cerrarVentana() {
    this.frame.cerrar();
  }
}