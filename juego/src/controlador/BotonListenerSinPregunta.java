package controlador;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import juego.Direccion;
import juego.Juego;
import vista.CasillaButton;
import vista.PanelTablero;

/**
 * Escuchador para los botones cuando se juega sin preguntas
 * 
 * @author Dibez, Santana
 *
 */
public class BotonListenerSinPregunta extends BotonListenerPadre {

  ManejadorJuego manejador;
  CasillaButton casilla;

  /**
   * Constructor
   * 
   * @param manejador
   *          -
   * 
   */
  public BotonListenerSinPregunta(ManejadorJuego manejador) {
    super(manejador);
  }
  
  public void llamarPregunta() {
    correcto();
  }
}