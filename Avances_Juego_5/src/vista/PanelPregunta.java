package vista;

import java.awt.Dimension;
import java.awt.Component;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import juego.Opcion;
import juego.Pregunta;

/**
 * Clase que crea el panel que contendra
 * cada pregunta que aparezca en el juego
 * @author Dibez, Santana
 *
 */
public class PanelPregunta extends JPanel
{
	private static final long serialVersionUID = 6228974768116494807L;
	
	private JLabel pregunta;
	private ArrayList<JButton> botones;
	
	/**
	 * Constructor que crea el panel de la pregunta
	 * que recibe como parametro y asigna los botones
	 * de opciones correspondientes a la mismas
	 * @param unaPregunta
	 */
	public PanelPregunta(Pregunta unaPregunta)
	{
		this.pregunta = new JLabel(unaPregunta.getPregunta());
		
		botones = new ArrayList<JButton>();
		
		botones.add(new JButton(unaPregunta.getOpcion1().getTituloOpcion()));
		botones.add(new JButton(unaPregunta.getOpcion2().getTituloOpcion()));
		botones.add(new JButton(unaPregunta.getOpcion3().getTituloOpcion()));

		Collections.shuffle(botones);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.setAlignmentY(CENTER_ALIGNMENT);
		this.setAlignmentX(CENTER_ALIGNMENT);

		this.add(this.pregunta);
		this.add(Box.createRigidArea(new Dimension(10, 10)));

		for(JButton boton: botones) {
			this.agregarBoton(boton);	
		}

		this.pregunta.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.pregunta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
		this.validate();

		setVisible(true);
	}
	
	/**
	 * Constructor que recibe la pregunta y sus opciones
	 * como parametros, las cuales incorpora al panel
	 * correspondiente
	 * @param pregunta
	 * @param opcion1
	 * @param opcion2
	 * @param opcion3
	 */
	@SuppressWarnings("unused")
  private PanelPregunta(String pregunta, JButton opcion1, JButton opcion2, JButton opcion3)
	{
		this.pregunta = new JLabel(pregunta);
		ArrayList<JButton> botones = new ArrayList<JButton>();
		
		botones.add(opcion1);
		botones.add(opcion2);
		botones.add(opcion3);
		
		Collections.shuffle(botones);
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setAlignmentY(CENTER_ALIGNMENT);
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(this.pregunta);
		this.add(Box.createRigidArea(new Dimension(10, 10)));
		
		for(JButton boton: botones) {
			this.agregarBoton(boton);	
		}
		
		this.pregunta.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.pregunta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		this.validate();
		
		setVisible(true);
	}
	
	/**
	 * Metodo que obtiene una pregunta
	 * @return la pregunta del panel definida como un objeto
	 * de la clase JLabel
	 */
	public JLabel getPregunta() 
	{
		return pregunta;
	}
	
	/**
	 * Metodo que establece una pregunta,pasada como parametro
	 * en el panel
	 * @param pregunta
	 */
	protected void setPregunta(JLabel pregunta) 
	{
		this.pregunta = pregunta;
	}
	
	/**
	 * Metodo que establece un boton, pasado como parametro,
	 * al panel de la pregunta
	 * @param boton
	 */
	private void agregarBoton(JButton boton) {
		
		this.add(boton);
		this.add(Box.createRigidArea(new Dimension(10, 10)));
		
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
	}
	
	public ArrayList<JButton> getBotones() {
	  return botones;
	}
}