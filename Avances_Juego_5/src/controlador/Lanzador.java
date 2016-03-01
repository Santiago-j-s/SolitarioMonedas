package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaPrincipal;

public class Lanzador {
	VentanaPrincipal mainWindow;
	
	/**
	 * Setea la ventana principal e inicia el programa
	 */
	public Lanzador() {
		this.mainWindow = new VentanaPrincipal();
		reset();
	}
	
	/**
	 * Resetea la aplicacion
	 */
	public void reset() {
		this.mainWindow.getNuevoJuego().setEnabled(false);
		this.mainWindow.getContentPane().removeAll();
		this.mainWindow.getNuevoJuego()
			.addActionListener(new NuevoJuegoListener());
		this.mainWindow.getSalir()
			.addActionListener(new SalirListener());
		new ManejadorMenuInicial(this.mainWindow);
	}
	
	public void salir() {
		System.exit(0);
	}
	
	/**
	 * Escuchador para el JMenuItem 'Nuevo Juego'
	 */
	private class NuevoJuegoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			reset();
		}
	}
	
	private class SalirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			salir();
		}
	}
	
	/**
	 * Lanza el programa
	 */
	public static void main(String[] args) {
		new Lanzador();
	}
}
