package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import juego.Direccion;

/**
 * Escuchador para los botones cuando se juega sin preguntas
 * @author Dibez, Santana
 *
 */
public class BotonListenerSinPregunta extends BotonListenerPadre {

	ManejadorJuego manejador;
	JButton casilla;
	
	/**
	 * Constructor
	 * 
	 * @param manejador - 
	 * 
	 */
	public BotonListenerSinPregunta(ManejadorJuego manejador) {
		super(manejador);
		this.setManejador(manejador);
	}

	/**
	 * @return the manejador
	 */
	protected ManejadorJuego getManejador() {
		return manejador;
	}

	/**
	 * @param manejador the manejador to set
	 */
	protected void setManejador(ManejadorJuego manejador) {
		this.manejador = manejador;
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
	 * Cuando se presiona en una casilla del juego 
	 * evalua si se trata de una moneda, en ese caso ejecuta 'accionClicMoneda'
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int fila;
		int columna;
		ManejadorJuego manejador = this.getManejador();
		
		manejador.getPanelTablero().setearTablero();
		
		this.setCasilla(((JButton) e.getSource()));
		
		fila = manejador.getPanelTablero().getFila(casilla);
		columna = manejador.getPanelTablero().getColumna(casilla);
		
		if(manejador.getJuego().puedeSaltar(fila, columna))
		{
			this.accionClicMoneda(fila, columna);
		}
		
		this.getCasilla().setSelected(false);
	}
	
	/**
	 * Evalúa las opciones de salto de la moneda indicada por los parámetros
	 * 		'fila' y 'columna'. Si solo hay un salto posible, lo efectúa, si hay más
	 * 		de un salto posible pregunta al usuario por la dirección 
	 * 		antes de efectuar el salto.
	 *
	 * @param fila - la fila de la moneda que va a saltar
	 * @param columna - la columna de la moneda que va a saltar
	 */
	public void accionClicMoneda(int fila, int columna) {
		manejador.getPanelTablero().colorearBoton(fila, columna, Color.MAGENTA);
		
		ArrayList<Direccion> direcciones = colorearDireccionesSalto(getCasilla());
		
		if (direcciones.size() == 1) {
			this.saltar(fila, columna, direcciones.get(0).toString());
		} else if (direcciones.size() > 1) {
			String direccion = preguntarDireccion(direcciones);
			if (direccion != null) this.saltar(fila, columna, direccion);
		}
		
		this.verificarFinJuego();
		
		manejador.getPanelTablero().setearTablero();
	}

}
