package juego;

/**
 * Una opción que contiene un título y un valor de verdad
 * 
 * @author Dibez, Santana
 *
 */
public class Opcion {
  String tituloOpcion;
  boolean esCorrecta;

  /**
   * Crea una opción con el título y el valor de verdad pasados como parámetros
   * 
   * @param titulo
   *          - El nombre que tendrá la opción
   * @param valorOpcion
   *          - El valor booleano que tendrá la opción
   */
  public Opcion(String titulo, boolean valorOpcion) {
    this.setTituloOpcion(titulo);
    this.setEsCorrecta(valorOpcion);
  }

  /**
   * Constructor defecto con un título vacío y cuyo valor es 'false'
   */
  public Opcion() {
    this("", false);
  }

  /**
   * 
   * @return getter de 'tituloOpcion'
   */
  public String getTituloOpcion() {
    return tituloOpcion;
  }

  /**
   * 
   * @return getter de 'esCorrecta'
   */
  public boolean esCorrecta() {
    return this.esCorrecta;
  }

  /**
   * Setter de tituloOpcion
   * 
   * @param tituloOpcion
   *          - el nombre de la opción
   */
  private void setTituloOpcion(String tituloOpcion) {
    this.tituloOpcion = tituloOpcion;
  }

  /**
   * Setter de esCorrecta
   * 
   * @param esCorrecta
   *          - el valor de verdad de la opción
   */
  private void setEsCorrecta(boolean esCorrecta) {
    this.esCorrecta = esCorrecta;
  }

  @Override
  public String toString() {
    return this.getTituloOpcion();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Opcion))
      return false;
    Opcion opcion = (Opcion) obj;
    return opcion.getTituloOpcion().equals(this.getTituloOpcion())
        && opcion.esCorrecta() == this.esCorrecta();
  }

}