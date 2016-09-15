package controlador;

import java.awt.EventQueue;

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

  /**
   * Setea la ventana principal e inicia el programa
   */
  private Lanzador() {
    this.ventana = new VentanaPrincipal(recursos);
    nuevoJuego();
  }

  @Override
  public void salir() {
    System.exit(0);
  }

  @Override
  public void nuevoJuego() {
    JFXPanel panel = fxPanel.getPanel();
    Platform.runLater(() -> {
      EventQueue.invokeLater(() -> {
        ventana.reset(this, panel);
      });
    });
  }

  /**
   * Lanza el programa
   */
  public static void main(String[] args) {
    new Lanzador();
  }
}
