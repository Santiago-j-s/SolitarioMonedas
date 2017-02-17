package pregunta;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

import controlador.FxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class FxPanelSeleccion {
  private final JFXPanel fxPanel = new JFXPanel();
  private ModeloSeleccion modelo;
  private final Categorizable categorizable;

  @FXML
  private ListView<String> listView;
  @FXML
  private Button iniciarJuego;

  public FxPanelSeleccion(Categorizable categorizable) throws IOException {
    this.start();
    this.categorizable = categorizable;
  }
  
  @FXML
  public void setCategoria() {
    EventQueue.invokeLater(() -> {
      this.categorizable.setCategoria(this.getCategoria());
      ((JFrame) fxPanel.getTopLevelAncestor()).dispose();
    });
  }
  
  public String getCategoria() {
    return this.modelo.getSelected();
  }

  public void start() {
    Platform.runLater(() -> {
      FxUtilities.initScene("panelSeleccion.fxml", this, fxPanel);
      try {
        this.modelo = new ModeloSeleccion(listView);
      } catch (IOException e) {
        System.exit(1);
        e.printStackTrace();
      }
    });
  }
  
  public JFXPanel getPanel() {
    return fxPanel;
  }
  
  public void lanzarVentanaSeleccion() {
    new VentanaSeleccion(this.fxPanel);
  }
}
