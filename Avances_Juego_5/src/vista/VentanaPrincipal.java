package vista;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
	public VentanaPrincipal() {
		super("Solitario con Monedas");
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/logoJuego2.png"));
		this.setIconImage(icono.getImage());
		
		this.setMinimumSize(new Dimension(400,400));
		
		this.setResizable(true);
		this.pack();
		this.setLocationByPlatform(true);
		
		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JMenuBar crearMenu() {
		JMenuBar barraMenu;
		JMenu menuJuego,menuAyuda;
		JMenuItem nuevoJuego,salir,verAyuda;
		
		//trabajamos con el menu
		
		nuevoJuego = new JMenuItem("Nuevo juego");
		salir = new JMenuItem("Salir");
		verAyuda = new JMenuItem("Ver ayuda");
		
		menuJuego = new JMenu("Juego");
		menuJuego.add(nuevoJuego);
		menuJuego.add(salir);
		
		menuAyuda = new JMenu("Ayuda");
		menuAyuda.add(verAyuda);
		
		barraMenu = new JMenuBar();
		
		barraMenu.add(menuJuego);
		barraMenu.add(menuAyuda);		
		
		return barraMenu;
	}
	
	
}
