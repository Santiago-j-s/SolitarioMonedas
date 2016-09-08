package menuinicial;

import javax.swing.SwingUtilities;

import controlador.ManejadorJuego;
import controlador.fxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pregunta.FachadaPregunta;

public class FxPanelInicio {
  private JFXPanel fxPanel;

  @FXML
  private Button categoria;
  @FXML
  private Button juego;

  private void start() {
    fxPanel = new JFXPanel();
    Platform.runLater(() -> {
      fxUtilities.initScene("panelInicio.fxml", this, fxPanel);
    });
  }

  public JFXPanel getPanel() {
    this.fxPanel = new JFXPanel();
    start();
    return fxPanel;
  }

  public void initialize() {
  }

  public void listCategorias(ActionEvent e) {
    FachadaPregunta.lanzarSeleccion();
  }

  public void comenzarJuego(ActionEvent e) {
    SwingUtilities.invokeLater(() -> {
      new ManejadorJuego((VentanaPrincipal) fxPanel.getTopLevelAncestor());
    });
  }
}
