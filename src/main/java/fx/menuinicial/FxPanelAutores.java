package fx.menuinicial;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controlador.FxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class FxPanelAutores {
  class VentanaAutores {
    JDialog dialog = new JDialog();
    
    VentanaAutores(JFXPanel panel) {
      dialog.setAlwaysOnTop(true);
      dialog.setLocationByPlatform(true);
      dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dialog.setResizable(false);
      dialog.add(panel);
      Platform.runLater(() -> {
        SwingUtilities.invokeLater(() -> {
          dialog.setMinimumSize(new Dimension(500, 272));
          dialog.pack();
          dialog.setVisible(true);
        });
      });
    }
  }
  
  public FxPanelAutores() {
    JFXPanel fxPanel = new JFXPanel();
    Platform.runLater(() -> {
      FxUtilities.initScene("autores.fxml", this, fxPanel);
    });
    new VentanaAutores(fxPanel);
  }
}
