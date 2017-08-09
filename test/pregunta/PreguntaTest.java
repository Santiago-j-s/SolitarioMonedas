/**
 * 
 */
package pregunta;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import pregunta.modelo.Opcion;
import pregunta.modelo.Pregunta;

/**
 * @author santiago
 *
 */
public class PreguntaTest {

  ArrayList<Pregunta> pruebasPregunta = new ArrayList<Pregunta>();
  ArrayList<String> preguntas = new ArrayList<String>();
  ArrayList<List<Opcion>> opciones = new ArrayList<List<Opcion>>();

  private ArrayList<Opcion> crearOpciones(String respuesta, String opcion2,
      String opcion3) {
    ArrayList<Opcion> opcionesPregunta = new ArrayList<Opcion>();
    opcionesPregunta.add(new Opcion(respuesta, true));
    opcionesPregunta.add(new Opcion(opcion2, false));
    opcionesPregunta.add(new Opcion(opcion3, false));
    return opcionesPregunta;
  }

  @Before
  public void setUp() {
    this.preguntas.add("¿Prueba1?");
    this.opciones.add(crearOpciones("Respuesta", "Opción2", "Opción3"));
    this.pruebasPregunta
        .add(new Pregunta("¿Prueba1?", "Respuesta", "Opción2", "Opción3"));
  }

  /**
   * Test method for {@link pregunta.modelo.Pregunta#correcta(java.lang.String)}.
   */
  @Test
  public void testCorrecta() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    assertTrue(pregunta.correcta("Respuesta"));
    assertFalse(pregunta.correcta("NoRespuesta"));
    assertFalse(pregunta.correcta("RespuestaNo"));
  }
}
