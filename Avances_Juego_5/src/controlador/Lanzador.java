package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import vista.Recursos;
import vista.VentanaPrincipal;

public class Lanzador {
  VentanaPrincipal mainWindow;
  private final Recursos recursos = new Recursos();

  /**
   * Setea la ventana principal e inicia el programa
   */
  public Lanzador() {
    this.mainWindow = new VentanaPrincipal(recursos);
    reset();
  }

  /**
   * Resetea la aplicacion
   */
  public void reset() {
    VentanaPrincipal ventana = this.mainWindow;
    JMenuItem itemJuego = ventana.getNuevoJuego();
    JMenuItem itemSalir = ventana.getSalir();

    itemJuego.setEnabled(false);
    ventana.getContentPane().removeAll();
    itemJuego.addActionListener(new NuevoJuegoListener());
    itemSalir.addActionListener(new SalirListener());
    new ManejadorMenuInicial(ventana);
  }

  public void salir() {
    System.exit(0);
  }

  /**
   * Escuchador para el JMenuItem 'Nuevo Juego'
   */
  private class NuevoJuegoListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      reset();
    }
  }

  private class SalirListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      salir();
    }
  }

  /**
   * Lanza el programa
   */
  public static void main(String[] args) {
    new Lanzador();
  }
}
