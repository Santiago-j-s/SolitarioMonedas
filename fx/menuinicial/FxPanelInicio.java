package menuinicial;

import java.awt.EventQueue;

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
  private String categoria = "preguntas";

  @FXML
  private Button categoriaButton;
  @FXML
  private Button juegoButton;

  public FxPanelInicio() {
    Platform.runLater(() -> {
      FxUtilities.initScene("panelInicio.fxml", this, fxPanel);
    });
  }
  
  public JFXPanel getPanel() {
    return fxPanel;
  }

  public VentanaPrincipal getVentana() {
    return (VentanaPrincipal) fxPanel.getTopLevelAncestor();
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
      new ManejadorJuego(this.getCategoria(), getVentana());
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
