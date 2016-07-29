/**
 * 
 */
package juego;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
   * Test method for
   * {@link juego.Pregunta#Pregunta(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
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
   * Test method for {@link juego.Pregunta#getPregunta()}.
   */
  @Test
  public void testGetPregunta() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    assertEquals("¿Prueba1?", pregunta.getPregunta());
  }

  /**
   * Test method for {@link juego.Pregunta#getOpcion1()}.
   */
  @Test
  public void testGetOpcion1() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    assertEquals("Respuesta", pregunta.getOpcion1().toString());
  }

  /**
   * Test method for {@link juego.Pregunta#getOpcion2()}.
   */
  @Test
  public void testGetOpcion2() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    assertEquals("Opción2", pregunta.getOpcion2().toString());
  }

  /**
   * Test method for {@link juego.Pregunta#getOpcion3()}.
   */
  @Test
  public void testGetOpcion3() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    assertEquals("Opción3", pregunta.getOpcion3().toString());
  }

  /**
   * Test method for {@link juego.Pregunta#correcta(java.lang.String)}.
   */
  @Test
  public void testCorrecta() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    assertTrue(pregunta.correcta("Respuesta"));
  }

  /**
   * Test method for {@link juego.Pregunta#setPregunta(java.lang.String)}.
   */
  @Test
  public void testSetPregunta() {
    Pregunta pregunta = this.pruebasPregunta.get(0);
    pregunta.setPregunta("NuevaPregunta");
    assertEquals("NuevaPregunta", pregunta.getPregunta());
  }

  /**
   * Test method for
   * {@link juego.Pregunta#setOpciones(java.lang.String, java.lang.String, java.lang.String)}
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
