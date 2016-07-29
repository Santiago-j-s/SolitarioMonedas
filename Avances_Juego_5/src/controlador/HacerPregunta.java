package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Iterator;

import juego.HistoricoPreguntas;
import juego.Pregunta;
import vista.PanelPregunta;

/**
 * Clase con observadores que muestra una pregunta en pantalla. Si la pregunta
 * es respondida correctamente lanza el método 'correcto' de sus observadores.
 * Si la pregunta es respondida incorrectamente lanza el método
 * 'incorrecto'
 *
 * @author Dibez, Santana
 *
 */
public class HacerPregunta {

  private Pregunta pregunta;
  private PanelPregunta panelPregunta;
  private ArrayList<ObservadorPregunta> observadores;
  JFrame ventanaPregunta;
  /**
   * Constructor
   * 
   * @param pregunta
   *          - pregunta con sus opciones que será mostrada en pantalla
   */
  public HacerPregunta(Pregunta pregunta) {
    this.pregunta = pregunta; 
    
    this.observadores = new ArrayList<ObservadorPregunta>();
    
    panelPregunta = new PanelPregunta(pregunta);
    
    Manejador manejadorPreg = new Manejador();
    panelPregunta.getBotones().forEach(
        boton -> boton.addActionListener(manejadorPreg)
    );
    
    this.lanzarPregunta(panelPregunta);
  }

  /**
   * 
   * @author Dibez, Santana
   */
  private class Manejador implements ActionListener {

    ArrayList<ObservadorPregunta> observadores;

    /**
     * Verifica si la pregunta fue respondida correctamente, lanza el método
     * 'correcto' o 'incorrecto' de cada observador
     */
    public void actionPerformed(ActionEvent e) {
      this.observadores = getObservadores();
      String respuesta = ((JButton) e.getSource()).getText();

      if (pregunta.correcta(respuesta)) {
        this.observadores.forEach(ObservadorPregunta::correcto);
      } else {
        this.observadores.forEach(ObservadorPregunta::incorrecto);
      }
    }
  }

  /**
   * Añade un observador
   * 
   * @param ObservadorPregunta
   *          - El observador a ser añadido
   */
  public void addObservadorPregunta(ObservadorPregunta ObservadorPregunta) {
    this.observadores.add(ObservadorPregunta);
  }

  /**
   * @return un iterador con los observadores de la instancia actual
   */
  public ArrayList<ObservadorPregunta> getObservadores() {
    return this.observadores;
  }
  
  public void setVentanaPregunta(JFrame ventanaPregunta) {
    this.ventanaPregunta = ventanaPregunta;
  }
  
  private void lanzarPregunta(PanelPregunta p) {
    JFrame frame = new JFrame("Pregunta");
    frame.setLocationByPlatform(true);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.add(p);
    frame.pack();
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    this.setVentanaPregunta(frame);
  }

  /**
   * @return la ventana de la instancia actual
   */
  public JFrame getVentanaPregunta() {
    return this.ventanaPregunta;
  }
}