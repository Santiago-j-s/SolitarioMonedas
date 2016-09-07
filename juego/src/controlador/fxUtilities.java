package controlador;

import java.io.IOException;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class fxUtilities {
  public static Scene initScene(String path, Object controller)
      throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setController(controller);
    loader.setLocation(controller.getClass().getResource(path));
    Scene scene;
    scene = new Scene(loader.load());
    return scene;
  }

  public static void initScene(String path, Object controller, JFXPanel panel) {
    try {
      panel.setScene(initScene(path, controller));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
