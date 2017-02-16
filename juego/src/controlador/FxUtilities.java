package controlador;

import java.io.IOException;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class FxUtilities {
  public static Scene initScene(String path, Object controller) {
    FXMLLoader loader = new FXMLLoader();
    loader.setController(controller);
    loader.setLocation(controller.getClass().getResource(path));
    Scene scene = null;
    
    try {
      scene = new Scene(loader.load());
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    return scene;
  }

  public static void initScene(String path, Object controller, JFXPanel panel) {
    Scene scene = initScene(path, controller);
    panel.setScene(scene);
  }
}
