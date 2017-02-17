package pregunta;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import vista.Recursos;

public class FxModeloSeleccion {
  private final ListProperty<String> listaCategorias = new SimpleListProperty<String>();
  private final ListView<String> listView;
  
  
  public FxModeloSeleccion(ListView<String> list) throws IOException {
    this.listView = list;
    this.setCategorias();
    this.bind();
  }
  
  public String getSelected() {
    return this.listView.getSelectionModel().getSelectedItem();
  }

  private void setCategorias() throws IOException {
    List<String> categorias = obtenerCategorias();
    listaCategorias.set(FXCollections.observableArrayList(categorias));
  }
  
  // Returns the filenames without extensions
  List<String> obtenerCategorias() throws IOException {
    List<String> categorias = Files.list(Recursos.PREGUNTAS_PATH)
        .map(c -> c.getFileName().toString().split("\\.(?=[^\\.]+$)")[0])
        .collect(Collectors.toList());
    return categorias;
  }
  
  private void bind() {
    this.listView.setItems(listaCategorias);
  }
}
