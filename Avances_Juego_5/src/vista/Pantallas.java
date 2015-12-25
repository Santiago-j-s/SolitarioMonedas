package vista;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 * Clase que se encarga de agrupar las distintas
 * pantallas del juego a traves de pestañas
 * @author Dibez, Santana
 *
 */
public class Pantallas extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor que asigna el panel del tablero y el 
	 * panel ayuda recibidos como parametros al JTabbedPane
	 * pantallas
	 * @param panelTablero
	 * @param panelAyuda
	 */
	public Pantallas(JPanel panelTablero, PanelAyuda panelAyuda) {
		super(JTabbedPane.TOP);

		this.setPreferredSize(new Dimension(300, 300));
		
		JScrollPane ayuda = new JScrollPane(panelAyuda);

		this.addTab("Juego", panelTablero);
		this.addTab("Ayuda", ayuda);
	}
	
	/**
	 * Metodo main de prueba para las pantallas
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new GridLayout(1, 1));
		frame.getContentPane().add(new Pantallas(new JPanel(), new PanelAyudaPreguntas()));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
