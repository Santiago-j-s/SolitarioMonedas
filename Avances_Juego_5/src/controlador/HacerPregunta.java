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
 * Si la pregunta es respondida incorrectamente lanza activa el método
 * 'incorrecto'
 *
 * @author Dibez, Santana
 *
 */
public class HacerPregunta {

  private Pregunta unaPregunta;
  private PanelPregunta unPanelPregunta;
  private ArrayList<ObservadorPregunta> observadores;
  JFrame ventanaPregunta;
  /**
   * Constructor
   * 
   * @param unaPregunta
   *          - pregunta con sus opciones que será mostrada en pantalla
   */
  public HacerPregunta(Pregunta unaPregunta) {
    this.unaPregunta = unaPregunta; // el colaborador unaPregunta apunta al
                                    // mismo objeto del parametro

    this.observadores = new ArrayList<ObservadorPregunta>();
    
    // inicializamos y cargamos unPanelPregunta con los datos de unaPregunta
    unPanelPregunta = new PanelPregunta(unaPregunta);
    
    Manejador manejadorPreg = new Manejador();
    unPanelPregunta.getBotones().forEach(
        boton -> boton.addActionListener(manejadorPreg)
    );
    
    this.lanzarPregunta(unPanelPregunta);
  }

  /**
   * Según cual sea el botón presionado lanza un método de los observadores
   * 
   * @author Dibez, Santana
   */
  private class Manejador implements ActionListener {

    Iterator<ObservadorPregunta> iteradorObservadores;

    /**
     * Verifica si la pregunta fue respondida correctamente, lanza el método
     * 'correcto' o 'incorrecto' de cada observador
     */
    public void actionPerformed(ActionEvent e) {
      this.iteradorObservadores = getIteradorObservadores();

      JButton boton = (JButton) e.getSource();

      if (boton.getText().equals(unaPregunta.getOpcion1().toString())) {
        while (this.iteradorObservadores.hasNext()) {
          this.iteradorObservadores.next().correcto();
        }
      } else {
        while (this.iteradorObservadores.hasNext()) {
          this.iteradorObservadores.next().incorrecto();
        }
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
  public Iterator<ObservadorPregunta> getIteradorObservadores() {
    return this.observadores.iterator();
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

  /**
   * Método de prueba
   * 
   * @param args
   *          - no tiene parámetros
   */
  public static void main(String[] args) {
    HistoricoPreguntas BDPreguntas = new HistoricoPreguntas();
    new HacerPregunta(BDPreguntas.sortearPregunta());
  }

}
