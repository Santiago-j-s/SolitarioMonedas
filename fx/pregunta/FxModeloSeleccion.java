package pregunta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import vista.Recursos;

public class FxModeloSeleccion {
  private final ListProperty<String> listaCategorias =
      new SimpleListProperty<String>(FXCollections.observableArrayList());
  
  private final ListView<String> listView;
  private final Logger logger = Logger.getLogger(getClass().getName());
  
  
  public FxModeloSeleccion(ListView<String> list) throws IOException {
    this.listView = list;
    this.inicializarCategorias();
    this.bind();
  }
  
  public String getSelected() {
    String elementoSeleccionado = listView.getSelectionModel().getSelectedItem();
    
    if(elementoSeleccionado == null) {
      elementoSeleccionado = this.listaCategorias.get(0);
    }
    
    logger.info(String.format("Elemento Seleccionado: %s", elementoSeleccionado));
    return elementoSeleccionado;
  }

  private void inicializarCategorias() throws IOException {
    List<String> categorias = obtenerCategorias();
    logger.info(String.format("Categorias iniciales: %s", categorias.toString()));
    listaCategorias.addAll(categorias);
  }
  
  private String nombreArchivoSinExtension(Path path) {
    return path.getFileName().toString().split("\\.(?=[^\\.]+$)")[0];
  }
  
  // Returns the filenames without extensions
  List<String> obtenerCategorias() throws IOException {
    List<String> categorias = Files.list(Recursos.PREGUNTAS_PATH)
        .map(c -> nombreArchivoSinExtension(c))
        .collect(Collectors.toList());
    
    return categorias;
  }
  
  private void bind() {
    this.listView.setItems(listaCategorias);
  }
}
