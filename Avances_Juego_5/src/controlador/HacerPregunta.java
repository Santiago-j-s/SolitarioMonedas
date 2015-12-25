package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Iterator;

import juego.HistoricoPreguntas;
import juego.Pregunta;
import vista.PanelPregunta;

/**
 * Clase con observadores que muestra una pregunta en pantalla.
 * Si la pregunta es respondida correctamente lanza el método 'correcto' de sus observadores.
 * Si la pregunta es respondida incorrectamente lanza activa el método 'incorrecto'
 *
 * @author Dibez, Santana
 *
 */
public class HacerPregunta
{
	
	private Pregunta unaPregunta;
	private PanelPregunta unPanelPregunta;
	private ArrayList<ObservadorPregunta> observadores;
	JFrame ventanaPregunta;
	
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	
	/**
	 * Constructor
	 * @param unaPregunta - pregunta con sus opciones que será mostrada en pantalla
	 */
	public HacerPregunta(Pregunta unaPregunta)
	{
		this.unaPregunta = unaPregunta; //el colaborador unaPregunta apunta al mismo objeto del parametro
		
		boton1 = new JButton(unaPregunta.getOpcion1().toString());
		boton2 = new JButton(unaPregunta.getOpcion2().toString());
		boton3 = new JButton(unaPregunta.getOpcion3().toString());
		
		this.observadores = new ArrayList<ObservadorPregunta>();
		
		//inicializamos y cargamos unPanelPregunta con los datos de unaPregunta
	    unPanelPregunta = new PanelPregunta(unaPregunta.getPregunta(),
	    									boton1,
	    									boton2,
	    									boton3
	    									);
	    
	    ventanaPregunta = new JFrame("Pregunta");
	    ventanaPregunta.add(unPanelPregunta);
	    
	    ImageIcon icono = new ImageIcon(getClass().
	    		getResource("/logoJuego2.png"));
	    
	    ventanaPregunta.setIconImage(icono.getImage());
	    ventanaPregunta.setResizable(false);
	    ventanaPregunta.pack();
	    ventanaPregunta.setLocationByPlatform(true);
	    ventanaPregunta.setVisible(true);
	    
	    Manejador manejadorPreg = new Manejador();
	    	    
	    boton1.addActionListener(manejadorPreg);
	    boton2.addActionListener(manejadorPreg);
	    boton3.addActionListener(manejadorPreg);
	    
	    this.getVentanaPregunta().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.getVentanaPregunta().setAlwaysOnTop(true);
	    
	    unPanelPregunta.setSize(300,300);
	}
	
	/**
	 * Según cual sea el botón presionado lanza un método de los observadores
	 * 
	 * @author Dibez, Santana
	 */
	private class Manejador implements ActionListener
	{

		Iterator<ObservadorPregunta> iteradorObservadores;
		
		/**
		 * Verifica si la pregunta fue respondida correctamente,
		 * 		lanza el método 'correcto' o 'incorrecto' de cada observador
		 */
		public void actionPerformed(ActionEvent e)
		{
			this.iteradorObservadores = getIteradorObservadores();
			
			JButton boton = (JButton) e.getSource();

			if (boton.getText().equals(unaPregunta.getOpcion1().toString()))
			{
				while (this.iteradorObservadores.hasNext()) {
					this.iteradorObservadores.next().correcto();
				}
			} 
			else
			{
				while (this.iteradorObservadores.hasNext()) {
					this.iteradorObservadores.next().incorrecto();
				}
			}
		}
		
	}
	
	/**
	 * Añade un observador
	 * 
	 * @param ObservadorPregunta - El observador a ser añadido
	 */
	public void addObservadorPregunta(ObservadorPregunta ObservadorPregunta) {
		this.observadores.add(ObservadorPregunta);
	}
	
	/**
	 * @return un iterador con los observadores de la instancia actual
	 */
	public Iterator<ObservadorPregunta> getIteradorObservadores() {
		return this.observadores.iterator();
	}
	
	/**
	 * @return la ventana de la instancia actual
	 */
	public JFrame getVentanaPregunta() {
		return this.ventanaPregunta;
	}
	
	/**
	 * Método de prueba
	 * @param args - no tiene parámetros
	 */
	public static void main(String[]args)
	{
		HistoricoPreguntas BDPreguntas = new HistoricoPreguntas();
		new HacerPregunta(BDPreguntas.sortearPregunta());
	}

}
