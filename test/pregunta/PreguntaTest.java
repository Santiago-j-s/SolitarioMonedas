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

import pregunta.Opcion;
import pregunta.Pregunta;

/**
 * @author santiago
 *
 */
public class PreguntaTest {

  ArrayList<Pregunta> pruebasPregunta = new ArrayList<Pregunta>();
  ArrayList<String> preguntas = new ArrayList<String>();
  ArrayList<List<Opcion>> opciones = new ArrayList<List<Opcion>>();

  private boolean compararOpciones(ArrayList<Pregunta> preguntas,
      ArrayList<List<Opcion>> opciones, int nroOpcion) {
    // Obtiene la primer opción de cada pregunta
    List<Opcion> opcionesPrueba = this.pruebasPregunta
        .stream()
        .map(p -> p.getOpcion(nroOpcion))
        .collect(Collectors.toList());

    // Obtiene el primer item de cada array de opciones
    List<Opcion> opcionesTest = this.opciones
        .stream()
        .map(o -> o.get(nroOpcion-1))
        .collect(Collectors.toList());
    
    return opcionesPrueba.equals(opcionesTest);
  }

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
   * Test method for
   * {@link pregunta.Pregunta#Pregunta(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
   * .
   */
  @Test
  public void testPreguntaStringStringStringString() {
    int i = 0;
    for (Pregunta pregunta : this.pruebasPregunta) {
      assertEquals(this.preguntas.get(i), pregunta.getPregunta());
      assertEquals(this.opciones.get(i).get(0), pregunta.getOpcion1());
      assertEquals(this.opciones.get(i).get(1), pregunta.getOpcion2());
      assertEquals(this.opciones.get(i).get(2), pregunta.getOpcion3());
      i++;
    }
  }

  /**
   * Test method for {@link pregunta.Pregunta#getPregunta()}.
   */
  @Test
  public void testGetPregunta() {
    // Retorna los enunciados de las preguntas
    List<String> preguntas2 = this.pruebasPregunta.stream()
        .map(p -> p.getPregunta()).collect(Collectors.toList());

    assertEquals(this.preguntas, preguntas2);
  }

  /**
   * Test method for {@link pregunta.Pregunta#getOpcion1()}.
   */
  @Test
  public void testGetOpcion1() {
    assertTrue(compararOpciones(pruebasPregunta, opciones, 1));
  }

  /**
   * Test method for {@link pregunta.Pregunta#getOpcion2()}.
   */
  @Test
  public void testGetOpcion2() {
    assertTrue(compararOpciones(pruebasPregunta, opciones, 2));
  }

  /**
   * Test method for {@link pregunta.Pregunta#getOpcion3()}.
   */
  @Test
  public void testGetOpcion3() {
    assertTrue(compararOpciones(pruebasPregunta, opciones, 3));
  }

  /**
   * Test method for {@link pregunta.Pregunta#correcta(java.lang.String)}.
   */
  @Test
  public void testCorrecta() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    assertTrue(pregunta.correcta("Respuesta"));
    assertFalse(pregunta.correcta("NoRespuesta"));
    assertFalse(pregunta.correcta("RespuestaNo"));
  }

  /**
   * Test method for {@link pregunta.Pregunta#setPregunta(java.lang.String)}.
   */
  @Test
  public void testSetPregunta() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    pregunta.setPregunta("NuevaPregunta");
    assertEquals("NuevaPregunta", pregunta.getPregunta());
  }

  /**
   * Test method for
   * {@link pregunta.Pregunta#setOpciones(java.lang.String, java.lang.String, java.lang.String)}
   * .
   */
  @Test
  public void testSetOpciones() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    pregunta.setOpciones("NuevaOpción1", "NuevaOpción2", "NuevaOpción3");
    assertEquals("NuevaOpción1", pregunta.getOpcion1().toString());
    assertEquals("NuevaOpción2", pregunta.getOpcion2().toString());
    assertEquals("NuevaOpción3", pregunta.getOpcion3().toString());
  }
}
