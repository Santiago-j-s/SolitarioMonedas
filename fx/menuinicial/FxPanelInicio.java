package menuinicial;

import java.io.IOException;

import javax.swing.SwingUtilities;

import controlador.ManejadorJuego;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class FxPanelInicio {
  private final JFXPanel fxPanel = new JFXPanel();

  @FXML
  private Button categoria;
  @FXML
  private Button juego;

  public JFXPanel start() {
    Platform.runLater(() -> {
      initScene("panelInicio.fxml");
    });

    return fxPanel;
  }

  public void initialize() {
  }

  public void listCategorias(ActionEvent e) {
  }

  public void comenzarJuego(ActionEvent e) {
    SwingUtilities.invokeLater(() -> {
      new ManejadorJuego(false,
          (VentanaPrincipal) fxPanel.getTopLevelAncestor());
    });
  }

  private void initScene(String path) {
    FXMLLoader loader = new FXMLLoader();
    try {
      loader.setController(this);
      loader.setLocation(getClass().getResource(path));
      AnchorPane anchor = (AnchorPane) loader.load();
      Scene scene = new Scene(anchor);
      fxPanel.setScene(scene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
