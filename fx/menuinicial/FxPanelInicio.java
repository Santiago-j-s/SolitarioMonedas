package menuinicial;

import java.awt.Container;
import java.awt.EventQueue;
import java.util.logging.Logger;

import controlador.ManejadorJuego;
import controlador.FxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pregunta.FachadaPregunta;

public class FxPanelInicio {
  private JFXPanel fxPanel = new JFXPanel();
  private final Logger logger = Logger.getLogger(getClass().getName());

  @FXML
  private Button categoria;
  @FXML
  private Button juego;

  public FxPanelInicio() {
    logger.info("Nuevo Panel Inicio");
    Platform.runLater(() -> {
      logger.info("start.runlater");
      FxUtilities.initScene("panelInicio.fxml", this, fxPanel);
    });
  }
  
  public JFXPanel getPanel() {
    logger.info("getPanel");
    return fxPanel;
  }

  private Container getVentana() {
    return fxPanel.getTopLevelAncestor();
  }

  @FXML
  public void listCategorias(ActionEvent e) {
    EventQueue.invokeLater(() -> {
      FachadaPregunta.lanzarSeleccion();
    });
  }

  @FXML
  public void comenzarJuego(ActionEvent e) {
    EventQueue.invokeLater(() -> {
      Container ventana = getVentana();
      new ManejadorJuego("preguntas", (VentanaPrincipal) ventana);
    });
  }
}
