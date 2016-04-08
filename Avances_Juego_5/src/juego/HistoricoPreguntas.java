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
	  this.historico_preguntas.add(new Pregunta("¿Quién creo la WWW?", "Tim Berners Lee", "Bill Gates", "Steve Jobs"));
	  this.historico_preguntas.add(new Pregunta("¿Cuántos bits contiene una dirección IP?", "32 bits", "16 bits", "8 bits"));
	  this.historico_preguntas.add(new Pregunta("¿Cuántas capas considera el modelo OSI/ISO?", "7 capas", "5 capas", "4 capas"));
	  this.historico_preguntas.add(new Pregunta("¿Quien es considerado/a el/la primer/a programador/a de la historia?", "Ada Lovelace", "Charles Babbage", "Alan Turing"));
	  this.historico_preguntas.add(new Pregunta("¿Cuál de las siguientes NO es una topología de red?", "Prisma", "Estrella", "Anillo"));
	  this.historico_preguntas.add(new Pregunta("¿Cómo se llama el protocolo destinado a reemplazar IPV4?", "IPv6", "IPv5", "IPv7"));
	  this.historico_preguntas.add(new Pregunta("¿Qué protocolos de transporte contempla el modelo TCP/IP?", "TCP - IP", "TCP - UDP", "TCP - DDP"));
	  this.historico_preguntas.add(new Pregunta("¿Qué componente de una PC ejecuta las instrucciones?", "Procesador", "Memoria", "Unidad E/S"));
	  this.historico_preguntas.add(new Pregunta("¿Qué condiciones tienen que cumplir las bases de datos?", "ACID", "BASIC", "SOLID"));
	  this.historico_preguntas.add(new Pregunta("¿A cuántos bits equivale un byte?", "8", "4", "16"));
	  this.historico_preguntas.add(new Pregunta("¿Cuántas direcciones de memoria va a tener una PC con un bus de direcciones de 32 bits?", "4 MB", "1 MB", "2 MB"));
	  this.historico_preguntas.add(new Pregunta("¿Cuántos bytes tiene un carácter ASCII?", "1", "2", "4"));
	  this.historico_preguntas.add(new Pregunta("¿Qué significan las siglas ASCII?", "American Standard Code for Information Interchange", "Asociation Standard Code for Information Interchange", "ANSI Standard Code for Information Interchange"));
	  this.historico_preguntas.add(new Pregunta("Un sistema numérico de base 4 ¿qué numerales contiene?", "0, 1, 2, 3", "1, 2, 3, 4", "1, 5, 9, 13"));
	  this.historico_preguntas.add(new Pregunta("¿Cuál de los siguientes tipos de tecnología es volátil?", "RAM", "ROM", "EPROM"));
	  this.historico_preguntas.add(new Pregunta("El número binario 1000 ¿qué número es en formato decimal?", "8", "10", "12"));
	  this.historico_preguntas.add(new Pregunta("¿Cuál de las siguientes NO es una capa del modelo OSI/ISO?", "Host", "Transporte", "Red"));
	  this.historico_preguntas.add(new Pregunta("¿Cuál de los siguientes  tipos de red es una red de área local?", "LAN", "WAN", "MAN"));
	  this.historico_preguntas.add(new Pregunta("¿Cuál fue la idea más importante detrás de la arquitectura de Von Neumann?", "Programa almacenado en memoria", "Instrucciones secuenciales", "Computadora programable"));
	  this.historico_preguntas.add(new Pregunta("¿Cómo se denomina al formato usado actualmente para representar números enteros?", "Complemento a uno", "Complemento a dos", "Magnitud y signo"));
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
