package menuinicial;

import java.awt.Container;

import controlador.ManejadorJuego;
import controlador.fxUtilities;
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

  private void start(JFXPanel panel) {
    fxUtilities.initScene("panelInicio.fxml", this, panel);
  }

  public JFXPanel getPanel() {
    this.fxPanel = new JFXPanel();
    start(this.fxPanel);
    return fxPanel;
  }
  
  private Container getVentana() {
    return fxPanel.getTopLevelAncestor();
  }

  @FXML
  public void listCategorias(ActionEvent e) {
    FachadaPregunta.lanzarSeleccion();
  }

  @FXML
  public void comenzarJuego(ActionEvent e) {
    new ManejadorJuego((VentanaPrincipal) getVentana());
  }
}
