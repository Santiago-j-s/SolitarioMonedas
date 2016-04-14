package controlador;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import vista.PanelMenuInicio;
import vista.PanelPantallaPrincipal;
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
	
	/**
	 * Construye la ventana inicial del juego
	 */
	public ManejadorMenuInicial(VentanaPrincipal ventanaPrincipal) {
		PanelMenuInicio panelMenuInicio = new PanelMenuInicio(ventanaPrincipal.getRecursos());
		
		this.ventanaPrincipal = ventanaPrincipal;
		
		ventanaPrincipal.add(panelMenuInicio);
		ventanaPrincipal.validate();
		ventanaPrincipal.repaint();
		
		panelMenuInicio.getBotonJugarConPreguntas().addActionListener(
				new LanzarJuegoConPreguntas());
		
		panelMenuInicio.getBotonJugarSinPreguntas().addActionListener(
				new LanzarJuegoSinPreguntas());
	}

	/**
	 * Inicia el juego
	 * @param preguntas - true si las preguntas estarán activadas
	 */
	private void LanzarJuego(boolean preguntas) {
		PanelPantallaPrincipal juego = 
				new ManejadorJuego(preguntas, this.ventanaPrincipal, ventanaPrincipal.getRecursos())
					.getPanelPantallaPrincipal();
		
		JPanel content = new JPanel(new GridBagLayout());
        ventanaPrincipal.setContentPane(content);	            
		ventanaPrincipal.getContentPane().add(juego);
		ventanaPrincipal.getNuevoJuego().setEnabled(true);
		ventanaPrincipal.pack();
		
		ventanaPrincipal.revalidate();
		ventanaPrincipal.repaint();
	}
	
	/**
	 * Inicia el juego con las preguntas activadas
	 * @author Santana, Dibez
	 *
	 */
	private class LanzarJuegoConPreguntas implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LanzarJuego(true);
		}
		
	}
	
	/**
	 * Inicia el juego con las preguntas desactivadas
	 * @author Santana, Dibez
	 */
	private class LanzarJuegoSinPreguntas implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LanzarJuego(false);
		}
	}
}
