package pregunta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class FxModeloSeleccion {
  private final ListProperty<String> listaCategorias;
  
  public FxModeloSeleccion(Path ruta) throws IOException {
    listaCategorias = new SimpleListProperty<String>();
    List<String> categorias = obtenerCategorias(ruta);
    listaCategorias.set(FXCollections.observableArrayList(categorias));
  }
  
  // Returns the filenames in 'ruta' without extensions
  List<String> obtenerCategorias(Path ruta) throws IOException {
    List<String> categorias = Files.list(ruta)
        .map(c -> c.getFileName().toString().split("\\.(?=[^\\.]+$)")[0])
        .collect(Collectors.toList());
    return categorias;
  }
  
  public void bind(ListView<String> list) {
    list.setItems(listaCategorias);
  }
}
