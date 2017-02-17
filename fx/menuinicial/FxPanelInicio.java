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
import pregunta.Categorizable;
import pregunta.FachadaPregunta;

public class FxPanelInicio implements Categorizable {
  private JFXPanel fxPanel = new JFXPanel();
  private final Logger logger = Logger.getLogger(getClass().getName());
  private String categoria = "preguntas";

  @FXML
  private Button categoriaButton;
  @FXML
  private Button juegoButton;

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

  public Container getVentana() {
    return fxPanel.getTopLevelAncestor();
  }

  @FXML
  public void listCategorias(ActionEvent e) {
    EventQueue.invokeLater(() -> {
      FachadaPregunta.lanzarVentanaSeleccion(this);
    });
  }

  @FXML
  public void comenzarJuego(ActionEvent e) {
    EventQueue.invokeLater(() -> {
      Container ventana = getVentana();
      new ManejadorJuego(this.getCategoria(), (VentanaPrincipal) ventana);
    });
  }

  @Override
  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  @Override
  public String getCategoria() {
    return this.categoria;
  }
}
