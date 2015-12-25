package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import vista.PanelMenuInicio;

/**
 * Maneja la GUI del menú inicial del juego.
 * El menú inicial permite lanzar 2 modalidades diferentes del juego.
 * Una con las preguntas activadas y otra con las preguntas desactivadas
 * 
 * @author Dibez, Santana
 *
 */
public class ManejadorMenuInicial {
	
	JFrame frame;
	
	/**
	 * Construye la ventana inicial del juego
	 */
	public ManejadorMenuInicial() {
		PanelMenuInicio panelMenuInicio = new PanelMenuInicio();
		ImageIcon icono = new ImageIcon(getClass().getResource("/logoJuego2.png"));
		
		frame = new JFrame("Solitario con Monedas");
		
		frame.add(panelMenuInicio);
		frame.setSize(300,300);
		frame.repaint();
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setIconImage(icono.getImage());
		frame.setVisible(true);
		
		panelMenuInicio.getBotonJugarConPreguntas().addActionListener(
				new LanzarJuegoConPreguntas());
		
		panelMenuInicio.getBotonJugarSinPreguntas().addActionListener(
				new LanzarJuegoSinPreguntas());
		
	}
	
	/**
	 * Inicia el juego con las preguntas activadas
	 * @author Santana, Dibez
	 *
	 */
	private class LanzarJuegoConPreguntas implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new ManejadorJuego(true);
			frame.dispose();
		}
		
	}
	
	/**
	 * Inicia el juego con las preguntas desactivadas
	 * @author Santana, Dibez
	 */
	private class LanzarJuegoSinPreguntas implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new ManejadorJuego(false);
			frame.dispose();
		}
	}
	
	/**
	 * Método solo usado para fines de testeo
	 * @param args - argumentos a recibir
	 */
	public static void main(String[] args) {
		new ManejadorMenuInicial();
	}
}
