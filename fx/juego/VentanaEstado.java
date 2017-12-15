package juego;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class VentanaEstado {
  private JFrame frame;

  VentanaEstado(JFXPanel panel) {
    frame = new JFrame("Estadísticas");
    frame.add(panel);
    frame.setResizable(true);
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    Platform.runLater(() -> {
      SwingUtilities.invokeLater(() -> {
        frame.pack();
      });
    });
  }

  void cerrar() {
    this.frame.dispose();
  }
}
