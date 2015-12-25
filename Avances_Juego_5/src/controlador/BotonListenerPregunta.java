package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import juego.Direccion;
import juego.HistoricoPreguntas;

/**
 * Invocado cuando se presiona una casilla. 
 * 
 * Verifica si la casilla contiene una moneda o no.
 * Si la casilla contiene una moneda colorea las direcciones de salto
 * 		posibles y pregunta por la dirección en que se desea saltar.
 * 
 * Cada 3 saltos presenta una pregunta, cada vez que la pregunta es respondida
 * 		incorrectamente, salta otra pregunta. No permite continuar jugando 
 * 		hasta que no se responda de forma correcta una pregunta
 *
 * @author Dibez, Santana
 *
 */
public class BotonListenerPregunta extends BotonListenerPadre implements
		ObservadorPregunta {

	private int fila;
	private int columna;
	
	private JButton casilla;

	private ManejadorJuego manejador;
	
	private HacerPregunta hacerPregunta;
	private HistoricoPreguntas preguntaRandom;
	
	public BotonListenerPregunta(ManejadorJuego manejador) {
		super(manejador);
		
		this.setManejador(manejador);
		
		this.setPreguntaRandom(new HistoricoPreguntas());
		this.setHacerPregunta(null);
	}
	
	/**
	 * @return the casilla
	 */
	protected JButton getCasilla() {
		return casilla;
	}

	/**
	 * @param casilla the casilla to set
	 */
	protected void setCasilla(JButton casilla) {
		this.casilla = casilla;
	}

	/**
	 * @return the manejador
	 */
	private ManejadorJuego getManejador() {
		return manejador;
	}

	/**
	 * @param manejador the manejador to set
	 */
	private void setManejador(ManejadorJuego manejador) {
		this.manejador = manejador;
	}

	/**
	 * @return the fila
	 */
	private int getFila() {
		return fila;
	}

	/**
	 * @param fila the fila to set
	 */
	private void setFila(int fila) {
		this.fila = fila;
	}

	/**
	 * @return the columna
	 */
	private int getColumna() {
		return columna;
	}

	/**
	 * @param columna the columna to set
	 */
	private void setColumna(int columna) {
		this.columna = columna;
	}

	/**
	 * @return the hacerPregunta
	 */
	private HacerPregunta getHacerPregunta() {
		return hacerPregunta;
	}

	/**
	 * @param hacerPregunta the hacerPregunta to set
	 */
	private void setHacerPregunta(HacerPregunta hacerPregunta) {
		this.hacerPregunta = hacerPregunta;
	}

	/**
	 * @return the preguntaRandom
	 */
	private HistoricoPreguntas getPreguntaRandom() {
		return preguntaRandom;
	}

	/**
	 * @param preguntaRandom the preguntaRandom to set
	 */
	private void setPreguntaRandom(HistoricoPreguntas preguntaRandom) {
		this.preguntaRandom = preguntaRandom;
	}

	/**
	 * Crea una ventana con una pregunta,
	 * 		lanza el método 'corecto' o 'incorrecto'
	 * 		según el resultado de la respuesta a la pregunta.
	 */
	@Override
	public void llamarPregunta() {
		
		this.setHacerPregunta(new HacerPregunta(
				this.getPreguntaRandom().sortearPregunta()
				));
		
		this.getHacerPregunta().addObservadorPregunta(this);
		this.getManejador().getVentanaPrincipal().setEnabled(false);
	}
	
	/**
	 * Permite continuar el juego
	 */
	@Override
	public void correcto() {
		this.getManejador().getPanelTablero().colorearBoton(this.getFila(), 
				this.getColumna(), Color.MAGENTA);
		
		if (this.getHacerPregunta() != null) {
			this.getHacerPregunta().getVentanaPregunta().dispose();
		}
		
		ArrayList<Direccion> direcciones = colorearDireccionesSalto(getCasilla());

		
		if (direcciones.size() == 1) {
			this.saltar(fila, columna, direcciones.get(0).toString());
		} else if (direcciones.size() > 1) {
			String direccion = preguntarDireccion(direcciones);
			if (direccion != null) this.saltar(fila, columna, direccion);
		}
		
		if(this.verificarFinJuego()) {
			this.getManejador().getPanelTablero().setEnabled(false);
		}
		
		this.getManejador().getPanelTablero().setearTablero();
	}
	
	/**
	 * Salta otra pregunta
	 */
	@Override
	public void incorrecto() {
		this.getHacerPregunta().getVentanaPregunta().dispose();
		this.llamarPregunta();
	}

	/**
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.getManejador().getPanelTablero().setearTablero();
		
		this.setCasilla(((JButton) e.getSource()));
		
		this.setFila(this.getManejador().getPanelTablero().getFila(casilla));
		this.setColumna(this.getManejador().getPanelTablero().getColumna(casilla));
		
		if(this.getManejador().getJuego().
				puedeSaltar(this.getFila(), this.getColumna()))
		{
			if (this.manejador.getJuego().getCantSaltos() % 3 == 0) {
				this.llamarPregunta();
			} else {
				this.correcto();
			}
		}
		
		this.getCasilla().setSelected(false);
	}
}
