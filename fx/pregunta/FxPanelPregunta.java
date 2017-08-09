package pregunta;

import java.util.logging.Logger;

import controlador.FxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pregunta.modelo.Pregunta;
import pregunta.modelo.Preguntas;

public class FxPanelPregunta {
  private final JFXPanel fxPanel = new JFXPanel();
  private final FxModeloPregunta modelo = new FxModeloPregunta();
  private final FachadaPregunta controlador;
  private final Preguntas preguntas = new Preguntas();
  private VentanaPregunta ventana;
  private final Logger logger = Logger.getLogger(getClass().getName());

  @FXML
  private Label title;
  @FXML
  private Button opcion1Button;
  @FXML
  private Button opcion2Button;
  @FXML
  private Button opcion3Button;
  
  public FxPanelPregunta(FachadaPregunta controlador) {
    this.controlador = controlador;
    this.start();
  }

  public void start() {
    Platform.runLater(() -> {
      FxUtilities.initScene("panelPregunta.fxml", this, fxPanel);
    });
  }

  public void setPregunta(Pregunta pregunta) {
    Platform.runLater(() -> {
      modelo.setProperties(pregunta);
    });
  }
  
  public Pregunta lanzarPregunta() {
    Pregunta preguntaActual = this.preguntas.sortearPregunta();
    this.setPregunta(preguntaActual);
    ventana = new VentanaPregunta(fxPanel);
    return preguntaActual;
  }
  
  public void cerrarPregunta() {
    ventana.cerrar();
  }
  
  public String getCategoria() {
    return this.preguntas.getCategoria();
  }
  
  public void setCategoria(String categoria) {
    this.preguntas.setCategoria(categoria);
  }
  
  @FXML
  public void onAction(ActionEvent e) {
    Button b = (Button) e.getSource();
    logger.info("Respuesta Seleccionada: " + b.getText());
    boolean correcta = modelo.correcta(b.getText());
    if(correcta) {
      controlador.getObservadoresPregunta().notifyCorrecto();
    } else {
      controlador.getObservadoresPregunta().notifyIncorrecto();
    }
  }

  public void initialize() {
    modelo.bind(title.textProperty(), opcion1Button.textProperty(),
        opcion2Button.textProperty(), opcion3Button.textProperty());
  }
}
