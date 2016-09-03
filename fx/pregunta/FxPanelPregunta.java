package pregunta;

import java.io.IOException;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
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
      initScene("panelPregunta.fxml");
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
    title.textProperty().bind(modelo.getPropertyPregunta());
    opcion1Button.textProperty().bind(modelo.getPropertyOpcion1());
    opcion2Button.textProperty().bind(modelo.getPropertyOpcion2());
    opcion3Button.textProperty().bind(modelo.getPropertyOpcion3());
  }

  private void initScene(String panelFXML) {
    FXMLLoader loader = new FXMLLoader();
    try {
      loader.setController(this);
      loader.setLocation(getClass().getResource(panelFXML));
      DialogPane dialog = (DialogPane) loader.load();
      Scene scene = new Scene(dialog);
      fxPanel.setScene(scene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
