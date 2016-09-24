package controlador;

/**
 * Escuchador para los botones cuando se juega sin preguntas
 * 
 * @author Dibez, Santana
 *
 */
public class BotonListenerSinPregunta extends BotonListenerPadre {

  /**
   * Constructor
   * 
   * @param manejador
   * 
   */
  public BotonListenerSinPregunta(ManejadorJuego manejador) {
    super(manejador);
  }

  @Override
  public void llamarPregunta() {}
}