package pregunta;

import controlador.fxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FxPanelPregunta {
  private final JFXPanel fxPanel = new JFXPanel();
  private final FxModeloPregunta modelo = new FxModeloPregunta();

  @FXML
  private Label title;
  @FXML
  private Button opcion1Button;
  @FXML
  private Button opcion2Button;
  @FXML
  private Button opcion3Button;

  public JFXPanel start() {
    Platform.runLater(() -> {
      fxUtilities.initScene("panelPregunta.fxml", this, fxPanel);
    });
    return fxPanel;
  }

  public void setPregunta(Pregunta pregunta) {
    Platform.runLater(() -> {
      modelo.setPregunta(pregunta);
    });
  }

  @FXML
  public void onAction(ActionEvent e) {
    Button b = (Button) e.getSource();
    boolean correcta = modelo.correcta(b.getText());
    if (correcta) {
      modelo.setPregunta("correcta");
    } else {
      modelo.setPregunta("incorrecta");
    }
  }

  public void initialize() {
    modelo.bind(title.textProperty(), opcion1Button.textProperty(),
        opcion2Button.textProperty(), opcion3Button.textProperty());
  }
}
