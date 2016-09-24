package pregunta;

import java.util.ArrayList;
import java.util.List;

/**
 * Una pregunta con 3 opciones posibles de respuesta
 * 
 * @author Dibez, Santana
 *
 */
class Pregunta {
  private String pregunta;
  private ArrayList<Opcion> opciones = new ArrayList<Opcion>();

  /**
   * Constructor
   * 
   * @param pregunta
   *          - La pregunta que el usuario ha de responder
   * @param opcion1
   *          - Primer opción
   * @param opcion2
   *          - Segunda opción
   * @param opcion3
   *          - Tercera opción
   */
  Pregunta(String pregunta, String opcion1, String opcion2,
      String opcion3) {
    this.setPregunta(pregunta);
    this.setOpciones(opcion1, opcion2, opcion3);
  }

  /*
   * Getter de 'pregunta'
   * 
   * @return una cadena con la pregunta
   */
  String getPregunta() {
    return pregunta;
  }

  /*
   * Retorna la opción con el número especificado TODO: Crear una excepción para
   * valores no permitidos
   */
  Opcion getOpcion(int n) {
    return opciones.get(n - 1);
  }
  
  List<Opcion> getOpciones() {
    return opciones;
  }

  /**
   * Getter de 'opción1'
   * 
   * @return la instancia de la primer opción
   */
  Opcion getOpcion1() {
    return opciones.get(0);
  }

  /**
   * Getter de 'opción2'
   * 
   * @return la instancia de la segunda opción
   */
  Opcion getOpcion2() {
    return opciones.get(1);
  }

  /**
   * Getter de 'opción3'
   * 
   * @return la instancia de la tercer opción
   */
  Opcion getOpcion3() {
    return opciones.get(2);
  }

  Boolean correcta(String s) {
    String respuesta = this.getOpcion1().getTituloOpcion();
    boolean equals = respuesta.equals(s);
    return equals;
  }

  /**
   * Setter de 'pregunta'
   * 
   * @param pregunta
   *          - la cadena con la pregunta
   */
  void setPregunta(String pregunta) {
    this.pregunta = pregunta;
  }
  
  void setOpciones(String opcion1, String opcion2, String opcion3) {
    ArrayList<Opcion> nuevasOpciones = new ArrayList<Opcion>();
    nuevasOpciones.add(new Opcion(opcion1, true));
    nuevasOpciones.add(new Opcion(opcion2, false));
    nuevasOpciones.add(new Opcion(opcion3, false));
    this.setOpciones(nuevasOpciones);
  }

  /**
   * Setea las 3 opciones de la pregunta
   * 
   * @param opciones
   *          - Un array con las opciones
   */
  private void setOpciones(ArrayList<Opcion> opciones) {
    this.opciones = opciones;
  }
}
