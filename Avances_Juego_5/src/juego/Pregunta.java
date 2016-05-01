package juego;

/**
 * Una pregunta con 3 opciones posibles de respuesta
 * @author Dibez, Santana
 *
 */
public class Pregunta 
{
	private String pregunta;
	private Opcion opcion1, opcion2, opcion3;
	
	/**
	 * Constructor
	 * 
	 * @param pregunta - La pregunta que el usuario ha de responder
	 * @param opcion1 - Primer opción
	 * @param opcion2 - Segunda opción
	 * @param opcion3 - Tercera opción
	 */
	public Pregunta(String pregunta, String opcion1, String opcion2, String opcion3)
	{
		this.setPregunta(pregunta);
		this.setOpciones(opcion1, opcion2, opcion3);
	}
	
	/**
	 * Constructor defecto
	 * La pregunta es: '¿Quien libero America?'
	 * Opcion1: 'Jose de SAN MARTIN'
	 * Opcion2: 'Manuel BELGRANO'
	 * Opcion3: 'Cornelio SAAVEDRA'
	 */
	public Pregunta()
	{
		//opciones locales
		this("¿Quien libero America?",  
				"Jose de SAN MARTIN", 
				"Manuel BELGRANO",
				"Cornelio SAAVEDRA"
				);
	}

	/**
	 * Getter de 'pregunta'
	 * @return una cadena con la pregunta
	 */
	public String getPregunta() 
	{
		return pregunta;
	}
	
	/**
	 * Getter de 'opción1'
	 * @return la instancia de la primer opción
	 */
	public Opcion getOpcion1() 
	{
		return opcion1;
	}
	
	/**
	 * Getter de 'opción2'
	 * @return la instancia de la segunda opción
	 */
	public Opcion getOpcion2() 
	{
		return opcion2;
	}
	
	/**
	 * Getter de 'opción3'
	 * @return la instancia de la tercer opción
	 */
	public Opcion getOpcion3() 
	{
		return opcion3;
	}
	
	/**
	 * Setter de 'pregunta'
	 * @param pregunta - la cadena con la pregunta
	 */
	protected void setPregunta(String pregunta) 
	{
		this.pregunta = pregunta;
	}
	
	/**
	 * Setea las 3 opciones de la pregunta
	 * @param opcion1 - una cadena con la primer opción para la pregunta
	 * @param opcion2 - una cadena con la segunda opción para la pregunta
	 * @param opcion3 - una cadena con la tercer opción para la pregunta
	 */
	protected void setOpciones(String opcion1, String opcion2, String opcion3)
	{
		this.setOpcion1(new Opcion(opcion1, true));
		this.setOpcion2(new Opcion(opcion2, false));
		this.setOpcion3(new Opcion(opcion3, false));
	}
	
	/**
	 * Setter de 'opcion1'
	 * @param opcion1 - la primer opción
	 */
	private void setOpcion1(Opcion opcion1) 
	{
		this.opcion1 = opcion1;
	}
	
	/**
	 * Setter de 'opcion2'
	 * @param opcion1 - la segunda opción
	 */
	private void setOpcion2(Opcion opcion2) 
	{
		this.opcion2 = opcion2;
	}
	
	/**
	 * Setter de 'opcion3'
	 * @param opcion1 - la tercer opción
	 */
	private void setOpcion3(Opcion opcion3) 
	{
		this.opcion3 = opcion3;
	}
}
