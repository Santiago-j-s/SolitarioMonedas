package fx.menuinicial;

import java.awt.EventQueue;

import controlador.ManejadorJuego;
import controlador.FxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import menuinicial.VentanaPrincipal;
import pregunta.modelo.Categorizable;
import pregunta.FachadaPregunta;

public class FxPanelInicio implements Categorizable {
  private JFXPanel fxPanel = new JFXPanel();
  private String categoriaInicial = "patrones";

  @FXML
  private Button categoriaButton;
  @FXML
  private Button juegoButton;

  public FxPanelInicio() {
    Platform.runLater(() -> {
      FxUtilities.initScene("/fx/panelInicio.fxml", this, fxPanel);
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
      new ManejadorJuego(this.getCategoriaInicial(), getVentana());
    });
  }

  @Override
  public void setCategoriaInicial(String categoriaInicial) {
    this.categoriaInicial = categoriaInicial;
  }

  @Override
  public String getCategoriaInicial() {
    return this.categoriaInicial;
  }
}
