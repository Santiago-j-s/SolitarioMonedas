package controlador;

import java.awt.EventQueue;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import menuinicial.AccionesAplicacion;
import menuinicial.FxPanelInicio;
import menuinicial.VentanaPrincipal;

public class Lanzador implements AccionesAplicacion {
  private VentanaPrincipal ventana;
  private final FxPanelInicio fxPanel = new FxPanelInicio();
  private JFXPanel panel;

  /**
   * Setea la ventana principal e inicia el programa
   */
  private Lanzador() {
    EventQueue.invokeLater(() -> {
      this.ventana = new VentanaPrincipal();
    });
    nuevoJuego();
  }

  @Override
  public void salir() {
    System.exit(0);
  }

  @Override
  public void nuevoJuego() {
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
