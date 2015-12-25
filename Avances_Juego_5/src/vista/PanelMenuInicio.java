package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Clase que crea un panel inicial en la cual se 
 * elige como desea jugar (con o sin preguntas)
 * 
 * 
 * @author Dibez, Santana
 *
 */
public class PanelMenuInicio extends JPanel
{

	private static final long serialVersionUID = 1L;
	//atributos
	JButton botonJugarConPreguntas;
	JButton botonJugarSinPreguntas;
	ImageIcon fondoMenu;
	
	/**
	 * Constructor que se encarga de crear el panel
	 * que se verá en la ventana de inicio del juego
	 * Agrega sus botones necesarios
	 */
	public PanelMenuInicio()
	{
		BoxLayout caja = new BoxLayout(this, BoxLayout.Y_AXIS);
		
		this.setLayout(caja);
		
		this.botonJugarConPreguntas = new JButton("JUGAR CON PREGUNTAS");
		this.botonJugarConPreguntas.setAlignmentX(CENTER_ALIGNMENT);
		
		this.botonJugarSinPreguntas = new JButton("JUGAR SIN PREGUNTAS");
		this.botonJugarSinPreguntas.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(Box.createRigidArea(new Dimension(0, 204)));
		
		this.add(botonJugarConPreguntas);
		
		this.add(Box.createRigidArea(new Dimension(0, 2)));
		
		this.add(botonJugarSinPreguntas);
		
		this.setVisible(true);
		
		this.setPreferredSize(new Dimension(300, 300));
		
	}
	
	/**
	 * @return the botonJugarConPreguntas
	 */
	public JButton getBotonJugarConPreguntas() {
		return botonJugarConPreguntas;
	}

	/**
	 * @return the botonJugarSinPreguntas
	 */
	public JButton getBotonJugarSinPreguntas() {
		return botonJugarSinPreguntas;
	}

    /**
     * Metodo que agrega una imagen de fondo al panel de la pantalla de inicio
     */
    public void paintComponent(Graphics g)
    {
    	this.fondoMenu = new ImageIcon(getClass().getResource("/menu2.jpg"));
    	g.drawImage(this.fondoMenu.getImage(), 0,0, this.getWidth(), this.getHeight(), null);
    	this.setOpaque(false);
    	super.paintComponents(g);
    }

	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Prueba Menu Inicio");
		PanelMenuInicio menu = new PanelMenuInicio();
		frame.add(menu);
		frame.setSize(300,300);
		frame.repaint();
		frame.setVisible(true);	
		
		
	}
}