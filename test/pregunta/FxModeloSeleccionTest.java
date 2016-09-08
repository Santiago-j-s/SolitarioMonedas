package pregunta;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FxModeloSeleccionTest {
  
  private FxModeloSeleccion modelo;
  Path path;
  
  @Before
  public void setUp() throws IOException {
    path = Paths.get("juego", "src", "recursos", "preguntas");
    modelo = new FxModeloSeleccion(path);
  }
  
  @Test
  public void testObtenerCategorias() throws IOException { 
    List<String> lista = modelo.obtenerCategorias(path);
    assertEquals("preguntas2.json", lista.get(0));
  }
}
