package pregunta;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;

public class FxPanelPregunta {

  private JFXPanel fxPanel;
  private Pregunta pregunta;
  @FXML
  private Label title;
  @FXML
  private Button opcion1Button;
  @FXML
  private Button opcion2Button;
  @FXML
  private Button opcion3Button;

  public JFXPanel start(Pregunta pregunta) {
    this.fxPanel = new JFXPanel();
    this.pregunta = pregunta;

    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        initFx();
      }
    });

    return fxPanel;
  }

  public void setearPregunta(Pregunta pregunta) {
    this.title.setText(pregunta.getPregunta());
    this.opcion1Button.setText(pregunta.getOpcion1().toString());
    this.opcion2Button.setText(pregunta.getOpcion2().toString());
    this.opcion3Button.setText(pregunta.getOpcion3().toString());
  }

  private void initFx() {
    abrirVentana("Juego Principal", "panelPregunta.fxml");
  }

  @FXML
  private void initialize() {
    this.setearPregunta(new Pregunta("a", "b", "c", "d"));
  }

  private void abrirVentana(String titulo, String panelFXML) {
    FXMLLoader loader = new FXMLLoader();
    try {
      loader
          .setLocation(getClass().getResource("panelPregunta.fxml"));
      DialogPane dialog = (DialogPane) loader.load();

      Scene scene = new Scene(dialog);
      fxPanel.setScene(scene);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
