package controlador;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import vista.PanelMenuInicio;
import vista.VentanaPrincipal;

/**
 * Maneja la GUI del menú inicial del juego.
 * El menú inicial permite lanzar 2 modalidades diferentes del juego.
 * Una con las preguntas activadas y otra con las preguntas desactivadas
 * 
 * @author Dibez, Santana
 *
 */
public class ManejadorMenuInicial {
	VentanaPrincipal ventanaPrincipal;
	ManejadorJuego manejadorJuego;
	
	/**
	 * Construye la ventana inicial del juego
	 */
	public ManejadorMenuInicial(VentanaPrincipal ventanaPrincipal) {
		PanelMenuInicio panelMenuInicio = new PanelMenuInicio();
		
		this.ventanaPrincipal = ventanaPrincipal;
		
		ventanaPrincipal.add(panelMenuInicio);
		ventanaPrincipal.setSize(400,400);
		ventanaPrincipal.setResizable(true);
		
		ventanaPrincipal.repaint();
		
		panelMenuInicio.getBotonJugarConPreguntas().addActionListener(
				new LanzarJuegoConPreguntas());
		
		panelMenuInicio.getBotonJugarSinPreguntas().addActionListener(
				new LanzarJuegoSinPreguntas());
	}
	
	private void ponerPanelEnFrame() {
		ventanaPrincipal.getContentPane().removeAll();
		
		JPanel content = new JPanel(new GridBagLayout());
        ventanaPrincipal.setContentPane(content);
					            
		ventanaPrincipal.getContentPane().add(manejadorJuego.getPanelPantallaPrincipal());
		ventanaPrincipal.pack();
		ventanaPrincipal.validate();	
		ventanaPrincipal.setLocationRelativeTo(null);
		
		manejadorJuego.setVentanaPrincipal(ventanaPrincipal);
	}
	
	/**
	 * Inicia el juego con las preguntas activadas
	 * @author Santana, Dibez
	 *
	 */
	private class LanzarJuegoConPreguntas implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			manejadorJuego = new ManejadorJuego(true);
			ponerPanelEnFrame();			
		}
		
	}
	
	/**
	 * Inicia el juego con las preguntas desactivadas
	 * @author Santana, Dibez
	 */
	private class LanzarJuegoSinPreguntas implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			manejadorJuego = new ManejadorJuego(false);
			ponerPanelEnFrame();
		}
	}
	
	/**
	 * Método solo usado para fines de testeo
	 * @param args - argumentos a recibir
	 */
	public static void main(String[] args) {
		new ManejadorMenuInicial(new VentanaPrincipal());
	}
}
