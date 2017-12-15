package menuinicial;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controlador.FxUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;

public class FxAyuda {
  public class FxPanelAutores {
    class VentanaAyuda {
      JDialog dialog = new JDialog();

      VentanaAyuda(JFXPanel panel) {
        dialog.setAlwaysOnTop(true);
        dialog.setLocationByPlatform(true);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.add(panel);
        Platform.runLater(() -> {
          SwingUtilities.invokeLater(() -> {
            dialog.setMinimumSize(new Dimension(800, 600));
            dialog.setResizable(false);
            dialog.setVisible(true);
          });
        });
      }
    }

    @FXML
    private WebView web;
    
    public void FxAyuda() {
      JFXPanel fxPanel = new JFXPanel();
      web.getEngine().load(getClass().getResource("/solitario.html").toString());
      Platform.runLater(() -> {
        FxUtilities.initScene("ayuda.fxml", this, fxPanel);
      });
      new VentanaAyuda(fxPanel);
    }
  }
}
