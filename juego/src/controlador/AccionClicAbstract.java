package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.CasillaButton;
import pregunta.modelo.Observador;

/**
 * Clase padre de todas las clases que implementan escuchadores para las
 * casillas del tablero
 * 
 * @author Dibez, Santana
 */
public abstract class AccionClicAbstract
    implements ActionListener, Observador {

  protected ManejadorJuego manejador;
  private CasillaButton casillaPresionada;

  protected AccionClicAbstract(ManejadorJuego manejador) {
    this.manejador = manejador;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    CasillaButton casilla = (CasillaButton) e.getSource();
    casillaPresionada = casilla;
    manejador.accionClicCasilla(casilla, this);
  }

  @Override
  public abstract void llamarPregunta();

  @Override
  public void correcto() {
    manejador.saltoMoneda(casillaPresionada);
  }

  @Override
  public void incorrecto() {}
}
