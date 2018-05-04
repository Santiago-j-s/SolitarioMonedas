package fx.pregunta;

import java.io.IOException;

import javafx.scene.control.ListView;

public class ModeloSeleccion {
  private final FxModeloSeleccion modelo;

  public ModeloSeleccion(ListView<String> list) throws IOException {
    this.modelo = new FxModeloSeleccion(list);
  }
  
  public String getSelected() {
    return this.modelo.getSelected();
  }
}