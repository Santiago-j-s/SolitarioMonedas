package pregunta;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.control.ListView;

public class FxModeloSeleccionTest {
  
  private FxModeloSeleccion modelo;
  private ListView<String> listView = new ListView<String>();
  
  @Before
  public void setUp() throws IOException {
    modelo = new FxModeloSeleccion(this.listView);
  }
  
  @Test
  public void testObtenerCategorias() throws IOException { 
    List<String> lista = modelo.obtenerCategorias();
    assertEquals("preguntas2", lista.get(0));
  }
}
