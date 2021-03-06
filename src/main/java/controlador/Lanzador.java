package controlador;

import java.awt.EventQueue;

import fx.menuinicial.FxPanelInicio;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import menuinicial.AccionesAplicacion;
import menuinicial.VentanaPrincipal;

public class Lanzador implements AccionesAplicacion {
  private VentanaPrincipal ventana;
  private final FxPanelInicio fxPanel = new FxPanelInicio();
  

  private Lanzador() {
    lanzarVentanaPrincipal();
    nuevoJuego();
  }

  @Override
  public void salir() {
    System.exit(0);
  }

  private void lanzarVentanaPrincipal() {
    EventQueue.invokeLater(() -> {
      this.ventana = new VentanaPrincipal();
    });
  }
  
  @Override
  public void nuevoJuego() {
    JFXPanel panel = fxPanel.getPanel();
    EventQueue.invokeLater(() -> {
      ventana.setContentPane(panel);
      ventana.reset(this);
    });
  }

  public static void main(String[] args) {
    Platform.setImplicitExit(false); // Evita que se cierre el thread de JavaFx
    new Lanzador();
  }
}
