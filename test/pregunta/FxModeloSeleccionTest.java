package pregunta;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.control.ListView;

public class FxModeloSeleccionTest {
  
  private FxModeloSeleccion modelo;
  private ListView<String> listView = new ListView<String>();
  Path path;
  
  @Before
  public void setUp() throws IOException {
    path = Paths.get("juego", "src", "recursos", "preguntas");
    modelo = new FxModeloSeleccion(this.listView, path);
  }
  
  @Test
  public void testObtenerCategorias() throws IOException { 
    List<String> lista = modelo.obtenerCategorias(path);
    assertEquals("preguntas2", lista.get(0));
  }
  
  @Test(expected = IOException.class)
  public void testObtenerCategorias2() throws IOException {
    path = Paths.get("juego", "src", "recursos", "preguntas2");
    modelo = new FxModeloSeleccion(this.listView, path);
  }
}
