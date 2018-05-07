package fx.juego;

import controlador.FxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import juego.Estado;

public class FxEstadisticas {
  private final JFXPanel fxPanel = new JFXPanel();
  private final FxModeloEstadisticas modelo = new FxModeloEstadisticas();
  private VentanaEstado ventana;
  
  @FXML
  private Label mensaje;
  @FXML
  private Label saltos;
  @FXML
  private Label aciertos;
  @FXML
  private Label fallos;
  @FXML
  private Button aceptar;
  
  public FxEstadisticas() {
    this.start();
  }
  
  public void start() {
    Platform.runLater(() -> {
      FxUtilities.initScene("/fx/estadisticas.fxml", this, fxPanel);
    });
  }

  public void setEstado(Estado estado, String mensaje) {
    Platform.runLater(() -> {
      modelo.setProperties(estado, mensaje);
    });
  }

  public void lanzarEstadisticas(Estado estado, String mensaje) {
    this.setEstado(estado, mensaje);
    this.ventana = new VentanaEstado(fxPanel);
  }
  
  @FXML
  public void cerrar(ActionEvent e) {
    ventana.cerrar();
  }
  
  public void initialize() {
    modelo.bind(mensaje.textProperty(),
                saltos.textProperty(),
                aciertos.textProperty(),
                fallos.textProperty()
        );
  }
}
