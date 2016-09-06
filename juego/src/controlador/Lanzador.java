package controlador;

import menuinicial.AccionesAplicacion;
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
    nuevoJuego();
  }

  @Override
  public void salir() {
    System.exit(0);
  }

  @Override
  public void nuevoJuego() {
    ventana.reset(this);
    System.out.println("Nuevo Juego.");
  }
  
  /**
   * Lanza el programa
   */
  public static void main(String[] args) {
    new Lanzador();
  }

}
