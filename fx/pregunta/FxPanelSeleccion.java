package pregunta;

import java.io.IOException;
import java.nio.file.Path;

import controlador.fxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class FxPanelSeleccion {
  private final JFXPanel fxPanel = new JFXPanel();
  private final FxModeloSeleccion modelo;

  @FXML
  private ListView<String> listView;
  @FXML
  private Button iniciarJuego;

  public FxPanelSeleccion(Path ruta) throws IOException {
    modelo = new FxModeloSeleccion(ruta);
  }
  
  /*
  @FXML
  public void comenzarJuego() {
    EventQueue.invokeLater(() -> {
      new ManejadorJuego(listView.getSelectionModel().getSelectedItem(),
          (VentanaPrincipal) fxPanel.getTopLevelAncestor());
    });
  }
  */

  public JFXPanel start() {
    Platform.runLater(() -> {
      fxUtilities.initScene("panelSeleccion.fxml", this, fxPanel);
    });
    return fxPanel;
  }

  public void initialize() {
    modelo.bind(listView);
  }
}
