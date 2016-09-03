package pregunta;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

class VentanaPregunta {

  private JFrame frame;

  VentanaPregunta(JFXPanel panel) {
    frame = new JFrame("Pregunta");
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.add(panel);
    frame.setResizable(true);
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.pack();
    /**
     * The size of the frame is setted manually. .pack() doesn't work because of
     * a race condition between the Event Dispatch Thread and the JavaFx thread.
     */
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
