package vista;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * Panel que contiene las pestañas Juego y Ayuda que se utilizan una vez ingresado
 * tras elegir el modo de juego en el menu inicial
 * @author Pablo
 *
 */
public class PanelPantallaPrincipal extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelPantallaPrincipal(JPanel panelTablero, PanelAyuda panelAyuda) {
		this.setLayout(new GridBagLayout());
		this.add(new Pantallas(panelTablero, panelAyuda));
		
	}

}
