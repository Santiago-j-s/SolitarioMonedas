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
  @FXML
  private WebView web;

  class VentanaAyuda {
    JDialog dialog = new JDialog();

    VentanaAyuda(JFXPanel panel) {
      dialog.setAlwaysOnTop(true);
      dialog.setLocationByPlatform(true);
      dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dialog.setResizable(false);
      dialog.add(panel);
      Platform.runLater(() -> {
        SwingUtilities.invokeLater(() -> {
          dialog.setMinimumSize(new Dimension(800, 600));
          dialog.pack();
          dialog.setVisible(true);
        });
      });
    }
  }

  public FxAyuda() {
    JFXPanel fxPanel = new JFXPanel();
    Platform.runLater(() -> {
      FxUtilities.initScene("ayuda.fxml", this, fxPanel);
      web.getEngine()
          .load(getClass().getResource("./solitario.html").toString());
    });
    new VentanaAyuda(fxPanel);
  }
}
