package menuinicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import controlador.ManejadorJuego;
import vista.Recursos;

/**
 * Maneja la GUI del menú inicial del juego. El menú inicial permite lanzar 2
 * modalidades diferentes del juego. Una con las preguntas activadas y otra con
 * las preguntas desactivadas
 * 
 * @author Dibez, Santana
 *
 */
public class ManejadorMenuInicial {
  VentanaPrincipal ventanaPrincipal;

  /**
   * Construye la ventana inicial del juego
   */
  public ManejadorMenuInicial(VentanaPrincipal ventanaPrincipal) {
    this.ventanaPrincipal = ventanaPrincipal;
    this.ventanaPrincipal.construirMenuInicial(
        new LanzarJuegoConPreguntas(),
        new LanzarJuegoSinPreguntas());
  }

  /**
   * Inicia el juego
   * 
   * @param preguntas
   *          - true si las preguntas estarán activadas
   */
  private void LanzarJuego(boolean preguntas) {
    VentanaPrincipal ventana = this.ventanaPrincipal;
    Recursos recursos = ventana.getRecursos();
    new ManejadorJuego(preguntas, ventana, recursos);
  }

  /**
   * Inicia el juego con las preguntas activadas
   * 
   * @author Santana, Dibez
   *
   */
  private class LanzarJuegoConPreguntas implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      LanzarJuego(true);
    }

  }

  /**
   * Inicia el juego con las preguntas desactivadas
   * 
   * @author Santana, Dibez
   */
  private class LanzarJuegoSinPreguntas implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      LanzarJuego(false);
    }
  }
}
