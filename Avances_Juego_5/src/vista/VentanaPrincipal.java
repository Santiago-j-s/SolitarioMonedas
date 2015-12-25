package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * La ventana principal del juego; es decir la que 
 * contiene el tablero y la ayuda.
 * @author Dibez, Santana
 *
 */
public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Único constructor de la clase. Recibe como parámetro al panel con el tablero de juego.
	 * Crea la ventana, introduce los elementos en un BorderLayout 
	 * 	y finalmente muestra la ventana
	 */
	public VentanaPrincipal(JPanel panelTablero, PanelAyuda panelAyuda) {
		
		super("Solitario con Monedas");
		this.add(new Pantallas(panelTablero, panelAyuda));
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/logoJuego2.png"));
		this.setIconImage(icono.getImage());
		
		this.setResizable(false);
		this.pack();
		this.setLocationByPlatform(true);
		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
