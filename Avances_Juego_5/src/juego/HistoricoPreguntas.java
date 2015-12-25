package juego;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que almacena una serie de preguntas 
 * que se utilizaran a lo largo del juego
 * @author Dibez, Santana
 *
 */
public class HistoricoPreguntas 
{
	ArrayList<Pregunta> historico_preguntas = new ArrayList<Pregunta>();
	
	/**
	 * Constructor defecto
	 */
	public HistoricoPreguntas()
	{		
		this.historico_preguntas.add(new Pregunta("¿Cuántos mundiales de fútbol ganó Argentina?",
												  "2",
												  "1",
												  "4"));
		
		this.historico_preguntas.add(new Pregunta("¿Quién es considerado/a el/la primer/a programador/a?",
												  "Ada LOVELACE",
												  "Charles BABBAGE",
												  "Alan TURING"));
		
		this.historico_preguntas.add(new Pregunta("¿Cuál de los siguientes músico no fue un integrante de 'The Beatles'?",
												  "Mick JAGGER",
												  "John LENNON",
												  "George HARRISON"));
		
		this.historico_preguntas.add(new Pregunta("¿Cuál de los siguientes libros fue escrito por Jorge Luis BORGES?",
												  "El Aleph",
												  "El Túnel",
												  "Rayuela"));
		
		this.historico_preguntas.add(new Pregunta("¿En qué continente se encuentra Japón?",
												  "Asia",
												  "Oceania",
												  "América"));

		this.historico_preguntas.add(new Pregunta("¿Quién creó la World Wide Web (WWW)?",
												  "Tim Berners-Lee",
												  "Steve Jobs",
												  "Bill Gates"));
		
		this.historico_preguntas.add(new Pregunta("¿Cuál es el nombre cientifico de las ballenas?",
												  "Eschirichtius gibbosus",
												  "Stenella dubia",
												  "Centruride sp"));
		
		this.historico_preguntas.add(new Pregunta("¿Cuántas cuerdas tiene un laud?",
												  "12",
												  "6",
												  "Ninguna"));
		
		this.historico_preguntas.add(new Pregunta("¿Cuál de estos inventos pertenece a Nikola TESLA?",
												  "Corriente Alterna",
												  "Telescopio",
												  "Pila alcalina"));

	}

	/**
	 * Selecciona de forma aleatoria una pregunta
	 * @return la pregunta sorteada
	 */
	public Pregunta sortearPregunta()
	{	
		//comienza el algoritmo
		Collections.shuffle(this.historico_preguntas);
		return this.historico_preguntas.get(0);
	}
}
