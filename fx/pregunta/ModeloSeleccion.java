package pregunta;

import java.io.IOException;
import java.nio.file.Path;

import javafx.scene.control.ListView;

public class ModeloSeleccion {
  private final FxModeloSeleccion modelo;

  public ModeloSeleccion(ListView<String> list, Path ruta) throws IOException {
    this.modelo = new FxModeloSeleccion(list, ruta);
  }
  
  public String getSelected() {
    return this.modelo.getSelected();
  }
}