package controlador;

import java.awt.EventQueue;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import menuinicial.AccionesAplicacion;
import menuinicial.FxPanelInicio;
import menuinicial.VentanaPrincipal;
import vista.Recursos;

public class Lanzador implements AccionesAplicacion {
  private VentanaPrincipal ventana;
  private final Recursos recursos = new Recursos();
  private final FxPanelInicio fxPanel = new FxPanelInicio();
  private final Logger logger = Logger.getLogger(getClass().getName());
  private JFXPanel panel;

  /**
   * Setea la ventana principal e inicia el programa
   */
  private Lanzador() {
    logger.info("Inicializando Lanzador");
    EventQueue.invokeLater(() -> {
      this.ventana = new VentanaPrincipal(recursos);
    });
    nuevoJuego();
  }

  @Override
  public void salir() {
    System.exit(0);
  }

  @Override
  public void nuevoJuego() {
    logger.info("Inicializando Nuevo Juego");
    panel = fxPanel.getPanel();
    EventQueue.invokeLater(() -> {
      ventana.setContentPane(panel);
      ventana.reset(this);
    });
  }

  /**
   * Lanza el programa
   */
  public static void main(String[] args) {
    Platform.setImplicitExit(false); // Evita que se cierre el thread de JavaFx
    new Lanzador();
  }
}
