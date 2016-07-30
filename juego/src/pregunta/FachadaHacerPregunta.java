package pregunta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Clase con observadores que muestra una pregunta en pantalla. Si la pregunta
 * es respondida correctamente lanza el método 'correcto' de sus observadores.
 * Si la pregunta es respondida incorrectamente lanza el método
 * 'incorrecto'
 *
 * @author Dibez, Santana
 *
 */
public class FachadaHacerPregunta implements ActionListener {

  private HistoricoPreguntas preguntas;
  private Pregunta preguntaActual;
  private ObservadorPregunta observador;
  private VentanaPregunta frame;
  /**
   * Constructor
   * 
   */
  public FachadaHacerPregunta() {
    this.preguntas = new HistoricoPreguntas();
  }
  
  public void actionPerformed(ActionEvent e) {
    String respuesta = ((JButton) e.getSource()).getText();
    
    if (preguntaActual.correcta(respuesta)) {
      this.observador.correcto();
    } else {
      this.observador.incorrecto();
    }
  }

  public void lanzarPregunta(ObservadorPregunta observadorPregunta) {
    preguntaActual = this.preguntas.sortearPregunta();
    PanelPregunta panel = new PanelPregunta(preguntaActual);
    
    this.observador = observadorPregunta;
    
    panel.getBotones().forEach(
        boton -> boton.addActionListener(this)
    );
    
    frame = new VentanaPregunta(panel);
  }
  
  public void cerrarVentana() {
    if (this.frame != null) {
      this.frame.cerrar();
    }
  }
}