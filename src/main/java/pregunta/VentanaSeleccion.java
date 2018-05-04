package pregunta;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class VentanaSeleccion {
  private JFrame frame;
  
  public VentanaSeleccion(JFXPanel panel) {
    frame = new JFrame("Seleccionar Categoría");
    frame.add(panel);
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    Platform.runLater(() -> {
      SwingUtilities.invokeLater(() -> {
        frame.pack();
      });
    });
  }
}
