package controlador;

/**
 * Escuchador para los botones cuando se juega sin preguntas
 * 
 * @author Dibez, Santana
 *
 */
public class AccionClic extends AccionClicAbstract {

  /**
   * Constructor
   * 
   * @param manejador
   * 
   */
  public AccionClic(ManejadorJuego manejador) {
    super(manejador);
  }

  @Override
  public void llamarPregunta() {}
}