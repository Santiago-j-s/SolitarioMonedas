package pregunta;

/**
 * Las clases que implementen esta interfaz permitiran lanzar una pregunta.
 * Según la respuesta a esa pregunta sea correcta o no se ejecutará 
 * alguno de los 2 métodos 'correcto' o 'incorrecto'
 * 
 * @author Dibez, Santana
 */
public interface ObservadorPregunta {
	
	/**
	 * Lanza una pregunta
	 */
	public void llamarPregunta();
	
	/**
	 * Si la pregunta es respondida correctamente se ejecuta este método
	 */
	public void correcto();
	
	/**
	 * Si la pregunta es respondida incorrectamente se ejecuta este método
	 */
	public void incorrecto();
}
