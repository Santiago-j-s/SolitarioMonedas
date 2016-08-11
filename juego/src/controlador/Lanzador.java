package controlador;

import menuinicial.AccionesAplicacion;
import menuinicial.ManejadorMenuInicial;
import menuinicial.VentanaPrincipal;
import vista.Recursos;

public class Lanzador implements AccionesAplicacion {
  private VentanaPrincipal ventana;
  private final Recursos recursos = new Recursos();

  /**
   * Setea la ventana principal e inicia el programa
   */
  private Lanzador() {
    this.ventana = new VentanaPrincipal(recursos);
    reset();
  }

  /**
   * Resetea la aplicacion
   */
  private void reset() {
    VentanaPrincipal ventana = this.ventana;
    ventana.reset(this);
    new ManejadorMenuInicial(ventana);
  }

  @Override
  public void salir() {
    System.exit(0);
  }

  @Override
  public void nuevoJuego() {
    reset();
  }
  
  /**
   * Lanza el programa
   */
  public static void main(String[] args) {
    new Lanzador();
  }

}
