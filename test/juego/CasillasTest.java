package juego;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CasillasTest {
  private Casillas casillas;
  private List<Integer> indexes;
  private List<Integer> correctIndexes = Arrays.asList(0, 24, 5);
  
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Before
  public void setUp() {
    casillas = new Casillas(5, 5);
    indexes = new ArrayList<Integer>();
  }

  @Test
  public void test() {
    indexes.add(casillas.getIndex(0, 0));
    indexes.add(casillas.getIndex(4, 4));
    indexes.add(casillas.getIndex(1, 0));
    for (int i = 1; i < indexes.size(); i++) {
      assertEquals(correctIndexes.get(i), indexes.get(i));
    }
  }
  
  @Test
  public void testSaltos() {
    Casilla casilla = casillas.getCasilla(0, 0);
    casilla.saltar(Direccion.Abajo);
    assertEquals(2, casilla.fila);
    assertEquals(0, casilla.columna);
    casilla.saltar(Direccion.Derecha);
    assertEquals(2, casilla.fila);
    assertEquals(2, casilla.columna);
    casilla.saltar(Direccion.Derecha);
    assertEquals(2, casilla.fila);
    assertEquals(4, casilla.columna);
    casilla.saltar(Direccion.Izquierda);
    assertEquals(2, casilla.fila);
    assertEquals(2, casilla.columna);
    casilla.saltar(Direccion.Arriba);
    assertEquals(0, casilla.fila);
    assertEquals(2, casilla.columna);
    casilla.saltar(Direccion.Derecha);
    assertEquals(0, casilla.fila);
    assertEquals(4, casilla.columna);
  }

}
