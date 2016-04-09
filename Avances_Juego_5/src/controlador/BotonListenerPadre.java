package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import vista.CasillaButton;
import vista.PanelIngresoDireccion;
import vista.VentanaPrincipal;
import juego.Direccion;

/**
 * Clase padre de todas las clases que implementan escuchadores 
 * para las casillas del tablero
 * 
 * @author Dibez, Santana
 */
public abstract class BotonListenerPadre implements ActionListener {

	private ManejadorJuego manejadorPrincipal;
	
	public BotonListenerPadre(ManejadorJuego manejador) {
		this.setManejadorPrincipal(manejador);
	}
		

	/**
	 * @return the manejadorPrincipal
	 */
	private ManejadorJuego getManejadorPrincipal() {
		return manejadorPrincipal;
	}



	/**
	 * @param manejadorPrincipal the manejadorPrincipal to set
	 */
	private void setManejadorPrincipal(ManejadorJuego manejadorPrincipal) {
		this.manejadorPrincipal = manejadorPrincipal;
	}



	@Override
	public abstract void actionPerformed(ActionEvent e);
	
	/**
	 * Colorea las casillas en que la moneda seleccionada puede saltar
	 * @param casilla - el botón correspondiente a la moneda seleccionada
	 * @return true si la moneda tiene saltos posibles, false si no los tiene
	 */
	protected ArrayList<Direccion> colorearDireccionesSalto(CasillaButton casilla) {
		
		ManejadorJuego manejador = this.getManejadorPrincipal();
		
		int fila = manejador.getPanelTablero().getFila(casilla);
		int columna = manejador.getPanelTablero().getColumna(casilla);
	
		ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
		
		if (manejador.getJuego().puedeSaltar(fila, columna, Direccion.Arriba)) {
			manejador.getPanelTablero().colorearBoton(fila - 2, columna, Color.GREEN);
			direcciones.add(Direccion.Arriba);
		} 
		
		if (manejador.getJuego().puedeSaltar(fila, columna, Direccion.Abajo)) {
			manejador.getPanelTablero().colorearBoton(fila + 2, columna, Color.GREEN);
			direcciones.add(Direccion.Abajo);
		} 
		
		if (manejador.getJuego().puedeSaltar(fila, columna, Direccion.Izquierda)) {
			manejador.getPanelTablero().colorearBoton(fila, columna - 2, Color.GREEN);
			direcciones.add(Direccion.Izquierda);
		} 
		
		if (manejador.getJuego().puedeSaltar(fila, columna, Direccion.Derecha)) {
			manejador.getPanelTablero().colorearBoton(fila, columna + 2, Color.GREEN);
			direcciones.add(Direccion.Derecha);
		}
		
		return direcciones;
	}
	
	/**
	 * Pregunta por la dirección en que se desea saltar
	 * @param direcciones 
	 * @return una cadena con la dirección
	 */
	protected String preguntarDireccion(ArrayList<Direccion> direcciones) {
		JFrame ventanaPrincipal = this.getManejadorPrincipal()
				.getVentanaPrincipal();
		
		JDialog ventana = new JDialog(ventanaPrincipal, "Dirección");
		
		PanelIngresoDireccion panelDireccion = new PanelIngresoDireccion(ventana, direcciones);
		
		int ventanaPosX = ventanaPrincipal.getX();
		int ventanaPosY = ventanaPrincipal.getY();
		int ventanaTamX = ventanaPrincipal.getSize().width;
		
		ventana.add(panelDireccion);
		ventana.setLocation(ventanaPosX + ventanaTamX, ventanaPosY);
		
		panelDireccion.setVisible(true);
		
		return panelDireccion.getDireccion();
	}
	
	/**
	 * Llama al método saltar de 'tablero' 
	 * y modifica las casillas de la IGU en consecuencia
	 * 
	 * @param fila - Fila de la moneda que realizará el salto
	 * @param columna - Columna de la moneda que realizará el salto
	 * @param direccion - Dirección en la que saltará la moneda
	 */
	protected void saltar(int fila, int columna, String direccion) {
		
		ManejadorJuego manejador = this.getManejadorPrincipal();
		
		manejador.getJuego().saltar(fila, columna, direccion);
		manejador.getPanelTablero().actualizar();
	}
	
	/**
	 * Testea si el jugador ha ganado o perdido el juego y
	 * 	muestra un mensaje en consecuencia.
	 */
	protected boolean verificarFinJuego() {
		
		ManejadorJuego manejador = this.getManejadorPrincipal();
		boolean fin = false;
		
		if (manejador.getJuego().victoria()) {
			JOptionPane.showMessageDialog(manejador.getVentanaPrincipal(), "Ha ganado el juego");
			fin = true;
		} else if (manejador.getJuego().derrota()) {
			JOptionPane.showMessageDialog(manejador.getVentanaPrincipal(), "Ha perdido el juego");
			fin = true;
		}
		
		return fin;
	}
}
