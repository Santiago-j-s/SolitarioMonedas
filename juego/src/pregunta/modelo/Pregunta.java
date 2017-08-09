package pregunta.modelo;

import java.util.ArrayList;

/**
 * Una pregunta con 3 opciones posibles de respuesta
 * 
 * @author Dibez, Santana
 */
public class Pregunta {
  public final String enunciado;
  public ArrayList<Opcion> opciones = new ArrayList<Opcion>();

  public Pregunta(String enunciado, String opcion1, String opcion2,
      String opcion3) {
    this.enunciado = enunciado;
    this.opciones.add(new Opcion(opcion1, true));
    this.opciones.add(new Opcion(opcion2, false));
    this.opciones.add(new Opcion(opcion3, false));
  }

  public Boolean correcta(String s) {
    String respuesta = this.opciones.get(0).getTituloOpcion();
    return respuesta.equals(s);
  }
}
